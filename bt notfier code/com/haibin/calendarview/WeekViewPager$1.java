/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.haibin.calendarview.BaseWeekView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.WeekViewPager
 */
package com.haibin.calendarview;

import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.WeekViewPager;

/*
 * Exception performing whole class analysis ignored.
 */
class WeekViewPager.1
implements ViewPager.OnPageChangeListener {
    final WeekViewPager this$0;

    WeekViewPager.1(WeekViewPager weekViewPager) {
        this.this$0 = weekViewPager;
    }

    public void onPageScrollStateChanged(int n) {
    }

    public void onPageScrolled(int n, float f, int n2) {
    }

    public void onPageSelected(int n) {
        if (this.this$0.getVisibility() != 0) {
            WeekViewPager.access$102((WeekViewPager)this.this$0, (boolean)false);
            return;
        }
        if (WeekViewPager.access$100((WeekViewPager)this.this$0)) {
            WeekViewPager.access$102((WeekViewPager)this.this$0, (boolean)false);
            return;
        }
        BaseWeekView baseWeekView = (BaseWeekView)this.this$0.findViewWithTag((Object)n);
        if (baseWeekView != null) {
            Calendar calendar = WeekViewPager.access$200((WeekViewPager)this.this$0).getSelectMode() != 0 ? WeekViewPager.access$200((WeekViewPager)this.this$0).mIndexCalendar : WeekViewPager.access$200((WeekViewPager)this.this$0).mSelectedCalendar;
            baseWeekView.performClickCalendar(calendar, WeekViewPager.access$100((WeekViewPager)this.this$0) ^ true);
            if (WeekViewPager.access$200((WeekViewPager)this.this$0).mWeekChangeListener != null) {
                WeekViewPager.access$200((WeekViewPager)this.this$0).mWeekChangeListener.onWeekChange(this.this$0.getCurrentWeekCalendars());
            }
        }
        WeekViewPager.access$102((WeekViewPager)this.this$0, (boolean)false);
    }
}
