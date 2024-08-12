/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 *  androidx.work.multiprocess.IWorkManagerImplCallback$Stub$Proxy
 */
package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public static abstract class IWorkManagerImplCallback.Stub
extends Binder
implements IWorkManagerImplCallback {
    private static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImplCallback";
    static final int TRANSACTION_onFailure = 2;
    static final int TRANSACTION_onSuccess = 1;

    public IWorkManagerImplCallback.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IWorkManagerImplCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IWorkManagerImplCallback)) return new Proxy(iBinder);
        return (IWorkManagerImplCallback)iInterface;
    }

    public static IWorkManagerImplCallback getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IWorkManagerImplCallback iWorkManagerImplCallback) {
        if (Proxy.sDefaultImpl != null) throw new IllegalStateException("setDefaultImpl() called twice");
        if (iWorkManagerImplCallback == null) return false;
        Proxy.sDefaultImpl = iWorkManagerImplCallback;
        return true;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            this.onSuccess(parcel.createByteArray());
            return true;
        }
        if (n == 2) {
            parcel.enforceInterface(DESCRIPTOR);
            this.onFailure(parcel.readString());
            return true;
        }
        if (n != 1598968902) {
            return super.onTransact(n, parcel, parcel2, n2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
