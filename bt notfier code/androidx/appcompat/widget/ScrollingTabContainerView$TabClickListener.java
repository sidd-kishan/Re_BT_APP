/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.ScrollingTabContainerView
 *  androidx.appcompat.widget.ScrollingTabContainerView$TabView
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;

private class ScrollingTabContainerView.TabClickListener
implements View.OnClickListener {
    final ScrollingTabContainerView this$0;

    ScrollingTabContainerView.TabClickListener(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    public void onClick(View view) {
        ((ScrollingTabContainerView.TabView)view).getTab().select();
        int n = this.this$0.mTabLayout.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view2 = this.this$0.mTabLayout.getChildAt(n2);
            boolean bl = view2 == view;
            view2.setSelected(bl);
            ++n2;
        }
    }
}
