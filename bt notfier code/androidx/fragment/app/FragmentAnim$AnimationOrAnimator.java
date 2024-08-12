/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.animation.Animation
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

static class FragmentAnim.AnimationOrAnimator {
    public final Animation animation;
    public final Animator animator;

    FragmentAnim.AnimationOrAnimator(Animator animator) {
        this.animation = null;
        this.animator = animator;
        if (animator == null) throw new IllegalStateException("Animator cannot be null");
    }

    FragmentAnim.AnimationOrAnimator(Animation animation) {
        this.animation = animation;
        this.animator = null;
        if (animation == null) throw new IllegalStateException("Animation cannot be null");
    }
}
