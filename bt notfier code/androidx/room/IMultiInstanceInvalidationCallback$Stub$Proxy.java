/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.room.IMultiInstanceInvalidationCallback
 */
package androidx.room;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

private static class IMultiInstanceInvalidationCallback.Stub.Proxy
implements IMultiInstanceInvalidationCallback {
    private IBinder mRemote;

    IMultiInstanceInvalidationCallback.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "androidx.room.IMultiInstanceInvalidationCallback";
    }

    public void onInvalidation(String[] stringArray) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
            parcel.writeStringArray(stringArray);
            this.mRemote.transact(1, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
