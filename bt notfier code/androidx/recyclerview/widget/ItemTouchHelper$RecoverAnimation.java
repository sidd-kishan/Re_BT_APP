/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;

static class ItemTouchHelper.RecoverAnimation
implements Animator.AnimatorListener {
    final int mActionState;
    final int mAnimationType;
    boolean mEnded = false;
    private float mFraction;
    boolean mIsPendingCleanup;
    boolean mOverridden = false;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    final ValueAnimator mValueAnimator;
    final RecyclerView.ViewHolder mViewHolder;
    float mX;
    float mY;

    ItemTouchHelper.RecoverAnimation(RecyclerView.ViewHolder viewHolder, int n, int n2, float f, float f2, float f3, float f4) {
        ValueAnimator valueAnimator;
        this.mActionState = n2;
        this.mAnimationType = n;
        this.mViewHolder = viewHolder;
        this.mStartDx = f;
        this.mStartDy = f2;
        this.mTargetX = f3;
        this.mTargetY = f4;
        this.mValueAnimator = valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mValueAnimator.setTarget((Object)viewHolder.itemView);
        this.mValueAnimator.addListener((Animator.AnimatorListener)this);
        this.setFraction(0.0f);
    }

    public void cancel() {
        this.mValueAnimator.cancel();
    }

    public void onAnimationCancel(Animator animator) {
        this.setFraction(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.mEnded) {
            this.mViewHolder.setIsRecyclable(true);
        }
        this.mEnded = true;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void setDuration(long l) {
        this.mValueAnimator.setDuration(l);
    }

    public void setFraction(float f) {
        this.mFraction = f;
    }

    public void start() {
        this.mViewHolder.setIsRecyclable(false);
        this.mValueAnimator.start();
    }

    public void update() {
        float f = this.mStartDx;
        float f2 = this.mTargetX;
        this.mX = f == f2 ? this.mViewHolder.itemView.getTranslationX() : f + this.mFraction * (f2 - f);
        f2 = this.mStartDy;
        f = this.mTargetY;
        this.mY = f2 == f ? this.mViewHolder.itemView.getTranslationY() : f2 + this.mFraction * (f - f2);
    }
}
