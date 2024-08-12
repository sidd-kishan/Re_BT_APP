/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.widget.RemoteViews
 *  com.bumptech.glide.request.target.SimpleTarget
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class NotificationTarget
extends SimpleTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context context, int n, int n2, int n3, RemoteViews remoteViews, Notification notification, int n4, String string) {
        super(n, n2);
        this.context = (Context)Preconditions.checkNotNull((Object)context, (String)"Context must not be null!");
        this.notification = (Notification)Preconditions.checkNotNull((Object)notification, (String)"Notification object can not be null!");
        this.remoteViews = (RemoteViews)Preconditions.checkNotNull((Object)remoteViews, (String)"RemoteViews object can not be null!");
        this.viewId = n3;
        this.notificationId = n4;
        this.notificationTag = string;
    }

    public NotificationTarget(Context context, int n, RemoteViews remoteViews, Notification notification, int n2) {
        this(context, n, remoteViews, notification, n2, null);
    }

    public NotificationTarget(Context context, int n, RemoteViews remoteViews, Notification notification, int n2, String string) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, n, remoteViews, notification, n2, string);
    }

    private void update() {
        ((NotificationManager)Preconditions.checkNotNull((Object)((NotificationManager)this.context.getSystemService("notification")))).notify(this.notificationTag, this.notificationId, this.notification);
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        this.update();
    }
}
