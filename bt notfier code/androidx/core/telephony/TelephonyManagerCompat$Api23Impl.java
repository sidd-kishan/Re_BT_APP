/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.telephony.TelephonyManager
 */
package androidx.core.telephony;

import android.telephony.TelephonyManager;

private static class TelephonyManagerCompat.Api23Impl {
    private TelephonyManagerCompat.Api23Impl() {
    }

    static String getDeviceId(TelephonyManager telephonyManager, int n) {
        return telephonyManager.getDeviceId(n);
    }
}
