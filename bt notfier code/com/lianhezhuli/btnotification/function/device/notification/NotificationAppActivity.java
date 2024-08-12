/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  butterknife.BindView
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.bean.NotificationAppBean
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$3_XU5M0oCqsqgiQiVH3o23KdjeA
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$GFucjXVM5_5Vli3Gcb5lULnpST0
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$_CkK4d5KaZPEXbfIxwJzyqKhcyc
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$_smwBO04ZefD5JFHlKtxpDzk1Fw
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$nyHbq4I_LGRRPx9VEETG8nYRQp4
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$tfiZ6Rpi8fmF5GTlTjymG8d1Rdk
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$w9nWeL1JPvnHzeUEtFSj_mOzhUg
 *  com.lianhezhuli.btnotification.function.device.notification._$$Lambda$NotificationAppActivity$zsvby2MZPcnZTra7wJx_JtfeeEY
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter$OnButtonClickListener
 *  com.lianhezhuli.btnotification.mtk.data.IgnoreList
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.utils.DialogUtils
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$OnTabSelectedListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 *  io.reactivex.Observable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.schedulers.Schedulers
 */
package com.lianhezhuli.btnotification.function.device.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.bean.NotificationAppBean;
import com.lianhezhuli.btnotification.function.device.notification._$;
import com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter;
import com.lianhezhuli.btnotification.mtk.data.IgnoreList;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.utils.DialogUtils;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class NotificationAppActivity
extends BaseActivity {
    private HashSet<String> ignoreApp;
    private List<View> mPagers = new ArrayList<View>();
    private NotificationAppAdapter mPersonalAdapter;
    private List<NotificationAppBean> mPersonalAppList = new ArrayList<NotificationAppBean>();
    private ListView mPersonalLv;
    private View mPersonalView;
    private NotificationAppAdapter mSystemAdapter;
    private List<NotificationAppBean> mSystemAppList = new ArrayList<NotificationAppBean>();
    private ListView mSystemLv;
    private View mSystemView;
    @BindView(value=2131296645)
    QMUITabSegment mTabSegment;
    private QMUITipDialog mTipDialog;
    @BindView(value=2131296646)
    QMUITopBarLayout mTopBar;
    @BindView(value=2131296647)
    ViewPager mViewPager;

    public NotificationAppActivity() {
        this.ignoreApp = new HashSet();
    }

    static /* synthetic */ List access$000(NotificationAppActivity notificationAppActivity) {
        return notificationAppActivity.mPagers;
    }

    private void getAppList() {
        Object object;
        this.mTipDialog = object = DialogUtils.getTipDialog((Context)this, (int)1, (String)this.getString(2131755248));
        object.show();
        object = IgnoreList.getInstance().getIgnoreList();
        HashSet hashSet = IgnoreList.getInstance().getExclusionList();
        Observable.fromIterable((Iterable)this.getPackageManager().getInstalledPackages(0)).observeOn(Schedulers.newThread()).subscribe((Consumer)new _$.Lambda.NotificationAppActivity.GFucjXVM5_5Vli3Gcb5lULnpST0(this, hashSet, (HashSet)object), (Consumer)new _$.Lambda.NotificationAppActivity.w9nWeL1JPvnHzeUEtFSj_mOzhUg(this), (Action)new _$.Lambda.NotificationAppActivity.tfiZ6Rpi8fmF5GTlTjymG8d1Rdk(this));
    }

    private void initTabSegment() {
        this.mTabSegment.addTab(new QMUITabSegment.Tab((CharSequence)this.getString(2131755106)));
        this.mTabSegment.addTab(new QMUITabSegment.Tab((CharSequence)this.getString(2131755107)));
        this.mTabSegment.setHasIndicator(true);
        this.mTabSegment.setIndicatorPosition(false);
        this.mTabSegment.setIndicatorWidthAdjustContent(false);
        this.mTabSegment.setupWithViewPager(this.mViewPager, false);
        this.mTabSegment.setMode(1);
        this.mTabSegment.addOnTabSelectedListener((QMUITabSegment.OnTabSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void initViewpager() {
        NotificationAppAdapter notificationAppAdapter;
        this.mPersonalView = this.getLayoutInflater().inflate(2131493003, null);
        this.mSystemView = this.getLayoutInflater().inflate(2131493003, null);
        this.mPagers.add(this.mPersonalView);
        this.mPagers.add(this.mSystemView);
        this.mPersonalLv = (ListView)this.mPersonalView.findViewById(2131296643);
        this.mPersonalAdapter = notificationAppAdapter = new NotificationAppAdapter((Context)this);
        this.mPersonalLv.setAdapter((ListAdapter)notificationAppAdapter);
        this.mPersonalAdapter.setOnButtonClickListener((NotificationAppAdapter.OnButtonClickListener)new _$.Lambda.NotificationAppActivity.nyHbq4I_LGRRPx9VEETG8nYRQp4(this));
        this.mSystemLv = (ListView)this.mSystemView.findViewById(2131296643);
        this.mSystemAdapter = notificationAppAdapter = new NotificationAppAdapter((Context)this);
        this.mSystemLv.setAdapter((ListAdapter)notificationAppAdapter);
        this.mSystemAdapter.setOnButtonClickListener((NotificationAppAdapter.OnButtonClickListener)new _$.Lambda.NotificationAppActivity._CkK4d5KaZPEXbfIxwJzyqKhcyc(this));
        notificationAppAdapter = new /* Unavailable Anonymous Inner Class!! */;
        this.mViewPager.setAdapter((PagerAdapter)notificationAppAdapter);
    }

    static /* synthetic */ int lambda$getAppList$3(NotificationAppBean notificationAppBean, NotificationAppBean notificationAppBean2) {
        return notificationAppBean.getAppName().compareToIgnoreCase(notificationAppBean2.getAppName());
    }

    protected void initView() {
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.NotificationAppActivity._smwBO04ZefD5JFHlKtxpDzk1Fw(this));
        this.mTopBar.setTitle(2131755097);
        this.initViewpager();
        this.initTabSegment();
        this.getAppList();
    }

    public /* synthetic */ void lambda$getAppList$1$NotificationAppActivity(HashSet hashSet, HashSet hashSet2, PackageInfo packageInfo) throws Exception {
        if (packageInfo == null) return;
        if (hashSet.contains(packageInfo.packageName)) {
            return;
        }
        hashSet = new NotificationAppBean();
        hashSet.setIcon(this.getPackageManager().getApplicationIcon(packageInfo.applicationInfo));
        hashSet.setAppName(this.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString());
        hashSet.setPackageName(packageInfo.packageName);
        hashSet.setSelect(hashSet2.contains(packageInfo.packageName) ^ true);
        if (Util.isSystemApp((ApplicationInfo)packageInfo.applicationInfo)) {
            this.mSystemAppList.add((NotificationAppBean)hashSet);
        } else {
            this.mPersonalAppList.add((NotificationAppBean)hashSet);
        }
    }

    public /* synthetic */ void lambda$getAppList$2$NotificationAppActivity(Throwable throwable) throws Exception {
        this.mTipDialog.dismiss();
        throwable.printStackTrace();
    }

    public /* synthetic */ void lambda$getAppList$4$NotificationAppActivity() {
        this.mTipDialog.dismiss();
        this.mPersonalAdapter.updateData(this.mPersonalAppList);
        this.mSystemAdapter.updateData(this.mSystemAppList);
    }

    public /* synthetic */ void lambda$getAppList$5$NotificationAppActivity() throws Exception {
        _$.Lambda.NotificationAppActivity.3_XU5M0oCqsqgiQiVH3o23KdjeA _XU5M0oCqsqgiQiVH3o23KdjeA = _$.Lambda.NotificationAppActivity.3_XU5M0oCqsqgiQiVH3o23KdjeA.INSTANCE;
        List<NotificationAppBean> list = this.mPersonalAppList;
        if (list != null) {
            Collections.sort(list, _XU5M0oCqsqgiQiVH3o23KdjeA);
        }
        if ((list = this.mSystemAppList) != null) {
            Collections.sort(list, _XU5M0oCqsqgiQiVH3o23KdjeA);
        }
        this.runOnUiThread((Runnable)new _$.Lambda.NotificationAppActivity.zsvby2MZPcnZTra7wJx_JtfeeEY(this));
    }

    public /* synthetic */ void lambda$initView$0$NotificationAppActivity(View view) {
        this.finish();
    }

    public /* synthetic */ void lambda$initViewpager$6$NotificationAppActivity(int n, boolean bl) {
        this.mPersonalAppList.get(n).setSelect(bl);
        if (!bl) {
            this.ignoreApp.add(this.mPersonalAppList.get(n).getPackageName());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("personal == ");
            stringBuilder.append(this.ignoreApp.size());
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        } else {
            this.ignoreApp.remove(this.mPersonalAppList.get(n).getPackageName());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("personal == ");
            stringBuilder.append(this.ignoreApp.size());
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        }
    }

    public /* synthetic */ void lambda$initViewpager$7$NotificationAppActivity(int n, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("system == ");
        stringBuilder.append(n);
        stringBuilder.append(" check == ");
        stringBuilder.append(bl);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (!bl) {
            this.ignoreApp.add(this.mSystemAppList.get(n).getPackageName());
            stringBuilder = new StringBuilder();
            stringBuilder.append("personal == ");
            stringBuilder.append(this.ignoreApp.size());
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        } else {
            this.ignoreApp.remove(this.mSystemAppList.get(n).getPackageName());
            stringBuilder = new StringBuilder();
            stringBuilder.append("personal == ");
            stringBuilder.append(this.ignoreApp.size());
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        IgnoreList.getInstance().saveIgnoreList(this.ignoreApp);
    }

    protected int setLayoutId() {
        return 2131492896;
    }
}
