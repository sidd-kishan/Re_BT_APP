/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.Transition$ViewAdapter
 *  com.bumptech.glide.request.transition.ViewTransition$ViewTransitionAnimationFactory
 */
package com.bumptech.glide.request.transition;

import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.ViewTransition;

public class ViewTransition<R>
implements Transition<R> {
    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    public boolean transition(R object, Transition.ViewAdapter viewAdapter) {
        object = viewAdapter.getView();
        if (object == null) return false;
        object.clearAnimation();
        object.startAnimation(this.viewTransitionAnimationFactory.build(object.getContext()));
        return false;
    }
}
