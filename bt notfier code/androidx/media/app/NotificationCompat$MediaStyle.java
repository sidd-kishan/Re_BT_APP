/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$MediaStyle
 *  android.app.Notification$Style
 *  android.app.PendingIntent
 *  android.media.session.MediaSession$Token
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.widget.RemoteViews
 *  androidx.core.app.BundleCompat
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$Action
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.media.R$id
 *  androidx.media.R$integer
 *  androidx.media.R$layout
 */
package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

public static class NotificationCompat.MediaStyle
extends NotificationCompat.Style {
    private static final int MAX_MEDIA_BUTTONS = 5;
    private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
    int[] mActionsToShowInCompact = null;
    PendingIntent mCancelButtonIntent;
    boolean mShowCancelButton;
    MediaSessionCompat.Token mToken;

    public NotificationCompat.MediaStyle() {
    }

    public NotificationCompat.MediaStyle(NotificationCompat.Builder builder) {
        this.setBuilder(builder);
    }

    private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
        boolean bl = action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
        remoteViews.setImageViewResource(R.id.action0, action.getIcon());
        if (!bl) {
            remoteViews.setOnClickPendingIntent(R.id.action0, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT < 15) return remoteViews;
        remoteViews.setContentDescription(R.id.action0, action.getTitle());
        return remoteViews;
    }

    public static MediaSessionCompat.Token getMediaSession(Notification notification) {
        if ((notification = NotificationCompat.getExtras((Notification)notification)) == null) return null;
        if (Build.VERSION.SDK_INT >= 21) {
            if ((notification = notification.getParcelable("android.mediaSession")) == null) return null;
            return MediaSessionCompat.Token.fromToken((Object)notification);
        }
        IBinder iBinder = BundleCompat.getBinder((Bundle)notification, (String)"android.mediaSession");
        if (iBinder == null) return null;
        notification = Parcel.obtain();
        notification.writeStrongBinder(iBinder);
        notification.setDataPosition(0);
        iBinder = (MediaSessionCompat.Token)MediaSessionCompat.Token.CREATOR.createFromParcel((Parcel)notification);
        notification.recycle();
        return iBinder;
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 21) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)this.fillInMediaStyle(new Notification.MediaStyle()));
        } else {
            if (!this.mShowCancelButton) return;
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
    }

    Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
        Object object = this.mActionsToShowInCompact;
        if (object != null) {
            mediaStyle.setShowActionsInCompactView(object);
        }
        if ((object = (Object)this.mToken) == null) return mediaStyle;
        mediaStyle.setMediaSession((MediaSession.Token)object.getToken());
        return mediaStyle;
    }

    RemoteViews generateBigContentView() {
        int n = Math.min(this.mBuilder.mActions.size(), 5);
        RemoteViews remoteViews = this.applyStandardTemplate(false, this.getBigContentViewLayoutResource(n), false);
        remoteViews.removeAllViews(R.id.media_actions);
        if (n > 0) {
            for (int i = 0; i < n; ++i) {
                RemoteViews remoteViews2 = this.generateMediaActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(i));
                remoteViews.addView(R.id.media_actions, remoteViews2);
            }
        }
        if (this.mShowCancelButton) {
            remoteViews.setViewVisibility(R.id.cancel_action, 0);
            remoteViews.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            remoteViews.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
        } else {
            remoteViews.setViewVisibility(R.id.cancel_action, 8);
        }
        return remoteViews;
    }

    RemoteViews generateContentView() {
        RemoteViews remoteViews = this.applyStandardTemplate(false, this.getContentViewLayoutResource(), true);
        int n = this.mBuilder.mActions.size();
        Object object = this.mActionsToShowInCompact;
        int n2 = object == null ? 0 : Math.min(((int[])object).length, 3);
        remoteViews.removeAllViews(R.id.media_actions);
        if (n2 > 0) {
            for (int i = 0; i < n2; ++i) {
                if (i >= n) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", i, n - 1));
                }
                object = this.generateMediaActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(this.mActionsToShowInCompact[i]));
                remoteViews.addView(R.id.media_actions, (RemoteViews)object);
            }
        }
        if (this.mShowCancelButton) {
            remoteViews.setViewVisibility(R.id.end_padder, 8);
            remoteViews.setViewVisibility(R.id.cancel_action, 0);
            remoteViews.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
            remoteViews.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        } else {
            remoteViews.setViewVisibility(R.id.end_padder, 0);
            remoteViews.setViewVisibility(R.id.cancel_action, 8);
        }
        return remoteViews;
    }

    int getBigContentViewLayoutResource(int n) {
        n = n <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        return n;
    }

    int getContentViewLayoutResource() {
        return R.layout.notification_template_media;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT < 21) return this.generateBigContentView();
        return null;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT < 21) return this.generateContentView();
        return null;
    }

    public NotificationCompat.MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
        this.mCancelButtonIntent = pendingIntent;
        return this;
    }

    public NotificationCompat.MediaStyle setMediaSession(MediaSessionCompat.Token token) {
        this.mToken = token;
        return this;
    }

    public NotificationCompat.MediaStyle setShowActionsInCompactView(int ... nArray) {
        this.mActionsToShowInCompact = nArray;
        return this;
    }

    public NotificationCompat.MediaStyle setShowCancelButton(boolean bl) {
        if (Build.VERSION.SDK_INT >= 21) return this;
        this.mShowCancelButton = bl;
        return this;
    }
}
