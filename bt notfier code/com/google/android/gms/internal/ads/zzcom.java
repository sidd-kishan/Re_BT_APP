/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zzi
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaao
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcok
 *  com.google.android.gms.internal.ads.zzcol
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaao;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcok;
import com.google.android.gms.internal.ads.zzcol;
import java.lang.ref.WeakReference;

public final class zzcom {
    private final zzcgz zza;
    private final Context zzb;
    private final WeakReference<Context> zzc;

    /* synthetic */ zzcom(zzcok zzcok2, zzcol zzcol2) {
        this.zza = zzcok.zza((zzcok)zzcok2);
        this.zzb = zzcok.zzb((zzcok)zzcok2);
        this.zzc = zzcok.zzc((zzcok)zzcok2);
    }

    final Context zza() {
        return this.zzb;
    }

    final WeakReference<Context> zzb() {
        return this.zzc;
    }

    final zzcgz zzc() {
        return this.zza;
    }

    final String zzd() {
        return zzt.zzc().zzi(this.zzb, this.zza.zza);
    }

    public final zzaas zze() {
        return new zzaas((zzaao)new zzi(this.zzb, this.zza));
    }
}
