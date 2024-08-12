/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.appwidget.AppWidgetManager
 *  android.content.ComponentName
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.widget.RemoteViews
 *  com.bumptech.glide.request.target.SimpleTarget
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class AppWidgetTarget
extends SimpleTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context context, int n, int n2, int n3, RemoteViews remoteViews, ComponentName componentName) {
        super(n, n2);
        this.context = (Context)Preconditions.checkNotNull((Object)context, (String)"Context can not be null!");
        this.remoteViews = (RemoteViews)Preconditions.checkNotNull((Object)remoteViews, (String)"RemoteViews object can not be null!");
        this.componentName = (ComponentName)Preconditions.checkNotNull((Object)componentName, (String)"ComponentName can not be null!");
        this.viewId = n3;
        this.widgetIds = null;
    }

    public AppWidgetTarget(Context context, int n, int n2, int n3, RemoteViews remoteViews, int ... nArray) {
        super(n, n2);
        if (nArray.length == 0) throw new IllegalArgumentException("WidgetIds must have length > 0");
        this.context = (Context)Preconditions.checkNotNull((Object)context, (String)"Context can not be null!");
        this.remoteViews = (RemoteViews)Preconditions.checkNotNull((Object)remoteViews, (String)"RemoteViews object can not be null!");
        this.widgetIds = (int[])Preconditions.checkNotNull((Object)nArray, (String)"WidgetIds can not be null!");
        this.viewId = n3;
        this.componentName = null;
    }

    public AppWidgetTarget(Context context, int n, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, n, remoteViews, componentName);
    }

    public AppWidgetTarget(Context context, int n, RemoteViews remoteViews, int ... nArray) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, n, remoteViews, nArray);
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance((Context)this.context);
        ComponentName componentName = this.componentName;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        this.update();
    }
}
