/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager
 *  com.google.android.material.tabs.TabLayout$OnTabSelectedListener
 *  com.google.android.material.tabs.TabLayout$Tab
 */
package com.google.android.material.tabs;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public static class TabLayout.ViewPagerOnTabSelectedListener
implements TabLayout.OnTabSelectedListener {
    private final ViewPager viewPager;

    public TabLayout.ViewPagerOnTabSelectedListener(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabSelected(TabLayout.Tab tab) {
        this.viewPager.setCurrentItem(tab.getPosition());
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }
}
