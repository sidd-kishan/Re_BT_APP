/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.animation.Animation
 *  com.bumptech.glide.request.transition.ViewTransition$ViewTransitionAnimationFactory
 */
package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.ViewTransition;

private static class ViewAnimationFactory.ConcreteViewTransitionAnimationFactory
implements ViewTransition.ViewTransitionAnimationFactory {
    private final Animation animation;

    ViewAnimationFactory.ConcreteViewTransitionAnimationFactory(Animation animation) {
        this.animation = animation;
    }

    public Animation build(Context context) {
        return this.animation;
    }
}
