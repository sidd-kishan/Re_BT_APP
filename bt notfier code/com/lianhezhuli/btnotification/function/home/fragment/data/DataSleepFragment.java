/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.lianhezhuli.btnotification.base.BaseMvpFragment
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 *  com.lianhezhuli.btnotification.bean.BarChartBean
 *  com.lianhezhuli.btnotification.event.SyncDataEvent
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract$View
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSleepPresenter
 *  com.lianhezhuli.btnotification.utils.DateUtil
 *  com.lianhezhuli.btnotification.utils.Utils
 *  com.lianhezhuli.btnotification.view.SleepBarChartView
 *  com.lianhezhuli.btnotification.view.SleepBarChartView$OnBarClickListener
 *  com.lianhezhuli.btnotification.view.SleepTimeProgressView
 *  com.lianhezhuli.btnotification.view.calendar.MyCalendarView
 *  com.lianhezhuli.btnotification.view.calendar.MyCalendarView$OnDateSelectListener
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.home.fragment.data;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lianhezhuli.btnotification.base.BaseMvpFragment;
import com.lianhezhuli.btnotification.base.baseview.BaseView;
import com.lianhezhuli.btnotification.bean.BarChartBean;
import com.lianhezhuli.btnotification.event.SyncDataEvent;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSleepContract;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSleepPresenter;
import com.lianhezhuli.btnotification.utils.DateUtil;
import com.lianhezhuli.btnotification.utils.Utils;
import com.lianhezhuli.btnotification.view.SleepBarChartView;
import com.lianhezhuli.btnotification.view.SleepTimeProgressView;
import com.lianhezhuli.btnotification.view.calendar.MyCalendarView;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DataSleepFragment
extends BaseMvpFragment<DataSleepPresenter>
implements DataSleepContract.View,
MyCalendarView.OnDateSelectListener,
SleepBarChartView.OnBarClickListener {
    @BindView(value=2131296415)
    SleepBarChartView mBarChart;
    @BindView(value=2131296417)
    MyCalendarView mCalendarView;
    @BindView(value=2131296418)
    TextView mDateTv;
    private List<String> mDates = new ArrayList<String>();
    @BindView(value=2131296419)
    RelativeLayout mHeadRl;
    @BindView(value=2131296420)
    TextView mHourTimeTv;
    private String mLastSelectDate = "";
    @BindView(value=2131296421)
    TextView mMinuteTimeTv;
    @BindView(value=2131296423)
    TextView mSecondTimeTv;
    @BindView(value=2131296422)
    SleepTimeProgressView mSleepTimeProgress;

    private void setTimeView(BarChartBean barChartBean) {
        Object object = this.mHourTimeTv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(barChartBean.getValue() / 3600);
        stringBuilder.append("");
        object.setText((CharSequence)stringBuilder.toString());
        stringBuilder = this.mMinuteTimeTv;
        object = new StringBuilder();
        ((StringBuilder)object).append(barChartBean.getValue() % 3600 / 60);
        ((StringBuilder)object).append("");
        stringBuilder.setText(((StringBuilder)object).toString());
        stringBuilder = this.mSecondTimeTv;
        object = new StringBuilder();
        ((StringBuilder)object).append(barChartBean.getValue() % 60);
        ((StringBuilder)object).append("");
        stringBuilder.setText(((StringBuilder)object).toString());
        this.mSleepTimeProgress.setProgress(barChartBean.getValue());
        this.mDateTv.setText((CharSequence)barChartBean.getDate());
    }

    @OnClick(value={2131296416})
    public void click(View view) {
        if (view.getId() != 2131296416) return;
        this.mCalendarView.showView();
    }

    protected int getLayoutId() {
        return 2131492925;
    }

    public void hideLoading() {
    }

    protected void initView() {
        this.mHeadRl.setPadding(0, Utils.getStatusBarHeight((Context)this.mActivity), 0, 0);
        this.mPresenter = new DataSleepPresenter();
        this.mCalendarView.setOnDateSelectListener((MyCalendarView.OnDateSelectListener)this);
        this.mBarChart.setOnBarClickListener((SleepBarChartView.OnBarClickListener)this);
        EventBus.getDefault().register((Object)this);
    }

    protected void loadData() {
        ((DataSleepPresenter)this.mPresenter).attachView((BaseView)this);
        this.mDates = DateUtil.getLast7Dates();
        ((DataSleepPresenter)this.mPresenter).getWeekData(this.mDates, "");
    }

    public void onDateSelect(String string) {
        this.mLastSelectDate = string;
        this.mDates.clear();
        this.mDates.addAll(DateUtil.getWeek((String)string));
        ((DataSleepPresenter)this.mPresenter).getWeekData(this.mDates, string);
        this.mDateTv.setText((CharSequence)string);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister((Object)this);
        super.onDestroy();
    }

    public void onError(Throwable throwable) {
    }

    public void onWitchClick(BarChartBean barChartBean) {
        this.setTimeView(barChartBean);
    }

    public void setWeekData(List<BarChartBean> list, int n, int n2) {
        this.mBarChart.setData(list, n);
        this.setTimeView(list.get(n2));
    }

    public void showLoading() {
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void syncSuccess(SyncDataEvent syncDataEvent) {
        if (this.mDates.size() != 7) return;
        ((DataSleepPresenter)this.mPresenter).getWeekData(this.mDates, this.mLastSelectDate);
    }
}
