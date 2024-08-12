/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.google.android.material.tabs.TabLayout
 */
package com.google.android.material.tabs;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

public static class TabLayout.TabLayoutOnPageChangeListener
implements ViewPager.OnPageChangeListener {
    private int previousScrollState;
    private int scrollState;
    private final WeakReference<TabLayout> tabLayoutRef;

    public TabLayout.TabLayoutOnPageChangeListener(TabLayout tabLayout) {
        this.tabLayoutRef = new WeakReference<TabLayout>(tabLayout);
    }

    public void onPageScrollStateChanged(int n) {
        this.previousScrollState = this.scrollState;
        this.scrollState = n;
    }

    public void onPageScrolled(int n, float f, int n2) {
        TabLayout tabLayout = (TabLayout)this.tabLayoutRef.get();
        if (tabLayout == null) return;
        n2 = this.scrollState;
        boolean bl = false;
        boolean bl2 = n2 != 2 || this.previousScrollState == 1;
        if (this.scrollState != 2 || this.previousScrollState != 0) {
            bl = true;
        }
        tabLayout.setScrollPosition(n, f, bl2, bl);
    }

    public void onPageSelected(int n) {
        TabLayout tabLayout = (TabLayout)this.tabLayoutRef.get();
        if (tabLayout == null) return;
        if (tabLayout.getSelectedTabPosition() == n) return;
        if (n >= tabLayout.getTabCount()) return;
        int n2 = this.scrollState;
        boolean bl = n2 == 0 || n2 == 2 && this.previousScrollState == 0;
        tabLayout.selectTab(tabLayout.getTabAt(n), bl);
    }

    void reset() {
        this.scrollState = 0;
        this.previousScrollState = 0;
    }
}
