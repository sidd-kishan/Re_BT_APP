/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.zzy
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.common.zza
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

public final class zzw
extends zza
implements zzy {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final IObjectWrapper zzd() throws RemoteException {
        Parcel parcel = this.zzB(1, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final int zze() throws RemoteException {
        Parcel parcel = this.zzB(2, this.zza());
        int n = parcel.readInt();
        parcel.recycle();
        return n;
    }
}
