/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  com.bigkoo.pickerview.configure.PickerOptions
 *  com.bigkoo.pickerview.listener.CustomListener
 *  com.bigkoo.pickerview.listener.OnTimeSelectChangeListener
 *  com.bigkoo.pickerview.listener.OnTimeSelectListener
 *  com.bigkoo.pickerview.view.TimePickerView
 *  com.contrarywind.view.WheelView$DividerType
 */
package com.bigkoo.pickerview.builder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.contrarywind.view.WheelView;
import java.util.Calendar;

public class TimePickerBuilder {
    private PickerOptions mPickerOptions;

    public TimePickerBuilder(Context context, OnTimeSelectListener onTimeSelectListener) {
        PickerOptions pickerOptions;
        this.mPickerOptions = pickerOptions = new PickerOptions(2);
        pickerOptions.context = context;
        this.mPickerOptions.timeSelectListener = onTimeSelectListener;
    }

    public TimePickerBuilder addOnCancelClickListener(View.OnClickListener onClickListener) {
        this.mPickerOptions.cancelListener = onClickListener;
        return this;
    }

    public TimePickerView build() {
        return new TimePickerView(this.mPickerOptions);
    }

    public TimePickerBuilder isCenterLabel(boolean bl) {
        this.mPickerOptions.isCenterLabel = bl;
        return this;
    }

    public TimePickerBuilder isCyclic(boolean bl) {
        this.mPickerOptions.cyclic = bl;
        return this;
    }

    public TimePickerBuilder isDialog(boolean bl) {
        this.mPickerOptions.isDialog = bl;
        return this;
    }

    @Deprecated
    public TimePickerBuilder setBackgroundId(int n) {
        this.mPickerOptions.outSideColor = n;
        return this;
    }

    public TimePickerBuilder setBgColor(int n) {
        this.mPickerOptions.bgColorWheel = n;
        return this;
    }

    public TimePickerBuilder setCancelColor(int n) {
        this.mPickerOptions.textColorCancel = n;
        return this;
    }

    public TimePickerBuilder setCancelText(String string) {
        this.mPickerOptions.textContentCancel = string;
        return this;
    }

    public TimePickerBuilder setContentTextSize(int n) {
        this.mPickerOptions.textSizeContent = n;
        return this;
    }

    public TimePickerBuilder setDate(Calendar calendar) {
        this.mPickerOptions.date = calendar;
        return this;
    }

    public TimePickerBuilder setDecorView(ViewGroup viewGroup) {
        this.mPickerOptions.decorView = viewGroup;
        return this;
    }

    public TimePickerBuilder setDividerColor(int n) {
        this.mPickerOptions.dividerColor = n;
        return this;
    }

    public TimePickerBuilder setDividerType(WheelView.DividerType dividerType) {
        this.mPickerOptions.dividerType = dividerType;
        return this;
    }

    public TimePickerBuilder setGravity(int n) {
        this.mPickerOptions.textGravity = n;
        return this;
    }

    public TimePickerBuilder setLabel(String string, String string2, String string3, String string4, String string5, String string6) {
        this.mPickerOptions.label_year = string;
        this.mPickerOptions.label_month = string2;
        this.mPickerOptions.label_day = string3;
        this.mPickerOptions.label_hours = string4;
        this.mPickerOptions.label_minutes = string5;
        this.mPickerOptions.label_seconds = string6;
        return this;
    }

    public TimePickerBuilder setLayoutRes(int n, CustomListener customListener) {
        this.mPickerOptions.layoutRes = n;
        this.mPickerOptions.customListener = customListener;
        return this;
    }

    public TimePickerBuilder setLineSpacingMultiplier(float f) {
        this.mPickerOptions.lineSpacingMultiplier = f;
        return this;
    }

    public TimePickerBuilder setLunarCalendar(boolean bl) {
        this.mPickerOptions.isLunarCalendar = bl;
        return this;
    }

    public TimePickerBuilder setOutSideCancelable(boolean bl) {
        this.mPickerOptions.cancelable = bl;
        return this;
    }

    public TimePickerBuilder setOutSideColor(int n) {
        this.mPickerOptions.outSideColor = n;
        return this;
    }

    public TimePickerBuilder setRangDate(Calendar calendar, Calendar calendar2) {
        this.mPickerOptions.startDate = calendar;
        this.mPickerOptions.endDate = calendar2;
        return this;
    }

    public TimePickerBuilder setSubCalSize(int n) {
        this.mPickerOptions.textSizeSubmitCancel = n;
        return this;
    }

    public TimePickerBuilder setSubmitColor(int n) {
        this.mPickerOptions.textColorConfirm = n;
        return this;
    }

    public TimePickerBuilder setSubmitText(String string) {
        this.mPickerOptions.textContentConfirm = string;
        return this;
    }

    public TimePickerBuilder setTextColorCenter(int n) {
        this.mPickerOptions.textColorCenter = n;
        return this;
    }

    public TimePickerBuilder setTextColorOut(int n) {
        this.mPickerOptions.textColorOut = n;
        return this;
    }

    public TimePickerBuilder setTextXOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        this.mPickerOptions.x_offset_year = n;
        this.mPickerOptions.x_offset_month = n2;
        this.mPickerOptions.x_offset_day = n3;
        this.mPickerOptions.x_offset_hours = n4;
        this.mPickerOptions.x_offset_minutes = n5;
        this.mPickerOptions.x_offset_seconds = n6;
        return this;
    }

    public TimePickerBuilder setTimeSelectChangeListener(OnTimeSelectChangeListener onTimeSelectChangeListener) {
        this.mPickerOptions.timeSelectChangeListener = onTimeSelectChangeListener;
        return this;
    }

    public TimePickerBuilder setTitleBgColor(int n) {
        this.mPickerOptions.bgColorTitle = n;
        return this;
    }

    public TimePickerBuilder setTitleColor(int n) {
        this.mPickerOptions.textColorTitle = n;
        return this;
    }

    public TimePickerBuilder setTitleSize(int n) {
        this.mPickerOptions.textSizeTitle = n;
        return this;
    }

    public TimePickerBuilder setTitleText(String string) {
        this.mPickerOptions.textContentTitle = string;
        return this;
    }

    public TimePickerBuilder setType(boolean[] blArray) {
        this.mPickerOptions.type = blArray;
        return this;
    }
}
