/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ImageView
 *  com.luck.picture.lib.listener.OnImageCompleteCallback
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.luck.picture.lib.engine;

import android.content.Context;
import android.widget.ImageView;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

public interface ImageEngine {
    public void loadAsGifImage(Context var1, String var2, ImageView var3);

    public void loadFolderImage(Context var1, String var2, ImageView var3);

    public void loadGridImage(Context var1, String var2, ImageView var3);

    public void loadImage(Context var1, String var2, ImageView var3);

    @Deprecated
    public void loadImage(Context var1, String var2, ImageView var3, SubsamplingScaleImageView var4);

    public void loadImage(Context var1, String var2, ImageView var3, SubsamplingScaleImageView var4, OnImageCompleteCallback var5);
}
