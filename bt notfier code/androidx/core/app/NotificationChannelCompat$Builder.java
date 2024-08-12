/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.core.app.NotificationChannelCompat
 */
package androidx.core.app;

import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationChannelCompat;

public static class NotificationChannelCompat.Builder {
    private final NotificationChannelCompat mChannel;

    public NotificationChannelCompat.Builder(String string, int n) {
        this.mChannel = new NotificationChannelCompat(string, n);
    }

    public NotificationChannelCompat build() {
        return this.mChannel;
    }

    public NotificationChannelCompat.Builder setConversationId(String string, String string2) {
        if (Build.VERSION.SDK_INT < 30) return this;
        this.mChannel.mParentId = string;
        this.mChannel.mConversationId = string2;
        return this;
    }

    public NotificationChannelCompat.Builder setDescription(String string) {
        this.mChannel.mDescription = string;
        return this;
    }

    public NotificationChannelCompat.Builder setGroup(String string) {
        this.mChannel.mGroupId = string;
        return this;
    }

    public NotificationChannelCompat.Builder setImportance(int n) {
        this.mChannel.mImportance = n;
        return this;
    }

    public NotificationChannelCompat.Builder setLightColor(int n) {
        this.mChannel.mLightColor = n;
        return this;
    }

    public NotificationChannelCompat.Builder setLightsEnabled(boolean bl) {
        this.mChannel.mLights = bl;
        return this;
    }

    public NotificationChannelCompat.Builder setName(CharSequence charSequence) {
        this.mChannel.mName = charSequence;
        return this;
    }

    public NotificationChannelCompat.Builder setShowBadge(boolean bl) {
        this.mChannel.mShowBadge = bl;
        return this;
    }

    public NotificationChannelCompat.Builder setSound(Uri uri, AudioAttributes audioAttributes) {
        this.mChannel.mSound = uri;
        this.mChannel.mAudioAttributes = audioAttributes;
        return this;
    }

    public NotificationChannelCompat.Builder setVibrationEnabled(boolean bl) {
        this.mChannel.mVibrationEnabled = bl;
        return this;
    }

    public NotificationChannelCompat.Builder setVibrationPattern(long[] lArray) {
        NotificationChannelCompat notificationChannelCompat = this.mChannel;
        boolean bl = lArray != null && lArray.length > 0;
        notificationChannelCompat.mVibrationEnabled = bl;
        this.mChannel.mVibrationPattern = lArray;
        return this;
    }
}
