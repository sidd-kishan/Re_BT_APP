/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  com.bumptech.glide.request.target.FixedSizeDrawable
 *  com.bumptech.glide.request.target.ImageViewTarget
 */
package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.request.target.FixedSizeDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;

public abstract class ThumbnailImageViewTarget<T>
extends ImageViewTarget<T> {
    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean bl) {
        super(imageView, bl);
    }

    protected abstract Drawable getDrawable(T var1);

    protected void setResource(T object) {
        ViewGroup.LayoutParams layoutParams = ((ImageView)this.view).getLayoutParams();
        Drawable drawable = this.getDrawable(object);
        object = drawable;
        if (layoutParams != null) {
            object = drawable;
            if (layoutParams.width > 0) {
                object = drawable;
                if (layoutParams.height > 0) {
                    object = new FixedSizeDrawable(drawable, layoutParams.width, layoutParams.height);
                }
            }
        }
        ((ImageView)this.view).setImageDrawable(object);
    }
}
