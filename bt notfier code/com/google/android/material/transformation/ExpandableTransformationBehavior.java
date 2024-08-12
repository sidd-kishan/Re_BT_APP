/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.view.View
 *  com.google.android.material.transformation.ExpandableBehavior
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.transformation.ExpandableBehavior;

public abstract class ExpandableTransformationBehavior
extends ExpandableBehavior {
    private AnimatorSet currentAnimation;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ AnimatorSet access$002(ExpandableTransformationBehavior expandableTransformationBehavior, AnimatorSet animatorSet) {
        expandableTransformationBehavior.currentAnimation = animatorSet;
        return animatorSet;
    }

    protected abstract AnimatorSet onCreateExpandedStateChangeAnimation(View var1, View var2, boolean var3, boolean var4);

    protected boolean onExpandedStateChange(View view, View view2, boolean bl, boolean bl2) {
        boolean bl3 = this.currentAnimation != null;
        if (bl3) {
            this.currentAnimation.cancel();
        }
        view = this.onCreateExpandedStateChangeAnimation(view, view2, bl, bl3);
        this.currentAnimation = view;
        view.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.currentAnimation.start();
        if (bl2) return true;
        this.currentAnimation.end();
        return true;
    }
}
