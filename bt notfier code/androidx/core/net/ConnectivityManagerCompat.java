/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build$VERSION
 */
package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    private ConnectivityManagerCompat() {
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        if ((intent = (NetworkInfo)intent.getParcelableExtra("networkInfo")) == null) return null;
        return connectivityManager.getNetworkInfo(intent.getType());
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT < 24) return 3;
        return connectivityManager.getRestrictBackgroundStatus();
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        if ((connectivityManager = connectivityManager.getActiveNetworkInfo()) == null) {
            return true;
        }
        int n = connectivityManager.getType();
        if (n == 1) return false;
        if (n == 7) return false;
        if (n == 9) return false;
        return true;
    }
}
