/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.initialization.AdapterStatus
 *  com.google.android.gms.ads.initialization.AdapterStatus$State
 *  com.google.android.gms.internal.ads.zzbhs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.internal.ads.zzbhs;

final class zzbho
implements AdapterStatus {
    zzbho(zzbhs zzbhs2) {
    }

    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }

    public final AdapterStatus.State getInitializationState() {
        return AdapterStatus.State.READY;
    }

    public final int getLatency() {
        return 0;
    }
}
