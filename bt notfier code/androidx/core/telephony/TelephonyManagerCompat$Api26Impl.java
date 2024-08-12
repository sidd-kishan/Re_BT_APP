/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.telephony.TelephonyManager
 */
package androidx.core.telephony;

import android.telephony.TelephonyManager;

private static class TelephonyManagerCompat.Api26Impl {
    private TelephonyManagerCompat.Api26Impl() {
    }

    static String getImei(TelephonyManager telephonyManager) {
        return telephonyManager.getImei();
    }
}
