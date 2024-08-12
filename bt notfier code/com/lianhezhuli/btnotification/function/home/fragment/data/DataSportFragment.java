/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.lianhezhuli.btnotification.base.BaseMvpFragment
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 *  com.lianhezhuli.btnotification.bean.BarChartBean
 *  com.lianhezhuli.btnotification.event.SyncDataEvent
 *  com.lianhezhuli.btnotification.function.home.fragment.data._$$Lambda$DataSportFragment$Wq6D7T3QRg0rLNWVWiVYMBF3zWU
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract$View
 *  com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSportPresenter
 *  com.lianhezhuli.btnotification.utils.DateUtil
 *  com.lianhezhuli.btnotification.utils.JsonUtils
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils.Utils
 *  com.lianhezhuli.btnotification.view.SportBarChartView
 *  com.lianhezhuli.btnotification.view.SportBarChartView$OnBarClickListener
 *  com.lianhezhuli.btnotification.view.calendar.MyCalendarView
 *  com.lianhezhuli.btnotification.view.calendar.MyCalendarView$OnDateSelectListener
 *  com.orhanobut.logger.Logger
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.home.fragment.data;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lianhezhuli.btnotification.base.BaseMvpFragment;
import com.lianhezhuli.btnotification.base.baseview.BaseView;
import com.lianhezhuli.btnotification.bean.BarChartBean;
import com.lianhezhuli.btnotification.event.SyncDataEvent;
import com.lianhezhuli.btnotification.function.home.fragment.data._$;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.DataSportContract;
import com.lianhezhuli.btnotification.function.home.fragment.data.mvp.datasport.DataSportPresenter;
import com.lianhezhuli.btnotification.utils.DateUtil;
import com.lianhezhuli.btnotification.utils.JsonUtils;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils.Utils;
import com.lianhezhuli.btnotification.view.SportBarChartView;
import com.lianhezhuli.btnotification.view.calendar.MyCalendarView;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DataSportFragment
extends BaseMvpFragment<DataSportPresenter>
implements DataSportContract.View,
MyCalendarView.OnDateSelectListener,
SportBarChartView.OnBarClickListener {
    @BindView(value=2131296426)
    TextView mActiveTimeTv;
    @BindView(value=2131296427)
    TextView mAverageTv;
    @BindView(value=2131296428)
    SportBarChartView mBarChart;
    @BindView(value=2131296430)
    MyCalendarView mCalendarView;
    @BindView(value=2131296431)
    TextView mCalorieTv;
    @BindView(value=2131296432)
    TextView mDateTv;
    private List<String> mDates;
    @BindView(value=2131296433)
    TextView mDistanceTv;
    private Handler mHandler = new Handler();
    @BindView(value=2131296434)
    LinearLayout mHeadLl;
    private String mLastSelectDate = "";
    @BindView(value=2131296436)
    TextView mTotalTv;

    public DataSportFragment() {
        this.mDates = new ArrayList<String>();
    }

    @OnClick(value={2131296429})
    public void click(View view) {
        if (view.getId() != 2131296429) return;
        this.mCalendarView.showView();
    }

    protected int getLayoutId() {
        return 2131492926;
    }

    public void hideLoading() {
    }

    protected void initView() {
        this.mHeadLl.setPadding(0, Utils.getStatusBarHeight((Context)this.mActivity), 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, Utils.getStatusBarHeight((Context)this.mActivity), 0, 0);
        this.mCalendarView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.mPresenter = new DataSportPresenter();
        EventBus.getDefault().register((Object)this);
    }

    public /* synthetic */ void lambda$loadData$0$DataSportFragment() {
        ((DataSportPresenter)this.mPresenter).getWeekData(this.mDates, "");
    }

    protected void loadData() {
        ((DataSportPresenter)this.mPresenter).attachView((BaseView)this);
        this.mCalendarView.setOnDateSelectListener((MyCalendarView.OnDateSelectListener)this);
        this.mBarChart.setOnBarClickListener((SportBarChartView.OnBarClickListener)this);
        this.mDates = DateUtil.getLast7Dates();
        this.mHandler.postDelayed((Runnable)new _$.Lambda.DataSportFragment.Wq6D7T3QRg0rLNWVWiVYMBF3zWU(this), 500L);
    }

    public void onDateSelect(String string) {
        this.mLastSelectDate = string;
        this.mDates.clear();
        this.mDates.addAll(DateUtil.getWeek((String)string));
        ((DataSportPresenter)this.mPresenter).getWeekData(this.mDates, string);
        this.mDateTv.setText((CharSequence)string);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister((Object)this);
        super.onDestroy();
    }

    public void onError(Throwable throwable) {
    }

    public void onWitchClick(BarChartBean barChartBean) {
        this.mDateTv.setText((CharSequence)barChartBean.getDate());
    }

    public void setWeekData(List<BarChartBean> object, int n, int n2, int n3, int n4) {
        Logger.e((String)JsonUtils.toJson(object), (Object[])new Object[0]);
        this.mBarChart.setData(object, n, n4);
        Object object2 = this.mTotalTv;
        object = new StringBuilder();
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append("");
        object2.setText((CharSequence)((StringBuilder)object).toString());
        object = this.mAverageTv;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(n2 / 7);
        ((StringBuilder)object2).append("");
        object.setText((CharSequence)((StringBuilder)object2).toString());
        TextView textView = this.mCalorieTv;
        object2 = "%.2f";
        object = n2 == 0 ? "%.0f" : "%.2f";
        textView.setText((CharSequence)StringUtils.formatStr((String)object, (Object[])new Object[]{Float.valueOf(Utils.getCalorie((int)n2))}));
        textView = this.mActiveTimeTv;
        object = n2 == 0 ? "%.0f" : "%.1f";
        textView.setText((CharSequence)StringUtils.formatStr((String)object, (Object[])new Object[]{Float.valueOf((float)n3 / 60.0f)}));
        textView = this.mDistanceTv;
        object = object2;
        if (n2 == 0) {
            object = "%.0f";
        }
        textView.setText((CharSequence)StringUtils.formatStr((String)object, (Object[])new Object[]{Float.valueOf(Utils.getDistance((int)n2))}));
    }

    public void showLoading() {
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void syncSuccess(SyncDataEvent syncDataEvent) {
        if (this.mDates.size() != 7) return;
        ((DataSportPresenter)this.mPresenter).getWeekData(this.mDates, this.mLastSelectDate);
    }
}
