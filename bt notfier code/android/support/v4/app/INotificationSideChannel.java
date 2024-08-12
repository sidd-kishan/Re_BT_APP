/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;
import android.os.RemoteException;

public interface INotificationSideChannel
extends IInterface {
    public void cancel(String var1, int var2, String var3) throws RemoteException;

    public void cancelAll(String var1) throws RemoteException;

    public void notify(String var1, int var2, String var3, Notification var4) throws RemoteException;
}
