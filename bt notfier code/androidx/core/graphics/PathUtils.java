/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  androidx.core.graphics.PathSegment
 */
package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.core.graphics.PathSegment;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {
    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path path) {
        return PathUtils.flatten(path, 0.5f);
    }

    public static Collection<PathSegment> flatten(Path object, float object2) {
        object = object.approximate(object2);
        int n = ((Path)object).length / 3;
        ArrayList<PathSegment> arrayList = new ArrayList<PathSegment>(n);
        int n2 = 1;
        while (n2 < n) {
            int n3 = n2 * 3;
            int n4 = (n2 - 1) * 3;
            Path path = object[n3];
            Path path2 = object[n3 + 1];
            Path path3 = object[n3 + 2];
            Path path4 = object[n4];
            object2 = object[n4 + 1];
            Path path5 = object[n4 + 2];
            if (path != path4 && (path2 != object2 || path3 != path5)) {
                arrayList.add(new PathSegment(new PointF(object2, (float)path5), (float)path4, new PointF((float)path2, (float)path3), (float)path));
            }
            ++n2;
        }
        return arrayList;
    }
}
