/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.widget.ScrollingTabContainerView
 *  androidx.appcompat.widget.ScrollingTabContainerView$TabView
 */
package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ScrollingTabContainerView;

private class ScrollingTabContainerView.TabAdapter
extends BaseAdapter {
    final ScrollingTabContainerView this$0;

    ScrollingTabContainerView.TabAdapter(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    public int getCount() {
        return this.this$0.mTabLayout.getChildCount();
    }

    public Object getItem(int n) {
        return ((ScrollingTabContainerView.TabView)this.this$0.mTabLayout.getChildAt(n)).getTab();
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.this$0.createTabView((ActionBar.Tab)this.getItem(n), true);
        } else {
            ((ScrollingTabContainerView.TabView)view).bindTab((ActionBar.Tab)this.getItem(n));
        }
        return view;
    }
}
