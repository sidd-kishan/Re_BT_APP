/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.bigkoo.pickerview.R$id
 *  com.bigkoo.pickerview.R$layout
 *  com.bigkoo.pickerview.R$string
 *  com.bigkoo.pickerview.configure.PickerOptions
 *  com.bigkoo.pickerview.listener.ISelectTimeCallback
 *  com.bigkoo.pickerview.view.BasePickerView
 *  com.bigkoo.pickerview.view.WheelTime
 */
package com.bigkoo.pickerview.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.ISelectTimeCallback;
import com.bigkoo.pickerview.view.BasePickerView;
import com.bigkoo.pickerview.view.WheelTime;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TimePickerView
extends BasePickerView
implements View.OnClickListener {
    private static final String TAG_CANCEL = "cancel";
    private static final String TAG_SUBMIT = "submit";
    private WheelTime wheelTime;

    public TimePickerView(PickerOptions pickerOptions) {
        super(pickerOptions.context);
        this.mPickerOptions = pickerOptions;
        this.initView(pickerOptions.context);
    }

    static /* synthetic */ WheelTime access$000(TimePickerView timePickerView) {
        return timePickerView.wheelTime;
    }

    private void initDefaultSelectedDate() {
        if (this.mPickerOptions.startDate != null && this.mPickerOptions.endDate != null) {
            if (this.mPickerOptions.date != null && this.mPickerOptions.date.getTimeInMillis() >= this.mPickerOptions.startDate.getTimeInMillis()) {
                if (this.mPickerOptions.date.getTimeInMillis() <= this.mPickerOptions.endDate.getTimeInMillis()) return;
            }
            this.mPickerOptions.date = this.mPickerOptions.startDate;
        } else if (this.mPickerOptions.startDate != null) {
            this.mPickerOptions.date = this.mPickerOptions.startDate;
        } else {
            if (this.mPickerOptions.endDate == null) return;
            this.mPickerOptions.date = this.mPickerOptions.endDate;
        }
    }

    private void initView(Context object) {
        this.setDialogOutSideCancelable();
        this.initViews();
        this.initAnim();
        if (this.mPickerOptions.customListener == null) {
            LayoutInflater.from((Context)object).inflate(R.layout.pickerview_time, this.contentContainer);
            TextView textView = (TextView)this.findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout)this.findViewById(R.id.rv_topbar);
            Button button = (Button)this.findViewById(R.id.btnSubmit);
            Button button2 = (Button)this.findViewById(R.id.btnCancel);
            button.setTag((Object)TAG_SUBMIT);
            button2.setTag((Object)TAG_CANCEL);
            button.setOnClickListener((View.OnClickListener)this);
            button2.setOnClickListener((View.OnClickListener)this);
            String string2 = TextUtils.isEmpty((CharSequence)this.mPickerOptions.textContentConfirm) ? object.getResources().getString(R.string.pickerview_submit) : this.mPickerOptions.textContentConfirm;
            button.setText((CharSequence)string2);
            object = TextUtils.isEmpty((CharSequence)this.mPickerOptions.textContentCancel) ? object.getResources().getString(R.string.pickerview_cancel) : this.mPickerOptions.textContentCancel;
            button2.setText((CharSequence)object);
            object = TextUtils.isEmpty((CharSequence)this.mPickerOptions.textContentTitle) ? "" : this.mPickerOptions.textContentTitle;
            textView.setText((CharSequence)object);
            button.setTextColor(this.mPickerOptions.textColorConfirm);
            button2.setTextColor(this.mPickerOptions.textColorCancel);
            textView.setTextColor(this.mPickerOptions.textColorTitle);
            relativeLayout.setBackgroundColor(this.mPickerOptions.bgColorTitle);
            button.setTextSize((float)this.mPickerOptions.textSizeSubmitCancel);
            button2.setTextSize((float)this.mPickerOptions.textSizeSubmitCancel);
            textView.setTextSize((float)this.mPickerOptions.textSizeTitle);
        } else {
            this.mPickerOptions.customListener.customLayout(LayoutInflater.from((Context)object).inflate(this.mPickerOptions.layoutRes, this.contentContainer));
        }
        object = (LinearLayout)this.findViewById(R.id.timepicker);
        object.setBackgroundColor(this.mPickerOptions.bgColorWheel);
        this.initWheelTime((LinearLayout)object);
    }

    private void initWheelTime(LinearLayout linearLayout) {
        this.wheelTime = new WheelTime((View)linearLayout, this.mPickerOptions.type, this.mPickerOptions.textGravity, this.mPickerOptions.textSizeContent);
        if (this.mPickerOptions.timeSelectChangeListener != null) {
            this.wheelTime.setSelectChangeCallback((ISelectTimeCallback)new /* Unavailable Anonymous Inner Class!! */);
        }
        this.wheelTime.setLunarMode(this.mPickerOptions.isLunarCalendar);
        if (this.mPickerOptions.startYear != 0 && this.mPickerOptions.endYear != 0 && this.mPickerOptions.startYear <= this.mPickerOptions.endYear) {
            this.setRange();
        }
        if (this.mPickerOptions.startDate != null && this.mPickerOptions.endDate != null) {
            if (this.mPickerOptions.startDate.getTimeInMillis() > this.mPickerOptions.endDate.getTimeInMillis()) throw new IllegalArgumentException("startDate can't be later than endDate");
            this.setRangDate();
        } else if (this.mPickerOptions.startDate != null) {
            if (this.mPickerOptions.startDate.get(1) < 1900) throw new IllegalArgumentException("The startDate can not as early as 1900");
            this.setRangDate();
        } else if (this.mPickerOptions.endDate != null) {
            if (this.mPickerOptions.endDate.get(1) > 2100) throw new IllegalArgumentException("The endDate should not be later than 2100");
            this.setRangDate();
        } else {
            this.setRangDate();
        }
        this.setTime();
        this.wheelTime.setLabels(this.mPickerOptions.label_year, this.mPickerOptions.label_month, this.mPickerOptions.label_day, this.mPickerOptions.label_hours, this.mPickerOptions.label_minutes, this.mPickerOptions.label_seconds);
        this.wheelTime.setTextXOffset(this.mPickerOptions.x_offset_year, this.mPickerOptions.x_offset_month, this.mPickerOptions.x_offset_day, this.mPickerOptions.x_offset_hours, this.mPickerOptions.x_offset_minutes, this.mPickerOptions.x_offset_seconds);
        this.setOutSideCancelable(this.mPickerOptions.cancelable);
        this.wheelTime.setCyclic(this.mPickerOptions.cyclic);
        this.wheelTime.setDividerColor(this.mPickerOptions.dividerColor);
        this.wheelTime.setDividerType(this.mPickerOptions.dividerType);
        this.wheelTime.setLineSpacingMultiplier(this.mPickerOptions.lineSpacingMultiplier);
        this.wheelTime.setTextColorOut(this.mPickerOptions.textColorOut);
        this.wheelTime.setTextColorCenter(this.mPickerOptions.textColorCenter);
        this.wheelTime.isCenterLabel(this.mPickerOptions.isCenterLabel);
    }

    private void setRangDate() {
        this.wheelTime.setRangDate(this.mPickerOptions.startDate, this.mPickerOptions.endDate);
        this.initDefaultSelectedDate();
    }

    private void setRange() {
        this.wheelTime.setStartYear(this.mPickerOptions.startYear);
        this.wheelTime.setEndYear(this.mPickerOptions.endYear);
    }

    private void setTime() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        Calendar calendar = Calendar.getInstance();
        if (this.mPickerOptions.date == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            n6 = calendar.get(1);
            n5 = calendar.get(2);
            n4 = calendar.get(5);
            n3 = calendar.get(11);
            n2 = calendar.get(12);
            n = calendar.get(13);
        } else {
            n6 = this.mPickerOptions.date.get(1);
            n5 = this.mPickerOptions.date.get(2);
            n4 = this.mPickerOptions.date.get(5);
            n3 = this.mPickerOptions.date.get(11);
            n2 = this.mPickerOptions.date.get(12);
            n = this.mPickerOptions.date.get(13);
        }
        this.wheelTime.setPicker(n6, n5, n4, n3, n2, n);
    }

    public boolean isDialog() {
        return this.mPickerOptions.isDialog;
    }

    public boolean isLunarCalendar() {
        return this.wheelTime.isLunarMode();
    }

    public void onClick(View view) {
        String string2 = (String)view.getTag();
        if (string2.equals(TAG_SUBMIT)) {
            this.returnData();
        } else if (string2.equals(TAG_CANCEL) && this.mPickerOptions.cancelListener != null) {
            this.mPickerOptions.cancelListener.onClick(view);
        }
        this.dismiss();
    }

    public void returnData() {
        if (this.mPickerOptions.timeSelectListener == null) return;
        try {
            Date date = WheelTime.dateFormat.parse(this.wheelTime.getTime());
            this.mPickerOptions.timeSelectListener.onTimeSelect(date, this.clickView);
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
    }

    public void setDate(Calendar calendar) {
        this.mPickerOptions.date = calendar;
        this.setTime();
    }

    public void setLunarCalendar(boolean bl) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(WheelTime.dateFormat.parse(this.wheelTime.getTime()));
            int n = calendar.get(1);
            int n2 = calendar.get(2);
            int n3 = calendar.get(5);
            int n4 = calendar.get(11);
            int n5 = calendar.get(12);
            int n6 = calendar.get(13);
            this.wheelTime.setLunarMode(bl);
            this.wheelTime.setLabels(this.mPickerOptions.label_year, this.mPickerOptions.label_month, this.mPickerOptions.label_day, this.mPickerOptions.label_hours, this.mPickerOptions.label_minutes, this.mPickerOptions.label_seconds);
            this.wheelTime.setPicker(n, n2, n3, n4, n5, n6);
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
    }

    public void setTitleText(String string2) {
        TextView textView = (TextView)this.findViewById(R.id.tvTitle);
        if (textView == null) return;
        textView.setText((CharSequence)string2);
    }
}
