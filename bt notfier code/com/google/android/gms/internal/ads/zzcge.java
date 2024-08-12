/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.util.zzj
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzaww
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbjq
 *  com.google.android.gms.internal.ads.zzbkt
 *  com.google.android.gms.internal.ads.zzblf
 *  com.google.android.gms.internal.ads.zzcar
 *  com.google.android.gms.internal.ads.zzcbx
 *  com.google.android.gms.internal.ads.zzcga
 *  com.google.android.gms.internal.ads.zzcgb
 *  com.google.android.gms.internal.ads.zzcgc
 *  com.google.android.gms.internal.ads.zzcgi
 *  com.google.android.gms.internal.ads.zzcgw
 *  com.google.android.gms.internal.ads.zzcgx
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchj
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzcar;
import com.google.android.gms.internal.ads.zzcbx;
import com.google.android.gms.internal.ads.zzcga;
import com.google.android.gms.internal.ads.zzcgb;
import com.google.android.gms.internal.ads.zzcgc;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzcgx;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcge {
    private final Object zza = new Object();
    private final zzj zzb = new zzj();
    private final zzcgi zzc = new zzcgi(zzber.zzc(), (zzg)this.zzb);
    private boolean zzd = false;
    private Context zze;
    private zzcgz zzf;
    private zzbjq zzg = null;
    private Boolean zzh = null;
    private final AtomicInteger zzi = new AtomicInteger(0);
    private final zzcgc zzj = new zzcgc(null);
    private final Object zzk = new Object();
    private zzfsm<ArrayList<String>> zzl;

    static /* synthetic */ Object zza(zzcge zzcge2) {
        return zzcge2.zza;
    }

    static /* synthetic */ Context zzb(zzcge zzcge2) {
        return zzcge2.zze;
    }

    static /* synthetic */ zzcgz zzc(zzcge zzcge2) {
        return zzcge2.zzf;
    }

    static /* synthetic */ zzbjq zzd(zzcge zzcge2) {
        return zzcge2.zzg;
    }

    public final zzbjq zze() {
        Object object = this.zza;
        synchronized (object) {
            zzbjq zzbjq2 = this.zzg;
            return zzbjq2;
        }
    }

    public final void zzf(Boolean bl) {
        Object object = this.zza;
        synchronized (object) {
            this.zzh = bl;
            return;
        }
    }

    public final Boolean zzg() {
        Object object = this.zza;
        synchronized (object) {
            Boolean bl = this.zzh;
            return bl;
        }
    }

    public final void zzh() {
        this.zzj.zza();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzi(Context context, zzcgz zzcgz2) {
        Object object = this.zza;
        synchronized (object) {
            if (!this.zzd) {
                zzbjq zzbjq2;
                this.zze = context.getApplicationContext();
                this.zzf = zzcgz2;
                zzt.zzf().zzb((zzaww)this.zzc);
                this.zzb.zza(this.zze);
                zzcar.zzb((Context)this.zze, (zzcgz)this.zzf);
                zzt.zzl();
                if (!((Boolean)zzbkt.zzc.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.util.zze.zza((String)"CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbjq2 = null;
                } else {
                    zzbjq2 = new zzbjq();
                }
                this.zzg = zzbjq2;
                if (zzbjq2 != null) {
                    zzbjq2 = new zzcgb(this);
                    zzchj.zza((zzfsm)zzbjq2.zzc(), (String)"AppState.registerCsiReporter");
                }
                this.zzd = true;
                this.zzr();
            }
        }
        zzt.zzc().zzi(context, zzcgz2.zza);
    }

    public final Resources zzj() {
        if (this.zzf.zzd) {
            return this.zze.getResources();
        }
        try {
            zzcgx.zzb((Context)this.zze).getResources();
            return null;
        }
        catch (zzcgw zzcgw2) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Cannot load resource from dynamite apk or local jar", (Throwable)zzcgw2);
            return null;
        }
    }

    public final void zzk(Throwable throwable, String string) {
        zzcar.zzb((Context)this.zze, (zzcgz)this.zzf).zzd(throwable, string);
    }

    public final void zzl(Throwable throwable, String string) {
        zzcar.zzb((Context)this.zze, (zzcgz)this.zzf).zze(throwable, string, ((Double)zzblf.zzg.zze()).floatValue());
    }

    public final void zzm() {
        this.zzi.incrementAndGet();
    }

    public final void zzn() {
        this.zzi.decrementAndGet();
    }

    public final int zzo() {
        return this.zzi.get();
    }

    public final zzg zzp() {
        Object object = this.zza;
        synchronized (object) {
            zzj zzj2 = this.zzb;
            return zzj2;
        }
    }

    public final Context zzq() {
        return this.zze;
    }

    public final zzfsm<ArrayList<String>> zzr() {
        if (!PlatformVersion.isAtLeastJellyBean()) return zzfsd.zza(new ArrayList());
        if (this.zze == null) return zzfsd.zza(new ArrayList());
        Object object = zzbjl.zzbN;
        if (((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
            return zzfsd.zza(new ArrayList());
        }
        object = this.zzk;
        synchronized (object) {
            zzfsn zzfsn2 = this.zzl;
            if (zzfsn2 != null) {
                return zzfsn2;
            }
            zzfsn2 = zzchg.zza;
            zzcga zzcga2 = new zzcga(this);
            this.zzl = zzfsn2 = zzfsn2.zzb((Callable)zzcga2);
            return zzfsn2;
        }
    }

    public final zzcgi zzs() {
        return this.zzc;
    }

    /*
     * Enabled force condition propagation
     */
    final /* synthetic */ ArrayList zzt() throws Exception {
        int n;
        Context context = zzcbx.zza((Context)this.zze);
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            context = Wrappers.packageManager((Context)context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (context.requestedPermissions == null) return arrayList;
            if (context.requestedPermissionsFlags == null) return arrayList;
            n = 0;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return arrayList;
        }
        while (n < context.requestedPermissions.length) {
            if ((context.requestedPermissionsFlags[n] & 2) != 0) {
                arrayList.add(context.requestedPermissions[n]);
            }
            ++n;
        }
        return arrayList;
    }
}
