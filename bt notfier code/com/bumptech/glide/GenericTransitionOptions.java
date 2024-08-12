/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.TransitionOptions
 *  com.bumptech.glide.request.transition.TransitionFactory
 *  com.bumptech.glide.request.transition.ViewPropertyTransition$Animator
 */
package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public final class GenericTransitionOptions<TranscodeType>
extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int n) {
        return (GenericTransitionOptions)new GenericTransitionOptions<TranscodeType>().transition(n);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(TransitionFactory<? super TranscodeType> transitionFactory) {
        return (GenericTransitionOptions)new GenericTransitionOptions<TranscodeType>().transition(transitionFactory);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(ViewPropertyTransition.Animator animator) {
        return (GenericTransitionOptions)new GenericTransitionOptions<TranscodeType>().transition(animator);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return (GenericTransitionOptions)new GenericTransitionOptions<TranscodeType>().dontTransition();
    }
}
