/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.telephony.SubscriptionManager
 */
package androidx.core.telephony;

import android.telephony.SubscriptionManager;

private static class SubscriptionManagerCompat.Api29Impl {
    private SubscriptionManagerCompat.Api29Impl() {
    }

    static int getSlotIndex(int n) {
        return SubscriptionManager.getSlotIndex((int)n);
    }
}
