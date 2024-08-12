/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 */
package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

class SwipeRefreshLayout.1
implements Animation.AnimationListener {
    final SwipeRefreshLayout this$0;

    SwipeRefreshLayout.1(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.this$0.mRefreshing) {
            this.this$0.mProgress.setAlpha(255);
            this.this$0.mProgress.start();
            if (this.this$0.mNotify && this.this$0.mListener != null) {
                this.this$0.mListener.onRefresh();
            }
            animation = this.this$0;
            animation.mCurrentTargetOffsetTop = animation.mCircleView.getTop();
        } else {
            this.this$0.reset();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
