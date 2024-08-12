/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  androidx.core.app.NotificationCompat$CarExtender$UnreadConversation
 *  androidx.core.app.RemoteInput
 */
package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.List;

public static class NotificationCompat.CarExtender.UnreadConversation.Builder {
    private long mLatestTimestamp;
    private final List<String> mMessages = new ArrayList<String>();
    private final String mParticipant;
    private PendingIntent mReadPendingIntent;
    private RemoteInput mRemoteInput;
    private PendingIntent mReplyPendingIntent;

    public NotificationCompat.CarExtender.UnreadConversation.Builder(String string) {
        this.mParticipant = string;
    }

    public NotificationCompat.CarExtender.UnreadConversation.Builder addMessage(String string) {
        if (string == null) return this;
        this.mMessages.add(string);
        return this;
    }

    public NotificationCompat.CarExtender.UnreadConversation build() {
        PendingIntent pendingIntent = this.mMessages;
        String[] stringArray = pendingIntent.toArray(new String[pendingIntent.size()]);
        String string = this.mParticipant;
        RemoteInput remoteInput = this.mRemoteInput;
        pendingIntent = this.mReplyPendingIntent;
        PendingIntent pendingIntent2 = this.mReadPendingIntent;
        long l = this.mLatestTimestamp;
        return new NotificationCompat.CarExtender.UnreadConversation(stringArray, remoteInput, pendingIntent, pendingIntent2, new String[]{string}, l);
    }

    public NotificationCompat.CarExtender.UnreadConversation.Builder setLatestTimestamp(long l) {
        this.mLatestTimestamp = l;
        return this;
    }

    public NotificationCompat.CarExtender.UnreadConversation.Builder setReadPendingIntent(PendingIntent pendingIntent) {
        this.mReadPendingIntent = pendingIntent;
        return this;
    }

    public NotificationCompat.CarExtender.UnreadConversation.Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
        this.mRemoteInput = remoteInput;
        this.mReplyPendingIntent = pendingIntent;
        return this;
    }
}
