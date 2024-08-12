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

public final class zzp
extends zza
implements IInterface {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, String string, int n, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        parcel.writeInt(n);
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        iObjectWrapper = this.zzB(2, parcel);
        string = IObjectWrapper.Stub.asInterface((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return string;
    }

    public final IObjectWrapper zzf(IObjectWrapper iObjectWrapper, String string, int n, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        parcel.writeInt(n);
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        iObjectWrapper = this.zzB(3, parcel);
        string = IObjectWrapper.Stub.asInterface((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return string;
    }
}
