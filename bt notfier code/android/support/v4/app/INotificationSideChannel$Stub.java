/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.v4.app.INotificationSideChannel
 *  android.support.v4.app.INotificationSideChannel$Stub$Proxy
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

public static abstract class INotificationSideChannel.Stub
extends Binder
implements INotificationSideChannel {
    private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;

    public INotificationSideChannel.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static INotificationSideChannel asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof INotificationSideChannel)) return new Proxy(iBinder);
        return (INotificationSideChannel)iInterface;
    }

    public static INotificationSideChannel getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(INotificationSideChannel iNotificationSideChannel) {
        if (Proxy.sDefaultImpl != null) throw new IllegalStateException("setDefaultImpl() called twice");
        if (iNotificationSideChannel == null) return false;
        Proxy.sDefaultImpl = iNotificationSideChannel;
        return true;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel object, Parcel object2, int n2) throws RemoteException {
        if (n != 1) {
            if (n == 2) {
                object.enforceInterface(DESCRIPTOR);
                this.cancel(object.readString(), object.readInt(), object.readString());
                return true;
            }
            if (n == 3) {
                object.enforceInterface(DESCRIPTOR);
                this.cancelAll(object.readString());
                return true;
            }
            if (n != 1598968902) {
                return super.onTransact(n, object, object2, n2);
            }
            object2.writeString(DESCRIPTOR);
            return true;
        }
        object.enforceInterface(DESCRIPTOR);
        object2 = object.readString();
        n = object.readInt();
        String string = object.readString();
        object = object.readInt() != 0 ? (Notification)Notification.CREATOR.createFromParcel(object) : null;
        this.notify((String)object2, n, string, (Notification)object);
        return true;
    }
}
