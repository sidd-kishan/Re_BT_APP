/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarView
 *  com.haibin.calendarview.CalendarView$OnInnerDateSelectedListener
 */
package com.haibin.calendarview;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarView.2
implements CalendarView.OnInnerDateSelectedListener {
    final CalendarView this$0;

    CalendarView.2(CalendarView calendarView) {
        this.this$0 = calendarView;
    }

    public void onMonthDateSelected(Calendar calendar, boolean bl) {
        if (calendar.getYear() == CalendarView.access$100((CalendarView)this.this$0).getCurrentDay().getYear() && calendar.getMonth() == CalendarView.access$100((CalendarView)this.this$0).getCurrentDay().getMonth() && CalendarView.access$200((CalendarView)this.this$0).getCurrentItem() != CalendarView.access$100((CalendarView)this.this$0).mCurrentMonthViewItem) {
            return;
        }
        CalendarView.access$100((CalendarView)this.this$0).mIndexCalendar = calendar;
        if (CalendarView.access$100((CalendarView)this.this$0).getSelectMode() == 0 || bl) {
            CalendarView.access$100((CalendarView)this.this$0).mSelectedCalendar = calendar;
        }
        CalendarView.access$000((CalendarView)this.this$0).updateSelected(CalendarView.access$100((CalendarView)this.this$0).mIndexCalendar, false);
        CalendarView.access$200((CalendarView)this.this$0).updateSelected();
        if (CalendarView.access$300((CalendarView)this.this$0) == null) return;
        if (CalendarView.access$100((CalendarView)this.this$0).getSelectMode() != 0) {
            if (!bl) return;
        }
        CalendarView.access$300((CalendarView)this.this$0).onDateSelected(calendar, CalendarView.access$100((CalendarView)this.this$0).getWeekStart(), bl);
    }

    public void onWeekDateSelected(Calendar calendar, boolean bl) {
        CalendarView.access$100((CalendarView)this.this$0).mIndexCalendar = calendar;
        if (CalendarView.access$100((CalendarView)this.this$0).getSelectMode() == 0 || bl || CalendarView.access$100((CalendarView)this.this$0).mIndexCalendar.equals((Object)CalendarView.access$100((CalendarView)this.this$0).mSelectedCalendar)) {
            CalendarView.access$100((CalendarView)this.this$0).mSelectedCalendar = calendar;
        }
        int n = calendar.getYear();
        int n2 = CalendarView.access$100((CalendarView)this.this$0).getMinYear();
        int n3 = CalendarView.access$100((CalendarView)this.this$0).mIndexCalendar.getMonth();
        int n4 = CalendarView.access$100((CalendarView)this.this$0).getMinYearMonth();
        CalendarView.access$000((CalendarView)this.this$0).updateSingleSelect();
        CalendarView.access$200((CalendarView)this.this$0).setCurrentItem((n - n2) * 12 + n3 - n4, false);
        CalendarView.access$200((CalendarView)this.this$0).updateSelected();
        if (CalendarView.access$300((CalendarView)this.this$0) == null) return;
        if (CalendarView.access$100((CalendarView)this.this$0).getSelectMode() != 0 && !bl) {
            if (!CalendarView.access$100((CalendarView)this.this$0).mIndexCalendar.equals((Object)CalendarView.access$100((CalendarView)this.this$0).mSelectedCalendar)) return;
        }
        CalendarView.access$300((CalendarView)this.this$0).onDateSelected(calendar, CalendarView.access$100((CalendarView)this.this$0).getWeekStart(), bl);
    }
}
