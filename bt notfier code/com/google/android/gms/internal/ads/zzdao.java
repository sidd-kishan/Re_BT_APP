/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdan
 *  com.google.android.gms.internal.ads.zzfam
 *  com.google.android.gms.internal.ads.zzfar
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdan;
import com.google.android.gms.internal.ads.zzfam;
import com.google.android.gms.internal.ads.zzfar;

public final class zzdao {
    private final Context zza;
    private final zzfar zzb;
    private final Bundle zzc;
    private final zzfam zzd;

    /* synthetic */ zzdao(zzdam zzdam2, zzdan zzdan2) {
        this.zza = zzdam.zza((zzdam)zzdam2);
        this.zzb = zzdam.zzb((zzdam)zzdam2);
        this.zzc = zzdam.zzc((zzdam)zzdam2);
        this.zzd = zzdam.zzd((zzdam)zzdam2);
    }

    final zzdam zza() {
        zzdam zzdam2 = new zzdam();
        zzdam2.zze(this.zza);
        zzdam2.zzf(this.zzb);
        zzdam2.zzg(this.zzc);
        return zzdam2;
    }

    final zzfar zzb() {
        return this.zzb;
    }

    final zzfam zzc() {
        return this.zzd;
    }

    final Bundle zzd() {
        return this.zzc;
    }

    final Context zze(Context context) {
        return this.zza;
    }
}
