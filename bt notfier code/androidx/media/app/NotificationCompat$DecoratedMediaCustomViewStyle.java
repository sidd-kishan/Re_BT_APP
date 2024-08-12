/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$DecoratedMediaCustomViewStyle
 *  android.app.Notification$MediaStyle
 *  android.app.Notification$Style
 *  android.os.Build$VERSION
 *  android.widget.RemoteViews
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.media.R$color
 *  androidx.media.R$id
 *  androidx.media.R$layout
 *  androidx.media.app.NotificationCompat$MediaStyle
 */
package androidx.media.app;

import android.app.Notification;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.media.R;
import androidx.media.app.NotificationCompat;

public static class NotificationCompat.DecoratedMediaCustomViewStyle
extends NotificationCompat.MediaStyle {
    private void setBackgroundColor(RemoteViews remoteViews) {
        int n = this.mBuilder.getColor() != 0 ? this.mBuilder.getColor() : this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
        remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", n);
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)this.fillInMediaStyle((Notification.MediaStyle)new Notification.DecoratedMediaCustomViewStyle()));
        } else {
            super.apply(notificationBuilderWithBuilderAccessor);
        }
    }

    int getBigContentViewLayoutResource(int n) {
        n = n <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        return n;
    }

    int getContentViewLayoutResource() {
        int n = this.mBuilder.getContentView() != null ? R.layout.notification_template_media_custom : super.getContentViewLayoutResource();
        return n;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView() != null ? this.mBuilder.getBigContentView() : this.mBuilder.getContentView();
        if (notificationBuilderWithBuilderAccessor == null) {
            return null;
        }
        RemoteViews remoteViews = this.generateBigContentView();
        this.buildIntoRemoteViews(remoteViews, (RemoteViews)notificationBuilderWithBuilderAccessor);
        if (Build.VERSION.SDK_INT < 21) return remoteViews;
        this.setBackgroundColor(remoteViews);
        return remoteViews;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
        boolean bl = true;
        boolean bl2 = notificationBuilderWithBuilderAccessor != null;
        if (Build.VERSION.SDK_INT < 21) {
            notificationBuilderWithBuilderAccessor = this.generateContentView();
            if (!bl2) return null;
            this.buildIntoRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, this.mBuilder.getContentView());
            return notificationBuilderWithBuilderAccessor;
        }
        boolean bl3 = bl;
        if (!bl2) {
            bl3 = this.mBuilder.getBigContentView() != null ? bl : false;
        }
        if (!bl3) return null;
        notificationBuilderWithBuilderAccessor = this.generateContentView();
        if (bl2) {
            this.buildIntoRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, this.mBuilder.getContentView());
        }
        this.setBackgroundColor((RemoteViews)notificationBuilderWithBuilderAccessor);
        return notificationBuilderWithBuilderAccessor;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getHeadsUpContentView() != null ? this.mBuilder.getHeadsUpContentView() : this.mBuilder.getContentView();
        if (notificationBuilderWithBuilderAccessor == null) {
            return null;
        }
        RemoteViews remoteViews = this.generateBigContentView();
        this.buildIntoRemoteViews(remoteViews, (RemoteViews)notificationBuilderWithBuilderAccessor);
        if (Build.VERSION.SDK_INT < 21) return remoteViews;
        this.setBackgroundColor(remoteViews);
        return remoteViews;
    }
}
