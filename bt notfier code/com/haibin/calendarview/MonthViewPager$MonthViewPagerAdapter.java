/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewpager.widget.PagerAdapter
 *  com.haibin.calendarview.BaseMonthView
 *  com.haibin.calendarview.BaseView
 *  com.haibin.calendarview.MonthViewPager
 */
package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.haibin.calendarview.BaseMonthView;
import com.haibin.calendarview.BaseView;
import com.haibin.calendarview.MonthViewPager;

/*
 * Exception performing whole class analysis ignored.
 */
private final class MonthViewPager.MonthViewPagerAdapter
extends PagerAdapter {
    final MonthViewPager this$0;

    private MonthViewPager.MonthViewPagerAdapter(MonthViewPager monthViewPager) {
        this.this$0 = monthViewPager;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        if ((object = (BaseView)object) == null) {
            return;
        }
        object.onDestroy();
        viewGroup.removeView((View)object);
    }

    public int getCount() {
        return MonthViewPager.access$700((MonthViewPager)this.this$0);
    }

    public int getItemPosition(Object object) {
        int n = MonthViewPager.access$800((MonthViewPager)this.this$0) ? -2 : super.getItemPosition(object);
        return n;
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        BaseMonthView baseMonthView;
        int n2 = (MonthViewPager.access$100((MonthViewPager)this.this$0).getMinYearMonth() + n - 1) / 12;
        int n3 = MonthViewPager.access$100((MonthViewPager)this.this$0).getMinYear();
        int n4 = MonthViewPager.access$100((MonthViewPager)this.this$0).getMinYearMonth();
        try {
            baseMonthView = (BaseMonthView)MonthViewPager.access$100((MonthViewPager)this.this$0).getMonthViewClass().getConstructor(Context.class).newInstance(this.this$0.getContext());
            baseMonthView.mMonthViewPager = this.this$0;
            baseMonthView.mParentLayout = this.this$0.mParentLayout;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        baseMonthView.setup(MonthViewPager.access$100((MonthViewPager)this.this$0));
        baseMonthView.setTag((Object)n);
        baseMonthView.initMonthWithDate(n2 + n3, (n4 + n - 1) % 12 + 1);
        baseMonthView.setSelectedCalendar(MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedCalendar);
        viewGroup.addView((View)baseMonthView);
        return baseMonthView;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
