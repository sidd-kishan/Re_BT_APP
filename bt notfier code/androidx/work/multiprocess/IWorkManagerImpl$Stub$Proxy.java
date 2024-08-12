/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IWorkManagerImpl
 *  androidx.work.multiprocess.IWorkManagerImpl$Stub
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 */
package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImpl;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/*
 * Exception performing whole class analysis ignored.
 */
private static class IWorkManagerImpl.Stub.Proxy
implements IWorkManagerImpl {
    public static IWorkManagerImpl sDefaultImpl;
    private IBinder mRemote;

    IWorkManagerImpl.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(6, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().cancelAllWork(iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void cancelAllWorkByTag(String string, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            parcel.writeString(string);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(4, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().cancelAllWorkByTag(string, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void cancelUniqueWork(String string, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            parcel.writeString(string);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(5, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().cancelUniqueWork(string, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void cancelWorkById(String string, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            parcel.writeString(string);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(3, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().cancelWorkById(string, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void enqueueContinuation(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            parcel.writeByteArray(byArray);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(2, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().enqueueContinuation(byArray, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void enqueueWorkRequests(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            parcel.writeByteArray(byArray);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(1, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().enqueueWorkRequests(byArray, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "androidx.work.multiprocess.IWorkManagerImpl";
    }

    public void queryWorkInfo(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            parcel.writeByteArray(byArray);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(7, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().queryWorkInfo(byArray, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void setProgress(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
            parcel.writeByteArray(byArray);
            IBinder iBinder = iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            if (this.mRemote.transact(8, parcel, null, 1)) return;
            if (IWorkManagerImpl.Stub.getDefaultImpl() == null) return;
            IWorkManagerImpl.Stub.getDefaultImpl().setProgress(byArray, iWorkManagerImplCallback);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
