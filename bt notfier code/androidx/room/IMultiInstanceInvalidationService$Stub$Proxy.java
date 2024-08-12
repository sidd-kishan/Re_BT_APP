/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.room.IMultiInstanceInvalidationCallback
 *  androidx.room.IMultiInstanceInvalidationService
 */
package androidx.room;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;

private static class IMultiInstanceInvalidationService.Stub.Proxy
implements IMultiInstanceInvalidationService {
    private IBinder mRemote;

    IMultiInstanceInvalidationService.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void broadcastInvalidation(int n, String[] stringArray) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            parcel.writeInt(n);
            parcel.writeStringArray(stringArray);
            this.mRemote.transact(3, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "androidx.room.IMultiInstanceInvalidationService";
    }

    public int registerCallback(IMultiInstanceInvalidationCallback object, String string) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            parcel.writeString(string);
            this.mRemote.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            return n;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback object, int n) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            parcel.writeInt(n);
            this.mRemote.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}
