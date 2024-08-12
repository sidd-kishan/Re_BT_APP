/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.bigkoo.pickerview.listener.OnOptionsSelectListener
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.bean.RemoteAlarmBean
 *  com.lianhezhuli.btnotification.event.RemoteAlarmEvent
 *  com.lianhezhuli.btnotification.function.device.remotealarm._$$Lambda$RemoteAlarmTimeSettingActivity$YzEVj4hhO_fEKEuE8hnftJFqylY
 *  com.lianhezhuli.btnotification.function.device.remotealarm._$$Lambda$RemoteAlarmTimeSettingActivity$ZZ3_Pu8wlQFfvRIv8NuM4TfEceg
 *  com.lianhezhuli.btnotification.function.device.remotealarm._$$Lambda$RemoteAlarmTimeSettingActivity$_ZAZhpmkQ0kSlJSI4Ln9qPuToLI
 *  com.lianhezhuli.btnotification.function.device.remotealarm._$$Lambda$RemoteAlarmTimeSettingActivity$kc7x5SEmWym3EkZkSQ86zztSpkE
 *  com.lianhezhuli.btnotification.function.device.remotealarm._$$Lambda$RemoteAlarmTimeSettingActivity$t4gRhgcqgGUWQHUT09NKTZszwpU
 *  com.lianhezhuli.btnotification.mtk.CommandUtil
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.utils.AlarmRepeatUtils
 *  com.lianhezhuli.btnotification.utils.DialogUtils
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.lianhezhuli.btnotification.view.pickerview.PickerViewHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MultiCheckableDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.device.remotealarm;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.bean.RemoteAlarmBean;
import com.lianhezhuli.btnotification.event.RemoteAlarmEvent;
import com.lianhezhuli.btnotification.function.device.remotealarm._$;
import com.lianhezhuli.btnotification.mtk.CommandUtil;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.utils.AlarmRepeatUtils;
import com.lianhezhuli.btnotification.utils.DialogUtils;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.lianhezhuli.btnotification.view.pickerview.PickerViewHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import java.io.Serializable;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class RemoteAlarmTimeSettingActivity
extends BaseActivity {
    private RemoteAlarmBean mAlarmBean;
    private List<RemoteAlarmBean> mAlarmList;
    @BindView(value=2131296324)
    TextView mAlarmRepeatTv;
    private int mEditIndex = -1;
    private int mRepeat = 0;
    @BindView(value=2131296325)
    CheckBox mSwitchCb;
    @BindView(value=2131296329)
    TextView mTimeSettingTv;
    private QMUITipDialog mTipDialog;
    @BindView(value=2131296327)
    QMUITopBarLayout mTopBar;

    private void initData() {
        int n;
        this.mAlarmList = (List)((Object)this.getIntent().getSerializableExtra("alarm_data"));
        this.mEditIndex = n = this.getIntent().getIntExtra("alarm_index", -1);
        if (n == -1) {
            this.finish();
        } else {
            RemoteAlarmBean remoteAlarmBean = this.mAlarmList;
            if (remoteAlarmBean != null) {
                this.mAlarmBean = remoteAlarmBean = remoteAlarmBean.get(n);
                this.mTimeSettingTv.setText((CharSequence)remoteAlarmBean.getTime());
                this.mRepeat = n = this.mAlarmBean.getRepeat();
                this.mAlarmRepeatTv.setText((CharSequence)AlarmRepeatUtils.getRepeatStr((int)n));
                this.mSwitchCb.setChecked(this.mAlarmBean.getOn().equals("1"));
            } else {
                this.finish();
            }
        }
    }

    static /* synthetic */ void lambda$click$3(QMUIDialog qMUIDialog, int n) {
        qMUIDialog.dismiss();
    }

    @OnClick(value={2131296328, 2131296323, 2131296326})
    public void click(View multiCheckableDialogBuilder) {
        int n = multiCheckableDialogBuilder.getId();
        if (n != 2131296323) {
            if (n != 2131296326) {
                if (n != 2131296328) return;
                multiCheckableDialogBuilder = this.mTimeSettingTv.getText().toString().split(":");
                PickerViewHelper.getInstance().showTimePicker((Context)this, this.getString(2131755205), (String)multiCheckableDialogBuilder[0], (String)multiCheckableDialogBuilder[1], (OnOptionsSelectListener)new _$.Lambda.RemoteAlarmTimeSettingActivity.t4gRhgcqgGUWQHUT09NKTZszwpU(this));
            } else {
                multiCheckableDialogBuilder = this.mSwitchCb;
                multiCheckableDialogBuilder.setChecked(multiCheckableDialogBuilder.isChecked() ^ true);
            }
        } else {
            multiCheckableDialogBuilder = new QMUIDialog.MultiCheckableDialogBuilder((Context)this).setCheckedItems(AlarmRepeatUtils.getRepeat((int)this.mRepeat)).addItems((CharSequence[])this.getResources().getStringArray(2130903052), null);
            ((QMUIDialog.MultiCheckableDialogBuilder)multiCheckableDialogBuilder.addAction(2131755050, (QMUIDialogAction.ActionListener)_$.Lambda.RemoteAlarmTimeSettingActivity.kc7x5SEmWym3EkZkSQ86zztSpkE.INSTANCE)).addAction(2131755116, (QMUIDialogAction.ActionListener)new _$.Lambda.RemoteAlarmTimeSettingActivity.YzEVj4hhO_fEKEuE8hnftJFqylY(this, multiCheckableDialogBuilder));
            multiCheckableDialogBuilder.create().show();
        }
    }

    protected void initView() {
        EventBus.getDefault().register((Object)this);
        this.mTopBar.setTitle(2131755208);
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.RemoteAlarmTimeSettingActivity._ZAZhpmkQ0kSlJSI4Ln9qPuToLI(this));
        Button button = this.mTopBar.addRightTextButton(2131755116, QMUIViewHelper.generateViewId());
        button.setTextColor(-1);
        button.setTextSize(12.0f);
        button.setOnClickListener((View.OnClickListener)new _$.Lambda.RemoteAlarmTimeSettingActivity.ZZ3_Pu8wlQFfvRIv8NuM4TfEceg(this));
        this.initData();
    }

    public /* synthetic */ void lambda$click$2$RemoteAlarmTimeSettingActivity(int n, int n2, int n3, View object) {
        TextView textView = this.mTimeSettingTv;
        object = new StringBuilder();
        ((StringBuilder)object).append(StringUtils.formatStr((String)"%02d", (Object[])new Object[]{n}));
        ((StringBuilder)object).append(":");
        ((StringBuilder)object).append(StringUtils.formatStr((String)"%02d", (Object[])new Object[]{n2}));
        textView.setText((CharSequence)((StringBuilder)object).toString());
    }

    public /* synthetic */ void lambda$click$4$RemoteAlarmTimeSettingActivity(QMUIDialog.MultiCheckableDialogBuilder multiCheckableDialogBuilder, QMUIDialog qMUIDialog, int n) {
        qMUIDialog.dismiss();
        this.mRepeat = n = AlarmRepeatUtils.handleRepeat((int[])multiCheckableDialogBuilder.getCheckedItemIndexes());
        this.mAlarmRepeatTv.setText((CharSequence)AlarmRepeatUtils.getRepeatStr((int)n));
    }

    public /* synthetic */ void lambda$initView$0$RemoteAlarmTimeSettingActivity(View view) {
        this.finish();
    }

    public /* synthetic */ void lambda$initView$1$RemoteAlarmTimeSettingActivity(View object) {
        object = DialogUtils.getTipDialog((Context)this, (int)1, (String)this.getString(2131755261));
        this.mTipDialog = object;
        object.show();
        String string = this.mTimeSettingTv.getText().toString();
        object = this.mSwitchCb.isChecked() ? "1" : "0";
        this.mAlarmBean.setTime(string);
        this.mAlarmBean.setRepeat(this.mRepeat);
        this.mAlarmBean.setOn((String)object);
        this.mAlarmList.set(this.mEditIndex, this.mAlarmBean);
        if (MainService.getInstance().sendPhoneData(CommandUtil.generateAlarmCommand(this.mAlarmList))) return;
        this.mTipDialog.dismiss();
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister((Object)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void setAlarmResult(RemoteAlarmEvent remoteAlarmEvent) {
        this.mTipDialog.dismiss();
        if (remoteAlarmEvent.isSuccess()) {
            ToastUtils.showLong((Context)this, (int)2131755260);
            remoteAlarmEvent = new Intent();
            remoteAlarmEvent.putExtra("alarm_data", (Serializable)((Object)this.mAlarmList));
            this.setResult(-1, (Intent)remoteAlarmEvent);
            this.finish();
        } else {
            this.setResult(0);
            ToastUtils.showLong((Context)this, (int)2131755259);
        }
    }

    protected int setLayoutId() {
        return 2131492898;
    }
}
