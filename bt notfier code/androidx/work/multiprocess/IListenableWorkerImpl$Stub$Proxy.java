/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IListenableWorkerImpl
 *  androidx.work.multiprocess.IListenableWorkerImpl$Stub
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 */
package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IListenableWorkerImpl;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/*
 * Exception performing whole class analysis ignored.
 */
private static class IListenableWorkerImpl.Stub.Proxy
implements IListenableWorkerImpl {
    public static IListenableWorkerImpl sDefaultImpl;
    private IBinder mRemote;

    IListenableWorkerImpl.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "androidx.work.multiprocess.IListenableWorkerImpl";
    }

    public void interrupt(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IListenableWorkerImpl");
            parcel.writeByteArray(byArray);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(2, parcel, null, 1)) return;
            if (IListenableWorkerImpl.Stub.getDefaultImpl() == null) return;
            IListenableWorkerImpl.Stub.getDefaultImpl().interrupt(byArray, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void startWork(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IListenableWorkerImpl");
            parcel.writeByteArray(byArray);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(1, parcel, null, 1)) return;
            if (IListenableWorkerImpl.Stub.getDefaultImpl() == null) return;
            IListenableWorkerImpl.Stub.getDefaultImpl().startWork(byArray, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
