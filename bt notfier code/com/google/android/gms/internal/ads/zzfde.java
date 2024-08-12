/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzfcc
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfcv
 *  com.google.android.gms.internal.ads.zzfcw
 *  com.google.android.gms.internal.ads.zzfcx
 *  com.google.android.gms.internal.ads.zzfdb
 *  com.google.android.gms.internal.ads.zzfdc
 *  com.google.android.gms.internal.ads.zzfdd
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzfcc;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfcv;
import com.google.android.gms.internal.ads.zzfcw;
import com.google.android.gms.internal.ads.zzfcx;
import com.google.android.gms.internal.ads.zzfdb;
import com.google.android.gms.internal.ads.zzfdc;
import com.google.android.gms.internal.ads.zzfdd;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzfde<R extends zzdal<AdT>, AdT extends zzcxg> {
    private final zzfcx<R, AdT> zza;
    private final zzfsm<zzfcv<R, AdT>> zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfde(zzfcc zzfcc2, zzfcw<R, AdT> zzfcw2, zzfcx<R, AdT> zzfcx2) {
        this.zza = zzfcx2;
        this.zzb = zzfsd.zzg((zzfsm)zzfsd.zzi((zzfsm)zzfcw2.zza(zzfcx2), (zzfrk)new zzfdb(this, zzfcw2, zzfcc2, zzfcx2), (Executor)zzfcx2.zza()), Exception.class, (zzfrk)new zzfdc(this, zzfcw2), (Executor)zzfcx2.zza());
    }

    public final void zza(zzfrz<Void> zzfrz2) {
        synchronized (this) {
            zzfsd.zzp((zzfsm)zzfsd.zzi(this.zzb, (zzfrk)zzfdd.zza, (Executor)this.zza.zza()), zzfrz2, (Executor)this.zza.zza());
            return;
        }
    }

    public final zzfsm<zzfcv<R, AdT>> zzb(zzfcx<R, AdT> zzfcx2) {
        synchronized (this) {
            if (this.zzd) return null;
            if (this.zzc) {
                return null;
            }
            if (this.zza.zzb() == null) return null;
            if (zzfcx2.zzb() == null) return null;
            if (!this.zza.zzb().equals((Object)zzfcx2.zzb())) {
                return null;
            }
            this.zzc = true;
            zzfcx2 = this.zzb;
            return zzfcx2;
        }
    }

    final /* synthetic */ zzfsm zzc(zzfcw zzfcw2, Exception exception) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exception;
        }
    }

    final /* synthetic */ zzfsm zzd(zzfcw zzfcw2, zzfcc zzfcc2, zzfcx zzfcx2, zzfcl zzfcl2) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfcw2.zzb(zzfcl2);
            if (!this.zzc) {
                zzfcc2.zzb(zzfcx2.zzb(), zzfcl2);
                zzfcw2 = zzfsd.zza(null);
                return zzfcw2;
            }
            zzfcw2 = new zzfcv(zzfcl2, zzfcx2);
            zzfcw2 = zzfsd.zza((Object)zzfcw2);
            return zzfcw2;
        }
    }
}
