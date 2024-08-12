/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  com.bumptech.glide.request.transition.ViewTransition$ViewTransitionAnimationFactory
 */
package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.request.transition.ViewTransition;

private static class ViewAnimationFactory.ResourceViewTransitionAnimationFactory
implements ViewTransition.ViewTransitionAnimationFactory {
    private final int animationId;

    ViewAnimationFactory.ResourceViewTransitionAnimationFactory(int n) {
        this.animationId = n;
    }

    public Animation build(Context context) {
        return AnimationUtils.loadAnimation((Context)context, (int)this.animationId);
    }
}
