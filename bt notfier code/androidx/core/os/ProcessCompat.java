/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.core.os.ProcessCompat$Api16Impl
 *  androidx.core.os.ProcessCompat$Api17Impl
 *  androidx.core.os.ProcessCompat$Api24Impl
 */
package androidx.core.os;

import android.os.Build;
import androidx.core.os.ProcessCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public final class ProcessCompat {
    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int n) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.isApplicationUid((int)n);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.isApplicationUid((int)n);
        }
        if (Build.VERSION.SDK_INT != 16) return true;
        return Api16Impl.isApplicationUid((int)n);
    }
}
