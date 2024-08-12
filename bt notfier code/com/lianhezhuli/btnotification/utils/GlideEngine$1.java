/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.PointF
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 *  com.bumptech.glide.request.target.ImageViewTarget
 *  com.lianhezhuli.btnotification.utils.GlideEngine
 *  com.luck.picture.lib.listener.OnImageCompleteCallback
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.widget.longimage.ImageSource
 *  com.luck.picture.lib.widget.longimage.ImageViewState
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.lianhezhuli.btnotification.utils;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.lianhezhuli.btnotification.utils.GlideEngine;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

class GlideEngine.1
extends ImageViewTarget<Bitmap> {
    final GlideEngine this$0;
    final OnImageCompleteCallback val$callback;
    final ImageView val$imageView;
    final SubsamplingScaleImageView val$longImageView;

    GlideEngine.1(GlideEngine glideEngine, ImageView imageView, OnImageCompleteCallback onImageCompleteCallback, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView2) {
        this.this$0 = glideEngine;
        this.val$callback = onImageCompleteCallback;
        this.val$longImageView = subsamplingScaleImageView;
        this.val$imageView = imageView2;
        super(imageView);
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        drawable = this.val$callback;
        if (drawable == null) return;
        drawable.onHideLoading();
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        drawable = this.val$callback;
        if (drawable == null) return;
        drawable.onShowLoading();
    }

    protected void setResource(Bitmap bitmap) {
        OnImageCompleteCallback onImageCompleteCallback = this.val$callback;
        if (onImageCompleteCallback != null) {
            onImageCompleteCallback.onHideLoading();
        }
        if (bitmap == null) return;
        boolean bl = MediaUtils.isLongImg((int)bitmap.getWidth(), (int)bitmap.getHeight());
        onImageCompleteCallback = this.val$longImageView;
        int n = 8;
        int n2 = bl ? 0 : 8;
        onImageCompleteCallback.setVisibility(n2);
        onImageCompleteCallback = this.val$imageView;
        n2 = bl ? n : 0;
        onImageCompleteCallback.setVisibility(n2);
        if (bl) {
            this.val$longImageView.setQuickScaleEnabled(true);
            this.val$longImageView.setZoomEnabled(true);
            this.val$longImageView.setPanEnabled(true);
            this.val$longImageView.setDoubleTapZoomDuration(100);
            this.val$longImageView.setMinimumScaleType(2);
            this.val$longImageView.setDoubleTapZoomDpi(2);
            this.val$longImageView.setImage(ImageSource.bitmap((Bitmap)bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
        } else {
            this.val$imageView.setImageBitmap(bitmap);
        }
    }
}
