/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
 *  com.google.android.material.tabs.TabLayout
 */
package com.google.android.material.tabs;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

private class TabLayout.AdapterChangeListener
implements ViewPager.OnAdapterChangeListener {
    private boolean autoRefresh;
    final TabLayout this$0;

    TabLayout.AdapterChangeListener(TabLayout tabLayout) {
        this.this$0 = tabLayout;
    }

    public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (this.this$0.viewPager != viewPager) return;
        this.this$0.setPagerAdapter(pagerAdapter2, this.autoRefresh);
    }

    void setAutoRefresh(boolean bl) {
        this.autoRefresh = bl;
    }
}
