/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.v4.os.IResultReceiver
 *  android.support.v4.os.IResultReceiver$Stub$Proxy
 */
package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

public static abstract class IResultReceiver.Stub
extends Binder
implements IResultReceiver {
    private static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
    static final int TRANSACTION_send = 1;

    public IResultReceiver.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IResultReceiver asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IResultReceiver)) return new Proxy(iBinder);
        return (IResultReceiver)iInterface;
    }

    public static IResultReceiver getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IResultReceiver iResultReceiver) {
        if (Proxy.sDefaultImpl != null) throw new IllegalStateException("setDefaultImpl() called twice");
        if (iResultReceiver == null) return false;
        Proxy.sDefaultImpl = iResultReceiver;
        return true;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 1598968902) {
                return super.onTransact(n, object, parcel, n2);
            }
            parcel.writeString(DESCRIPTOR);
            return true;
        }
        object.enforceInterface(DESCRIPTOR);
        n = object.readInt();
        object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
        this.send(n, (Bundle)object);
        return true;
    }
}
