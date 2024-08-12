/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$DecoratedCustomViewStyle
 *  android.app.Notification$Style
 *  android.os.Build$VERSION
 *  android.widget.RemoteViews
 *  androidx.core.R$color
 *  androidx.core.R$id
 *  androidx.core.R$layout
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat$Action
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public static class NotificationCompat.DecoratedCustomViewStyle
extends NotificationCompat.Style {
    private static final int MAX_ACTION_BUTTONS = 3;
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

    private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean bl) {
        boolean bl2;
        int n;
        int n2 = R.layout.notification_template_custom_big;
        boolean bl3 = true;
        int n3 = 0;
        RemoteViews remoteViews2 = this.applyStandardTemplate(true, n2, false);
        remoteViews2.removeAllViews(R.id.actions);
        List<NotificationCompat.Action> list = NotificationCompat.DecoratedCustomViewStyle.getNonContextualActions(this.mBuilder.mActions);
        if (bl && list != null && (n = Math.min(list.size(), 3)) > 0) {
            n2 = 0;
            while (true) {
                bl2 = bl3;
                if (n2 < n) {
                    RemoteViews remoteViews3 = this.generateActionButton(list.get(n2));
                    remoteViews2.addView(R.id.actions, remoteViews3);
                    ++n2;
                    continue;
                }
                break;
            }
        } else {
            bl2 = false;
        }
        n2 = bl2 ? n3 : 8;
        remoteViews2.setViewVisibility(R.id.actions, n2);
        remoteViews2.setViewVisibility(R.id.action_divider, n2);
        this.buildIntoRemoteViews(remoteViews2, remoteViews);
        return remoteViews2;
    }

    private RemoteViews generateActionButton(NotificationCompat.Action action) {
        boolean bl = action.actionIntent == null;
        String string = this.mBuilder.mContext.getPackageName();
        int n = bl ? R.layout.notification_action_tombstone : R.layout.notification_action;
        string = new RemoteViews(string, n);
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            string.setImageViewBitmap(R.id.action_image, this.createColoredBitmap(iconCompat, this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
        }
        string.setTextViewText(R.id.action_text, action.title);
        if (!bl) {
            string.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
        }
        if (Build.VERSION.SDK_INT < 15) return string;
        string.setContentDescription(R.id.action_container, action.title);
        return string;
    }

    private static List<NotificationCompat.Action> getNonContextualActions(List<NotificationCompat.Action> action) {
        if (action == null) {
            return null;
        }
        ArrayList<NotificationCompat.Action> arrayList = new ArrayList<NotificationCompat.Action>();
        Iterator<NotificationCompat.Action> iterator = action.iterator();
        while (iterator.hasNext()) {
            action = iterator.next();
            if (action.isContextual()) continue;
            arrayList.add(action);
        }
        return arrayList;
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT < 24) return;
        notificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)new Notification.DecoratedCustomViewStyle());
    }

    public boolean displayCustomViewInline() {
        return true;
    }

    protected String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView();
        if (notificationBuilderWithBuilderAccessor == null) {
            notificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
        }
        if (notificationBuilderWithBuilderAccessor != null) return this.createRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, true);
        return null;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        if (this.mBuilder.getContentView() != null) return this.createRemoteViews(this.mBuilder.getContentView(), false);
        return null;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 24) {
            return null;
        }
        RemoteViews remoteViews = this.mBuilder.getHeadsUpContentView();
        notificationBuilderWithBuilderAccessor = remoteViews != null ? remoteViews : this.mBuilder.getContentView();
        if (remoteViews != null) return this.createRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, true);
        return null;
    }
}
