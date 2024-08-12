/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza
implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zza(IBinder iBinder, String string) {
        this.zza = iBinder;
        this.zzb = "com.google.android.gms.appset.internal.IAppSetService";
    }

    public final IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel zza() {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken(this.zzb);
        return parcel;
    }

    protected final void zzb(int n, Parcel parcel) throws RemoteException {
        Parcel parcel2 = Parcel.obtain();
        try {
            this.zza.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }
}
