/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfm
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzbzz
 *  com.google.android.gms.internal.ads.zzcac
 *  com.google.android.gms.internal.ads.zzccf
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzdds
 *  com.google.android.gms.internal.ads.zzekn
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzewj
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfav
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfbm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbzz;
import com.google.android.gms.internal.ads.zzcac;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzdds;
import com.google.android.gms.internal.ads.zzekn;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzewj;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfav;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfbm;
import java.util.Collections;

public final class zzeko
extends zzbfm
implements zzdds {
    private final Context zza;
    private final zzewj zzb;
    private final String zzc;
    private final zzeli zzd;
    private zzbdl zze;
    private final zzfap zzf;
    private zzcvh zzg;

    public zzeko(Context context, zzbdl zzbdl2, String string, zzewj zzewj2, zzeli zzeli2) {
        this.zza = context;
        this.zzb = zzewj2;
        this.zze = zzbdl2;
        this.zzc = string;
        this.zzd = zzeli2;
        this.zzf = zzewj2.zzl();
        zzewj2.zzn((zzdds)this);
    }

    static /* synthetic */ zzcvh zzb(zzeko zzeko2) {
        return zzeko2.zzg;
    }

    static /* synthetic */ zzcvh zzc(zzeko zzeko2, zzcvh zzcvh2) {
        zzeko2.zzg = zzcvh2;
        return zzcvh2;
    }

    private final void zzd(zzbdl zzbdl2) {
        synchronized (this) {
            this.zzf.zzt(zzbdl2);
            this.zzf.zzu(this.zze.zzn);
            return;
        }
    }

    private final boolean zze(zzbdg zzbdg2) throws RemoteException {
        synchronized (this) {
            Preconditions.checkMainThread((String)"loadAd must be called on the main UI thread.");
            zzt.zzc();
            if (zzs.zzK((Context)this.zza) && zzbdg2.zzs == null) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Failed to load the ad because app ID is missing.");
                zzbdg2 = this.zzd;
                if (zzbdg2 == null) return false;
                zzbdg2.zzbD(zzfbm.zzd((int)4, null, null));
                return false;
            }
            zzfbh.zzb((Context)this.zza, (boolean)zzbdg2.zzf);
            zzewj zzewj2 = this.zzb;
            String string = this.zzc;
            zzekn zzekn2 = new zzekn(this);
            boolean bl = zzewj2.zza(zzbdg2, string, null, (zzelx)zzekn2);
            return bl;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final zzbgz zzA() {
        synchronized (this) {
            zzbjd zzbjd2 = zzbjl.zzfb;
            boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
            if (!bl) {
                return null;
            }
            zzbjd2 = this.zzg;
            if (zzbjd2 != null) return zzbjd2.zzm();
            return null;
        }
    }

    public final String zzB() {
        synchronized (this) {
            String string = this.zzc;
            return string;
        }
    }

    public final zzbfu zzC() {
        return this.zzd.zzd();
    }

    public final zzbfa zzD() {
        return this.zzd.zzc();
    }

    public final void zzE(zzbkg zzbkg2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
            this.zzb.zzj(zzbkg2);
            return;
        }
    }

    public final void zzF(zzbex zzbex2) {
        Preconditions.checkMainThread((String)"setAdListener must be called on the main UI thread.");
        this.zzb.zzk(zzbex2);
    }

    public final void zzG(boolean bl) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setManualImpressionsEnabled must be called from the main thread.");
            this.zzf.zzA(bl);
            return;
        }
    }

    public final boolean zzH() {
        synchronized (this) {
            boolean bl = this.zzb.zzb();
            return bl;
        }
    }

    public final void zzI(zzccf zzccf2) {
    }

    public final void zzJ(String string) {
    }

    public final void zzK(String string) {
    }

    public final zzbhc zzL() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"getVideoController must be called from the main thread.");
            zzcvh zzcvh2 = this.zzg;
            if (zzcvh2 == null) return null;
            zzcvh2 = zzcvh2.zzc();
            return zzcvh2;
        }
    }

    public final void zzM(zzbis zzbis2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setVideoOptions must be called on the main UI thread.");
            this.zzf.zzy(zzbis2);
            return;
        }
    }

    public final void zzN(zzbhg zzbhg2) {
    }

    public final void zzO(zzbdr zzbdr2) {
    }

    public final void zzP(zzaxz zzaxz2) {
    }

    public final void zzQ(boolean bl) {
    }

    public final void zzX(zzbgw zzbgw2) {
        Preconditions.checkMainThread((String)"setPaidEventListener must be called on the main UI thread.");
        this.zzd.zzr(zzbgw2);
    }

    public final void zzY(zzbdg zzbdg2, zzbfd zzbfd2) {
    }

    public final void zzZ(IObjectWrapper iObjectWrapper) {
    }

    public final void zza() {
        synchronized (this) {
            if (!this.zzb.zzm()) {
                this.zzb.zzo();
                return;
            }
            zzbdl zzbdl2 = this.zzf.zzv();
            zzcvh zzcvh2 = this.zzg;
            zzbdl zzbdl3 = zzbdl2;
            if (zzcvh2 != null) {
                zzbdl3 = zzbdl2;
                if (zzcvh2.zzf() != null) {
                    zzbdl3 = zzbdl2;
                    if (this.zzf.zzM()) {
                        zzbdl3 = zzfav.zzb((Context)this.zza, Collections.singletonList(this.zzg.zzf()));
                    }
                }
            }
            this.zzd(zzbdl3);
            try {
                this.zze(this.zzf.zzs());
                return;
            }
            catch (RemoteException remoteException) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Failed to refresh the banner ad.");
                return;
            }
        }
    }

    public final void zzaa(zzbgb zzbgb2) {
    }

    public final void zzab(zzbfy zzbfy2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setCorrelationIdProvider must be called on the main UI thread");
            this.zzf.zzO(zzbfy2);
            return;
        }
    }

    public final IObjectWrapper zzi() {
        Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap((Object)this.zzb.zzi());
    }

    public final void zzj() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
            zzcvh zzcvh2 = this.zzg;
            if (zzcvh2 == null) return;
            zzcvh2.zzT();
            return;
        }
    }

    public final boolean zzk() {
        return false;
    }

    public final boolean zzl(zzbdg zzbdg2) throws RemoteException {
        synchronized (this) {
            this.zzd(this.zze);
            boolean bl = this.zze(zzbdg2);
            return bl;
        }
    }

    public final void zzm() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"pause must be called on the main UI thread.");
            zzcvh zzcvh2 = this.zzg;
            if (zzcvh2 == null) return;
            zzcvh2.zzl().zza(null);
            return;
        }
    }

    public final void zzn() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"resume must be called on the main UI thread.");
            zzcvh zzcvh2 = this.zzg;
            if (zzcvh2 == null) return;
            zzcvh2.zzl().zzb(null);
            return;
        }
    }

    public final void zzo(zzbfa zzbfa2) {
        Preconditions.checkMainThread((String)"setAdListener must be called on the main UI thread.");
        this.zzd.zze(zzbfa2);
    }

    public final void zzp(zzbfu zzbfu2) {
        Preconditions.checkMainThread((String)"setAppEventListener must be called on the main UI thread.");
        this.zzd.zzp(zzbfu2);
    }

    public final void zzq(zzbfr zzbfr2) {
        Preconditions.checkMainThread((String)"setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle zzr() {
        Preconditions.checkMainThread((String)"getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final void zzs() {
    }

    public final void zzt() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"recordManualImpression must be called on the main UI thread.");
            zzcvh zzcvh2 = this.zzg;
            if (zzcvh2 == null) return;
            zzcvh2.zzh();
            return;
        }
    }

    public final zzbdl zzu() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"getAdSize must be called on the main UI thread.");
            zzcvh zzcvh2 = this.zzg;
            if (zzcvh2 != null) {
                zzcvh2 = zzfav.zzb((Context)this.zza, Collections.singletonList(zzcvh2.zze()));
                return zzcvh2;
            }
            zzcvh2 = this.zzf.zzv();
            return zzcvh2;
        }
    }

    public final void zzv(zzbdl zzbdl2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setAdSize must be called on the main UI thread.");
            this.zzf.zzt(zzbdl2);
            this.zze = zzbdl2;
            zzcvh zzcvh2 = this.zzg;
            if (zzcvh2 == null) return;
            zzcvh2.zzb(this.zzb.zzi(), zzbdl2);
            return;
        }
    }

    public final void zzw(zzbzz zzbzz2) {
    }

    public final void zzx(zzcac zzcac2, String string) {
    }

    public final String zzy() {
        synchronized (this) {
            Object object = this.zzg;
            if (object == null) return null;
            if (object.zzm() == null) return null;
            object = this.zzg.zzm().zze();
            return object;
        }
    }

    public final String zzz() {
        synchronized (this) {
            Object object = this.zzg;
            if (object == null) return null;
            if (object.zzm() == null) return null;
            object = this.zzg.zzm().zze();
            return object;
        }
    }
}
