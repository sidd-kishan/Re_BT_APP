/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.request.transition.BitmapContainerTransitionFactory$BitmapGlideAnimation
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.TransitionFactory
 */
package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.BitmapContainerTransitionFactory;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;

public abstract class BitmapContainerTransitionFactory<R>
implements TransitionFactory<R> {
    private final TransitionFactory<Drawable> realFactory;

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.realFactory = transitionFactory;
    }

    public Transition<R> build(DataSource dataSource, boolean bl) {
        return new BitmapGlideAnimation(this, this.realFactory.build(dataSource, bl));
    }

    protected abstract Bitmap getBitmap(R var1);
}
