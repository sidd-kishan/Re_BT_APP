/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.util;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(Object object, Object object2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(object, object2);
        }
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    public static int hash(Object ... objectArray) {
        if (Build.VERSION.SDK_INT < 19) return Arrays.hashCode(objectArray);
        return Objects.hash(objectArray);
    }

    public static int hashCode(Object object) {
        int n = object != null ? object.hashCode() : 0;
        return n;
    }

    public static <T> T requireNonNull(T t) {
        if (t == null) throw null;
        return t;
    }

    public static <T> T requireNonNull(T t, String string) {
        if (t == null) throw new NullPointerException(string);
        return t;
    }

    public static String toString(Object object, String string) {
        if (object == null) return string;
        string = object.toString();
        return string;
    }
}
