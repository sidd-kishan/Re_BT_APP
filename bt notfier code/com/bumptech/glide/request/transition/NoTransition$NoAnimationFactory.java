/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.request.transition.NoTransition
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.TransitionFactory
 */
package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;

public static class NoTransition.NoAnimationFactory<R>
implements TransitionFactory<R> {
    public Transition<R> build(DataSource dataSource, boolean bl) {
        return NoTransition.NO_ANIMATION;
    }
}
