/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  androidx.room.IMultiInstanceInvalidationCallback
 *  androidx.room.IMultiInstanceInvalidationCallback$Stub$Proxy
 */
package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

public static abstract class IMultiInstanceInvalidationCallback.Stub
extends Binder
implements IMultiInstanceInvalidationCallback {
    private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationCallback";
    static final int TRANSACTION_onInvalidation = 1;

    public IMultiInstanceInvalidationCallback.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IMultiInstanceInvalidationCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IMultiInstanceInvalidationCallback)) return new Proxy(iBinder);
        return (IMultiInstanceInvalidationCallback)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            this.onInvalidation(parcel.createStringArray());
            return true;
        }
        if (n != 1598968902) {
            return super.onTransact(n, parcel, parcel2, n2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
