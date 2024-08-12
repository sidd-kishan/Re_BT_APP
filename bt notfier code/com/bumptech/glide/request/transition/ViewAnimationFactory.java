/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.request.transition.NoTransition
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.TransitionFactory
 *  com.bumptech.glide.request.transition.ViewAnimationFactory$ConcreteViewTransitionAnimationFactory
 *  com.bumptech.glide.request.transition.ViewAnimationFactory$ResourceViewTransitionAnimationFactory
 *  com.bumptech.glide.request.transition.ViewTransition
 *  com.bumptech.glide.request.transition.ViewTransition$ViewTransitionAnimationFactory
 */
package com.bumptech.glide.request.transition;

import android.view.animation.Animation;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewTransition;

public class ViewAnimationFactory<R>
implements TransitionFactory<R> {
    private Transition<R> transition;
    private final ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public ViewAnimationFactory(int n) {
        this((ViewTransition.ViewTransitionAnimationFactory)new ResourceViewTransitionAnimationFactory(n));
    }

    public ViewAnimationFactory(Animation animation) {
        this((ViewTransition.ViewTransitionAnimationFactory)new ConcreteViewTransitionAnimationFactory(animation));
    }

    ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    public Transition<R> build(DataSource dataSource, boolean bl) {
        if (dataSource == DataSource.MEMORY_CACHE) return NoTransition.get();
        if (!bl) {
            return NoTransition.get();
        }
        if (this.transition != null) return this.transition;
        this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
        return this.transition;
    }
}
