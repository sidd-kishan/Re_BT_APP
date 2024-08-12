/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup$LayoutParams
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.haibin.calendarview.BaseMonthView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.MonthViewPager
 */
package com.haibin.calendarview;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.BaseMonthView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.MonthViewPager;

/*
 * Exception performing whole class analysis ignored.
 */
class MonthViewPager.1
implements ViewPager.OnPageChangeListener {
    final MonthViewPager this$0;

    MonthViewPager.1(MonthViewPager monthViewPager) {
        this.this$0 = monthViewPager;
    }

    public void onPageScrollStateChanged(int n) {
    }

    public void onPageScrolled(int n, float f, int n2) {
        float f2;
        if (MonthViewPager.access$100((MonthViewPager)this.this$0).getMonthViewShowMode() == 0) {
            return;
        }
        if (n < this.this$0.getCurrentItem()) {
            f2 = (float)MonthViewPager.access$200((MonthViewPager)this.this$0) * (1.0f - f);
            n = MonthViewPager.access$300((MonthViewPager)this.this$0);
        } else {
            f2 = (float)MonthViewPager.access$300((MonthViewPager)this.this$0) * (1.0f - f);
            n = MonthViewPager.access$400((MonthViewPager)this.this$0);
        }
        n = (int)(f2 + (float)n * f);
        ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
        layoutParams.height = n;
        this.this$0.setLayoutParams(layoutParams);
    }

    public void onPageSelected(int n) {
        BaseMonthView baseMonthView;
        Calendar calendar = CalendarUtil.getFirstCalendarFromMonthViewPager((int)n, (CalendarViewDelegate)MonthViewPager.access$100((MonthViewPager)this.this$0));
        if (this.this$0.getVisibility() == 0) {
            if (!MonthViewPager.access$100((MonthViewPager)this.this$0).isShowYearSelectedLayout && MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar != null && calendar.getYear() != MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar.getYear() && MonthViewPager.access$100((MonthViewPager)this.this$0).mYearChangeListener != null) {
                MonthViewPager.access$100((MonthViewPager)this.this$0).mYearChangeListener.onYearChange(calendar.getYear());
            }
            MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar = calendar;
        }
        if (MonthViewPager.access$100((MonthViewPager)this.this$0).mMonthChangeListener != null) {
            MonthViewPager.access$100((MonthViewPager)this.this$0).mMonthChangeListener.onMonthChange(calendar.getYear(), calendar.getMonth());
        }
        if (this.this$0.mWeekPager.getVisibility() == 0) {
            MonthViewPager.access$500((MonthViewPager)this.this$0, (int)calendar.getYear(), (int)calendar.getMonth());
            return;
        }
        if (MonthViewPager.access$100((MonthViewPager)this.this$0).getSelectMode() == 0) {
            MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedCalendar = !calendar.isCurrentMonth() ? calendar : CalendarUtil.getRangeEdgeCalendar((Calendar)calendar, (CalendarViewDelegate)MonthViewPager.access$100((MonthViewPager)this.this$0));
            MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar = MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedCalendar;
        } else if (MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedStartRangeCalendar != null && MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedStartRangeCalendar.isSameMonth(MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar)) {
            MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar = MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedStartRangeCalendar;
        } else if (calendar.isSameMonth(MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedCalendar)) {
            MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar = MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedCalendar;
        }
        MonthViewPager.access$100((MonthViewPager)this.this$0).updateSelectCalendarScheme();
        if (!MonthViewPager.access$600((MonthViewPager)this.this$0) && MonthViewPager.access$100((MonthViewPager)this.this$0).getSelectMode() == 0) {
            this.this$0.mWeekBar.onDateSelected(MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedCalendar, MonthViewPager.access$100((MonthViewPager)this.this$0).getWeekStart(), false);
            if (MonthViewPager.access$100((MonthViewPager)this.this$0).mCalendarSelectListener != null) {
                MonthViewPager.access$100((MonthViewPager)this.this$0).mCalendarSelectListener.onCalendarSelect(MonthViewPager.access$100((MonthViewPager)this.this$0).mSelectedCalendar, false);
            }
        }
        if ((baseMonthView = (BaseMonthView)this.this$0.findViewWithTag((Object)n)) != null) {
            n = baseMonthView.getSelectedIndex(MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar);
            if (MonthViewPager.access$100((MonthViewPager)this.this$0).getSelectMode() == 0) {
                baseMonthView.mCurrentItem = n;
            }
            if (n >= 0 && this.this$0.mParentLayout != null) {
                this.this$0.mParentLayout.updateSelectPosition(n);
            }
            baseMonthView.invalidate();
        }
        this.this$0.mWeekPager.updateSelected(MonthViewPager.access$100((MonthViewPager)this.this$0).mIndexCalendar, false);
        MonthViewPager.access$500((MonthViewPager)this.this$0, (int)calendar.getYear(), (int)calendar.getMonth());
        MonthViewPager.access$602((MonthViewPager)this.this$0, (boolean)false);
    }
}
