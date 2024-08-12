/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.ScrollingTabContainerView
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;

class ScrollingTabContainerView.1
implements Runnable {
    final ScrollingTabContainerView this$0;
    final View val$tabView;

    ScrollingTabContainerView.1(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.this$0 = scrollingTabContainerView;
        this.val$tabView = view;
    }

    @Override
    public void run() {
        int n = this.val$tabView.getLeft();
        int n2 = (this.this$0.getWidth() - this.val$tabView.getWidth()) / 2;
        this.this$0.smoothScrollTo(n - n2, 0);
        this.this$0.mTabSelector = null;
    }
}
