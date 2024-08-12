/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.AnimationUtils
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarView
 *  com.haibin.calendarview.CalendarView$OnCalendarSelectListener
 *  com.haibin.calendarview.CalendarView$OnMonthChangeListener
 *  com.haibin.calendarview.CalendarView$OnYearChangeListener
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.lianhezhuli.btnotification.view.calendar.MyCalendarView$OnDateSelectListener
 */
package com.lianhezhuli.btnotification.view.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.haibin.calendarview.CalendarView;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.lianhezhuli.btnotification.view.calendar.MyCalendarView;
import java.util.Calendar;

public class MyCalendarView
extends LinearLayout
implements CalendarView.OnCalendarSelectListener,
CalendarView.OnYearChangeListener,
View.OnClickListener,
CalendarView.OnMonthChangeListener {
    private String completeDateStr = "%04d-%02d-%02d";
    private View mBottomView;
    private CalendarView mCalendarView;
    private Context mContext;
    private OnDateSelectListener mDateSelectListener = null;
    private TextView mDateTv;
    private String yearAndMFormatStr = "%04d-%02d";

    public MyCalendarView(Context context) {
        super(context);
        this.init(context);
    }

    public MyCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public MyCalendarView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context);
    }

    public MyCalendarView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.init(context);
    }

    private String getCurDate() {
        return StringUtils.formatStr((String)this.yearAndMFormatStr, (Object[])new Object[]{this.mCalendarView.getCurYear(), this.mCalendarView.getCurMonth()});
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from((Context)context).inflate(2131493002, (ViewGroup)this, true);
        this.mDateTv = (TextView)this.findViewById(2131296383);
        this.mCalendarView = (CalendarView)this.findViewById(2131296384);
        context = this.findViewById(2131296382);
        this.mBottomView = context;
        context.setOnClickListener((View.OnClickListener)this);
        this.mDateTv.setOnClickListener((View.OnClickListener)this);
        this.mCalendarView.setOnYearChangeListener((CalendarView.OnYearChangeListener)this);
        this.mCalendarView.setOnMonthChangeListener((CalendarView.OnMonthChangeListener)this);
        this.mCalendarView.setOnCalendarSelectListener((CalendarView.OnCalendarSelectListener)this);
        this.mDateTv.setText((CharSequence)this.getCurDate());
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isFutureDate(com.haibin.calendarview.Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance();
        int n = calendar.getYear();
        boolean bl = true;
        if (n > calendar2.get(1)) {
            ToastUtils.showShort((Context)this.mContext, (int)2131755046);
            return bl;
        }
        if (calendar.getYear() != calendar2.get(1)) return false;
        if (calendar.getMonth() > calendar2.get(2) + 1) {
            ToastUtils.showShort((Context)this.mContext, (int)2131755046);
            return bl;
        }
        if (calendar.getMonth() != calendar2.get(2) + 1) return false;
        if (calendar.getDay() <= calendar2.get(5)) return false;
        ToastUtils.showShort((Context)this.mContext, (int)2131755046);
        return bl;
    }

    public void onCalendarOutOfRange(com.haibin.calendarview.Calendar calendar) {
    }

    public void onCalendarSelect(com.haibin.calendarview.Calendar calendar, boolean bl) {
        if (!bl) return;
        if (this.isFutureDate(calendar)) {
            this.mCalendarView.clearSingleSelect();
            return;
        }
        this.setVisibility(8);
        OnDateSelectListener onDateSelectListener = this.mDateSelectListener;
        if (onDateSelectListener == null) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(calendar.getYear());
        stringBuilder.append("-");
        stringBuilder.append(calendar.getMonth());
        stringBuilder.append("-");
        stringBuilder.append(calendar.getDay());
        onDateSelectListener.onDateSelect(stringBuilder.toString());
    }

    public void onClick(View view) {
        if (view.getId() != 2131296382) return;
        this.setVisibility(8);
        this.mCalendarView.scrollToCurrent();
        this.mDateTv.setText((CharSequence)this.getCurDate());
    }

    public void onMonthChange(int n, int n2) {
        this.mDateTv.setText((CharSequence)StringUtils.formatStr((String)this.yearAndMFormatStr, (Object[])new Object[]{n, n2}));
    }

    public void onYearChange(int n) {
    }

    public void setOnDateSelectListener(OnDateSelectListener onDateSelectListener) {
        this.mDateSelectListener = onDateSelectListener;
    }

    public void showView() {
        if (this.getVisibility() != 8) return;
        this.startAnimation(AnimationUtils.loadAnimation((Context)this.mContext, (int)2130772005));
        this.setVisibility(0);
    }
}
