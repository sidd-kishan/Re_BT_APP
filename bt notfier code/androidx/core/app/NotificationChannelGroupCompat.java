/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.NotificationChannel
 *  android.app.NotificationChannelGroup
 *  android.os.Build$VERSION
 *  androidx.core.app.NotificationChannelCompat
 *  androidx.core.app.NotificationChannelGroupCompat$Builder
 *  androidx.core.util.Preconditions
 */
package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationChannelGroupCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels = Collections.emptyList();
    String mDescription;
    final String mId;
    CharSequence mName;

    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup, List<NotificationChannel> list) {
        this(notificationChannelGroup.getId());
        this.mName = notificationChannelGroup.getName();
        if (Build.VERSION.SDK_INT >= 28) {
            this.mDescription = notificationChannelGroup.getDescription();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.mBlocked = notificationChannelGroup.isBlocked();
            this.mChannels = this.getChannelsCompat(notificationChannelGroup.getChannels());
        } else {
            this.mChannels = this.getChannelsCompat(list);
        }
    }

    NotificationChannelGroupCompat(String string) {
        this.mId = (String)Preconditions.checkNotNull((Object)string);
    }

    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> notificationChannel) {
        ArrayList<NotificationChannelCompat> arrayList = new ArrayList<NotificationChannelCompat>();
        Iterator<NotificationChannel> iterator = notificationChannel.iterator();
        while (iterator.hasNext()) {
            notificationChannel = iterator.next();
            if (!this.mId.equals(notificationChannel.getGroup())) continue;
            arrayList.add(new NotificationChannelCompat(notificationChannel));
        }
        return arrayList;
    }

    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(this.mId, this.mName);
        if (Build.VERSION.SDK_INT < 28) return notificationChannelGroup;
        notificationChannelGroup.setDescription(this.mDescription);
        return notificationChannelGroup;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }
}
