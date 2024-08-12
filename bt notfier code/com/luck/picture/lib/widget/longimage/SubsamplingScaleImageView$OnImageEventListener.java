/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.widget.longimage;

public static interface SubsamplingScaleImageView.OnImageEventListener {
    public void onImageLoadError(Exception var1);

    public void onImageLoaded();

    public void onPreviewLoadError(Exception var1);

    public void onPreviewReleased();

    public void onReady();

    public void onTileLoadError(Exception var1);
}
