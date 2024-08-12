/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.CalendarView
 *  com.haibin.calendarview.YearRecyclerView$OnMonthSelectedListener
 */
package com.haibin.calendarview;

import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.YearRecyclerView;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarView.3
implements YearRecyclerView.OnMonthSelectedListener {
    final CalendarView this$0;

    CalendarView.3(CalendarView calendarView) {
        this.this$0 = calendarView;
    }

    public void onMonthSelected(int n, int n2) {
        int n3 = CalendarView.access$100((CalendarView)this.this$0).getMinYear();
        int n4 = CalendarView.access$100((CalendarView)this.this$0).getMinYearMonth();
        CalendarView.access$400((CalendarView)this.this$0, (int)((n - n3) * 12 + n2 - n4));
        CalendarView.access$100((CalendarView)this.this$0).isShowYearSelectedLayout = false;
    }
}
