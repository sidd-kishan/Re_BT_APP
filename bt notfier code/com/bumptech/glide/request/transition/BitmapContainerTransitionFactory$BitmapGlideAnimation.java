/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.Transition$ViewAdapter
 */
package com.bumptech.glide.request.transition;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.transition.BitmapContainerTransitionFactory;
import com.bumptech.glide.request.transition.Transition;

private final class BitmapContainerTransitionFactory.BitmapGlideAnimation
implements Transition<R> {
    final BitmapContainerTransitionFactory this$0;
    private final Transition<Drawable> transition;

    BitmapContainerTransitionFactory.BitmapGlideAnimation(BitmapContainerTransitionFactory bitmapContainerTransitionFactory, Transition<Drawable> transition) {
        this.this$0 = bitmapContainerTransitionFactory;
        this.transition = transition;
    }

    public boolean transition(R object, Transition.ViewAdapter viewAdapter) {
        object = new BitmapDrawable(viewAdapter.getView().getResources(), this.this$0.getBitmap(object));
        return this.transition.transition(object, viewAdapter);
    }
}
