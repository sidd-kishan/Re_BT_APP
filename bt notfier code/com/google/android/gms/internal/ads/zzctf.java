/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkk
 *  com.google.android.gms.internal.ads.zzbkm
 *  com.google.android.gms.internal.ads.zzbkx
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcsy
 *  com.google.android.gms.internal.ads.zzcsz
 *  com.google.android.gms.internal.ads.zzcta
 *  com.google.android.gms.internal.ads.zzctb
 *  com.google.android.gms.internal.ads.zzctc
 *  com.google.android.gms.internal.ads.zzctd
 *  com.google.android.gms.internal.ads.zzcte
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfbb
 *  com.google.android.gms.internal.ads.zzffr
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcsy;
import com.google.android.gms.internal.ads.zzcsz;
import com.google.android.gms.internal.ads.zzcta;
import com.google.android.gms.internal.ads.zzctb;
import com.google.android.gms.internal.ads.zzctc;
import com.google.android.gms.internal.ads.zzctd;
import com.google.android.gms.internal.ads.zzcte;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfbb;
import com.google.android.gms.internal.ads.zzffr;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzctf
implements zzdbc,
zzdcq,
zzdbw,
zzbcv,
zzdbs {
    private final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    private final zzfal zze;
    private final zzezz zzf;
    private final zzffr zzg;
    private final zzfbb zzh;
    private final zzaas zzi;
    private final zzbkk zzj;
    private final WeakReference<View> zzk;
    private boolean zzl;
    private final AtomicBoolean zzm = new AtomicBoolean();
    private final zzbkm zzn;

    public zzctf(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfal zzfal2, zzezz zzezz2, zzffr zzffr2, zzfbb zzfbb2, View view, zzaas zzaas2, zzbkk zzbkk2, zzbkm zzbkm2, byte[] byArray) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfal2;
        this.zzf = zzezz2;
        this.zzg = zzffr2;
        this.zzh = zzfbb2;
        this.zzi = zzaas2;
        this.zzk = new WeakReference<View>(view);
        this.zzj = zzbkk2;
        this.zzn = zzbkm2;
    }

    static /* synthetic */ Context zza(zzctf zzctf2) {
        return zzctf2.zza;
    }

    static /* synthetic */ zzfal zzb(zzctf zzctf2) {
        return zzctf2.zze;
    }

    static /* synthetic */ zzezz zzc(zzctf zzctf2) {
        return zzctf2.zzf;
    }

    static /* synthetic */ zzffr zzd(zzctf zzctf2) {
        return zzctf2.zzg;
    }

    static /* synthetic */ zzfbb zze(zzctf zzctf2) {
        return zzctf2.zzh;
    }

    private final void zzs(int n, int n2) {
        View view;
        if (n > 0 && ((view = (View)this.zzk.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            this.zzd.schedule((Runnable)new zzcta(this, n, n2), (long)n2, TimeUnit.MILLISECONDS);
            return;
        }
        this.zzt();
    }

    private final void zzt() {
        Object object = zzbjl.zzca;
        object = (Boolean)zzbet.zzc().zzc(object) != false ? this.zzi.zzb().zzo(this.zza, (View)this.zzk.get(), null) : null;
        zzbjd zzbjd2 = zzbjl.zzai;
        if (!(((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && this.zze.zzb.zzb.zzg || !((Boolean)zzbkx.zzh.zze()).booleanValue())) {
            zzbjd2 = zzfru.zzw((zzfsm)zzfsd.zza(null));
            zzbjd zzbjd3 = zzbjl.zzaG;
            zzfsd.zzp((zzfsm)((zzfru)zzfsd.zzh((zzfsm)zzbjd2, (long)((Long)zzbet.zzc().zzc(zzbjd3)), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzd)), (zzfrz)new zzcte(this, (String)object), (Executor)this.zzb);
            return;
        }
        zzfbb zzfbb2 = this.zzh;
        zzffr zzffr2 = this.zzg;
        zzfal zzfal2 = this.zze;
        zzbjd2 = this.zzf;
        zzfbb2.zza(zzffr2.zzb(zzfal2, (zzezz)zzbjd2, false, (String)object, null, zzbjd2.zzd));
    }

    public final void onAdClicked() {
        zzbjd zzbjd2 = zzbjl.zzai;
        if (!(((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && this.zze.zzb.zzb.zzg || !((Boolean)zzbkx.zzd.zze()).booleanValue())) {
            zzfsd.zzp((zzfsm)zzfsd.zzf((zzfsm)zzfru.zzw((zzfsm)this.zzj.zzb()), Throwable.class, (zzfln)zzcsy.zza, (Executor)zzchg.zzf), (zzfrz)new zzctd(this), (Executor)this.zzb);
            return;
        }
        zzbjd2 = this.zzh;
        zzffr zzffr2 = this.zzg;
        Object object = this.zze;
        zzezz zzezz2 = this.zzf;
        object = zzffr2.zza(object, zzezz2, zzezz2.zzc);
        zzt.zzc();
        boolean bl = zzs.zzI((Context)this.zza);
        int n = 1;
        if (bl) {
            n = 2;
        }
        zzbjd2.zzb((List)object, n);
    }

    public final void zzf() {
        synchronized (this) {
            if (this.zzl) {
                ArrayList arrayList = new ArrayList(this.zzf.zzd);
                arrayList.addAll(this.zzf.zzg);
                this.zzh.zza(this.zzg.zzb(this.zze, this.zzf, true, null, null, arrayList));
            } else {
                zzfbb zzfbb2 = this.zzh;
                zzffr zzffr2 = this.zzg;
                zzfal zzfal2 = this.zze;
                zzezz zzezz2 = this.zzf;
                zzfbb2.zza(zzffr2.zza(zzfal2, zzezz2, zzezz2.zzn));
                zzezz2 = this.zzh;
                zzfbb2 = this.zzg;
                zzfal2 = this.zze;
                zzffr2 = this.zzf;
                zzezz2.zza(zzfbb2.zza(zzfal2, (zzezz)zzffr2, zzffr2.zzg));
            }
            this.zzl = true;
            return;
        }
    }

    public final void zzg() {
        if (!this.zzm.compareAndSet(false, true)) {
            return;
        }
        zzbjd zzbjd2 = zzbjl.zzcd;
        int n = (Integer)zzbet.zzc().zzc(zzbjd2);
        if (n > 0) {
            zzbjd2 = zzbjl.zzce;
            this.zzs(n, (Integer)zzbet.zzc().zzc(zzbjd2));
            return;
        }
        zzbjd2 = zzbjl.zzcc;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            this.zzc.execute((Runnable)new zzcsz(this));
            return;
        }
        this.zzt();
    }

    public final void zzh() {
    }

    public final void zzi() {
    }

    public final void zzj() {
    }

    public final void zzk(zzcbz zzcbz2, String string, String string2) {
        string = this.zzh;
        string2 = this.zzg;
        zzezz zzezz2 = this.zzf;
        string.zza(string2.zzc(zzezz2, zzezz2.zzi, zzcbz2));
    }

    public final void zzl() {
        zzfbb zzfbb2 = this.zzh;
        zzffr zzffr2 = this.zzg;
        zzfal zzfal2 = this.zze;
        zzezz zzezz2 = this.zzf;
        zzfbb2.zza(zzffr2.zza(zzfal2, zzezz2, zzezz2.zzh));
    }

    public final void zzm() {
        zzfbb zzfbb2 = this.zzh;
        zzffr zzffr2 = this.zzg;
        zzfal zzfal2 = this.zze;
        zzezz zzezz2 = this.zzf;
        zzfbb2.zza(zzffr2.zza(zzfal2, zzezz2, zzezz2.zzj));
    }

    public final void zzn(zzbcz object) {
        zzbjd zzbjd2 = zzbjl.zzaZ;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        object = zzffr.zzd((int)2, (int)object.zza, (List)this.zzf.zzo);
        this.zzh.zza(this.zzg.zza(this.zze, this.zzf, (List)object));
    }

    final /* synthetic */ void zzo(int n, int n2) {
        this.zzb.execute((Runnable)new zzctb(this, n, n2));
    }

    final /* synthetic */ void zzp(int n, int n2) {
        this.zzs(n - 1, n2);
    }

    final /* synthetic */ void zzq() {
        this.zzb.execute((Runnable)new zzctc(this));
    }
}
