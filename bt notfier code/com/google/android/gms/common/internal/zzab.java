/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.GetServiceRequest
 *  com.google.android.gms.common.internal.IGmsCallbacks
 *  com.google.android.gms.common.internal.IGmsServiceBroker
 *  com.google.android.gms.common.internal.zzl
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.zzl;

final class zzab
implements IGmsServiceBroker {
    private final IBinder zza;

    zzab(IBinder iBinder) {
        this.zza = iBinder;
    }

    public final IBinder asBinder() {
        return this.zza;
    }

    public final void getService(IGmsCallbacks object, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            if (getServiceRequest != null) {
                parcel.writeInt(1);
                zzl.zza((GetServiceRequest)getServiceRequest, (Parcel)parcel, (int)0);
            } else {
                parcel.writeInt(0);
            }
            this.zza.transact(46, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}
