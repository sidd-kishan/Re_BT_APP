/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment
 *  com.lianhezhuli.btnotification.view.SleepBarChartView
 *  com.lianhezhuli.btnotification.view.SleepTimeProgressView
 *  com.lianhezhuli.btnotification.view.calendar.MyCalendarView
 */
package com.lianhezhuli.btnotification.function.home.fragment.data;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment;
import com.lianhezhuli.btnotification.view.SleepBarChartView;
import com.lianhezhuli.btnotification.view.SleepTimeProgressView;
import com.lianhezhuli.btnotification.view.calendar.MyCalendarView;

public class DataSleepFragment_ViewBinding
implements Unbinder {
    private DataSleepFragment target;
    private View view7f0900a0;

    public DataSleepFragment_ViewBinding(DataSleepFragment dataSleepFragment, View view) {
        this.target = dataSleepFragment;
        dataSleepFragment.mHeadRl = (RelativeLayout)Utils.findRequiredViewAsType((View)view, (int)2131296419, (String)"field 'mHeadRl'", RelativeLayout.class);
        dataSleepFragment.mBarChart = (SleepBarChartView)Utils.findRequiredViewAsType((View)view, (int)2131296415, (String)"field 'mBarChart'", SleepBarChartView.class);
        dataSleepFragment.mSleepTimeProgress = (SleepTimeProgressView)Utils.findRequiredViewAsType((View)view, (int)2131296422, (String)"field 'mSleepTimeProgress'", SleepTimeProgressView.class);
        dataSleepFragment.mCalendarView = (MyCalendarView)Utils.findRequiredViewAsType((View)view, (int)2131296417, (String)"field 'mCalendarView'", MyCalendarView.class);
        dataSleepFragment.mHourTimeTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296420, (String)"field 'mHourTimeTv'", TextView.class);
        dataSleepFragment.mMinuteTimeTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296421, (String)"field 'mMinuteTimeTv'", TextView.class);
        dataSleepFragment.mSecondTimeTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296423, (String)"field 'mSecondTimeTv'", TextView.class);
        dataSleepFragment.mDateTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296418, (String)"field 'mDateTv'", TextView.class);
        this.view7f0900a0 = view = Utils.findRequiredView((View)view, (int)2131296416, (String)"method 'click'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        DataSleepFragment dataSleepFragment = this.target;
        if (dataSleepFragment == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        dataSleepFragment.mHeadRl = null;
        dataSleepFragment.mBarChart = null;
        dataSleepFragment.mSleepTimeProgress = null;
        dataSleepFragment.mCalendarView = null;
        dataSleepFragment.mHourTimeTv = null;
        dataSleepFragment.mMinuteTimeTv = null;
        dataSleepFragment.mSecondTimeTv = null;
        dataSleepFragment.mDateTv = null;
        this.view7f0900a0.setOnClickListener(null);
        this.view7f0900a0 = null;
    }
}
