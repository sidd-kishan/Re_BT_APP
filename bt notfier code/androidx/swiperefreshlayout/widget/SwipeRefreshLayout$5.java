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

class SwipeRefreshLayout.5
implements Animation.AnimationListener {
    final SwipeRefreshLayout this$0;

    SwipeRefreshLayout.5(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.this$0.mScale) return;
        this.this$0.startScaleDownAnimation(null);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
