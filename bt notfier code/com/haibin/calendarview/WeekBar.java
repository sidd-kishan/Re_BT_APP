/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.R$array
 *  com.haibin.calendarview.R$layout
 */
package com.haibin.calendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.R;

public class WeekBar
extends LinearLayout {
    private CalendarViewDelegate mDelegate;

    public WeekBar(Context context) {
        super(context);
        if (!"com.haibin.calendarview.WeekBar".equals(((Object)((Object)this)).getClass().getName())) return;
        LayoutInflater.from((Context)context).inflate(R.layout.cv_week_bar, (ViewGroup)this, true);
    }

    private String getWeekString(int n, int n2) {
        String[] stringArray = this.getContext().getResources().getStringArray(R.array.week_string_array);
        if (n2 == 1) {
            return stringArray[n];
        }
        int n3 = 6;
        if (n2 == 2) {
            n = n == 6 ? 0 : ++n;
            return stringArray[n];
        }
        n = n == 0 ? n3 : --n;
        return stringArray[n];
    }

    protected int getViewIndexByCalendar(Calendar calendar, int n) {
        int n2 = calendar.getWeek() + 1;
        if (n == 1) {
            return n2 - 1;
        }
        if (n != 2) {
            n = n2;
            if (n2 != 7) return n;
            n = 0;
            return n;
        }
        n = n2 == 1 ? 6 : n2 - 2;
        return n;
    }

    protected void onDateSelected(Calendar calendar, int n, boolean bl) {
    }

    protected void onMeasure(int n, int n2) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        n2 = calendarViewDelegate != null ? View.MeasureSpec.makeMeasureSpec((int)calendarViewDelegate.getWeekBarHeight(), (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)CalendarUtil.dipToPx((Context)this.getContext(), (float)40.0f), (int)0x40000000);
        super.onMeasure(n, n2);
    }

    protected void onWeekStartChange(int n) {
        if (!"com.haibin.calendarview.WeekBar".equalsIgnoreCase(((Object)((Object)this)).getClass().getName())) {
            return;
        }
        int n2 = 0;
        while (n2 < this.getChildCount()) {
            ((TextView)this.getChildAt(n2)).setText((CharSequence)this.getWeekString(n2, n));
            ++n2;
        }
    }

    protected void setTextColor(int n) {
        int n2 = 0;
        while (n2 < this.getChildCount()) {
            ((TextView)this.getChildAt(n2)).setTextColor(n);
            ++n2;
        }
    }

    protected void setTextSize(int n) {
        int n2 = 0;
        while (n2 < this.getChildCount()) {
            ((TextView)this.getChildAt(n2)).setTextSize(0, (float)n);
            ++n2;
        }
    }

    void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        if (!"com.haibin.calendarview.WeekBar".equalsIgnoreCase(((Object)((Object)this)).getClass().getName())) return;
        this.setTextSize(this.mDelegate.getWeekTextSize());
        this.setTextColor(calendarViewDelegate.getWeekTextColor());
        this.setBackgroundColor(calendarViewDelegate.getWeekBackground());
        this.setPadding(calendarViewDelegate.getCalendarPadding(), 0, calendarViewDelegate.getCalendarPadding(), 0);
    }
}
