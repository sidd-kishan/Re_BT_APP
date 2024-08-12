/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.ActivityManager;
import android.os.Build;

public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT < 19) return false;
        return activityManager.isLowRamDevice();
    }
}
