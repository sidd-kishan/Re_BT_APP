/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  butterknife.BindView
 *  com.lianhezhuli.btnotification.base.BaseMvpFragment
 *  com.lianhezhuli.btnotification.base.basepresenter.BasePresenter
 *  com.lianhezhuli.btnotification.base.baseview.BaseView
 *  com.lianhezhuli.btnotification.event.SyncDataEvent
 *  com.lianhezhuli.btnotification.function.home.fragment._$$Lambda$SportFragment$5mVehyG_wUFVlyYL2W8nrixJuEg
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract$View
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.sport.SportPresenter
 *  com.lianhezhuli.btnotification.mtk.CommandUtil
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils.Utils
 *  com.lianhezhuli.btnotification.view.SportProgressView
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.lianhezhuli.btnotification.base.BaseMvpFragment;
import com.lianhezhuli.btnotification.base.basepresenter.BasePresenter;
import com.lianhezhuli.btnotification.base.baseview.BaseView;
import com.lianhezhuli.btnotification.event.SyncDataEvent;
import com.lianhezhuli.btnotification.function.home.fragment._$;
import com.lianhezhuli.btnotification.function.home.fragment.mvp.SportContract;
import com.lianhezhuli.btnotification.function.home.fragment.mvp.sport.SportPresenter;
import com.lianhezhuli.btnotification.mtk.CommandUtil;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils.Utils;
import com.lianhezhuli.btnotification.view.SportProgressView;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SportFragment
extends BaseMvpFragment<SportPresenter>
implements SportContract.View,
SwipeRefreshLayout.OnRefreshListener {
    @BindView(value=2131296771)
    TextView mCalorieTv;
    @BindView(value=2131296768)
    ViewPager mDataVp;
    private String[] mDateArr;
    @BindView(value=2131296770)
    TextView mDistanceTv;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    @BindView(value=2131296778)
    LinearLayout mIndicatorLl;
    private ImageView[] mIndicators;
    private PagerAdapter mPagerAdapter;
    private List<View> mPagers = new ArrayList<View>();
    @BindView(value=2131296777)
    SportProgressView mProgressView;
    @BindView(value=2131296772)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(value=2131296773)
    View mStatusView;
    @BindView(value=2131296775)
    TextView mStepNumTv;
    @BindView(value=2131296776)
    TextView mTargetProgressTv;

    static /* synthetic */ List access$000(SportFragment sportFragment) {
        return sportFragment.mPagers;
    }

    static /* synthetic */ ImageView[] access$100(SportFragment sportFragment) {
        return sportFragment.mIndicators;
    }

    static /* synthetic */ String[] access$200(SportFragment sportFragment) {
        return sportFragment.mDateArr;
    }

    static /* synthetic */ BasePresenter access$300(SportFragment sportFragment) {
        return sportFragment.mPresenter;
    }

    private void initViewpager() {
        this.mPagers.add(this.getLayoutInflater().inflate(2131492932, null));
        this.mPagers.add(this.getLayoutInflater().inflate(2131492932, null));
        this.mPagers.add(this.getLayoutInflater().inflate(2131492932, null));
        this.mPagerAdapter = new /* Unavailable Anonymous Inner Class!! */;
        this.mDataVp.addOnPageChangeListener((ViewPager.OnPageChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mDataVp.setAdapter(this.mPagerAdapter);
        this.mIndicators = new ImageView[this.mPagers.size()];
        int n = 0;
        while (n < this.mIndicators.length) {
            ImageView imageView = new ImageView((Context)this.mActivity);
            ImageView[] imageViewArray = new LinearLayout.LayoutParams(QMUIDisplayHelper.dpToPx((int)5), QMUIDisplayHelper.dpToPx((int)5));
            if (n == 1) {
                imageViewArray.setMargins(QMUIDisplayHelper.dpToPx((int)10), 0, QMUIDisplayHelper.dpToPx((int)10), QMUIDisplayHelper.dpToPx((int)10));
            }
            imageView.setLayoutParams((ViewGroup.LayoutParams)imageViewArray);
            imageViewArray = this.mIndicators;
            imageViewArray[n] = imageView;
            if (n == 0) {
                imageViewArray[n].setBackgroundResource(2131623982);
            } else {
                imageViewArray[n].setBackgroundResource(2131623983);
            }
            this.mIndicatorLl.addView((View)this.mIndicators[n]);
            ++n;
        }
    }

    protected int getLayoutId() {
        return 2131492928;
    }

    public void hideLoading() {
    }

    protected void initView() {
        this.mPresenter = new SportPresenter();
        EventBus.getDefault().register((Object)this);
        Object object = new LinearLayout.LayoutParams(-1, Utils.getStatusBarHeight((Context)this.mActivity));
        this.mStatusView.setLayoutParams((ViewGroup.LayoutParams)object);
        this.mRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)this);
        object = new StringBuilder();
        ((StringBuilder)object).append("target: ");
        ((StringBuilder)object).append(this.getString(2131755227));
        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        this.mTargetProgressTv.setText((CharSequence)StringUtils.formatStr((String)this.getString(2131755227), (Object[])new Object[]{5000}));
        this.mDateArr = new String[]{this.getString(2131755223), this.getString(2131755224), this.getString(2131755222)};
        this.initViewpager();
    }

    public /* synthetic */ void lambda$onRefresh$0$SportFragment() {
        if (!this.mRefreshLayout.isRefreshing()) return;
        this.mRefreshLayout.setRefreshing(false);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister((Object)this);
        super.onDestroy();
    }

    public void onError(Throwable throwable) {
    }

    public void onRefresh() {
        if (!MainService.getInstance().sendPhoneData(CommandUtil.SYNC_DATA)) {
            this.mRefreshLayout.setRefreshing(false);
            return;
        }
        this.mHandler.postDelayed((Runnable)new _$.Lambda.SportFragment.5mVehyG_wUFVlyYL2W8nrixJuEg(this), 15000L);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((SportPresenter)this.mPresenter).attachView((BaseView)this);
        ((SportPresenter)this.mPresenter).getStepData(0);
    }

    public void setStepData(int n, int n2) {
        StringBuilder stringBuilder;
        float f = Utils.getDistance((int)n);
        float f2 = Utils.getCalorie((int)n);
        CharSequence charSequence = "%.0f";
        CharSequence charSequence2 = n == 0 ? "%.0f" : "%.2f";
        String string = StringUtils.formatStr((String)charSequence2, (Object[])new Object[]{Float.valueOf(f)});
        charSequence2 = n == 0 ? charSequence : "%.2f";
        charSequence2 = StringUtils.formatStr((String)charSequence2, (Object[])new Object[]{Float.valueOf(f2)});
        if (n2 == 0) {
            charSequence = this.mStepNumTv;
            stringBuilder = new StringBuilder();
            stringBuilder.append(n);
            stringBuilder.append("");
            charSequence.setText((CharSequence)stringBuilder.toString());
            this.mProgressView.setData(5000, n);
            if (n >= 5000) {
                this.mTargetProgressTv.setText((CharSequence)this.getString(2131755226));
            } else {
                this.mTargetProgressTv.setText((CharSequence)StringUtils.formatStr((String)this.getString(2131755227), (Object[])new Object[]{5000 - n}));
            }
            this.mDistanceTv.setText((CharSequence)string);
            this.mCalorieTv.setText(charSequence2);
        }
        stringBuilder = (TextView)this.mPagers.get(n2).findViewById(2131296767);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(n);
        ((StringBuilder)charSequence).append("");
        stringBuilder.setText(((StringBuilder)charSequence).toString());
        ((TextView)this.mPagers.get(n2).findViewById(2131296766)).setText((CharSequence)string);
        ((TextView)this.mPagers.get(n2).findViewById(2131296764)).setText(charSequence2);
    }

    public void showLoading() {
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void syncSuccess(SyncDataEvent object) {
        this.mRefreshLayout.setRefreshing(false);
        this.mHandler.removeCallbacksAndMessages(null);
        if (!object.isSuccess()) return;
        object = new StringBuilder();
        ((StringBuilder)object).append(this.TAG);
        ((StringBuilder)object).append(" syncSuccess --- ");
        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        ((SportPresenter)this.mPresenter).getStepData(0);
    }
}
