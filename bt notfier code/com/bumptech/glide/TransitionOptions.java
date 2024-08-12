/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.transition.NoTransition
 *  com.bumptech.glide.request.transition.TransitionFactory
 *  com.bumptech.glide.request.transition.ViewAnimationFactory
 *  com.bumptech.glide.request.transition.ViewPropertyAnimationFactory
 *  com.bumptech.glide.request.transition.ViewPropertyTransition$Animator
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide;

import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType>
implements Cloneable {
    private TransitionFactory<? super TranscodeType> transitionFactory = NoTransition.getFactory();

    private CHILD self() {
        return (CHILD)this;
    }

    public final CHILD clone() {
        TransitionOptions transitionOptions;
        try {
            transitionOptions = (TransitionOptions)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
        return (CHILD)transitionOptions;
    }

    public final CHILD dontTransition() {
        return this.transition(NoTransition.getFactory());
    }

    final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    public final CHILD transition(int n) {
        return this.transition((TransitionFactory<? super TranscodeType>)new ViewAnimationFactory(n));
    }

    public final CHILD transition(TransitionFactory<? super TranscodeType> transitionFactory) {
        this.transitionFactory = (TransitionFactory)Preconditions.checkNotNull(transitionFactory);
        return this.self();
    }

    public final CHILD transition(ViewPropertyTransition.Animator animator) {
        return this.transition((TransitionFactory<? super TranscodeType>)new ViewPropertyAnimationFactory(animator));
    }
}
