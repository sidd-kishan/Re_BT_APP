/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigPictureStyle
 *  android.graphics.drawable.Icon
 */
package androidx.core.app;

import android.app.Notification;
import android.graphics.drawable.Icon;

private static class NotificationCompat.BigPictureStyle.Api23Impl {
    private NotificationCompat.BigPictureStyle.Api23Impl() {
    }

    static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
        bigPictureStyle.bigLargeIcon(icon);
    }
}
