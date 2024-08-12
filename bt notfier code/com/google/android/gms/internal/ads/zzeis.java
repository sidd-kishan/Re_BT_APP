/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzccj
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzdba
 *  com.google.android.gms.internal.ads.zzdcj
 *  com.google.android.gms.internal.ads.zzddi
 *  com.google.android.gms.internal.ads.zzdix
 *  com.google.android.gms.internal.ads.zzeit
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzccj;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzdba;
import com.google.android.gms.internal.ads.zzdcj;
import com.google.android.gms.internal.ads.zzddi;
import com.google.android.gms.internal.ads.zzdix;
import com.google.android.gms.internal.ads.zzeit;

final class zzeis
extends zzccj {
    final zzddi zza;
    final zzdba zzb;
    final zzdcj zzc;
    final zzdix zzd;

    zzeis(zzeit zzeit2, zzddi zzddi2, zzdba zzdba2, zzdcj zzdcj2, zzdix zzdix2) {
        this.zza = zzddi2;
        this.zzb = zzdba2;
        this.zzc = zzdcj2;
        this.zzd = zzdix2;
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    public final void zzf(IObjectWrapper iObjectWrapper, int n) {
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zza.zzbp();
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzd.zza();
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzbs(4);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzccl zzccl2) {
        this.zzd.zzb(zzccl2);
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    public final void zzm(IObjectWrapper iObjectWrapper, int n) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzc.zzf();
    }
}
