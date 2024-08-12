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

class SwipeRefreshLayout.7
extends Animation {
    final SwipeRefreshLayout this$0;

    SwipeRefreshLayout.7(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.this$0.moveToStart(f);
    }
}
