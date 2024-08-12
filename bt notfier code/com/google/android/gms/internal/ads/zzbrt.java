/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.initialization.AdapterStatus
 *  com.google.android.gms.ads.initialization.AdapterStatus$State
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

public final class zzbrt
implements AdapterStatus {
    private final AdapterStatus.State zza;
    private final String zzb;
    private final int zzc;

    public zzbrt(AdapterStatus.State state, String string, int n) {
        this.zza = state;
        this.zzb = string;
        this.zzc = n;
    }

    public final String getDescription() {
        return this.zzb;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.zza;
    }

    public final int getLatency() {
        return this.zzc;
    }
}
