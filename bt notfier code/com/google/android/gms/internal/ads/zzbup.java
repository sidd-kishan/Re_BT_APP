/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbts
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbul
 *  com.google.android.gms.internal.ads.zzbum
 *  com.google.android.gms.internal.ads.zzbun
 *  com.google.android.gms.internal.ads.zzbuo
 *  com.google.android.gms.internal.ads.zzbus
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzchn
 *  com.google.android.gms.internal.ads.zzchp
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbul;
import com.google.android.gms.internal.ads.zzbum;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbuo;
import com.google.android.gms.internal.ads.zzbus;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzchn;
import com.google.android.gms.internal.ads.zzchp;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzbup {
    private final zzbts zza;
    private zzfsm<zzbtt> zzb;

    zzbup(zzbts zzbts2) {
        this.zza = zzbts2;
    }

    private final void zzd() {
        zzchl zzchl2;
        if (this.zzb != null) return;
        this.zzb = zzchl2 = new zzchl();
        this.zza.zzg(null).zzf((zzchp)new zzbul(zzchl2), (zzchn)new zzbum(zzchl2));
    }

    public final <I, O> zzbus<I, O> zza(String string, zzbtz<I> zzbtz2, zzbty<O> zzbty2) {
        this.zzd();
        return new zzbus(this.zzb, "google.afma.activeView.handleUpdate", zzbtz2, zzbty2);
    }

    public final void zzb(String string, zzbpr<? super zzbtt> zzbpr2) {
        this.zzd();
        this.zzb = zzfsd.zzi(this.zzb, (zzfrk)new zzbun(string, zzbpr2), (Executor)zzchg.zzf);
    }

    public final void zzc(String string, zzbpr<? super zzbtt> zzbpr2) {
        this.zzb = zzfsd.zzj(this.zzb, (zzfln)new zzbuo(string, zzbpr2), (Executor)zzchg.zzf);
    }
}
