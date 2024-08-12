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

class SwipeRefreshLayout.4
extends Animation {
    final SwipeRefreshLayout this$0;
    final int val$endingAlpha;
    final int val$startingAlpha;

    SwipeRefreshLayout.4(SwipeRefreshLayout swipeRefreshLayout, int n, int n2) {
        this.this$0 = swipeRefreshLayout;
        this.val$startingAlpha = n;
        this.val$endingAlpha = n2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        transformation = this.this$0.mProgress;
        int n = this.val$startingAlpha;
        transformation.setAlpha((int)((float)n + (float)(this.val$endingAlpha - n) * f));
    }
}
