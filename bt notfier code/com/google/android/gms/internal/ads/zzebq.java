/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbld
 *  com.google.android.gms.internal.ads.zzbli
 *  com.google.android.gms.internal.ads.zzbtw
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbud
 *  com.google.android.gms.internal.ads.zzbug
 *  com.google.android.gms.internal.ads.zzcba
 *  com.google.android.gms.internal.ads.zzcbf
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcbm
 *  com.google.android.gms.internal.ads.zzcbu
 *  com.google.android.gms.internal.ads.zzcbv
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchj
 *  com.google.android.gms.internal.ads.zzcrz
 *  com.google.android.gms.internal.ads.zzebb
 *  com.google.android.gms.internal.ads.zzebc
 *  com.google.android.gms.internal.ads.zzebd
 *  com.google.android.gms.internal.ads.zzebe
 *  com.google.android.gms.internal.ads.zzebf
 *  com.google.android.gms.internal.ads.zzebg
 *  com.google.android.gms.internal.ads.zzebh
 *  com.google.android.gms.internal.ads.zzebi
 *  com.google.android.gms.internal.ads.zzebj
 *  com.google.android.gms.internal.ads.zzebk
 *  com.google.android.gms.internal.ads.zzebl
 *  com.google.android.gms.internal.ads.zzebm
 *  com.google.android.gms.internal.ads.zzebn
 *  com.google.android.gms.internal.ads.zzebp
 *  com.google.android.gms.internal.ads.zzebu
 *  com.google.android.gms.internal.ads.zzebv
 *  com.google.android.gms.internal.ads.zzebw
 *  com.google.android.gms.internal.ads.zzebx
 *  com.google.android.gms.internal.ads.zzesb
 *  com.google.android.gms.internal.ads.zzesq
 *  com.google.android.gms.internal.ads.zzfcj
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzfll
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzbli;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbud;
import com.google.android.gms.internal.ads.zzbug;
import com.google.android.gms.internal.ads.zzcba;
import com.google.android.gms.internal.ads.zzcbf;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcbm;
import com.google.android.gms.internal.ads.zzcbu;
import com.google.android.gms.internal.ads.zzcbv;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzcrz;
import com.google.android.gms.internal.ads.zzebb;
import com.google.android.gms.internal.ads.zzebc;
import com.google.android.gms.internal.ads.zzebd;
import com.google.android.gms.internal.ads.zzebe;
import com.google.android.gms.internal.ads.zzebf;
import com.google.android.gms.internal.ads.zzebg;
import com.google.android.gms.internal.ads.zzebh;
import com.google.android.gms.internal.ads.zzebi;
import com.google.android.gms.internal.ads.zzebj;
import com.google.android.gms.internal.ads.zzebk;
import com.google.android.gms.internal.ads.zzebl;
import com.google.android.gms.internal.ads.zzebm;
import com.google.android.gms.internal.ads.zzebn;
import com.google.android.gms.internal.ads.zzebp;
import com.google.android.gms.internal.ads.zzebu;
import com.google.android.gms.internal.ads.zzebv;
import com.google.android.gms.internal.ads.zzebw;
import com.google.android.gms.internal.ads.zzebx;
import com.google.android.gms.internal.ads.zzesb;
import com.google.android.gms.internal.ads.zzesq;
import com.google.android.gms.internal.ads.zzfcj;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzebq
extends zzcba {
    private final Context zza;
    private final Executor zzb;
    private final zzcbu zzc;
    private final zzcrz zzd;
    private final ArrayDeque<zzebn> zze;
    private final zzcbv zzf;
    private final zzebv zzg;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzebq(Context context, Executor executor, zzcbv zzcbv2, zzcrz zzcrz2, zzcbu zzcbu2, ArrayDeque arrayDeque, zzebv zzebv2, byte[] byArray) {
        zzbjl.zza((Context)context);
        this.zza = context;
        this.zzb = executor;
        this.zzf = zzcbv2;
        this.zzc = zzcbu2;
        this.zzd = zzcrz2;
        this.zze = arrayDeque;
        this.zzg = zzebv2;
    }

    private static zzfsm<JSONObject> zzl(zzcbj zzcbj2, zzfes zzfes2, zzesq zzesq2) {
        zzesq2 = new zzebe(zzesq2);
        zzfdw zzfdw2 = zzebf.zza;
        return zzfes2.zze((Object)zzfem.zze, zzfsd.zza((Object)zzcbj2.zza)).zzc((zzfrk)zzesq2).zzb(zzfdw2).zzi();
    }

    private static zzfsm<zzcbm> zzm(zzfsm<JSONObject> zzfsm2, zzfes zzfes2, zzbug zzbug2) {
        zzbug2 = zzbug2.zza("AFMA_getAdDictionary", (zzbtz)zzbud.zza, zzebg.zza);
        return zzfes2.zze((Object)zzfem.zzg, zzfsm2).zzc((zzfrk)zzbug2).zzi();
    }

    private final void zzn(zzfsm<InputStream> zzfsm2, zzcbf zzcbf2) {
        zzfsd.zzp((zzfsm)zzfsd.zzi(zzfsm2, (zzfrk)new zzebk(this), (Executor)zzchg.zza), (zzfrz)new zzebm(this, zzcbf2), (Executor)zzchg.zzf);
    }

    private final void zzo() {
        synchronized (this) {
            try {
                int n = ((Long)zzbld.zzc.zze()).intValue();
                while (this.zze.size() >= n) {
                    this.zze.removeFirst();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private final void zzp(zzebn zzebn2) {
        synchronized (this) {
            this.zzo();
            this.zze.addLast(zzebn2);
            return;
        }
    }

    private final zzebn zzq(String string) {
        synchronized (this) {
            try {
                zzebn zzebn2;
                Iterator<zzebn> iterator = this.zze.iterator();
                do {
                    if (!iterator.hasNext()) return null;
                    zzebn2 = iterator.next();
                } while (!zzebn2.zzc.equals(string));
                iterator.remove();
                return zzebn2;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private final zzebn zzr(String string) {
        synchronized (this) {
            try {
                zzebn zzebn2;
                Iterator<zzebn> iterator = this.zze.iterator();
                do {
                    if (!iterator.hasNext()) return null;
                    zzebn2 = iterator.next();
                } while (!zzebn2.zzd.equals(string));
                iterator.remove();
                return zzebn2;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final zzfsm<InputStream> zzb(zzcbj zzebw2, int n) {
        zzbug zzbug2 = zzt.zzp().zza(this.zza, zzcgz.zza());
        zzesq zzesq2 = this.zzd.zzA((zzcbj)zzebw2, n);
        zzbtw zzbtw2 = zzbug2.zza("google.afma.response.normalize", zzebp.zzd, zzbud.zzb);
        zzebx zzebx2 = new zzebx(zzebw2.zzg);
        zzebu zzebu2 = new zzebu(this.zza, zzebw2.zzb.zza, this.zzf, n, null);
        zzfes zzfes2 = zzesq2.zzc();
        boolean bl = (Boolean)zzbld.zza.zze();
        zzfsm zzfsm2 = null;
        zzfsm zzfsm3 = null;
        if (!bl) {
            String string = zzebw2.zzj;
            zzfsm3 = zzfsm2;
            if (string != null) {
                zzfsm3 = zzfsm2;
                if (!string.isEmpty()) {
                    com.google.android.gms.ads.internal.util.zze.zza((String)"Request contained a PoolKey but split request is disabled.");
                    zzfsm3 = zzfsm2;
                }
            }
        } else {
            if (((Boolean)zzbld.zzd.zze()).booleanValue()) {
                zzfsm2 = this.zzq(zzebw2.zzh);
            } else {
                zzfsm2 = zzfsm3;
                if (!TextUtils.isEmpty((CharSequence)zzebw2.zzj)) {
                    zzfsm2 = this.zzr(zzebw2.zzj);
                }
            }
            zzfsm3 = zzfsm2;
            if (zzfsm2 == null) {
                com.google.android.gms.ads.internal.util.zze.zza((String)"Request contained a PoolKey but no matching parameters were found.");
                zzfsm3 = zzfsm2;
            }
        }
        if (zzfsm3 == null) {
            zzebw2 = zzebq.zzl((zzcbj)zzebw2, zzfes2, zzesq2);
            zzfsm2 = zzebq.zzm((zzfsm<JSONObject>)zzebw2, zzfes2, zzbug2);
            zzfsm3 = zzfes2.zzf((Object)zzfem.zzh, new zzfsm[]{zzfsm2, zzebw2}).zza((Callable)new zzebb((zzfsm)zzebw2, zzfsm2)).zzb((zzfdw)zzebx2).zzb((zzfdw)zzebu2).zzi();
            return zzfes2.zzf((Object)zzfem.zzi, new zzfsm[]{zzebw2, zzfsm2, zzfsm3}).zza((Callable)new zzebc(zzfsm3, (zzfsm)zzebw2, zzfsm2)).zzc((zzfrk)zzbtw2).zzi();
        }
        zzebw2 = new zzebw(zzfsm3.zzb, zzfsm3.zza);
        zzebw2 = zzfes2.zze((Object)zzfem.zzh, zzfsd.zza((Object)zzebw2)).zzb((zzfdw)zzebx2).zzb((zzfdw)zzebu2).zzi();
        zzfsm2 = zzfsd.zza(zzfsm3);
        return zzfes2.zzf((Object)zzfem.zzi, new zzfsm[]{zzebw2, zzfsm2}).zza((Callable)new zzebd((zzfsm)zzebw2, zzfsm2)).zzc((zzfrk)zzbtw2).zzi();
    }

    public final zzfsm<InputStream> zzc(zzcbj zzcbj2, int n) {
        if (!((Boolean)zzbld.zza.zze()).booleanValue()) {
            return zzfsd.zzc((Throwable)new Exception("Split request is disabled."));
        }
        zzfcj zzfcj2 = zzcbj2.zzi;
        if (zzfcj2 == null) {
            return zzfsd.zzc((Throwable)new Exception("Pool configuration missing from request."));
        }
        if (zzfcj2.zzc == 0) return zzfsd.zzc((Throwable)new Exception("Caching is disabled."));
        if (zzfcj2.zzd == 0) {
            return zzfsd.zzc((Throwable)new Exception("Caching is disabled."));
        }
        zzfsm<zzcbm> zzfsm2 = zzt.zzp().zza(this.zza, zzcgz.zza());
        zzfsm<JSONObject> zzfsm3 = this.zzd.zzA(zzcbj2, n);
        zzfcj2 = zzfsm3.zzc();
        zzfsm3 = zzebq.zzl(zzcbj2, (zzfes)zzfcj2, (zzesq)zzfsm3);
        zzfsm2 = zzebq.zzm(zzfsm3, (zzfes)zzfcj2, (zzbug)zzfsm2);
        return zzfcj2.zzf((Object)zzfem.zzw, new zzfsm[]{zzfsm3, zzfsm2}).zza((Callable)new zzebi(this, zzfsm2, zzfsm3, zzcbj2)).zzi();
    }

    public final zzfsm<InputStream> zzd(String string) {
        if (!((Boolean)zzbld.zza.zze()).booleanValue()) {
            return zzfsd.zzc((Throwable)new Exception("Split request is disabled."));
        }
        zzebl zzebl2 = new zzebl(this);
        zzebn zzebn2 = (Boolean)zzbld.zzd.zze() != false ? this.zzq(string) : this.zzr(string);
        if (zzebn2 != null) return zzfsd.zza((Object)zzebl2);
        string = (string = String.valueOf(string)).length() != 0 ? "URL to be removed not found for cache key: ".concat(string) : new String("URL to be removed not found for cache key: ");
        return zzfsd.zzc((Throwable)new Exception(string));
    }

    public final void zze(zzcbj zzfsm2, zzcbf zzcbf2) {
        zzfsm2 = this.zzb((zzcbj)zzfsm2, Binder.getCallingUid());
        this.zzn(zzfsm2, zzcbf2);
        zzfsm2.zze((Runnable)new zzebh(this), this.zzb);
    }

    public final void zzf(zzcbj zzcbj2, zzcbf zzcbf2) {
        this.zzn(this.zzi(zzcbj2, Binder.getCallingUid()), zzcbf2);
    }

    public final void zzg(zzcbj zzcbj2, zzcbf zzcbf2) {
        this.zzn(this.zzc(zzcbj2, Binder.getCallingUid()), zzcbf2);
    }

    public final void zzh(String string, zzcbf zzcbf2) {
        this.zzn(this.zzd(string), zzcbf2);
    }

    public final zzfsm<InputStream> zzi(zzcbj zzcbj2, int n) {
        zzbug zzbug2 = zzt.zzp().zza(this.zza, zzcgz.zza());
        if (!((Boolean)zzbli.zza.zze()).booleanValue()) {
            return zzfsd.zzc((Throwable)new Exception("Signal collection disabled."));
        }
        zzesq zzesq2 = this.zzd.zzA(zzcbj2, n);
        zzesb zzesb2 = zzesq2.zzb();
        zzbug2 = zzbug2.zza("google.afma.request.getSignals", (zzbtz)zzbud.zza, zzbud.zzb);
        return zzesq2.zzc().zze((Object)zzfem.zzj, zzfsd.zza((Object)zzcbj2.zza)).zzc((zzfrk)new zzebj(zzesb2)).zzj((Object)zzfem.zzk).zzc((zzfrk)zzbug2).zzi();
    }

    final /* synthetic */ InputStream zzj(zzfsm zzfsm2, zzfsm zzfsm3, zzcbj object) throws Exception {
        String string = ((zzcbm)zzfsm2.get()).zzi();
        zzfsm3 = (JSONObject)zzfsm3.get();
        object = object.zzh;
        this.zzp(new zzebn((zzcbm)zzfsm2.get(), (JSONObject)zzfsm3, (String)object, string));
        return new ByteArrayInputStream(string.getBytes(zzfll.zzc));
    }

    final /* synthetic */ void zzk() {
        zzchj.zza((zzfsm)this.zzc.zza(), (String)"persistFlags");
    }
}
