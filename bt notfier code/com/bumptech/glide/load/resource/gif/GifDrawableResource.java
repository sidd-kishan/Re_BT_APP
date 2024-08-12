/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.load.engine.Initializable
 *  com.bumptech.glide.load.resource.drawable.DrawableResource
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 */
package com.bumptech.glide.load.resource.gif;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public class GifDrawableResource
extends DrawableResource<GifDrawable>
implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super((Drawable)gifDrawable);
    }

    public Class<GifDrawable> getResourceClass() {
        return GifDrawable.class;
    }

    public int getSize() {
        return ((GifDrawable)this.drawable).getSize();
    }

    public void initialize() {
        ((GifDrawable)this.drawable).getFirstFrame().prepareToDraw();
    }

    public void recycle() {
        ((GifDrawable)this.drawable).stop();
        ((GifDrawable)this.drawable).recycle();
    }
}
