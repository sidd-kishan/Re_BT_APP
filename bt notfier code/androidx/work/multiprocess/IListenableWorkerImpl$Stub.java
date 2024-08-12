/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IListenableWorkerImpl
 *  androidx.work.multiprocess.IListenableWorkerImpl$Stub$Proxy
 *  androidx.work.multiprocess.IWorkManagerImplCallback$Stub
 */
package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IListenableWorkerImpl;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public static abstract class IListenableWorkerImpl.Stub
extends Binder
implements IListenableWorkerImpl {
    private static final String DESCRIPTOR = "androidx.work.multiprocess.IListenableWorkerImpl";
    static final int TRANSACTION_interrupt = 2;
    static final int TRANSACTION_startWork = 1;

    public IListenableWorkerImpl.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IListenableWorkerImpl asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IListenableWorkerImpl)) return new Proxy(iBinder);
        return (IListenableWorkerImpl)iInterface;
    }

    public static IListenableWorkerImpl getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IListenableWorkerImpl iListenableWorkerImpl) {
        if (Proxy.sDefaultImpl != null) throw new IllegalStateException("setDefaultImpl() called twice");
        if (iListenableWorkerImpl == null) return false;
        Proxy.sDefaultImpl = iListenableWorkerImpl;
        return true;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            this.startWork(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
            return true;
        }
        if (n == 2) {
            parcel.enforceInterface(DESCRIPTOR);
            this.interrupt(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
            return true;
        }
        if (n != 1598968902) {
            return super.onTransact(n, parcel, parcel2, n2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
