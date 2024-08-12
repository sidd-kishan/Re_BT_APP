/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationSet
 *  android.view.animation.Transformation
 *  androidx.core.view.OneShotPreDrawListener
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;

static class FragmentAnim.EndViewTransitionAnimation
extends AnimationSet
implements Runnable {
    private boolean mAnimating = true;
    private final View mChild;
    private boolean mEnded;
    private final ViewGroup mParent;
    private boolean mTransitionEnded;

    FragmentAnim.EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.mParent = viewGroup;
        this.mChild = view;
        this.addAnimation(animation);
        this.mParent.post((Runnable)this);
    }

    public boolean getTransformation(long l, Transformation transformation) {
        this.mAnimating = true;
        if (this.mEnded) {
            return this.mTransitionEnded ^ true;
        }
        if (super.getTransformation(l, transformation)) return true;
        this.mEnded = true;
        OneShotPreDrawListener.add((View)this.mParent, (Runnable)this);
        return true;
    }

    public boolean getTransformation(long l, Transformation transformation, float f) {
        this.mAnimating = true;
        if (this.mEnded) {
            return this.mTransitionEnded ^ true;
        }
        if (super.getTransformation(l, transformation, f)) return true;
        this.mEnded = true;
        OneShotPreDrawListener.add((View)this.mParent, (Runnable)this);
        return true;
    }

    @Override
    public void run() {
        if (!this.mEnded && this.mAnimating) {
            this.mAnimating = false;
            this.mParent.post((Runnable)this);
        } else {
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
        }
    }
}
