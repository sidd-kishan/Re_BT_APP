/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.PagerTitleStrip
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 */
package androidx.viewpager.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

private class PagerTitleStrip.PageListener
extends DataSetObserver
implements ViewPager.OnPageChangeListener,
ViewPager.OnAdapterChangeListener {
    private int mScrollState;
    final PagerTitleStrip this$0;

    PagerTitleStrip.PageListener(PagerTitleStrip pagerTitleStrip) {
        this.this$0 = pagerTitleStrip;
    }

    public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        this.this$0.updateAdapter(pagerAdapter, pagerAdapter2);
    }

    public void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.this$0;
        pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
        float f = this.this$0.mLastKnownPositionOffset;
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = this.this$0.mLastKnownPositionOffset;
        }
        pagerTitleStrip = this.this$0;
        pagerTitleStrip.updateTextPositions(pagerTitleStrip.mPager.getCurrentItem(), f2, true);
    }

    public void onPageScrollStateChanged(int n) {
        this.mScrollState = n;
    }

    public void onPageScrolled(int n, float f, int n2) {
        n2 = n;
        if (f > 0.5f) {
            n2 = n + 1;
        }
        this.this$0.updateTextPositions(n2, f, false);
    }

    public void onPageSelected(int n) {
        if (this.mScrollState != 0) return;
        PagerTitleStrip pagerTitleStrip = this.this$0;
        pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
        float f = this.this$0.mLastKnownPositionOffset;
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = this.this$0.mLastKnownPositionOffset;
        }
        pagerTitleStrip = this.this$0;
        pagerTitleStrip.updateTextPositions(pagerTitleStrip.mPager.getCurrentItem(), f2, true);
    }
}
