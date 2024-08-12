/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzdao
 *  com.google.android.gms.internal.ads.zzfam
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzdao;
import com.google.android.gms.internal.ads.zzfam;
import com.google.android.gms.internal.ads.zzfar;

public final class zzdam {
    private Context zza;
    private zzfar zzb;
    private Bundle zzc;
    private zzfam zzd;

    static /* synthetic */ Context zza(zzdam zzdam2) {
        return zzdam2.zza;
    }

    static /* synthetic */ zzfar zzb(zzdam zzdam2) {
        return zzdam2.zzb;
    }

    static /* synthetic */ Bundle zzc(zzdam zzdam2) {
        return zzdam2.zzc;
    }

    static /* synthetic */ zzfam zzd(zzdam zzdam2) {
        return zzdam2.zzd;
    }

    public final zzdam zze(Context context) {
        this.zza = context;
        return this;
    }

    public final zzdam zzf(zzfar zzfar2) {
        this.zzb = zzfar2;
        return this;
    }

    public final zzdam zzg(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzdao zzh() {
        return new zzdao(this, null);
    }

    public final zzdam zzi(zzfam zzfam2) {
        this.zzd = zzfam2;
        return this;
    }
}
