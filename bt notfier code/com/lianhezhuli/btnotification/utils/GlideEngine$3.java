/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 *  androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
 *  com.bumptech.glide.request.target.BitmapImageViewTarget
 *  com.lianhezhuli.btnotification.utils.GlideEngine
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lianhezhuli.btnotification.utils.GlideEngine;

class GlideEngine.3
extends BitmapImageViewTarget {
    final GlideEngine this$0;
    final Context val$context;
    final ImageView val$imageView;

    GlideEngine.3(GlideEngine glideEngine, ImageView imageView, Context context, ImageView imageView2) {
        this.this$0 = glideEngine;
        this.val$context = context;
        this.val$imageView = imageView2;
        super(imageView);
    }

    protected void setResource(Bitmap bitmap) {
        bitmap = RoundedBitmapDrawableFactory.create((Resources)this.val$context.getResources(), (Bitmap)bitmap);
        bitmap.setCornerRadius(8.0f);
        this.val$imageView.setImageDrawable((Drawable)bitmap);
    }
}
