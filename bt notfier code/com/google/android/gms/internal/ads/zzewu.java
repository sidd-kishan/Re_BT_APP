/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazm
 *  com.google.android.gms.internal.ads.zzazn
 *  com.google.android.gms.internal.ads.zzazo
 *  com.google.android.gms.internal.ads.zzazr
 *  com.google.android.gms.internal.ads.zzazu
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdak
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzdym
 *  com.google.android.gms.internal.ads.zzewq
 *  com.google.android.gms.internal.ads.zzewr
 *  com.google.android.gms.internal.ads.zzewt
 *  com.google.android.gms.internal.ads.zzewz
 *  com.google.android.gms.internal.ads.zzexa
 *  com.google.android.gms.internal.ads.zzexe
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexo
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfcm
 *  com.google.android.gms.internal.ads.zzfcv
 *  com.google.android.gms.internal.ads.zzfcx
 *  com.google.android.gms.internal.ads.zzfcy
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzazo;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdak;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzdym;
import com.google.android.gms.internal.ads.zzewq;
import com.google.android.gms.internal.ads.zzewr;
import com.google.android.gms.internal.ads.zzewt;
import com.google.android.gms.internal.ads.zzewz;
import com.google.android.gms.internal.ads.zzexa;
import com.google.android.gms.internal.ads.zzexe;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexo;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfcm;
import com.google.android.gms.internal.ads.zzfcv;
import com.google.android.gms.internal.ads.zzfcx;
import com.google.android.gms.internal.ads.zzfcy;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzewu<R extends zzdal<AdT>, AdT extends zzcxg>
implements zzexo<R, AdT> {
    private final zzexo<R, AdT> zza;
    private final zzexo<R, zzewz<R, AdT>> zzb;
    private final zzfcy<R, AdT> zzc;
    private final String zzd;
    private R zze;
    private final Executor zzf;

    public zzewu(zzexo<R, AdT> zzexo2, zzexo<R, zzewz<R, AdT>> zzexo3, zzfcy<R, AdT> zzfcy2, String string, Executor executor) {
        this.zza = zzexo2;
        this.zzb = zzexo3;
        this.zzc = zzfcy2;
        this.zzd = string;
        this.zzf = executor;
    }

    private final zzfsm<AdT> zzg(zzfcl<R, AdT> zzdal2, zzexp zzexp2) {
        zzexo<R, AdT> zzexo2 = zzdal2.zza;
        this.zze = zzexo2;
        if (zzdal2.zzc != null) {
            if (zzexo2.zzQ() == null) return zzfsd.zza((Object)zzdal2.zzc);
            zzdal2.zzc.zzn().zzq(zzdal2.zza.zzQ());
            return zzfsd.zza((Object)zzdal2.zzc);
        }
        zzexo2.zzP().zzi(zzdal2.zzb);
        zzexo2 = this.zza;
        zzdal2 = zzdal2.zza;
        return ((zzexe)zzexo2).zzb(zzexp2, null, zzdal2);
    }

    public final R zza() {
        R r;
        synchronized (this) {
            r = this.zze;
        }
        return r;
    }

    public final zzfsm<AdT> zzb(zzexp zzexp2, zzexn<R> zzexn2, R object) {
        synchronized (this) {
            zzdak zzdak2 = zzexn2.zza(zzexp2.zzb);
            object = new Object(this.zzd);
            zzdak2.zzg(object);
            object = (zzdal)zzdak2.zzf();
            object.zzN();
            object.zzN();
            zzdak2 = object.zzN().zzd;
            if (zzdak2.zzs == null && zzdak2.zzx == null) {
                zzdak2 = object.zzN();
                zzbdg zzbdg2 = zzdak2.zzd;
                String string = zzdak2.zzf;
                zzbdr zzbdr2 = zzdak2.zzj;
                zzdak2 = new zzewt(zzexn2, zzexp2, zzbdg2, string, this.zzf, zzbdr2, null);
                string = zzfru.zzw((zzfsm)((zzexa)this.zzb).zza(zzexp2, zzexn2, object));
                zzbdg2 = new zzewq(this, zzexp2, (zzewt)zzdak2, zzexn2, object);
                zzexp2 = zzfsd.zzi((zzfsm)string, (zzfrk)zzbdg2, (Executor)this.zzf);
                return zzexp2;
            }
            this.zze = object;
            zzexp2 = ((zzexe)this.zza).zzb(zzexp2, zzexn2, object);
            return zzexp2;
        }
    }

    final /* synthetic */ zzfsm zze(zzfcv zzfcv2) throws Exception {
        if (zzfcv2 == null) throw new zzdym(1, "Empty prefetch");
        if (zzfcv2.zza == null) throw new zzdym(1, "Empty prefetch");
        zzfcx zzfcx2 = zzfcv2.zzb;
        if (zzfcx2 == null) throw new zzdym(1, "Empty prefetch");
        zzfcx2 = (zzewt)zzfcx2;
        zzazo zzazo2 = zzazu.zza();
        zzazm zzazm2 = zzazn.zza();
        zzazm2.zzd(2);
        zzazm2.zza(zzazr.zzc());
        zzazo2.zza(zzazm2);
        zzazm2 = (zzazu)zzazo2.zzah();
        zzfcv2.zza.zza.zzP().zze().zze((zzazu)zzazm2);
        return this.zzg(zzfcv2.zza, zzfcx2.zzb);
    }

    final /* synthetic */ zzfsm zzf(zzexp zzexp2, zzewt zzewt2, zzexn zzexn2, zzdal zzdal2, zzewz zzewz2) throws Exception {
        zzexp zzexp3 = zzexp2;
        if (zzewz2 != null) {
            zzexp3 = zzewz2.zza;
            zzewt2 = new zzewt(zzewt2.zza, zzewt2.zzb, zzewt2.zzc, zzewt2.zzd, zzewt2.zze, zzewt2.zzf, (zzfcm)zzexp3);
            if (zzewz2.zzc != null) {
                this.zze = null;
                this.zzc.zzc((zzfcx)zzewt2);
                return this.zzg(zzewz2.zzc, zzexp2);
            }
            zzexp3 = this.zzc.zzd((zzfcx)zzewt2);
            if (zzexp3 != null) {
                this.zze = null;
                return zzfsd.zzi((zzfsm)zzexp3, (zzfrk)new zzewr(this), (Executor)this.zzf);
            }
            this.zzc.zzc((zzfcx)zzewt2);
            zzexp3 = new zzexp(zzexp2.zzb, zzewz2.zzb);
        }
        zzexp2 = ((zzexe)this.zza).zzb(zzexp3, zzexn2, zzdal2);
        this.zze = zzdal2;
        return zzexp2;
    }
}
