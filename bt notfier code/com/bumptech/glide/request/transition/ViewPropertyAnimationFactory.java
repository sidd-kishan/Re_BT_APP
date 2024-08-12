/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.request.transition.NoTransition
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.TransitionFactory
 *  com.bumptech.glide.request.transition.ViewPropertyTransition
 *  com.bumptech.glide.request.transition.ViewPropertyTransition$Animator
 */
package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public class ViewPropertyAnimationFactory<R>
implements TransitionFactory<R> {
    private ViewPropertyTransition<R> animation;
    private final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.animator = animator;
    }

    public Transition<R> build(DataSource dataSource, boolean bl) {
        if (dataSource == DataSource.MEMORY_CACHE) return NoTransition.get();
        if (!bl) {
            return NoTransition.get();
        }
        if (this.animation != null) return this.animation;
        this.animation = new ViewPropertyTransition(this.animator);
        return this.animation;
    }
}
