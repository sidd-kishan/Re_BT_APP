/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.Calendar
 */
package com.haibin.calendarview;

import com.haibin.calendarview.Calendar;

public static interface CalendarView.OnCalendarRangeSelectListener {
    public void onCalendarRangeSelect(Calendar var1, boolean var2);

    public void onCalendarSelectOutOfRange(Calendar var1);

    public void onSelectOutOfRange(Calendar var1, boolean var2);
}
