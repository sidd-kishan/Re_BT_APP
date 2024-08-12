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

class SwipeRefreshLayout.8
extends Animation {
    final SwipeRefreshLayout this$0;

    SwipeRefreshLayout.8(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.this$0.mStartingScale;
        float f3 = -this.this$0.mStartingScale;
        this.this$0.setAnimationProgress(f2 + f3 * f);
        this.this$0.moveToStart(f);
    }
}
