/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout
 */
package androidx.slidingpanelayout.widget;

import android.view.View;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

private class SlidingPaneLayout.DisableLayerRunnable
implements Runnable {
    final View mChildView;
    final SlidingPaneLayout this$0;

    SlidingPaneLayout.DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view) {
        this.this$0 = slidingPaneLayout;
        this.mChildView = view;
    }

    @Override
    public void run() {
        if (this.mChildView.getParent() == this.this$0) {
            this.mChildView.setLayerType(0, null);
            this.this$0.invalidateChildRegion(this.mChildView);
        }
        this.this$0.mPostedRunnables.remove(this);
    }
}
