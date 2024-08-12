/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.CalendarLayout
 */
package com.haibin.calendarview;

import com.haibin.calendarview.CalendarLayout;

class CalendarLayout.2
implements Runnable {
    final CalendarLayout this$0;

    CalendarLayout.2(CalendarLayout calendarLayout) {
        this.this$0 = calendarLayout;
    }

    @Override
    public void run() {
        this.this$0.shrink(0);
    }
}
