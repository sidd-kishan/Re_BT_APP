/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader
 */
package com.bumptech.glide.load.resource.gif;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;

static final class GifDrawable.GifState
extends Drawable.ConstantState {
    final GifFrameLoader frameLoader;

    GifDrawable.GifState(GifFrameLoader gifFrameLoader) {
        this.frameLoader = gifFrameLoader;
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        return new GifDrawable(this);
    }

    public Drawable newDrawable(Resources resources) {
        return this.newDrawable();
    }
}
