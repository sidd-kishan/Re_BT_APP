/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewpager.widget.PagerAdapter
 *  com.haibin.calendarview.BaseWeekView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.WeekViewPager
 */
package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.WeekViewPager;

/*
 * Exception performing whole class analysis ignored.
 */
private class WeekViewPager.WeekViewPagerAdapter
extends PagerAdapter {
    final WeekViewPager this$0;

    private WeekViewPager.WeekViewPagerAdapter(WeekViewPager weekViewPager) {
        this.this$0 = weekViewPager;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        if ((object = (BaseWeekView)object) == null) {
            return;
        }
        object.onDestroy();
        viewGroup.removeView((View)object);
    }

    public int getCount() {
        return WeekViewPager.access$300((WeekViewPager)this.this$0);
    }

    public int getItemPosition(Object object) {
        int n = WeekViewPager.access$400((WeekViewPager)this.this$0) ? -2 : super.getItemPosition(object);
        return n;
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        BaseWeekView baseWeekView;
        Calendar calendar = CalendarUtil.getFirstCalendarStartWithMinCalendar((int)WeekViewPager.access$200((WeekViewPager)this.this$0).getMinYear(), (int)WeekViewPager.access$200((WeekViewPager)this.this$0).getMinYearMonth(), (int)WeekViewPager.access$200((WeekViewPager)this.this$0).getMinYearDay(), (int)(n + 1), (int)WeekViewPager.access$200((WeekViewPager)this.this$0).getWeekStart());
        try {
            baseWeekView = (BaseWeekView)WeekViewPager.access$200((WeekViewPager)this.this$0).getWeekViewClass().getConstructor(Context.class).newInstance(this.this$0.getContext());
            baseWeekView.mParentLayout = this.this$0.mParentLayout;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        baseWeekView.setup(WeekViewPager.access$200((WeekViewPager)this.this$0));
        baseWeekView.setup(calendar);
        baseWeekView.setTag((Object)n);
        baseWeekView.setSelectedCalendar(WeekViewPager.access$200((WeekViewPager)this.this$0).mSelectedCalendar);
        viewGroup.addView((View)baseWeekView);
        return baseWeekView;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
