/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgt
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzccr
 *  com.google.android.gms.internal.ads.zzccv
 *  com.google.android.gms.internal.ads.zzccz
 *  com.google.android.gms.internal.ads.zzcda
 *  com.google.android.gms.internal.ads.zzcdg
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzezc
 *  com.google.android.gms.internal.ads.zzeze
 *  com.google.android.gms.internal.ads.zzezm
 *  com.google.android.gms.internal.ads.zzezo
 *  com.google.android.gms.internal.ads.zzezp
 *  com.google.android.gms.internal.ads.zzfam
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfid
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccr;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcda;
import com.google.android.gms.internal.ads.zzcdg;
import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzezc;
import com.google.android.gms.internal.ads.zzeze;
import com.google.android.gms.internal.ads.zzezm;
import com.google.android.gms.internal.ads.zzezo;
import com.google.android.gms.internal.ads.zzezp;
import com.google.android.gms.internal.ads.zzfam;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfid;

public final class zzezq
extends zzccr {
    private final zzezm zza;
    private final zzezc zzb;
    private final String zzc;
    private final zzfam zzd;
    private final Context zze;
    private zzdrw zzf;
    private boolean zzg;

    public zzezq(String string, zzezm zzezm2, Context context, zzezc zzezc2, zzfam zzfam2) {
        this.zzc = string;
        this.zza = zzezm2;
        this.zzb = zzezc2;
        this.zzd = zzfam2;
        this.zze = context;
        string = zzbjl.zzat;
        this.zzg = (Boolean)zzbet.zzc().zzc((zzbjd)string);
    }

    static /* synthetic */ zzdrw zzr(zzezq zzezq2) {
        return zzezq2.zzf;
    }

    static /* synthetic */ zzdrw zzs(zzezq zzezq2, zzdrw zzdrw2) {
        zzezq2.zzf = zzdrw2;
        return zzdrw2;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private final void zzt(zzbdg zzbdg2, zzccz zzccz2, int n) throws RemoteException {
        synchronized (this) {
            void var3_3;
            zzdrw zzdrw2;
            Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
            this.zzb.zzc((zzccz)zzdrw2);
            zzt.zzc();
            if (zzs.zzK((Context)this.zze) && zzbdg2.zzs == null) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Failed to load the ad because app ID is missing.");
                this.zzb.zzbD(zzfbm.zzd((int)4, null, null));
                return;
            }
            zzdrw2 = this.zzf;
            if (zzdrw2 != null) {
                return;
            }
            zzdrw2 = new zzeze(null);
            this.zza.zzi((int)var3_3);
            zzezm zzezm2 = this.zza;
            String string = this.zzc;
            zzezp zzezp2 = new zzezp(this);
            zzezm2.zza(zzbdg2, string, (zzelw)zzdrw2, (zzelx)zzezp2);
            return;
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            this.zzk(iObjectWrapper, this.zzg);
            return;
        }
    }

    public final void zzc(zzbdg zzbdg2, zzccz zzccz2) throws RemoteException {
        synchronized (this) {
            this.zzt(zzbdg2, zzccz2, 2);
            return;
        }
    }

    public final void zzd(zzbdg zzbdg2, zzccz zzccz2) throws RemoteException {
        synchronized (this) {
            this.zzt(zzbdg2, zzccz2, 3);
            return;
        }
    }

    public final void zze(zzccv zzccv2) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        this.zzb.zzd(zzccv2);
    }

    public final void zzf(zzbgt zzbgt2) {
        if (zzbgt2 == null) {
            this.zzb.zze(null);
            return;
        }
        this.zzb.zze((zzfid)new zzezo(this, zzbgt2));
    }

    public final Bundle zzg() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzdrw zzdrw2 = this.zzf;
        zzdrw2 = zzdrw2 != null ? zzdrw2.zzg() : new Bundle();
        return zzdrw2;
    }

    public final void zzh(zzcdg zzcdg2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
            zzfam zzfam2 = this.zzd;
            zzfam2.zza = zzcdg2.zza;
            zzfam2.zzb = zzcdg2.zzb;
            return;
        }
    }

    public final boolean zzi() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzdrw zzdrw2 = this.zzf;
        if (zzdrw2 == null) return false;
        if (zzdrw2.zzb()) return false;
        return true;
    }

    public final String zzj() throws RemoteException {
        synchronized (this) {
            Object object = this.zzf;
            if (object == null) return null;
            if (object.zzm() == null) return null;
            object = this.zzf.zzm().zze();
            return object;
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, boolean bl) throws RemoteException {
        synchronized (this) {
            Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
            if (this.zzf == null) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Rewarded can not be shown before loaded");
                this.zzb.zzn(zzfbm.zzd((int)9, null, null));
                return;
            }
            iObjectWrapper = (Activity)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
            this.zzf.zza(bl, (Activity)iObjectWrapper);
            return;
        }
    }

    public final zzccp zzl() {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        zzdrw zzdrw2 = this.zzf;
        if (zzdrw2 == null) return null;
        return zzdrw2.zzc();
    }

    public final zzbgz zzm() {
        zzbjd zzbjd2 = zzbjl.zzfb;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return null;
        }
        zzbjd2 = this.zzf;
        if (zzbjd2 == null) return null;
        return zzbjd2.zzm();
    }

    public final void zzn(zzbgw zzbgw2) {
        Preconditions.checkMainThread((String)"setOnPaidEventListener must be called on the main UI thread.");
        this.zzb.zzg(zzbgw2);
    }

    public final void zzo(boolean bl) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setImmersiveMode must be called on the main UI thread.");
            this.zzg = bl;
            return;
        }
    }

    public final void zzp(zzcda zzcda2) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        this.zzb.zzr(zzcda2);
    }
}
