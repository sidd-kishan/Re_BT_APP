/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.Build$VERSION
 *  androidx.work.impl.foreground.SystemForegroundService
 */
package androidx.work.impl.foreground;

import android.app.Notification;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;

class SystemForegroundService.1
implements Runnable {
    final SystemForegroundService this$0;
    final Notification val$notification;
    final int val$notificationId;
    final int val$notificationType;

    SystemForegroundService.1(SystemForegroundService systemForegroundService, int n, Notification notification, int n2) {
        this.this$0 = systemForegroundService;
        this.val$notificationId = n;
        this.val$notification = notification;
        this.val$notificationType = n2;
    }

    @Override
    public void run() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.this$0.startForeground(this.val$notificationId, this.val$notification, this.val$notificationType);
        } else {
            this.this$0.startForeground(this.val$notificationId, this.val$notification);
        }
    }
}
