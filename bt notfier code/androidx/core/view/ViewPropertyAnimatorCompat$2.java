/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorUpdateListener
 */
package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

class ViewPropertyAnimatorCompat.2
implements ValueAnimator.AnimatorUpdateListener {
    final ViewPropertyAnimatorCompat this$0;
    final ViewPropertyAnimatorUpdateListener val$listener;
    final View val$view;

    ViewPropertyAnimatorCompat.2(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.this$0 = viewPropertyAnimatorCompat;
        this.val$listener = viewPropertyAnimatorUpdateListener;
        this.val$view = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.val$listener.onAnimationUpdate(this.val$view);
    }
}
