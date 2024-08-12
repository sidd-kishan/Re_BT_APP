/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcca
 *  com.google.android.gms.internal.ads.zzccb
 *  com.google.android.gms.internal.ads.zzccf
 *  com.google.android.gms.internal.ads.zzccg
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzezc
 *  com.google.android.gms.internal.ads.zzeze
 *  com.google.android.gms.internal.ads.zzezm
 *  com.google.android.gms.internal.ads.zzezu
 *  com.google.android.gms.internal.ads.zzezv
 *  com.google.android.gms.internal.ads.zzfam
 *  com.google.android.gms.internal.ads.zzfid
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcca;
import com.google.android.gms.internal.ads.zzccb;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzccg;
import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzezc;
import com.google.android.gms.internal.ads.zzeze;
import com.google.android.gms.internal.ads.zzezm;
import com.google.android.gms.internal.ads.zzezu;
import com.google.android.gms.internal.ads.zzezv;
import com.google.android.gms.internal.ads.zzfam;
import com.google.android.gms.internal.ads.zzfid;
import java.util.regex.Pattern;

public final class zzezw
extends zzccb {
    private final zzezm zza;
    private final zzezc zzb;
    private final zzfam zzc;
    private zzdrw zzd;
    private boolean zze = false;

    public zzezw(zzezm zzezm2, zzezc zzezc2, zzfam zzfam2) {
        this.zza = zzezm2;
        this.zzb = zzezc2;
        this.zzc = zzfam2;
    }

    static /* synthetic */ zzdrw zzv(zzezw zzezw2, zzdrw zzdrw2) {
        zzezw2.zzd = zzdrw2;
        return zzdrw2;
    }

    static /* synthetic */ zzdrw zzw(zzezw zzezw2) {
        return zzezw2.zzd;
    }

    private final boolean zzx() {
        synchronized (this) {
            boolean bl;
            zzdrw zzdrw2 = this.zzd;
            bl = zzdrw2 != null && !(bl = zzdrw2.zze());
            return bl;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzb(zzccg object) throws RemoteException {
        synchronized (this) {
            boolean bl;
            Object object2;
            String string;
            block9: {
                Preconditions.checkMainThread((String)"loadAd must be called on the main UI thread.");
                string = object.zzb;
                object2 = zzbjl.zzdJ;
                object2 = (String)zzbet.zzc().zzc(object2);
                if (object2 != null && string != null) {
                    try {
                        bl = Pattern.matches((String)object2, string);
                        if (!bl) break block9;
                    }
                    catch (RuntimeException runtimeException) {
                        zzt.zzg().zzk((Throwable)runtimeException, "NonagonUtil.isPatternMatched");
                        break block9;
                    }
                    return;
                }
            }
            if (this.zzx()) {
                string = zzbjl.zzdL;
                bl = (Boolean)zzbet.zzc().zzc((zzbjd)string);
                if (!bl) {
                    return;
                }
            }
            object2 = new zzeze(null);
            this.zzd = null;
            this.zza.zzi(1);
            zzezm zzezm2 = this.zza;
            string = object.zza;
            object = object.zzb;
            zzezu zzezu2 = new zzezu(this);
            zzezm2.zza((zzbdg)string, (String)object, (zzelw)object2, (zzelx)zzezu2);
            return;
        }
    }

    public final void zzc() throws RemoteException {
        synchronized (this) {
            this.zzp(null);
            return;
        }
    }

    public final void zzd(zzccf zzccf2) throws RemoteException {
        Preconditions.checkMainThread((String)"setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzp(zzccf2);
    }

    public final boolean zze() throws RemoteException {
        Preconditions.checkMainThread((String)"isLoaded must be called on the main UI thread.");
        return this.zzx();
    }

    public final void zzf() {
        this.zzi(null);
    }

    public final void zzg() {
        this.zzj(null);
    }

    public final void zzh() throws RemoteException {
        this.zzk(null);
    }

    public final void zzi(IObjectWrapper object) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"pause must be called on the main UI thread.");
            if (this.zzd == null) return;
            object = object == null ? null : (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
            this.zzd.zzl().zza((Context)object);
            return;
        }
    }

    public final void zzj(IObjectWrapper object) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"resume must be called on the main UI thread.");
            if (this.zzd == null) return;
            object = object == null ? null : (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
            this.zzd.zzl().zzb((Context)object);
            return;
        }
    }

    public final void zzk(IObjectWrapper object) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
            zzezc zzezc2 = this.zzb;
            Object var2_4 = null;
            zzezc2.zze(null);
            if (this.zzd == null) return;
            object = object == null ? var2_4 : (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
            this.zzd.zzl().zzc((Context)object);
            return;
        }
    }

    public final String zzl() throws RemoteException {
        synchronized (this) {
            Object object = this.zzd;
            if (object == null) return null;
            if (object.zzm() == null) return null;
            object = this.zzd.zzm().zze();
            return object;
        }
    }

    public final void zzm(String string) throws RemoteException {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setUserId must be called on the main UI thread.");
            this.zzc.zza = string;
            return;
        }
    }

    public final void zzn(zzbfr zzbfr2) {
        Preconditions.checkMainThread((String)"setAdMetadataListener can only be called from the UI thread.");
        if (zzbfr2 == null) {
            this.zzb.zze(null);
            return;
        }
        this.zzb.zze((zzfid)new zzezv(this, zzbfr2));
    }

    public final Bundle zzo() {
        Preconditions.checkMainThread((String)"getAdMetadata can only be called from the UI thread.");
        zzdrw zzdrw2 = this.zzd;
        zzdrw2 = zzdrw2 != null ? zzdrw2.zzg() : new Bundle();
        return zzdrw2;
    }

    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            Preconditions.checkMainThread((String)"showAd must be called on the main UI thread.");
            if (this.zzd == null) return;
            Object var2_3 = null;
            if (iObjectWrapper == null) {
                iObjectWrapper = var2_3;
            } else {
                Object object = ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
                iObjectWrapper = var2_3;
                if (object instanceof Activity) {
                    iObjectWrapper = (Activity)object;
                }
            }
            this.zzd.zza(this.zze, (Activity)iObjectWrapper);
            return;
        }
    }

    public final void zzq(String string) throws RemoteException {
        synchronized (this) {
            Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.: setCustomData");
            this.zzc.zzb = string;
            return;
        }
    }

    public final void zzr(boolean bl) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setImmersiveMode must be called on the main UI thread.");
            this.zze = bl;
            return;
        }
    }

    public final boolean zzs() {
        zzdrw zzdrw2 = this.zzd;
        if (zzdrw2 == null) return false;
        if (!zzdrw2.zzf()) return false;
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final zzbgz zzt() throws RemoteException {
        synchronized (this) {
            zzbjd zzbjd2 = zzbjl.zzfb;
            boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
            if (!bl) {
                return null;
            }
            zzbjd2 = this.zzd;
            if (zzbjd2 == null) return null;
            return zzbjd2.zzm();
        }
    }

    public final void zzu(zzcca zzcca2) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzs(zzcca2);
    }
}
