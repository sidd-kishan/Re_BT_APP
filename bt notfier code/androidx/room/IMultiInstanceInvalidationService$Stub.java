/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.room.IMultiInstanceInvalidationCallback$Stub
 *  androidx.room.IMultiInstanceInvalidationService
 *  androidx.room.IMultiInstanceInvalidationService$Stub$Proxy
 */
package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;

public static abstract class IMultiInstanceInvalidationService.Stub
extends Binder
implements IMultiInstanceInvalidationService {
    private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";
    static final int TRANSACTION_broadcastInvalidation = 3;
    static final int TRANSACTION_registerCallback = 1;
    static final int TRANSACTION_unregisterCallback = 2;

    public IMultiInstanceInvalidationService.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IMultiInstanceInvalidationService asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IMultiInstanceInvalidationService)) return new Proxy(iBinder);
        return (IMultiInstanceInvalidationService)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            n = this.registerCallback(IMultiInstanceInvalidationCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(n);
            return true;
        }
        if (n == 2) {
            parcel.enforceInterface(DESCRIPTOR);
            this.unregisterCallback(IMultiInstanceInvalidationCallback.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
        if (n == 3) {
            parcel.enforceInterface(DESCRIPTOR);
            this.broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        if (n != 1598968902) {
            return super.onTransact(n, parcel, parcel2, n2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
