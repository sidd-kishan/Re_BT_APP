/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  butterknife.BindView
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter$OnItemClickListener
 *  com.lianhezhuli.btnotification.bean.RemoteAlarmBean
 *  com.lianhezhuli.btnotification.event.RemoteAlarmEvent
 *  com.lianhezhuli.btnotification.function.device.remotealarm._$$Lambda$RemoteAlarmActivity$KGo0_6b3c_1eZCMRuif7u4zuJi0
 *  com.lianhezhuli.btnotification.function.device.remotealarm._$$Lambda$RemoteAlarmActivity$gDxCS9S5PMcEZFUib0PK7h7QuM0
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter$OnButtonClickListener
 *  com.lianhezhuli.btnotification.utils.DialogUtils
 *  com.lianhezhuli.btnotification.utils.SpUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.lianhezhuli.btnotification.view.SwipeRecycler
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.device.remotealarm;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter;
import com.lianhezhuli.btnotification.bean.RemoteAlarmBean;
import com.lianhezhuli.btnotification.event.RemoteAlarmEvent;
import com.lianhezhuli.btnotification.function.device.remotealarm._$;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter;
import com.lianhezhuli.btnotification.utils.DialogUtils;
import com.lianhezhuli.btnotification.utils.SpUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.lianhezhuli.btnotification.view.SwipeRecycler;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class RemoteAlarmActivity
extends BaseActivity {
    public static final String ALARM_DATA = "alarm_data";
    public static final String ALARM_INDEX = "alarm_index";
    private List<RemoteAlarmBean> mAlarmList;
    @BindView(value=2131296700)
    SwipeRecycler mRecycler;
    private RemoteAlarmAdapter mRecyclerAdapter;
    private QMUITipDialog mTipDialog;
    @BindView(value=2131296702)
    QMUITopBarLayout mTopBar;
    private final int requestCode;

    public RemoteAlarmActivity() {
        this.requestCode = 1000;
    }

    static /* synthetic */ QMUITipDialog access$000(RemoteAlarmActivity remoteAlarmActivity) {
        return remoteAlarmActivity.mTipDialog;
    }

    static /* synthetic */ List access$100(RemoteAlarmActivity remoteAlarmActivity) {
        return remoteAlarmActivity.mAlarmList;
    }

    static /* synthetic */ RemoteAlarmAdapter access$200(RemoteAlarmActivity remoteAlarmActivity) {
        return remoteAlarmActivity.mRecyclerAdapter;
    }

    protected void initView() {
        List list;
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.RemoteAlarmActivity.gDxCS9S5PMcEZFUib0PK7h7QuM0(this));
        this.mTopBar.setTitle(2131755098);
        this.mAlarmList = list = (List)SpUtils.getShareData((String)"remote_alarm_data", (Type)new /* Unavailable Anonymous Inner Class!! */.getType());
        if (list == null) {
            this.mAlarmList = new ArrayList<RemoteAlarmBean>();
            for (int i = 0; i < 5; ++i) {
                list = new RemoteAlarmBean();
                list.setTime("12:00");
                list.setRepeat(0);
                list.setOn("0");
                this.mAlarmList.add((RemoteAlarmBean)list);
            }
        }
        this.mTipDialog = DialogUtils.getTipDialog((Context)this, (int)1, (String)this.getString(2131755261));
        list = new RemoteAlarmAdapter((Context)this);
        this.mRecyclerAdapter = list;
        this.mRecycler.setAdapter((RecyclerView.Adapter)list);
        this.mRecyclerAdapter.setList(this.mAlarmList);
        this.mRecyclerAdapter.setOnButtonClickListener((RemoteAlarmAdapter.OnButtonClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mRecyclerAdapter.setOnItemClickListener((BaseRecyclerAdapter.OnItemClickListener)new _$.Lambda.RemoteAlarmActivity.KGo0_6b3c_1eZCMRuif7u4zuJi0(this));
    }

    public /* synthetic */ void lambda$initView$0$RemoteAlarmActivity(View view) {
        this.finish();
    }

    public /* synthetic */ void lambda$initView$1$RemoteAlarmActivity(View view, Object object, int n) {
        this.mRecycler.closeEx();
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n != 1000) return;
        if (n2 != -1) return;
        this.mAlarmList.clear();
        this.mAlarmList.addAll((List)((Object)intent.getSerializableExtra(ALARM_DATA)));
        this.mRecyclerAdapter.setList(this.mAlarmList);
        SpUtils.saveJsonData((String)"remote_alarm_data", this.mAlarmList);
    }

    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister((Object)this);
    }

    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register((Object)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void setAlarmResult(RemoteAlarmEvent remoteAlarmEvent) {
        this.mTipDialog.dismiss();
        if (remoteAlarmEvent.isSuccess()) {
            ToastUtils.showLong((Context)this, (int)2131755260);
        } else {
            ToastUtils.showLong((Context)this, (int)2131755259);
        }
    }

    protected int setLayoutId() {
        return 2131492897;
    }
}
