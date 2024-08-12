/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zza
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.overlay.zzt
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbzp
 */
package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbzp;

public final class zzu
extends zzbzp {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final void zzb() {
        synchronized (this) {
            if (this.zzd) return;
            zzo zzo2 = this.zza.zzc;
            if (zzo2 != null) {
                zzo2.zzbs(4);
            }
            this.zzd = true;
            return;
        }
    }

    public final void zze() throws RemoteException {
    }

    public final void zzf() throws RemoteException {
        zzo zzo2 = this.zza.zzc;
        if (zzo2 == null) return;
        zzo2.zze();
    }

    public final boolean zzg() throws RemoteException {
        return false;
    }

    public final void zzh(Bundle bundle) {
        boolean bl;
        zzbjd zzbjd2 = zzbjl.zzgn;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            this.zzb.requestWindowFeature(1);
        }
        boolean bl2 = bl = false;
        if (bundle != null) {
            bl2 = bl;
            if (bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
                bl2 = true;
            }
        }
        if ((zzbjd2 = this.zza) == null) {
            this.zzb.finish();
            return;
        }
        if (bl2) {
            this.zzb.finish();
            return;
        }
        if (bundle == null) {
            bundle = zzbjd2.zzb;
            if (bundle != null) {
                bundle.onAdClicked();
            }
            if ((bundle = this.zza.zzy) != null) {
                bundle.zzb();
            }
            if (this.zzb.getIntent() != null && this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (bundle = this.zza.zzc) != null) {
                bundle.zzbp();
            }
        }
        zzt.zza();
        zzbjd2 = this.zzb;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        bundle = adOverlayInfoParcel.zza;
        if (com.google.android.gms.ads.internal.overlay.zza.zzb((Context)zzbjd2, (zzc)bundle, (zzv)adOverlayInfoParcel.zzi, (com.google.android.gms.ads.internal.overlay.zzt)bundle.zzi)) return;
        this.zzb.finish();
    }

    public final void zzi() throws RemoteException {
    }

    public final void zzj() throws RemoteException {
    }

    public final void zzk() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzo zzo2 = this.zza.zzc;
        if (zzo2 == null) return;
        zzo2.zzbr();
    }

    public final void zzl() throws RemoteException {
        zzo zzo2 = this.zza.zzc;
        if (zzo2 != null) {
            zzo2.zzbq();
        }
        if (!this.zzb.isFinishing()) return;
        this.zzb();
    }

    public final void zzm(int n, int n2, Intent intent) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzp() throws RemoteException {
        if (!this.zzb.isFinishing()) return;
        this.zzb();
    }

    public final void zzq() throws RemoteException {
        if (!this.zzb.isFinishing()) return;
        this.zzb();
    }

    public final void zzs() throws RemoteException {
    }
}
