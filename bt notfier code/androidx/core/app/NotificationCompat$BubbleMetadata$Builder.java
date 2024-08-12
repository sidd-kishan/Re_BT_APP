/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.text.TextUtils
 *  androidx.core.app.NotificationCompat$BubbleMetadata
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;

public static final class NotificationCompat.BubbleMetadata.Builder {
    private PendingIntent mDeleteIntent;
    private int mDesiredHeight;
    private int mDesiredHeightResId;
    private int mFlags;
    private IconCompat mIcon;
    private PendingIntent mPendingIntent;
    private String mShortcutId;

    @Deprecated
    public NotificationCompat.BubbleMetadata.Builder() {
    }

    public NotificationCompat.BubbleMetadata.Builder(PendingIntent pendingIntent, IconCompat iconCompat) {
        if (pendingIntent == null) throw new NullPointerException("Bubble requires non-null pending intent");
        if (iconCompat == null) throw new NullPointerException("Bubbles require non-null icon");
        this.mPendingIntent = pendingIntent;
        this.mIcon = iconCompat;
    }

    public NotificationCompat.BubbleMetadata.Builder(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new NullPointerException("Bubble requires a non-null shortcut id");
        this.mShortcutId = string;
    }

    private NotificationCompat.BubbleMetadata.Builder setFlag(int n, boolean bl) {
        this.mFlags = bl ? n | this.mFlags : ~n & this.mFlags;
        return this;
    }

    public NotificationCompat.BubbleMetadata build() {
        if (this.mShortcutId == null) {
            if (this.mPendingIntent == null) throw new NullPointerException("Must supply pending intent or shortcut to bubble");
        }
        if (this.mShortcutId == null) {
            if (this.mIcon == null) throw new NullPointerException("Must supply an icon or shortcut for the bubble");
        }
        NotificationCompat.BubbleMetadata bubbleMetadata = new NotificationCompat.BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, this.mShortcutId, null);
        bubbleMetadata.setFlags(this.mFlags);
        return bubbleMetadata;
    }

    public NotificationCompat.BubbleMetadata.Builder setAutoExpandBubble(boolean bl) {
        this.setFlag(1, bl);
        return this;
    }

    public NotificationCompat.BubbleMetadata.Builder setDeleteIntent(PendingIntent pendingIntent) {
        this.mDeleteIntent = pendingIntent;
        return this;
    }

    public NotificationCompat.BubbleMetadata.Builder setDesiredHeight(int n) {
        this.mDesiredHeight = Math.max(n, 0);
        this.mDesiredHeightResId = 0;
        return this;
    }

    public NotificationCompat.BubbleMetadata.Builder setDesiredHeightResId(int n) {
        this.mDesiredHeightResId = n;
        this.mDesiredHeight = 0;
        return this;
    }

    public NotificationCompat.BubbleMetadata.Builder setIcon(IconCompat iconCompat) {
        if (this.mShortcutId != null) throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
        if (iconCompat == null) throw new NullPointerException("Bubbles require non-null icon");
        this.mIcon = iconCompat;
        return this;
    }

    public NotificationCompat.BubbleMetadata.Builder setIntent(PendingIntent pendingIntent) {
        if (this.mShortcutId != null) throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
        if (pendingIntent == null) throw new NullPointerException("Bubble requires non-null pending intent");
        this.mPendingIntent = pendingIntent;
        return this;
    }

    public NotificationCompat.BubbleMetadata.Builder setSuppressNotification(boolean bl) {
        this.setFlag(2, bl);
        return this;
    }
}
