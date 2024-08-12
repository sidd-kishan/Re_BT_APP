/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 */
package com.qmuiteam.qmui.util;

import android.animation.ValueAnimator;
import android.view.View;
import com.qmuiteam.qmui.util.QMUIViewHelper;

/*
 * Exception performing whole class analysis ignored.
 */
static final class QMUIViewHelper.3
implements ValueAnimator.AnimatorUpdateListener {
    final View val$v;

    QMUIViewHelper.3(View view) {
        this.val$v = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        QMUIViewHelper.setBackgroundColorKeepPadding((View)this.val$v, (int)((Integer)valueAnimator.getAnimatedValue()));
    }
}
