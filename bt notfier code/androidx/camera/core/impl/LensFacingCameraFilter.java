/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LensFacingCameraFilter
implements CameraFilter {
    private int mLensFacing;

    public LensFacingCameraFilter(int n) {
        this.mLensFacing = n;
    }

    public List<CameraInfo> filter(List<CameraInfo> object) {
        ArrayList<CameraInfo> arrayList = new ArrayList<CameraInfo>();
        Iterator<CameraInfo> iterator = object.iterator();
        while (iterator.hasNext()) {
            CameraInfo cameraInfo = iterator.next();
            Preconditions.checkArgument((boolean)(cameraInfo instanceof CameraInfoInternal), (Object)"The camera info doesn't contain internal implementation.");
            object = ((CameraInfoInternal)cameraInfo).getLensFacing();
            if (object == null || (Integer)object != this.mLensFacing) continue;
            arrayList.add(cameraInfo);
        }
        return arrayList;
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }
}
