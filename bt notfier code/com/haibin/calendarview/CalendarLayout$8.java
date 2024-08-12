/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.CalendarLayout
 */
package com.haibin.calendarview;

import com.haibin.calendarview.CalendarLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarLayout.8
implements Runnable {
    final CalendarLayout this$0;

    CalendarLayout.8(CalendarLayout calendarLayout) {
        this.this$0 = calendarLayout;
    }

    @Override
    public void run() {
        CalendarLayout.access$500((CalendarLayout)this.this$0).mViewChangeListener.onViewChange(true);
    }
}
