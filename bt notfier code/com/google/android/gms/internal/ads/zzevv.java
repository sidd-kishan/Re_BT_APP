/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.internal.ads.zzaxw
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzaya
 *  com.google.android.gms.internal.ads.zzayd
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbdn
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzddb
 *  com.google.android.gms.internal.ads.zzddn
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzevg
 *  com.google.android.gms.internal.ads.zzevh
 *  com.google.android.gms.internal.ads.zzevi
 *  com.google.android.gms.internal.ads.zzevj
 *  com.google.android.gms.internal.ads.zzevk
 *  com.google.android.gms.internal.ads.zzevl
 *  com.google.android.gms.internal.ads.zzevm
 *  com.google.android.gms.internal.ads.zzevn
 *  com.google.android.gms.internal.ads.zzevo
 *  com.google.android.gms.internal.ads.zzevp
 *  com.google.android.gms.internal.ads.zzevq
 *  com.google.android.gms.internal.ads.zzevr
 *  com.google.android.gms.internal.ads.zzevs
 *  com.google.android.gms.internal.ads.zzevt
 *  com.google.android.gms.internal.ads.zzevu
 *  com.google.android.gms.internal.ads.zzexb
 *  com.google.android.gms.internal.ads.zzexc
 *  com.google.android.gms.internal.ads.zzexl
 *  com.google.android.gms.internal.ads.zzfby
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzaya;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzddb;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzevg;
import com.google.android.gms.internal.ads.zzevh;
import com.google.android.gms.internal.ads.zzevi;
import com.google.android.gms.internal.ads.zzevj;
import com.google.android.gms.internal.ads.zzevk;
import com.google.android.gms.internal.ads.zzevl;
import com.google.android.gms.internal.ads.zzevm;
import com.google.android.gms.internal.ads.zzevn;
import com.google.android.gms.internal.ads.zzevo;
import com.google.android.gms.internal.ads.zzevp;
import com.google.android.gms.internal.ads.zzevq;
import com.google.android.gms.internal.ads.zzevr;
import com.google.android.gms.internal.ads.zzevs;
import com.google.android.gms.internal.ads.zzevt;
import com.google.android.gms.internal.ads.zzevu;
import com.google.android.gms.internal.ads.zzexb;
import com.google.android.gms.internal.ads.zzexc;
import com.google.android.gms.internal.ads.zzexl;
import com.google.android.gms.internal.ads.zzfby;
import java.util.concurrent.atomic.AtomicReference;

public final class zzevv
implements zzdbf,
zzddb,
zzexl,
zzo,
zzddn,
zzdbs,
zzdio {
    private final zzfby zza;
    private final AtomicReference<zzaxz> zzb = new AtomicReference();
    private final AtomicReference<zzaya> zzc = new AtomicReference();
    private final AtomicReference<zzayd> zzd = new AtomicReference();
    private final AtomicReference<zzddb> zze = new AtomicReference();
    private final AtomicReference<zzo> zzf = new AtomicReference();
    private final AtomicReference<zzbgw> zzg = new AtomicReference();
    private zzevv zzh = null;

    public zzevv(zzfby zzfby2) {
        this.zza = zzfby2;
    }

    public static zzevv zzg(zzevv zzevv2) {
        zzevv zzevv3 = new zzevv(zzevv2.zza);
        zzevv3.zzh = zzevv2;
        return zzevv3;
    }

    public final void zzR() {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzR();
            return;
        }
        zzexc.zza(this.zze, (zzexb)zzevr.zza);
    }

    public final void zzb() {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzb();
            return;
        }
        zzexc.zza(this.zzd, (zzexb)zzevk.zza);
    }

    public final void zzbD(zzbcz zzbcz2) {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzbD(zzbcz2);
            return;
        }
        zzexc.zza(this.zzb, (zzexb)new zzevn(zzbcz2));
        zzexc.zza(this.zzb, (zzexb)new zzevo(zzbcz2));
    }

    public final void zzbp() {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzbp();
            return;
        }
        zzexc.zza(this.zzf, (zzexb)zzevs.zza);
        zzexc.zza(this.zzd, (zzexb)zzevt.zza);
        zzexc.zza(this.zzd, (zzexb)zzevu.zza);
    }

    public final void zzbq() {
    }

    public final void zzbr() {
    }

    public final void zzbs(int n) {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzbs(n);
            return;
        }
        zzexc.zza(this.zzf, (zzexb)new zzevh(n));
    }

    public final void zzd() {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzd();
            return;
        }
        zzexc.zza(this.zzf, (zzexb)zzevi.zza);
    }

    public final void zze() {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zze();
            return;
        }
        zzexc.zza(this.zzf, (zzexb)zzevj.zza);
    }

    public final void zzh(zzaxz zzaxz2) {
        this.zzb.set(zzaxz2);
    }

    public final void zzi(zzayd zzayd2) {
        this.zzd.set(zzayd2);
    }

    public final void zzj(zzddb zzddb2) {
        this.zze.set(zzddb2);
    }

    public final void zzk(zzo zzo2) {
        this.zzf.set(zzo2);
    }

    public final void zzl(zzbgw zzbgw2) {
        this.zzg.set(zzbgw2);
    }

    public final void zzm(zzaxw zzaxw2) {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzm(zzaxw2);
            return;
        }
        zzexc.zza(this.zzb, (zzexb)new zzevm(zzaxw2));
    }

    public final void zzn(zzbcz zzbcz2) {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzn(zzbcz2);
            return;
        }
        zzexc.zza(this.zzd, (zzexb)new zzevl(zzbcz2));
    }

    public final void zzo(zzbdn zzbdn2) {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzo(zzbdn2);
            return;
        }
        zzexc.zza(this.zzg, (zzexb)new zzevg(zzbdn2));
    }

    public final void zzp() {
        zzevv zzevv2 = this.zzh;
        if (zzevv2 != null) {
            zzevv2.zzp();
            return;
        }
        this.zza.zzb();
        zzexc.zza(this.zzc, (zzexb)zzevp.zza);
        zzexc.zza(this.zzd, (zzexb)zzevq.zza);
    }

    public final void zzq(zzexl zzexl2) {
        this.zzh = (zzevv)zzexl2;
    }

    public final void zzr(zzaya zzaya2) {
        this.zzc.set(zzaya2);
    }
}
