/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzfbx
 *  com.google.android.gms.internal.ads.zzfby
 *  com.google.android.gms.internal.ads.zzfcc
 *  com.google.android.gms.internal.ads.zzfct
 *  com.google.android.gms.internal.ads.zzfcu
 *  com.google.android.gms.internal.ads.zzfcv
 *  com.google.android.gms.internal.ads.zzfcw
 *  com.google.android.gms.internal.ads.zzfcx
 *  com.google.android.gms.internal.ads.zzfde
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzfbx;
import com.google.android.gms.internal.ads.zzfby;
import com.google.android.gms.internal.ads.zzfcc;
import com.google.android.gms.internal.ads.zzfct;
import com.google.android.gms.internal.ads.zzfcu;
import com.google.android.gms.internal.ads.zzfcv;
import com.google.android.gms.internal.ads.zzfcw;
import com.google.android.gms.internal.ads.zzfcx;
import com.google.android.gms.internal.ads.zzfde;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayDeque;

public final class zzfcy<R extends zzdal<AdT>, AdT extends zzcxg> {
    private final zzfcc zza;
    private final zzfcw<R, AdT> zzb;
    private final zzfby zzc;
    private final ArrayDeque<zzfcx<R, AdT>> zzd;
    private zzfde<R, AdT> zze;
    private int zzf = 1;

    public zzfcy(zzfcc zzfcc2, zzfby zzfby2, zzfcw<R, AdT> zzfcw2) {
        this.zza = zzfcc2;
        this.zzc = zzfby2;
        this.zzb = zzfcw2;
        this.zzd = new ArrayDeque();
        this.zzc.zza((zzfbx)new zzfct(this));
    }

    static /* synthetic */ ArrayDeque zza(zzfcy zzfcy2) {
        return zzfcy2.zzd;
    }

    static /* synthetic */ zzfde zzb(zzfcy zzfcy2, zzfde zzfde2) {
        zzfcy2.zze = null;
        return null;
    }

    static /* synthetic */ void zze(zzfcy zzfcy2) {
        zzfcy2.zzh();
    }

    static /* synthetic */ int zzg(zzfcy zzfcy2) {
        return zzfcy2.zzf;
    }

    private final void zzh() {
        synchronized (this) {
            try {
                zzfde zzfde2;
                zzfcx<R, AdT> zzfcx2 = zzbjl.zzeD;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)zzfcx2)).booleanValue() && !zzt.zzg().zzp().zzn().zzi()) {
                    this.zzd.clear();
                    return;
                }
                if (!this.zzi()) return;
                do {
                    if (this.zzd.isEmpty()) return;
                } while ((zzfcx2 = this.zzd.pollFirst()) != null && (zzfcx2.zzb() == null || !this.zza.zzc(zzfcx2.zzb())));
                this.zze = zzfde2 = new zzfde(this.zza, this.zzb, zzfcx2);
                zzfcu zzfcu2 = new zzfcu(this, zzfcx2);
                zzfde2.zza((zzfrz)zzfcu2);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private final boolean zzi() {
        synchronized (this) {
            zzfde<R, AdT> zzfde2 = this.zze;
            boolean bl = zzfde2 == null;
            return bl;
        }
    }

    public final void zzc(zzfcx<R, AdT> zzfcx2) {
        synchronized (this) {
            this.zzd.add(zzfcx2);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final zzfsm<zzfcv<R, AdT>> zzd(zzfcx<R, AdT> zzfsm2) {
        synchronized (this) {
            this.zzf = 2;
            boolean bl = this.zzi();
            if (!bl) return this.zze.zzb((zzfcx)zzfsm2);
            return null;
        }
    }

    final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            this.zzh();
            return;
        }
    }
}
