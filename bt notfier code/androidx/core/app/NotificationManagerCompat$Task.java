/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.support.v4.app.INotificationSideChannel
 */
package androidx.core.app;

import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

private static interface NotificationManagerCompat.Task {
    public void send(INotificationSideChannel var1) throws RemoteException;
}
