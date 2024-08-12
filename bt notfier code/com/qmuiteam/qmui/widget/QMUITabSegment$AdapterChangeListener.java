/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 */
package com.qmuiteam.qmui.widget;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.widget.QMUITabSegment;

/*
 * Exception performing whole class analysis ignored.
 */
private class QMUITabSegment.AdapterChangeListener
implements ViewPager.OnAdapterChangeListener {
    private boolean mAutoRefresh;
    private final boolean mUseAdapterTitle;
    final QMUITabSegment this$0;

    QMUITabSegment.AdapterChangeListener(QMUITabSegment qMUITabSegment, boolean bl) {
        this.this$0 = qMUITabSegment;
        this.mUseAdapterTitle = bl;
    }

    public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (QMUITabSegment.access$2100((QMUITabSegment)this.this$0) != viewPager) return;
        this.this$0.setPagerAdapter(pagerAdapter2, this.mUseAdapterTitle, this.mAutoRefresh);
    }

    void setAutoRefresh(boolean bl) {
        this.mAutoRefresh = bl;
    }
}
