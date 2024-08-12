/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.haibin.calendarview.CalendarView
 */
package com.haibin.calendarview;

import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.CalendarView;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarView.1
implements ViewPager.OnPageChangeListener {
    final CalendarView this$0;

    CalendarView.1(CalendarView calendarView) {
        this.this$0 = calendarView;
    }

    public void onPageScrollStateChanged(int n) {
    }

    public void onPageScrolled(int n, float f, int n2) {
    }

    public void onPageSelected(int n) {
        if (CalendarView.access$000((CalendarView)this.this$0).getVisibility() == 0) {
            return;
        }
        if (CalendarView.access$100((CalendarView)this.this$0).mYearChangeListener == null) return;
        CalendarView.access$100((CalendarView)this.this$0).mYearChangeListener.onYearChange(n + CalendarView.access$100((CalendarView)this.this$0).getMinYear());
    }
}
