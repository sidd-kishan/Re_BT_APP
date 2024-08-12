/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.Calendar
 */
package com.haibin.calendarview;

import com.haibin.calendarview.Calendar;

public static interface CalendarView.OnCalendarMultiSelectListener {
    public void onCalendarMultiSelect(Calendar var1, int var2, int var3);

    public void onCalendarMultiSelectOutOfRange(Calendar var1);

    public void onMultiSelectOutOfSize(Calendar var1, int var2);
}
