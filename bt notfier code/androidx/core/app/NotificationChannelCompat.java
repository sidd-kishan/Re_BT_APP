/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.Settings$System
 *  androidx.core.app.NotificationChannelCompat$Builder
 *  androidx.core.util.Preconditions
 */
package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor = 0;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge = true;
    Uri mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    NotificationChannelCompat(NotificationChannel notificationChannel) {
        this(notificationChannel.getId(), notificationChannel.getImportance());
        this.mName = notificationChannel.getName();
        this.mDescription = notificationChannel.getDescription();
        this.mGroupId = notificationChannel.getGroup();
        this.mShowBadge = notificationChannel.canShowBadge();
        this.mSound = notificationChannel.getSound();
        this.mAudioAttributes = notificationChannel.getAudioAttributes();
        this.mLights = notificationChannel.shouldShowLights();
        this.mLightColor = notificationChannel.getLightColor();
        this.mVibrationEnabled = notificationChannel.shouldVibrate();
        this.mVibrationPattern = notificationChannel.getVibrationPattern();
        if (Build.VERSION.SDK_INT >= 30) {
            this.mParentId = notificationChannel.getParentChannelId();
            this.mConversationId = notificationChannel.getConversationId();
        }
        this.mBypassDnd = notificationChannel.canBypassDnd();
        this.mLockscreenVisibility = notificationChannel.getLockscreenVisibility();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mCanBubble = notificationChannel.canBubble();
        }
        if (Build.VERSION.SDK_INT < 30) return;
        this.mImportantConversation = notificationChannel.isImportantConversation();
    }

    NotificationChannelCompat(String string, int n) {
        this.mId = (String)Preconditions.checkNotNull((Object)string);
        this.mImportance = n;
        if (Build.VERSION.SDK_INT < 21) return;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannel getNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(this.mId, this.mName, this.mImportance);
        notificationChannel.setDescription(this.mDescription);
        notificationChannel.setGroup(this.mGroupId);
        notificationChannel.setShowBadge(this.mShowBadge);
        notificationChannel.setSound(this.mSound, this.mAudioAttributes);
        notificationChannel.enableLights(this.mLights);
        notificationChannel.setLightColor(this.mLightColor);
        notificationChannel.setVibrationPattern(this.mVibrationPattern);
        notificationChannel.enableVibration(this.mVibrationEnabled);
        if (Build.VERSION.SDK_INT < 30) return notificationChannel;
        String string = this.mParentId;
        if (string == null) return notificationChannel;
        String string2 = this.mConversationId;
        if (string2 == null) return notificationChannel;
        notificationChannel.setConversationId(string, string2);
        return notificationChannel;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }
}
