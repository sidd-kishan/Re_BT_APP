/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzamv
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcve
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcxu
 *  com.google.android.gms.internal.ads.zzcyj
 *  com.google.android.gms.internal.ads.zzdam
 *  com.google.android.gms.internal.ads.zzdgn
 *  com.google.android.gms.internal.ads.zzdlb
 *  com.google.android.gms.internal.ads.zzelv
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzely
 *  com.google.android.gms.internal.ads.zzelz
 *  com.google.android.gms.internal.ads.zzema
 *  com.google.android.gms.internal.ads.zzemb
 *  com.google.android.gms.internal.ads.zzeme
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzgli
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzamv;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcve;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcxu;
import com.google.android.gms.internal.ads.zzcyj;
import com.google.android.gms.internal.ads.zzdam;
import com.google.android.gms.internal.ads.zzdgn;
import com.google.android.gms.internal.ads.zzdlb;
import com.google.android.gms.internal.ads.zzelv;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzely;
import com.google.android.gms.internal.ads.zzelz;
import com.google.android.gms.internal.ads.zzema;
import com.google.android.gms.internal.ads.zzemb;
import com.google.android.gms.internal.ads.zzeme;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzgli;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzemf
implements zzely<zzcxg> {
    private final zzfap zza;
    private final zzcoj zzb;
    private final Context zzc;
    private final zzelv zzd;
    private zzcxu zze;

    public zzemf(zzcoj zzcoj2, Context context, zzelv zzelv2, zzfap zzfap2) {
        this.zzb = zzcoj2;
        this.zzc = context;
        this.zzd = zzelv2;
        this.zza = zzfap2;
        zzfap2.zzJ(zzelv2.zzc());
    }

    static /* synthetic */ zzcoj zzc(zzemf zzemf2) {
        return zzemf2.zzb;
    }

    static /* synthetic */ zzelv zzd(zzemf zzemf2) {
        return zzemf2.zzd;
    }

    public final boolean zza(zzbdg zzbdg2, String string, zzelw object, zzelx<? super zzcxg> zzelx2) throws RemoteException {
        zzt.zzc();
        if (zzs.zzK((Context)this.zzc) && zzbdg2.zzs == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Failed to load the ad because app ID is missing.");
            this.zzb.zze().execute((Runnable)new zzema(this));
            return false;
        }
        if (string == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zze().execute((Runnable)new zzemb(this));
            return false;
        }
        zzfbh.zzb((Context)this.zzc, (boolean)zzbdg2.zzf);
        string = zzbjl.zzgp;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue() && zzbdg2.zzf) {
            this.zzb.zzz().zzc(true);
        }
        int n = ((zzelz)object).zza;
        string = this.zza;
        string.zzr(zzbdg2);
        string.zzB(n);
        object = string.zzL();
        if (object.zzn != null) {
            this.zzd.zzc().zzp(object.zzn);
        }
        zzbdg2 = this.zzb.zzr();
        string = new zzdam();
        string.zze(this.zzc);
        string.zzf((zzfar)object);
        zzbdg2.zzd(string.zzh());
        string = new zzdgn();
        string.zzt((zzamv)this.zzd.zzc(), this.zzb.zze());
        zzbdg2.zze(string.zzC());
        zzbdg2.zzc(this.zzd.zzb());
        zzbdg2.zzb(new zzcve(null));
        zzbdg2 = zzbdg2.zza();
        this.zzb.zzy().zza(1);
        string = zzchg.zza;
        zzgli.zzb((Object)string);
        object = this.zzb.zzf();
        zzcyj zzcyj2 = zzbdg2.zzR();
        string = new zzcxu((Executor)((Object)string), (ScheduledExecutorService)object, zzcyj2.zzd(zzcyj2.zzc()));
        this.zze = string;
        string.zza((zzfrz)new zzeme(this, zzelx2, (zzdlb)zzbdg2));
        return true;
    }

    public final boolean zzb() {
        zzcxu zzcxu2 = this.zze;
        if (zzcxu2 == null) return false;
        if (!zzcxu2.zzc()) return false;
        return true;
    }

    final /* synthetic */ void zze() {
        this.zzd.zze().zzbD(zzfbm.zzd((int)6, null, null));
    }

    final /* synthetic */ void zzf() {
        this.zzd.zze().zzbD(zzfbm.zzd((int)4, null, null));
    }
}
