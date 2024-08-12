/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 *  androidx.work.multiprocess.IWorkManagerImplCallback$Stub
 */
package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/*
 * Exception performing whole class analysis ignored.
 */
private static class IWorkManagerImplCallback.Stub.Proxy
implements IWorkManagerImplCallback {
    public static IWorkManagerImplCallback sDefaultImpl;
    private IBinder mRemote;

    IWorkManagerImplCallback.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "androidx.work.multiprocess.IWorkManagerImplCallback";
    }

    public void onFailure(String string) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImplCallback");
            parcel.writeString(string);
            if (this.mRemote.transact(2, parcel, null, 1)) return;
            if (IWorkManagerImplCallback.Stub.getDefaultImpl() == null) return;
            IWorkManagerImplCallback.Stub.getDefaultImpl().onFailure(string);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onSuccess(byte[] byArray) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImplCallback");
            parcel.writeByteArray(byArray);
            if (this.mRemote.transact(1, parcel, null, 1)) return;
            if (IWorkManagerImplCallback.Stub.getDefaultImpl() == null) return;
            IWorkManagerImplCallback.Stub.getDefaultImpl().onSuccess(byArray);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
