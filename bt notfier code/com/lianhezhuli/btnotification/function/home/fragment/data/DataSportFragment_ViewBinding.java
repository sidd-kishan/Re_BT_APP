/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment
 *  com.lianhezhuli.btnotification.view.SportBarChartView
 *  com.lianhezhuli.btnotification.view.calendar.MyCalendarView
 */
package com.lianhezhuli.btnotification.function.home.fragment.data;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment;
import com.lianhezhuli.btnotification.view.SportBarChartView;
import com.lianhezhuli.btnotification.view.calendar.MyCalendarView;

public class DataSportFragment_ViewBinding
implements Unbinder {
    private DataSportFragment target;
    private View view7f0900ad;

    public DataSportFragment_ViewBinding(DataSportFragment dataSportFragment, View view) {
        this.target = dataSportFragment;
        dataSportFragment.mHeadLl = (LinearLayout)Utils.findRequiredViewAsType((View)view, (int)2131296434, (String)"field 'mHeadLl'", LinearLayout.class);
        dataSportFragment.mBarChart = (SportBarChartView)Utils.findRequiredViewAsType((View)view, (int)2131296428, (String)"field 'mBarChart'", SportBarChartView.class);
        dataSportFragment.mCalendarView = (MyCalendarView)Utils.findRequiredViewAsType((View)view, (int)2131296430, (String)"field 'mCalendarView'", MyCalendarView.class);
        dataSportFragment.mCalorieTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296431, (String)"field 'mCalorieTv'", TextView.class);
        dataSportFragment.mActiveTimeTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296426, (String)"field 'mActiveTimeTv'", TextView.class);
        dataSportFragment.mDistanceTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296433, (String)"field 'mDistanceTv'", TextView.class);
        dataSportFragment.mAverageTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296427, (String)"field 'mAverageTv'", TextView.class);
        dataSportFragment.mTotalTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296436, (String)"field 'mTotalTv'", TextView.class);
        dataSportFragment.mDateTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296432, (String)"field 'mDateTv'", TextView.class);
        this.view7f0900ad = view = Utils.findRequiredView((View)view, (int)2131296429, (String)"method 'click'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        DataSportFragment dataSportFragment = this.target;
        if (dataSportFragment == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        dataSportFragment.mHeadLl = null;
        dataSportFragment.mBarChart = null;
        dataSportFragment.mCalendarView = null;
        dataSportFragment.mCalorieTv = null;
        dataSportFragment.mActiveTimeTv = null;
        dataSportFragment.mDistanceTv = null;
        dataSportFragment.mAverageTv = null;
        dataSportFragment.mTotalTv = null;
        dataSportFragment.mDateTv = null;
        this.view7f0900ad.setOnClickListener(null);
        this.view7f0900ad = null;
    }
}
