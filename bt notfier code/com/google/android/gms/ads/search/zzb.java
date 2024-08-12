/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.internal.ads.zzbhi
 */
package com.google.android.gms.ads.search;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzbhi;

public final class zzb {
    private final zzbhi zza = new zzbhi();
    private String zzb;

    static /* synthetic */ zzbhi zza(zzb zzb2) {
        return zzb2.zza;
    }

    static /* synthetic */ String zzb(zzb zzb2) {
        return zzb2.zzb;
    }

    public final zzb zzc(NetworkExtras networkExtras) {
        this.zza.zzt(networkExtras);
        return this;
    }

    public final zzb zzd(Class<? extends MediationAdapter> clazz, Bundle bundle) {
        this.zza.zzu(clazz, bundle);
        return this;
    }

    public final zzb zze(Class<? extends CustomEvent> clazz, Bundle bundle) {
        this.zza.zzv(clazz, bundle);
        return this;
    }

    public final zzb zzf(String string) {
        this.zzb = string;
        return this;
    }
}
