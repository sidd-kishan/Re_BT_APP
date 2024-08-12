/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  androidx.core.app.RemoteInput
 */
package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.app.RemoteInput;

@Deprecated
public static class NotificationCompat.CarExtender.UnreadConversation {
    private final long mLatestTimestamp;
    private final String[] mMessages;
    private final String[] mParticipants;
    private final PendingIntent mReadPendingIntent;
    private final RemoteInput mRemoteInput;
    private final PendingIntent mReplyPendingIntent;

    NotificationCompat.CarExtender.UnreadConversation(String[] stringArray, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] stringArray2, long l) {
        this.mMessages = stringArray;
        this.mRemoteInput = remoteInput;
        this.mReadPendingIntent = pendingIntent2;
        this.mReplyPendingIntent = pendingIntent;
        this.mParticipants = stringArray2;
        this.mLatestTimestamp = l;
    }

    public long getLatestTimestamp() {
        return this.mLatestTimestamp;
    }

    public String[] getMessages() {
        return this.mMessages;
    }

    public String getParticipant() {
        Object object = this.mParticipants;
        object = ((String[])object).length > 0 ? object[0] : null;
        return object;
    }

    public String[] getParticipants() {
        return this.mParticipants;
    }

    public PendingIntent getReadPendingIntent() {
        return this.mReadPendingIntent;
    }

    public RemoteInput getRemoteInput() {
        return this.mRemoteInput;
    }

    public PendingIntent getReplyPendingIntent() {
        return this.mReplyPendingIntent;
    }
}
