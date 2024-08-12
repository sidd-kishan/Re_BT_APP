/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.Service;
import android.os.Build;

public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    private ServiceCompat() {
    }

    public static void stopForeground(Service service, int n) {
        if (Build.VERSION.SDK_INT >= 24) {
            service.stopForeground(n);
        } else {
            boolean bl = true;
            if ((n & 1) == 0) {
                bl = false;
            }
            service.stopForeground(bl);
        }
    }
}
