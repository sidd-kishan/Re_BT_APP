/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.appbar.HeaderBehavior
 */
package com.google.android.material.appbar;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.HeaderBehavior;

private class HeaderBehavior.FlingRunnable
implements Runnable {
    private final V layout;
    private final CoordinatorLayout parent;
    final HeaderBehavior this$0;

    HeaderBehavior.FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
        this.this$0 = var1_1;
        this.parent = coordinatorLayout;
        this.layout = v;
    }

    @Override
    public void run() {
        if (this.layout == null) return;
        if (this.this$0.scroller == null) return;
        if (this.this$0.scroller.computeScrollOffset()) {
            HeaderBehavior headerBehavior = this.this$0;
            headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
            ViewCompat.postOnAnimation(this.layout, (Runnable)this);
        } else {
            this.this$0.onFlingFinished(this.parent, this.layout);
        }
    }
}
