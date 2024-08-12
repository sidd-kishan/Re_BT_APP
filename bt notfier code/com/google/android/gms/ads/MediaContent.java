/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.google.android.gms.ads.VideoController
 */
package com.google.android.gms.ads;

import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.VideoController;

public interface MediaContent {
    public float getAspectRatio();

    public float getCurrentTime();

    public float getDuration();

    public Drawable getMainImage();

    public VideoController getVideoController();

    public boolean hasVideoContent();

    public void setMainImage(Drawable var1);
}
