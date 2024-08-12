/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Transformation
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 */
package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

class SwipeRefreshLayout.6
extends Animation {
    final SwipeRefreshLayout this$0;

    SwipeRefreshLayout.6(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        int n = !this.this$0.mUsingCustomStart ? this.this$0.mSpinnerOffsetEnd - Math.abs(this.this$0.mOriginalOffsetTop) : this.this$0.mSpinnerOffsetEnd;
        int n2 = this.this$0.mFrom;
        int n3 = (int)((float)(n - this.this$0.mFrom) * f);
        n = this.this$0.mCircleView.getTop();
        this.this$0.setTargetOffsetTopAndBottom(n2 + n3 - n);
        this.this$0.mProgress.setArrowScale(1.0f - f);
    }
}
