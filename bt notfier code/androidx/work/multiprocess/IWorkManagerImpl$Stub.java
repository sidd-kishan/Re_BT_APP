/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IWorkManagerImpl
 *  androidx.work.multiprocess.IWorkManagerImpl$Stub$Proxy
 *  androidx.work.multiprocess.IWorkManagerImplCallback$Stub
 */
package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImpl;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public static abstract class IWorkManagerImpl.Stub
extends Binder
implements IWorkManagerImpl {
    private static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";
    static final int TRANSACTION_cancelAllWork = 6;
    static final int TRANSACTION_cancelAllWorkByTag = 4;
    static final int TRANSACTION_cancelUniqueWork = 5;
    static final int TRANSACTION_cancelWorkById = 3;
    static final int TRANSACTION_enqueueContinuation = 2;
    static final int TRANSACTION_enqueueWorkRequests = 1;
    static final int TRANSACTION_queryWorkInfo = 7;
    static final int TRANSACTION_setProgress = 8;

    public IWorkManagerImpl.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IWorkManagerImpl asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IWorkManagerImpl)) return new Proxy(iBinder);
        return (IWorkManagerImpl)iInterface;
    }

    public static IWorkManagerImpl getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IWorkManagerImpl iWorkManagerImpl) {
        if (Proxy.sDefaultImpl != null) throw new IllegalStateException("setDefaultImpl() called twice");
        if (iWorkManagerImpl == null) return false;
        Proxy.sDefaultImpl = iWorkManagerImpl;
        return true;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n == 1598968902) {
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 8: {
                parcel.enforceInterface(DESCRIPTOR);
                this.setProgress(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                return true;
            }
            case 7: {
                parcel.enforceInterface(DESCRIPTOR);
                this.queryWorkInfo(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                return true;
            }
            case 6: {
                parcel.enforceInterface(DESCRIPTOR);
                this.cancelAllWork(IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                return true;
            }
            case 5: {
                parcel.enforceInterface(DESCRIPTOR);
                this.cancelUniqueWork(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                return true;
            }
            case 4: {
                parcel.enforceInterface(DESCRIPTOR);
                this.cancelAllWorkByTag(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                return true;
            }
            case 3: {
                parcel.enforceInterface(DESCRIPTOR);
                this.cancelWorkById(parcel.readString(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                return true;
            }
            case 2: {
                parcel.enforceInterface(DESCRIPTOR);
                this.enqueueContinuation(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface(DESCRIPTOR);
        this.enqueueWorkRequests(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()));
        return true;
    }
}
