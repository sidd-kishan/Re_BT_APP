/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigPictureStyle
 *  android.graphics.Bitmap
 */
package androidx.core.app;

import android.app.Notification;
import android.graphics.Bitmap;

private static class NotificationCompat.BigPictureStyle.Api16Impl {
    private NotificationCompat.BigPictureStyle.Api16Impl() {
    }

    static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
        bigPictureStyle.bigLargeIcon(bitmap);
    }

    static void setSummaryText(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
        bigPictureStyle.setSummaryText(charSequence);
    }
}
