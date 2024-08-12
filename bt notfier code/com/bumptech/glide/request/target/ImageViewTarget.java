/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 *  com.bumptech.glide.request.target.ViewTarget
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.Transition$ViewAdapter
 */
package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z>
extends ViewTarget<ImageView, Z>
implements Transition.ViewAdapter {
    private Animatable animatable;

    public ImageViewTarget(ImageView imageView) {
        super((View)imageView);
    }

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean bl) {
        super((View)imageView, bl);
    }

    private void maybeUpdateAnimatable(Z object) {
        if (object instanceof Animatable) {
            object = (Animatable)object;
            this.animatable = object;
            object.start();
        } else {
            this.animatable = null;
        }
    }

    private void setResourceInternal(Z z) {
        this.setResource(z);
        this.maybeUpdateAnimatable(z);
    }

    public Drawable getCurrentDrawable() {
        return ((ImageView)this.view).getDrawable();
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.stop();
        }
        this.setResourceInternal(null);
        this.setDrawable(drawable);
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        this.setResourceInternal(null);
        this.setDrawable(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        this.setResourceInternal(null);
        this.setDrawable(drawable);
    }

    public void onResourceReady(Z z, Transition<? super Z> transition) {
        if (transition != null && transition.transition(z, (Transition.ViewAdapter)this)) {
            this.maybeUpdateAnimatable(z);
        } else {
            this.setResourceInternal(z);
        }
    }

    public void onStart() {
        Animatable animatable = this.animatable;
        if (animatable == null) return;
        animatable.start();
    }

    public void onStop() {
        Animatable animatable = this.animatable;
        if (animatable == null) return;
        animatable.stop();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    protected abstract void setResource(Z var1);
}
