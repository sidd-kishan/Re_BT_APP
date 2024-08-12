/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.foreground.SystemForegroundService
 */
package androidx.work.impl.foreground;

import androidx.work.impl.foreground.SystemForegroundService;

class SystemForegroundService.3
implements Runnable {
    final SystemForegroundService this$0;
    final int val$notificationId;

    SystemForegroundService.3(SystemForegroundService systemForegroundService, int n) {
        this.this$0 = systemForegroundService;
        this.val$notificationId = n;
    }

    @Override
    public void run() {
        this.this$0.mNotificationManager.cancel(this.val$notificationId);
    }
}
