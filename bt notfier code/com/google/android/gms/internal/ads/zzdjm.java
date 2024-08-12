/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdac
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdfs
 *  com.google.android.gms.internal.ads.zzdhz
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzdjl
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzdks
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdac;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdfs;
import com.google.android.gms.internal.ads.zzdhz;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzdjl;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzdks;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzdjm {
    private final zzdkn zza;
    private final zzcml zzb;

    public zzdjm(zzdkn zzdkn2, zzcml zzcml2) {
        this.zza = zzdkn2;
        this.zzb = zzcml2;
    }

    public static final zzdih<zzdhz> zzh(zzdks zzdks2) {
        return new zzdih((Object)zzdks2, (Executor)zzchg.zzf);
    }

    public final zzdkn zza() {
        return this.zza;
    }

    public final zzcml zzb() {
        return this.zzb;
    }

    public final View zzc() {
        zzcml zzcml2 = this.zzb;
        if (zzcml2 == null) return null;
        return zzcml2.zzG();
    }

    public final View zzd() {
        zzcml zzcml2 = this.zzb;
        if (zzcml2 != null) return zzcml2.zzG();
        return null;
    }

    public Set<zzdih<zzdbc>> zze(zzdac zzdac2) {
        return Collections.singleton(new zzdih((Object)zzdac2, (Executor)zzchg.zzf));
    }

    public Set<zzdih<zzdhz>> zzf(zzdac zzdac2) {
        return Collections.singleton(new zzdih((Object)zzdac2, (Executor)zzchg.zzf));
    }

    public final zzdih<zzdfs> zzg(Executor executor) {
        return new zzdih((Object)new zzdjl(this.zzb), executor);
    }
}
