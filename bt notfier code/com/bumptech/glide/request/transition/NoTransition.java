/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.transition.NoTransition$NoAnimationFactory
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.Transition$ViewAdapter
 *  com.bumptech.glide.request.transition.TransitionFactory
 */
package com.bumptech.glide.request.transition;

import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;

public class NoTransition<R>
implements Transition<R> {
    static final NoTransition<?> NO_ANIMATION = new NoTransition();
    private static final TransitionFactory<?> NO_ANIMATION_FACTORY = new NoAnimationFactory();

    public static <R> Transition<R> get() {
        return NO_ANIMATION;
    }

    public static <R> TransitionFactory<R> getFactory() {
        return NO_ANIMATION_FACTORY;
    }

    public boolean transition(Object object, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
