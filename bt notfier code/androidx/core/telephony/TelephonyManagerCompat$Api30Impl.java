/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.telephony.TelephonyManager
 */
package androidx.core.telephony;

import android.telephony.TelephonyManager;

private static class TelephonyManagerCompat.Api30Impl {
    private TelephonyManagerCompat.Api30Impl() {
    }

    static int getSubscriptionId(TelephonyManager telephonyManager) {
        return telephonyManager.getSubscriptionId();
    }
}
