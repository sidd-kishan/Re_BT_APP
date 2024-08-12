/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzd
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzb
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzf
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzazf
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcfb
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcok
 *  com.google.android.gms.internal.ads.zzcom
 *  com.google.android.gms.internal.ads.zzcpi
 *  com.google.android.gms.internal.ads.zzcpz
 *  com.google.android.gms.internal.ads.zzcqv
 *  com.google.android.gms.internal.ads.zzcqw
 *  com.google.android.gms.internal.ads.zzcrf
 *  com.google.android.gms.internal.ads.zzcrz
 *  com.google.android.gms.internal.ads.zzcuj
 *  com.google.android.gms.internal.ads.zzcuu
 *  com.google.android.gms.internal.ads.zzcwd
 *  com.google.android.gms.internal.ads.zzddr
 *  com.google.android.gms.internal.ads.zzdke
 *  com.google.android.gms.internal.ads.zzdla
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzdsa
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzdwq
 *  com.google.android.gms.internal.ads.zzdyc
 *  com.google.android.gms.internal.ads.zzecm
 *  com.google.android.gms.internal.ads.zzecq
 *  com.google.android.gms.internal.ads.zzedi
 *  com.google.android.gms.internal.ads.zzedy
 *  com.google.android.gms.internal.ads.zzesq
 *  com.google.android.gms.internal.ads.zzetx
 *  com.google.android.gms.internal.ads.zzeux
 *  com.google.android.gms.internal.ads.zzewl
 *  com.google.android.gms.internal.ads.zzeye
 *  com.google.android.gms.internal.ads.zzezs
 *  com.google.android.gms.internal.ads.zzfbj
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzb;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzazf;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcok;
import com.google.android.gms.internal.ads.zzcom;
import com.google.android.gms.internal.ads.zzcpi;
import com.google.android.gms.internal.ads.zzcpz;
import com.google.android.gms.internal.ads.zzcqv;
import com.google.android.gms.internal.ads.zzcqw;
import com.google.android.gms.internal.ads.zzcrf;
import com.google.android.gms.internal.ads.zzcrz;
import com.google.android.gms.internal.ads.zzcuj;
import com.google.android.gms.internal.ads.zzcuu;
import com.google.android.gms.internal.ads.zzcwd;
import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzdke;
import com.google.android.gms.internal.ads.zzdla;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzdsa;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzdwq;
import com.google.android.gms.internal.ads.zzdyc;
import com.google.android.gms.internal.ads.zzecm;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzedi;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzesq;
import com.google.android.gms.internal.ads.zzetx;
import com.google.android.gms.internal.ads.zzeux;
import com.google.android.gms.internal.ads.zzewl;
import com.google.android.gms.internal.ads.zzeye;
import com.google.android.gms.internal.ads.zzezs;
import com.google.android.gms.internal.ads.zzfbj;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzcoj
implements zzcrz {
    private static zzcoj zza;

    public static zzcoj zza(Context object, zzbvg zzbvg2, int n) {
        object = zzcoj.zzb((Context)object, n);
        ((zzcoj)object).zzi().zza(zzbvg2);
        return object;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Deprecated
    public static zzcoj zzb(Context object, int n) {
        synchronized (zzcoj.class) {
            if (zza == null) return zzcoj.zzc(new zzcgz(213806000, n, true, false), object, (zzcqv)new zzcpi());
            return zza;
        }
    }

    @Deprecated
    public static zzcoj zzc(zzcgz object, Context context, zzcqv zzcqv2) {
        synchronized (zzcoj.class) {
            if (zza == null) {
                zzcpz zzcpz2 = new zzcpz(null);
                zzcok zzcok2 = new zzcok();
                zzcok2.zzd(object);
                zzcok2.zze(context);
                zzcom zzcom2 = new zzcom(zzcok2, null);
                zzcpz2.zza(zzcom2);
                zzcom2 = new zzcqw(zzcqv2);
                zzcpz2.zzb((zzcqw)zzcom2);
                zza = zzcpz2.zzc();
                zzbjl.zza((Context)context);
                zzt.zzg().zzi(context, object);
                zzt.zzi().zzd(context);
                zzt.zzc().zzg(context);
                zzt.zzc().zzh(context);
                zzt.zzc().zzr(context);
                zzd.zza((Context)context);
                zzt.zzf().zza(context);
                zzt.zzx().zza(context);
                zzcfb.zzd((Context)context);
                zzcqv2 = zzbjl.zzex;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)zzcqv2)).booleanValue()) {
                    zzcqv2 = zzbjl.zzap;
                    if (!((Boolean)zzbet.zzc().zzc((zzbjd)zzcqv2)).booleanValue()) {
                        zzcom2 = new zzazf(context);
                        zzcpz2 = new zzazb((zzazf)zzcom2);
                        zzcok2 = new zzecm(context);
                        zzcom2 = new zzecq((zzecm)zzcok2, zza.zzg());
                        zzt.zzc();
                        zzcqv2 = new zzedi(context, object, (zzazb)zzcpz2, (zzecq)zzcom2, UUID.randomUUID().toString(), zza.zzd());
                        zzcqv2.zza(zzt.zzg().zzp().zzC());
                    }
                }
            }
            object = zza;
            return object;
        }
    }

    public final zzesq zzA(zzcbj zzcbj2, int n) {
        return this.zzB(new zzetx(zzcbj2, n));
    }

    protected abstract zzesq zzB(zzetx var1);

    public abstract zzdwq zzC();

    public abstract zzffc zzd();

    public abstract Executor zze();

    public abstract ScheduledExecutorService zzf();

    public abstract zzfsn zzg();

    public abstract zzddr zzh();

    public abstract zzdtf zzi();

    public abstract zzcrf zzj();

    public abstract zzcwd zzk();

    public abstract zzewl zzl();

    public abstract zzcuj zzm();

    public abstract zzcuu zzn();

    public abstract zzeux zzo();

    public abstract zzdke zzp();

    public abstract zzeye zzq();

    public abstract zzdla zzr();

    public abstract zzdsa zzs();

    public abstract zzezs zzt();

    public abstract zzf zzu();

    public abstract zzv zzv();

    public abstract zzb zzw();

    public abstract zzedy zzx();

    public abstract zzfbj<zzdrh> zzy();

    public abstract zzdyc zzz();
}
