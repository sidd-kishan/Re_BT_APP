/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.request.transition.Transition$ViewAdapter
 *  com.bumptech.glide.request.transition.ViewPropertyTransition$Animator
 */
package com.bumptech.glide.request.transition;

import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public class ViewPropertyTransition<R>
implements Transition<R> {
    private final Animator animator;

    public ViewPropertyTransition(Animator animator) {
        this.animator = animator;
    }

    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) return false;
        this.animator.animate(viewAdapter.getView());
        return false;
    }
}
