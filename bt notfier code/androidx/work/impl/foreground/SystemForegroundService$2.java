/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  androidx.work.impl.foreground.SystemForegroundService
 */
package androidx.work.impl.foreground;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

class SystemForegroundService.2
implements Runnable {
    final SystemForegroundService this$0;
    final Notification val$notification;
    final int val$notificationId;

    SystemForegroundService.2(SystemForegroundService systemForegroundService, int n, Notification notification) {
        this.this$0 = systemForegroundService;
        this.val$notificationId = n;
        this.val$notification = notification;
    }

    @Override
    public void run() {
        this.this$0.mNotificationManager.notify(this.val$notificationId, this.val$notification);
    }
}
