/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzbe
 *  com.google.android.gms.ads.internal.util.zzcd
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsm
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbsv
 *  com.google.android.gms.internal.ads.zzbsx
 *  com.google.android.gms.internal.ads.zzbsy
 *  com.google.android.gms.internal.ads.zzbsz
 *  com.google.android.gms.internal.ads.zzbta
 *  com.google.android.gms.internal.ads.zzbtc
 *  com.google.android.gms.internal.ads.zzbtd
 *  com.google.android.gms.internal.ads.zzbte
 *  com.google.android.gms.internal.ads.zzbtg
 *  com.google.android.gms.internal.ads.zzbth
 *  com.google.android.gms.internal.ads.zzbti
 *  com.google.android.gms.internal.ads.zzbtm
 *  com.google.android.gms.internal.ads.zzbtr
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchn
 *  com.google.android.gms.internal.ads.zzchp
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.ads.internal.util.zzcd;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbsx;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbta;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzbtd;
import com.google.android.gms.internal.ads.zzbte;
import com.google.android.gms.internal.ads.zzbtg;
import com.google.android.gms.internal.ads.zzbth;
import com.google.android.gms.internal.ads.zzbti;
import com.google.android.gms.internal.ads.zzbtm;
import com.google.android.gms.internal.ads.zzbtr;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchn;
import com.google.android.gms.internal.ads.zzchp;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbts {
    private final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final zzcgz zzd;
    private final zzbe<zzbsn> zze;
    private final zzbe<zzbsn> zzf;
    private zzbtr zzg;
    private int zzh = 1;

    public zzbts(Context context, zzcgz zzcgz2, String string, zzbe<zzbsn> zzbe2, zzbe<zzbsn> zzbe3) {
        this.zzc = string;
        this.zzb = context.getApplicationContext();
        this.zzd = zzcgz2;
        this.zze = zzbe2;
        this.zzf = zzbe3;
    }

    static /* synthetic */ Object zza(zzbts zzbts2) {
        return zzbts2.zza;
    }

    static /* synthetic */ zzbtr zzb(zzbts zzbts2, zzbtr zzbtr2) {
        zzbts2.zzg = zzbtr2;
        return zzbtr2;
    }

    static /* synthetic */ zzbtr zzc(zzbts zzbts2) {
        return zzbts2.zzg;
    }

    static /* synthetic */ int zzd(zzbts zzbts2, int n) {
        zzbts2.zzh = n;
        return n;
    }

    static /* synthetic */ int zze(zzbts zzbts2) {
        return zzbts2.zzh;
    }

    protected final zzbtr zzf(zzaas zzaas2) {
        zzaas2 = new zzbtr(this.zzf);
        zzchg.zze.execute((Runnable)new zzbsx(this, null, (zzbtr)zzaas2));
        zzaas2.zzf((zzchp)new zzbth(this, (zzbtr)zzaas2), (zzchn)new zzbti(this, (zzbtr)zzaas2));
        return zzaas2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final zzbtm zzg(zzaas object) {
        object = this.zza;
        synchronized (object) {
            Object object2 = this.zza;
            synchronized (object2) {
                zzbtr zzbtr2 = this.zzg;
                if (zzbtr2 != null && this.zzh == 0) {
                    zzbsy zzbsy2 = new zzbsy(this);
                    zzbtr2.zzf((zzchp)zzbsy2, zzbsz.zza);
                }
            }
            object2 = this.zzg;
            if (object2 != null && object2.zzi() != -1) {
                int n = this.zzh;
                if (n == 0) {
                    return this.zzg.zza();
                }
                if (n != 1) return this.zzg.zza();
                this.zzh = 2;
                this.zzf(null);
                return this.zzg.zza();
            }
            this.zzh = 2;
            object2 = this.zzf(null);
            this.zzg = object2;
            return object2.zza();
        }
    }

    final /* synthetic */ void zzh(zzbsn zzbsn2) {
        if (!zzbsn2.zzj()) return;
        this.zzh = 1;
    }

    final /* synthetic */ void zzi(zzaas zzaas2, zzbtr zzbtr2) {
        zzbsv zzbsv2;
        try {
            zzbsv2 = new zzbsv(this.zzb, this.zzd, null, null);
        }
        catch (Throwable throwable) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error creating webview.", (Throwable)throwable);
            zzt.zzg().zzk(throwable, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbtr2.zzh();
            return;
        }
        zzbsv2.zzh((zzbsm)new zzbta(this, zzbtr2, (zzbsn)zzbsv2));
        zzbsv2.zzl("/jsLoaded", (zzbpr)new zzbtd(this, zzbtr2, (zzbsn)zzbsv2));
        zzaas2 = new zzcd();
        zzbte zzbte2 = new zzbte(this, null, (zzbsn)zzbsv2, (zzcd)zzaas2);
        zzaas2.zzb((Object)zzbte2);
        zzbsv2.zzl("/requestReload", (zzbpr)zzbte2);
        if (this.zzc.endsWith(".js")) {
            zzbsv2.zzc(this.zzc);
        } else if (this.zzc.startsWith("<html>")) {
            zzbsv2.zzg(this.zzc);
        } else {
            zzbsv2.zzf(this.zzc);
        }
        zzs.zza.postDelayed((Runnable)new zzbtg(this, zzbtr2, (zzbsn)zzbsv2), 60000L);
    }

    final /* synthetic */ void zzj(zzbtr zzbtr2, zzbsn zzbsn2) {
        Object object = this.zza;
        synchronized (object) {
            if (zzbtr2.zzi() == -1) return;
            if (zzbtr2.zzi() == 1) {
                return;
            }
            zzbtr2.zzh();
            zzchg.zze.execute(zzbtc.zza((zzbsn)zzbsn2));
            com.google.android.gms.ads.internal.util.zze.zza((String)"Could not receive loaded message in a timely manner. Rejecting.");
            return;
        }
    }
}
