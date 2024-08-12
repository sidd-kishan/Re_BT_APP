/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager
 *  com.qmuiteam.qmui.widget.QMUITabSegment$OnTabSelectedListener
 */
package com.qmuiteam.qmui.widget;

import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.widget.QMUITabSegment;

private static class QMUITabSegment.ViewPagerOnTabSelectedListener
implements QMUITabSegment.OnTabSelectedListener {
    private final ViewPager mViewPager;

    public QMUITabSegment.ViewPagerOnTabSelectedListener(ViewPager viewPager) {
        this.mViewPager = viewPager;
    }

    public void onDoubleTap(int n) {
    }

    public void onTabReselected(int n) {
    }

    public void onTabSelected(int n) {
        this.mViewPager.setCurrentItem(n, false);
    }

    public void onTabUnselected(int n) {
    }
}
