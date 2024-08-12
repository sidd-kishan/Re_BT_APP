/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation
 */
package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;

class ItemTouchHelper.RecoverAnimation.1
implements ValueAnimator.AnimatorUpdateListener {
    final ItemTouchHelper.RecoverAnimation this$0;

    ItemTouchHelper.RecoverAnimation.1(ItemTouchHelper.RecoverAnimation recoverAnimation) {
        this.this$0 = recoverAnimation;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.setFraction(valueAnimator.getAnimatedFraction());
    }
}
