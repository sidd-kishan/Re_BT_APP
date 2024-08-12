/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.request.transition.DrawableCrossFadeTransition
 *  com.bumptech.glide.request.transition.NoTransition
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.TransitionFactory
 */
package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;

public class DrawableCrossFadeFactory
implements TransitionFactory<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    protected DrawableCrossFadeFactory(int n, boolean bl) {
        this.duration = n;
        this.isCrossFadeEnabled = bl;
    }

    private Transition<Drawable> getResourceTransition() {
        if (this.resourceTransition != null) return this.resourceTransition;
        this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        return this.resourceTransition;
    }

    public Transition<Drawable> build(DataSource object, boolean bl) {
        object = object == DataSource.MEMORY_CACHE ? NoTransition.get() : this.getResourceTransition();
        return object;
    }
}
