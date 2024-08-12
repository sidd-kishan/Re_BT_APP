/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewpager.widget.PagerAdapter
 *  com.haibin.calendarview.YearRecyclerView
 *  com.haibin.calendarview.YearViewPager
 */
package com.haibin.calendarview;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.haibin.calendarview.YearRecyclerView;
import com.haibin.calendarview.YearViewPager;

/*
 * Exception performing whole class analysis ignored.
 */
class YearViewPager.1
extends PagerAdapter {
    final YearViewPager this$0;

    YearViewPager.1(YearViewPager yearViewPager) {
        this.this$0 = yearViewPager;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup.removeView((View)object);
    }

    public int getCount() {
        return YearViewPager.access$000((YearViewPager)this.this$0);
    }

    public int getItemPosition(Object object) {
        int n = YearViewPager.access$100((YearViewPager)this.this$0) ? -2 : super.getItemPosition(object);
        return n;
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        YearRecyclerView yearRecyclerView = new YearRecyclerView(this.this$0.getContext());
        viewGroup.addView((View)yearRecyclerView);
        yearRecyclerView.setup(YearViewPager.access$200((YearViewPager)this.this$0));
        yearRecyclerView.setOnMonthSelectedListener(YearViewPager.access$300((YearViewPager)this.this$0));
        yearRecyclerView.init(n + YearViewPager.access$200((YearViewPager)this.this$0).getMinYear());
        return yearRecyclerView;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl = view == object;
        return bl;
    }
}
