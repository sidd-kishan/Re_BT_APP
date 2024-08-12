/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbhb
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbly
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmg
 *  com.google.android.gms.internal.ads.zzbmh
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
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmg;
import com.google.android.gms.internal.ads.zzbmh;
import java.util.ArrayList;
import java.util.List;

public final class zzbvs
extends zzadj
implements IInterface {
    zzbvs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final String zze() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final List zzf() throws RemoteException {
        Parcel parcel = this.zzbi(3, this.zza());
        ArrayList arrayList = zzadl.zzg((Parcel)parcel);
        parcel.recycle();
        return arrayList;
    }

    public final String zzg() throws RemoteException {
        Parcel parcel = this.zzbi(4, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final zzbmh zzh() throws RemoteException {
        Parcel parcel = this.zzbi(5, this.zza());
        zzbmh zzbmh2 = zzbmg.zzg((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbmh2;
    }

    public final String zzi() throws RemoteException {
        Parcel parcel = this.zzbi(6, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final String zzj() throws RemoteException {
        Parcel parcel = this.zzbi(7, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final void zzk() throws RemoteException {
        this.zzbj(8, this.zza());
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(9, parcel);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(10, parcel);
    }

    public final boolean zzn() throws RemoteException {
        Parcel parcel = this.zzbi(11, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final boolean zzo() throws RemoteException {
        Parcel parcel = this.zzbi(12, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final Bundle zzp() throws RemoteException {
        Parcel parcel = this.zzbi(13, this.zza());
        Bundle bundle = (Bundle)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR);
        parcel.recycle();
        return bundle;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(14, parcel);
    }

    public final IObjectWrapper zzr() throws RemoteException {
        Parcel parcel = this.zzbi(15, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final zzbhc zzs() throws RemoteException {
        Parcel parcel = this.zzbi(16, this.zza());
        zzbhc zzbhc2 = zzbhb.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbhc2;
    }

    public final zzblz zzt() throws RemoteException {
        Parcel parcel = this.zzbi(19, this.zza());
        zzblz zzblz2 = zzbly.zzj((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzblz2;
    }

    public final IObjectWrapper zzu() throws RemoteException {
        Parcel parcel = this.zzbi(20, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final IObjectWrapper zzv() throws RemoteException {
        Parcel parcel = this.zzbi(21, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final void zzw(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper3);
        this.zzbj(22, parcel);
    }
}
