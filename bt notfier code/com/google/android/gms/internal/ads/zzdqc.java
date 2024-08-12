/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcua
 *  com.google.android.gms.internal.ads.zzdij
 *  com.google.android.gms.internal.ads.zzdpy
 *  com.google.android.gms.internal.ads.zzdpz
 *  com.google.android.gms.internal.ads.zzdqa
 *  com.google.android.gms.internal.ads.zzdqb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcua;
import com.google.android.gms.internal.ads.zzdij;
import com.google.android.gms.internal.ads.zzdpy;
import com.google.android.gms.internal.ads.zzdpz;
import com.google.android.gms.internal.ads.zzdqa;
import com.google.android.gms.internal.ads.zzdqb;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzdqc {
    private final Executor zza;
    private final zzcua zzb;
    private final zzdij zzc;

    zzdqc(Executor executor, zzcua zzcua2, zzdij zzdij2) {
        this.zza = executor;
        this.zzc = zzdij2;
        this.zzb = zzcua2;
    }

    public final void zza(zzcml zzcml2) {
        if (zzcml2 == null) {
            return;
        }
        this.zzc.zza(zzcml2.zzH());
        this.zzc.zzi((Object)new zzdpy(zzcml2), this.zza);
        this.zzc.zzi((Object)new zzdpz(zzcml2), this.zza);
        this.zzc.zzi((Object)this.zzb, this.zza);
        this.zzb.zza(zzcml2);
        zzcml2.zzab("/trackActiveViewUnit", (zzbpr)new zzdqa(this));
        zzcml2.zzab("/untrackActiveViewUnit", (zzbpr)new zzdqb(this));
    }

    final /* synthetic */ void zzb(zzcml zzcml2, Map map) {
        this.zzb.zzb();
    }

    final /* synthetic */ void zzc(zzcml zzcml2, Map map) {
        this.zzb.zzd();
    }
}
