/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout
 */
package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;

class QMUICollapsingTopBarLayout.2
implements ValueAnimator.AnimatorUpdateListener {
    final QMUICollapsingTopBarLayout this$0;

    QMUICollapsingTopBarLayout.2(QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout) {
        this.this$0 = qMUICollapsingTopBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.setScrimAlpha(((Integer)valueAnimator.getAnimatedValue()).intValue());
    }
}
