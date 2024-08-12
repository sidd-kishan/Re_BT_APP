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
 *  com.google.android.gms.internal.common.zza
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzo
extends zza
implements IInterface {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, String string, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        parcel.writeInt(n);
        string = this.zzB(2, parcel);
        iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)string.readStrongBinder());
        string.recycle();
        return iObjectWrapper;
    }

    public final int zzf(IObjectWrapper iObjectWrapper, String string, boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        zzc.zzb((Parcel)parcel, (boolean)bl);
        iObjectWrapper = this.zzB(3, parcel);
        int n = iObjectWrapper.readInt();
        iObjectWrapper.recycle();
        return n;
    }

    public final IObjectWrapper zzg(IObjectWrapper iObjectWrapper, String string, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        parcel.writeInt(n);
        string = this.zzB(4, parcel);
        iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)string.readStrongBinder());
        string.recycle();
        return iObjectWrapper;
    }

    public final int zzh(IObjectWrapper iObjectWrapper, String string, boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        zzc.zzb((Parcel)parcel, (boolean)bl);
        iObjectWrapper = this.zzB(5, parcel);
        int n = iObjectWrapper.readInt();
        iObjectWrapper.recycle();
        return n;
    }

    public final int zzi() throws RemoteException {
        Parcel parcel = this.zzB(6, this.zza());
        int n = parcel.readInt();
        parcel.recycle();
        return n;
    }

    public final IObjectWrapper zzj(IObjectWrapper iObjectWrapper, String string, boolean bl, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        zzc.zzb((Parcel)parcel, (boolean)bl);
        parcel.writeLong(l);
        iObjectWrapper = this.zzB(7, parcel);
        string = IObjectWrapper.Stub.asInterface((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return string;
    }

    public final IObjectWrapper zzk(IObjectWrapper iObjectWrapper, String string, int n, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        parcel.writeInt(n);
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        string = this.zzB(8, parcel);
        iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)string.readStrongBinder());
        string.recycle();
        return iObjectWrapper;
    }
}
