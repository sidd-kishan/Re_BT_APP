/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
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
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzelp
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzexv
 *  com.google.android.gms.internal.ads.zzeyc
 *  com.google.android.gms.internal.ads.zzezc
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfbm
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzelp;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzexv;
import com.google.android.gms.internal.ads.zzeyc;
import com.google.android.gms.internal.ads.zzezc;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfbm;

public final class zzelq
extends zzbfm {
    private final zzbdl zza;
    private final Context zzb;
    private final zzeyc zzc;
    private final String zzd;
    private final zzeli zze;
    private final zzezc zzf;
    private zzdji zzg;
    private boolean zzh;

    public zzelq(Context context, zzbdl zzbdl2, String string, zzeyc zzeyc2, zzeli zzeli2, zzezc zzezc2) {
        this.zza = zzbdl2;
        this.zzd = string;
        this.zzb = context;
        this.zzc = zzeyc2;
        this.zze = zzeli2;
        this.zzf = zzezc2;
        context = zzbjl.zzat;
        this.zzh = (Boolean)zzbet.zzc().zzc((zzbjd)context);
    }

    static /* synthetic */ zzdji zzb(zzelq zzelq2, zzdji zzdji2) {
        zzelq2.zzg = zzdji2;
        return zzdji2;
    }

    static /* synthetic */ zzdji zzc(zzelq zzelq2) {
        return zzelq2.zzg;
    }

    private final boolean zzd() {
        synchronized (this) {
            boolean bl;
            zzdji zzdji2 = this.zzg;
            bl = zzdji2 != null && !(bl = zzdji2.zzb());
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
            String string = this.zzd;
            return string;
        }
    }

    public final zzbfu zzC() {
        return this.zze.zzd();
    }

    public final zzbfa zzD() {
        return this.zze.zzc();
    }

    public final void zzE(zzbkg zzbkg2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
            this.zzc.zzg(zzbkg2);
            return;
        }
    }

    public final void zzF(zzbex zzbex2) {
    }

    public final void zzG(boolean bl) {
    }

    public final boolean zzH() {
        synchronized (this) {
            boolean bl = this.zzc.zzb();
            return bl;
        }
    }

    public final void zzI(zzccf zzccf2) {
        this.zzf.zzp(zzccf2);
    }

    public final void zzJ(String string) {
    }

    public final void zzK(String string) {
    }

    public final zzbhc zzL() {
        return null;
    }

    public final void zzM(zzbis zzbis2) {
    }

    public final void zzN(zzbhg zzbhg2) {
    }

    public final void zzO(zzbdr zzbdr2) {
    }

    public final void zzP(zzaxz zzaxz2) {
    }

    public final void zzQ(boolean bl) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setImmersiveMode must be called on the main UI thread.");
            this.zzh = bl;
            return;
        }
    }

    public final void zzX(zzbgw zzbgw2) {
        Preconditions.checkMainThread((String)"setPaidEventListener must be called on the main UI thread.");
        this.zze.zzr(zzbgw2);
    }

    public final void zzY(zzbdg zzbdg2, zzbfd zzbfd2) {
        this.zze.zzs(zzbfd2);
        this.zzl(zzbdg2);
    }

    public final void zzZ(IObjectWrapper iObjectWrapper) {
        synchronized (this) {
            if (this.zzg == null) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Interstitial can not be shown before loaded.");
                this.zze.zzn(zzfbm.zzd((int)9, null, null));
                return;
            }
            iObjectWrapper = (Activity)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
            this.zzg.zza(this.zzh, (Activity)iObjectWrapper);
            return;
        }
    }

    public final void zzaa(zzbgb zzbgb2) {
        this.zze.zzt(zzbgb2);
    }

    public final void zzab(zzbfy zzbfy2) {
    }

    public final IObjectWrapper zzi() {
        return null;
    }

    public final void zzj() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
            zzdji zzdji2 = this.zzg;
            if (zzdji2 == null) return;
            zzdji2.zzl().zzc(null);
            return;
        }
    }

    public final boolean zzk() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"isLoaded must be called on the main UI thread.");
            boolean bl = this.zzd();
            return bl;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzl(zzbdg zzbdg2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"loadAd must be called on the main UI thread.");
            zzt.zzc();
            if (zzs.zzK((Context)this.zzb) && zzbdg2.zzs == null) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Failed to load the ad because app ID is missing.");
                zzbdg2 = this.zze;
                if (zzbdg2 == null) return false;
                zzbdg2.zzbD(zzfbm.zzd((int)4, null, null));
                return false;
            }
            boolean bl = this.zzd();
            if (bl) {
                return false;
            }
            zzfbh.zzb((Context)this.zzb, (boolean)zzbdg2.zzf);
            this.zzg = null;
            zzeyc zzeyc2 = this.zzc;
            String string = this.zzd;
            zzexv zzexv2 = new zzexv(this.zza);
            zzelp zzelp2 = new zzelp(this);
            return zzeyc2.zza(zzbdg2, string, (zzelw)zzexv2, (zzelx)zzelp2);
        }
    }

    public final void zzm() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"pause must be called on the main UI thread.");
            zzdji zzdji2 = this.zzg;
            if (zzdji2 == null) return;
            zzdji2.zzl().zza(null);
            return;
        }
    }

    public final void zzn() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"resume must be called on the main UI thread.");
            zzdji zzdji2 = this.zzg;
            if (zzdji2 == null) return;
            zzdji2.zzl().zzb(null);
            return;
        }
    }

    public final void zzo(zzbfa zzbfa2) {
        Preconditions.checkMainThread((String)"setAdListener must be called on the main UI thread.");
        this.zze.zze(zzbfa2);
    }

    public final void zzp(zzbfu zzbfu2) {
        Preconditions.checkMainThread((String)"setAppEventListener must be called on the main UI thread.");
        this.zze.zzp(zzbfu2);
    }

    public final void zzq(zzbfr zzbfr2) {
        Preconditions.checkMainThread((String)"setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle zzr() {
        Preconditions.checkMainThread((String)"getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final void zzs() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"showInterstitial must be called on the main UI thread.");
            zzdji zzdji2 = this.zzg;
            if (zzdji2 == null) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Interstitial can not be shown before loaded.");
                this.zze.zzn(zzfbm.zzd((int)9, null, null));
                return;
            }
            zzdji2.zza(this.zzh, null);
            return;
        }
    }

    public final void zzt() {
    }

    public final zzbdl zzu() {
        return null;
    }

    public final void zzv(zzbdl zzbdl2) {
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
