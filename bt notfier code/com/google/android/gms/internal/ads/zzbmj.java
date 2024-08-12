/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbml
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbml;

public final class zzbmj
extends zzadj
implements zzbml {
    zzbmj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final void zzb(String string, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(1, parcel);
    }

    public final void zzbu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(9, parcel);
    }

    public final void zzbv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(7, parcel);
    }

    public final void zzbw(zzbme zzbme2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbme2);
        this.zzbj(8, parcel);
    }

    public final IObjectWrapper zzc(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel = this.zzbi(2, parcel);
        string = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return string;
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(3, parcel);
    }

    public final void zze() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzf(IObjectWrapper iObjectWrapper, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeInt(n);
        this.zzbj(5, parcel);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(6, parcel);
    }
}
