/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  androidx.transition.R$id
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.transition.R;
import androidx.transition.Transition;

private static class TranslationAnimationCreator.TransitionPositionListener
extends AnimatorListenerAdapter
implements Transition.TransitionListener {
    private final View mMovingView;
    private float mPausedX;
    private float mPausedY;
    private final int mStartX;
    private final int mStartY;
    private final float mTerminalX;
    private final float mTerminalY;
    private int[] mTransitionPosition;
    private final View mViewInHierarchy;

    TranslationAnimationCreator.TransitionPositionListener(View object, View view, int n, int n2, float f, float f2) {
        this.mMovingView = object;
        this.mViewInHierarchy = view;
        this.mStartX = n - Math.round(object.getTranslationX());
        this.mStartY = n2 - Math.round(this.mMovingView.getTranslationY());
        this.mTerminalX = f;
        this.mTerminalY = f2;
        object = (int[])this.mViewInHierarchy.getTag(R.id.transition_position);
        this.mTransitionPosition = (int[])object;
        if (object == null) return;
        this.mViewInHierarchy.setTag(R.id.transition_position, null);
    }

    public void onAnimationCancel(Animator animator) {
        if (this.mTransitionPosition == null) {
            this.mTransitionPosition = new int[2];
        }
        this.mTransitionPosition[0] = Math.round((float)this.mStartX + this.mMovingView.getTranslationX());
        this.mTransitionPosition[1] = Math.round((float)this.mStartY + this.mMovingView.getTranslationY());
        this.mViewInHierarchy.setTag(R.id.transition_position, (Object)this.mTransitionPosition);
    }

    public void onAnimationPause(Animator animator) {
        this.mPausedX = this.mMovingView.getTranslationX();
        this.mPausedY = this.mMovingView.getTranslationY();
        this.mMovingView.setTranslationX(this.mTerminalX);
        this.mMovingView.setTranslationY(this.mTerminalY);
    }

    public void onAnimationResume(Animator animator) {
        this.mMovingView.setTranslationX(this.mPausedX);
        this.mMovingView.setTranslationY(this.mPausedY);
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        this.mMovingView.setTranslationX(this.mTerminalX);
        this.mMovingView.setTranslationY(this.mTerminalY);
        transition.removeListener((Transition.TransitionListener)this);
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
