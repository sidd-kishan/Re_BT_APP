/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.v4.os.IResultReceiver
 *  android.support.v4.os.IResultReceiver$Stub
 */
package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

/*
 * Exception performing whole class analysis ignored.
 */
private static class IResultReceiver.Stub.Proxy
implements IResultReceiver {
    public static IResultReceiver sDefaultImpl;
    private IBinder mRemote;

    IResultReceiver.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.os.IResultReceiver";
    }

    public void send(int n, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
            parcel.writeInt(n);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (this.mRemote.transact(1, parcel, null, 1)) return;
            if (IResultReceiver.Stub.getDefaultImpl() == null) return;
            IResultReceiver.Stub.getDefaultImpl().send(n, bundle);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
