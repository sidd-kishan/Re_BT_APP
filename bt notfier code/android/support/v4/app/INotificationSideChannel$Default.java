/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.support.v4.app.INotificationSideChannel
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

public static class INotificationSideChannel.Default
implements INotificationSideChannel {
    public IBinder asBinder() {
        return null;
    }

    public void cancel(String string, int n, String string2) throws RemoteException {
    }

    public void cancelAll(String string) throws RemoteException {
    }

    public void notify(String string, int n, String string2, Notification notification) throws RemoteException {
    }
}
