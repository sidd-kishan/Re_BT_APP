/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BubbleMetadata
 *  android.app.PendingIntent
 *  android.os.Build$VERSION
 *  androidx.core.app.NotificationCompat$BubbleMetadata$Api29Impl
 *  androidx.core.app.NotificationCompat$BubbleMetadata$Api30Impl
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class NotificationCompat.BubbleMetadata {
    private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
    private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
    private PendingIntent mDeleteIntent;
    private int mDesiredHeight;
    private int mDesiredHeightResId;
    private int mFlags;
    private IconCompat mIcon;
    private PendingIntent mPendingIntent;
    private String mShortcutId;

    private NotificationCompat.BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int n, int n2, int n3, String string) {
        this.mPendingIntent = pendingIntent;
        this.mIcon = iconCompat;
        this.mDesiredHeight = n;
        this.mDesiredHeightResId = n2;
        this.mDeleteIntent = pendingIntent2;
        this.mFlags = n3;
        this.mShortcutId = string;
    }

    public static NotificationCompat.BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
        if (bubbleMetadata == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.fromPlatform((Notification.BubbleMetadata)bubbleMetadata);
        }
        if (Build.VERSION.SDK_INT != 29) return null;
        return Api29Impl.fromPlatform((Notification.BubbleMetadata)bubbleMetadata);
    }

    public static Notification.BubbleMetadata toPlatform(NotificationCompat.BubbleMetadata bubbleMetadata) {
        if (bubbleMetadata == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.toPlatform((NotificationCompat.BubbleMetadata)bubbleMetadata);
        }
        if (Build.VERSION.SDK_INT != 29) return null;
        return Api29Impl.toPlatform((NotificationCompat.BubbleMetadata)bubbleMetadata);
    }

    public boolean getAutoExpandBubble() {
        int n = this.mFlags;
        boolean bl = true;
        if ((n & 1) != 0) return bl;
        bl = false;
        return bl;
    }

    public PendingIntent getDeleteIntent() {
        return this.mDeleteIntent;
    }

    public int getDesiredHeight() {
        return this.mDesiredHeight;
    }

    public int getDesiredHeightResId() {
        return this.mDesiredHeightResId;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    public String getShortcutId() {
        return this.mShortcutId;
    }

    public boolean isNotificationSuppressed() {
        boolean bl = (this.mFlags & 2) != 0;
        return bl;
    }

    public void setFlags(int n) {
        this.mFlags = n;
    }
}
