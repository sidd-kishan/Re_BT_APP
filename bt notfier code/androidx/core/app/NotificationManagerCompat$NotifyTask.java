/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.RemoteException
 *  android.support.v4.app.INotificationSideChannel
 *  androidx.core.app.NotificationManagerCompat$Task
 */
package androidx.core.app;

import android.app.Notification;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import androidx.core.app.NotificationManagerCompat;

private static class NotificationManagerCompat.NotifyTask
implements NotificationManagerCompat.Task {
    final int id;
    final Notification notif;
    final String packageName;
    final String tag;

    NotificationManagerCompat.NotifyTask(String string, int n, String string2, Notification notification) {
        this.packageName = string;
        this.id = n;
        this.tag = string2;
        this.notif = notification;
    }

    public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
        iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
        stringBuilder.append("packageName:");
        stringBuilder.append(this.packageName);
        stringBuilder.append(", id:");
        stringBuilder.append(this.id);
        stringBuilder.append(", tag:");
        stringBuilder.append(this.tag);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
