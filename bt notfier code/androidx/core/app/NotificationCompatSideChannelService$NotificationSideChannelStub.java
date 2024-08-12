/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.RemoteException
 *  android.support.v4.app.INotificationSideChannel$Stub
 *  androidx.core.app.NotificationCompatSideChannelService
 */
package androidx.core.app;

import android.app.Notification;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import androidx.core.app.NotificationCompatSideChannelService;

private class NotificationCompatSideChannelService.NotificationSideChannelStub
extends INotificationSideChannel.Stub {
    final NotificationCompatSideChannelService this$0;

    NotificationCompatSideChannelService.NotificationSideChannelStub(NotificationCompatSideChannelService notificationCompatSideChannelService) {
        this.this$0 = notificationCompatSideChannelService;
    }

    public void cancel(String string, int n, String string2) throws RemoteException {
        this.this$0.checkPermission(NotificationCompatSideChannelService.NotificationSideChannelStub.getCallingUid(), string);
        long l = NotificationCompatSideChannelService.NotificationSideChannelStub.clearCallingIdentity();
        try {
            this.this$0.cancel(string, n, string2);
            return;
        }
        finally {
            NotificationCompatSideChannelService.NotificationSideChannelStub.restoreCallingIdentity((long)l);
        }
    }

    public void cancelAll(String string) {
        this.this$0.checkPermission(NotificationCompatSideChannelService.NotificationSideChannelStub.getCallingUid(), string);
        long l = NotificationCompatSideChannelService.NotificationSideChannelStub.clearCallingIdentity();
        try {
            this.this$0.cancelAll(string);
            return;
        }
        finally {
            NotificationCompatSideChannelService.NotificationSideChannelStub.restoreCallingIdentity((long)l);
        }
    }

    public void notify(String string, int n, String string2, Notification notification) throws RemoteException {
        this.this$0.checkPermission(NotificationCompatSideChannelService.NotificationSideChannelStub.getCallingUid(), string);
        long l = NotificationCompatSideChannelService.NotificationSideChannelStub.clearCallingIdentity();
        try {
            this.this$0.notify(string, n, string2, notification);
            return;
        }
        finally {
            NotificationCompatSideChannelService.NotificationSideChannelStub.restoreCallingIdentity((long)l);
        }
    }
}
