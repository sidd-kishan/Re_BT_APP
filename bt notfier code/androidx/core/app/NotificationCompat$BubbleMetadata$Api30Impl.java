/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BubbleMetadata
 *  android.app.Notification$BubbleMetadata$Builder
 *  android.graphics.drawable.Icon
 *  androidx.core.app.NotificationCompat$BubbleMetadata
 *  androidx.core.app.NotificationCompat$BubbleMetadata$Builder
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.graphics.drawable.Icon;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;

private static class NotificationCompat.BubbleMetadata.Api30Impl {
    private NotificationCompat.BubbleMetadata.Api30Impl() {
    }

    static NotificationCompat.BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
        if (bubbleMetadata == null) {
            return null;
        }
        NotificationCompat.BubbleMetadata.Builder builder = bubbleMetadata.getShortcutId() != null ? new NotificationCompat.BubbleMetadata.Builder(bubbleMetadata.getShortcutId()) : new NotificationCompat.BubbleMetadata.Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon((Icon)bubbleMetadata.getIcon()));
        builder.setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
        if (bubbleMetadata.getDesiredHeight() != 0) {
            builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
        }
        if (bubbleMetadata.getDesiredHeightResId() == 0) return builder.build();
        builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
        return builder.build();
    }

    static Notification.BubbleMetadata toPlatform(NotificationCompat.BubbleMetadata bubbleMetadata) {
        if (bubbleMetadata == null) {
            return null;
        }
        Notification.BubbleMetadata.Builder builder = bubbleMetadata.getShortcutId() != null ? new Notification.BubbleMetadata.Builder(bubbleMetadata.getShortcutId()) : new Notification.BubbleMetadata.Builder(bubbleMetadata.getIntent(), bubbleMetadata.getIcon().toIcon());
        builder.setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
        if (bubbleMetadata.getDesiredHeight() != 0) {
            builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
        }
        if (bubbleMetadata.getDesiredHeightResId() == 0) return builder.build();
        builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
        return builder.build();
    }
}
