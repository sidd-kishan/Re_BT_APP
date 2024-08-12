/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  androidx.collection.ArrayMap
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.collection.ArrayMap;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.util.ArrayList;

private static class AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState
extends Drawable.ConstantState {
    AnimatorSet mAnimatorSet;
    ArrayList<Animator> mAnimators;
    int mChangingConfigurations;
    ArrayMap<Animator, String> mTargetNameMap;
    VectorDrawableCompat mVectorDrawable;

    public AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState(Context object, AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback object2, Resources resources) {
        if (animatedVectorDrawableCompatState == null) return;
        this.mChangingConfigurations = animatedVectorDrawableCompatState.mChangingConfigurations;
        object = animatedVectorDrawableCompatState.mVectorDrawable;
        int n = 0;
        if (object != null) {
            object = object.getConstantState();
            this.mVectorDrawable = resources != null ? (VectorDrawableCompat)object.newDrawable(resources) : (VectorDrawableCompat)object.newDrawable();
            object = (VectorDrawableCompat)this.mVectorDrawable.mutate();
            this.mVectorDrawable = object;
            object.setCallback(object2);
            this.mVectorDrawable.setBounds(animatedVectorDrawableCompatState.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
        }
        if ((object = animatedVectorDrawableCompatState.mAnimators) == null) return;
        int n2 = ((ArrayList)object).size();
        this.mAnimators = new ArrayList(n2);
        this.mTargetNameMap = new ArrayMap(n2);
        while (true) {
            if (n >= n2) {
                this.setupAnimatorSet();
                return;
            }
            object2 = animatedVectorDrawableCompatState.mAnimators.get(n);
            object = object2.clone();
            object2 = (String)animatedVectorDrawableCompatState.mTargetNameMap.get(object2);
            object.setTarget(this.mVectorDrawable.getTargetByName((String)object2));
            this.mAnimators.add((Animator)object);
            this.mTargetNameMap.put(object, object2);
            ++n;
        }
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    public void setupAnimatorSet() {
        if (this.mAnimatorSet == null) {
            this.mAnimatorSet = new AnimatorSet();
        }
        this.mAnimatorSet.playTogether(this.mAnimators);
    }
}
