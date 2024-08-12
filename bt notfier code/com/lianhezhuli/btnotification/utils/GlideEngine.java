/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ImageView
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.target.Target
 *  com.luck.picture.lib.engine.ImageEngine
 *  com.luck.picture.lib.listener.OnImageCompleteCallback
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

public class GlideEngine
implements ImageEngine {
    private static GlideEngine instance;

    private GlideEngine() {
    }

    public static GlideEngine createGlideEngine() {
        if (instance != null) return instance;
        synchronized (GlideEngine.class) {
            GlideEngine glideEngine;
            if (instance != null) return instance;
            instance = glideEngine = new GlideEngine();
        }
        return instance;
    }

    public void loadAsGifImage(Context context, String string, ImageView imageView) {
        Glide.with((Context)context).asGif().load(string).into(imageView);
    }

    public void loadFolderImage(Context context, String string, ImageView imageView) {
        Glide.with((Context)context).asBitmap().load(string).apply(new RequestOptions().placeholder(2131230921).override(180, 180).centerCrop().sizeMultiplier(0.5f)).into((Target)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void loadGridImage(Context context, String string, ImageView imageView) {
        Glide.with((Context)context).load(string).apply(new RequestOptions().placeholder(2131230921).override(200, 200).centerCrop()).into(imageView);
    }

    public void loadImage(Context context, String string, ImageView imageView) {
        Glide.with((Context)context).load(string).into(imageView);
    }

    public void loadImage(Context context, String string, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
        Glide.with((Context)context).asBitmap().load(string).into((Target)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void loadImage(Context context, String string, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback) {
        Glide.with((Context)context).asBitmap().load(string).into((Target)new /* Unavailable Anonymous Inner Class!! */);
    }
}
