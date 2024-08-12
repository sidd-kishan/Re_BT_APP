/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.support.v4.app.INotificationSideChannel
 *  androidx.core.app.NotificationManagerCompat$Task
 */
package androidx.core.app;

import android.content.ComponentName;
import android.support.v4.app.INotificationSideChannel;
import androidx.core.app.NotificationManagerCompat;
import java.util.ArrayDeque;

private static class NotificationManagerCompat.SideChannelManager.ListenerRecord {
    boolean bound = false;
    final ComponentName componentName;
    int retryCount = 0;
    INotificationSideChannel service;
    ArrayDeque<NotificationManagerCompat.Task> taskQueue = new ArrayDeque();

    NotificationManagerCompat.SideChannelManager.ListenerRecord(ComponentName componentName) {
        this.componentName = componentName;
    }
}
