/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbgt
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgy
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzccn
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzccs
 *  com.google.android.gms.internal.ads.zzccv
 *  com.google.android.gms.internal.ads.zzccz
 *  com.google.android.gms.internal.ads.zzcda
 *  com.google.android.gms.internal.ads.zzcdg
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzccn;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcda;
import com.google.android.gms.internal.ads.zzcdg;

public final class zzccq
extends zzadj
implements zzccs {
    zzccq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(5, parcel);
    }

    public final void zzc(zzbdg zzbdg2, zzccz zzccz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzccz2);
        this.zzbj(1, parcel);
    }

    public final void zzd(zzbdg zzbdg2, zzccz zzccz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzccz2);
        this.zzbj(14, parcel);
    }

    public final void zze(zzccv zzccv2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzccv2);
        this.zzbj(2, parcel);
    }

    public final void zzf(zzbgt zzbgt2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgt2);
        this.zzbj(8, parcel);
    }

    public final Bundle zzg() throws RemoteException {
        Parcel parcel = this.zzbi(9, this.zza());
        Bundle bundle = (Bundle)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR);
        parcel.recycle();
        return bundle;
    }

    public final void zzh(zzcdg zzcdg2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzcdg2);
        this.zzbj(7, parcel);
    }

    public final boolean zzi() throws RemoteException {
        throw null;
    }

    public final String zzj() throws RemoteException {
        throw null;
    }

    public final void zzk(IObjectWrapper iObjectWrapper, boolean bl) throws RemoteException {
        throw null;
    }

    public final zzccp zzl() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(11, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem")) instanceof zzccp ? (zzccp)iInterface : new zzccn(object));
        parcel.recycle();
        return object;
    }

    public final zzbgz zzm() throws RemoteException {
        Parcel parcel = this.zzbi(12, this.zza());
        zzbgz zzbgz2 = zzbgy.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbgz2;
    }

    public final void zzn(zzbgw zzbgw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgw2);
        this.zzbj(13, parcel);
    }

    public final void zzo(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(15, parcel);
    }

    public final void zzp(zzcda zzcda2) throws RemoteException {
        throw null;
    }
}
