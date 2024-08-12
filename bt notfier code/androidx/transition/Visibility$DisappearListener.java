/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.AnimatorUtils$AnimatorPauseListenerCompat
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.ViewGroupUtils
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;

private static class Visibility.DisappearListener
extends AnimatorListenerAdapter
implements Transition.TransitionListener,
AnimatorUtils.AnimatorPauseListenerCompat {
    boolean mCanceled = false;
    private final int mFinalVisibility;
    private boolean mLayoutSuppressed;
    private final ViewGroup mParent;
    private final boolean mSuppressLayout;
    private final View mView;

    Visibility.DisappearListener(View view, int n, boolean bl) {
        this.mView = view;
        this.mFinalVisibility = n;
        this.mParent = (ViewGroup)view.getParent();
        this.mSuppressLayout = bl;
        this.suppressLayout(true);
    }

    private void hideViewWhenNotCanceled() {
        if (!this.mCanceled) {
            ViewUtils.setTransitionVisibility((View)this.mView, (int)this.mFinalVisibility);
            ViewGroup viewGroup = this.mParent;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        this.suppressLayout(false);
    }

    private void suppressLayout(boolean bl) {
        if (!this.mSuppressLayout) return;
        if (this.mLayoutSuppressed == bl) return;
        ViewGroup viewGroup = this.mParent;
        if (viewGroup == null) return;
        this.mLayoutSuppressed = bl;
        ViewGroupUtils.suppressLayout((ViewGroup)viewGroup, (boolean)bl);
    }

    public void onAnimationCancel(Animator animator) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(Animator animator) {
        this.hideViewWhenNotCanceled();
    }

    public void onAnimationPause(Animator animator) {
        if (this.mCanceled) return;
        ViewUtils.setTransitionVisibility((View)this.mView, (int)this.mFinalVisibility);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationResume(Animator animator) {
        if (this.mCanceled) return;
        ViewUtils.setTransitionVisibility((View)this.mView, (int)0);
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        this.hideViewWhenNotCanceled();
        transition.removeListener((Transition.TransitionListener)this);
    }

    public void onTransitionPause(Transition transition) {
        this.suppressLayout(false);
    }

    public void onTransitionResume(Transition transition) {
        this.suppressLayout(true);
    }

    public void onTransitionStart(Transition transition) {
    }
}
