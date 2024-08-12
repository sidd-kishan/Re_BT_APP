/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bigkoo.pickerview.builder.TimePickerBuilder
 *  com.bigkoo.pickerview.listener.OnTimeSelectListener
 *  com.bigkoo.pickerview.view.TimePickerView
 */
package com.lianhezhuli.btnotification.view.pickerview;

import android.content.Context;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import java.util.Calendar;

public class UnLimitDatePicker {
    private Calendar endDate;
    private TimePickerView mTimePicker;
    private Calendar selectedDate;
    private Calendar startDate;

    public UnLimitDatePicker(Context context, OnTimeSelectListener onTimeSelectListener) {
        this.setDate();
        this.getInstance(context, onTimeSelectListener);
    }

    public void dismiss() {
        TimePickerView timePickerView = this.mTimePicker;
        if (timePickerView == null) return;
        if (!timePickerView.isShowing()) return;
        this.mTimePicker.dismiss();
    }

    public TimePickerView getInstance(Context context, OnTimeSelectListener onTimeSelectListener) {
        context = new TimePickerBuilder(context, onTimeSelectListener).setDate(this.selectedDate).setRangDate(this.startDate, this.endDate).setCancelText(context.getString(2131755050)).setSubmitText(context.getString(2131755116)).setOutSideCancelable(true).setSubmitColor(context.getResources().getColor(2131099739)).setCancelColor(context.getResources().getColor(2131099739)).setTitleBgColor(-1).setType(new boolean[]{true, true, true, false, false, false}).setLabel("", "", "", "", "", "").build();
        this.mTimePicker = context;
        return context;
    }

    public void setDate() {
        Calendar calendar;
        this.selectedDate = Calendar.getInstance();
        this.startDate = Calendar.getInstance();
        int n = this.selectedDate.get(1);
        int n2 = this.selectedDate.get(2);
        int n3 = this.selectedDate.get(5);
        this.startDate.set(1950, 1, 1);
        this.endDate = calendar = Calendar.getInstance();
        calendar.set(n, n2, n3);
    }

    public void show() {
        TimePickerView timePickerView = this.mTimePicker;
        if (timePickerView == null) return;
        if (timePickerView.isShowing()) return;
        this.mTimePicker.show();
    }
}
