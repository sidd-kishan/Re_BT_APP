/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.v4.app.INotificationSideChannel
 *  android.support.v4.app.INotificationSideChannel$Stub
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

/*
 * Exception performing whole class analysis ignored.
 */
private static class INotificationSideChannel.Stub.Proxy
implements INotificationSideChannel {
    public static INotificationSideChannel sDefaultImpl;
    private IBinder mRemote;

    INotificationSideChannel.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void cancel(String string, int n, String string2) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            parcel.writeString(string);
            parcel.writeInt(n);
            parcel.writeString(string2);
            if (this.mRemote.transact(2, parcel, null, 1)) return;
            if (INotificationSideChannel.Stub.getDefaultImpl() == null) return;
            INotificationSideChannel.Stub.getDefaultImpl().cancel(string, n, string2);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void cancelAll(String string) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            parcel.writeString(string);
            if (this.mRemote.transact(3, parcel, null, 1)) return;
            if (INotificationSideChannel.Stub.getDefaultImpl() == null) return;
            INotificationSideChannel.Stub.getDefaultImpl().cancelAll(string);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.app.INotificationSideChannel";
    }

    public void notify(String string, int n, String string2, Notification notification) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            parcel.writeString(string);
            parcel.writeInt(n);
            parcel.writeString(string2);
            if (notification != null) {
                parcel.writeInt(1);
                notification.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (this.mRemote.transact(1, parcel, null, 1)) return;
            if (INotificationSideChannel.Stub.getDefaultImpl() == null) return;
            INotificationSideChannel.Stub.getDefaultImpl().notify(string, n, string2, notification);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
