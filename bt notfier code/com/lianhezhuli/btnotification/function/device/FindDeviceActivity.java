/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.event.FindWatchEvent
 *  com.lianhezhuli.btnotification.function.device._$$Lambda$FindDeviceActivity$Md_DnPDMX3lprrbCXB__afH0LQM
 *  com.lianhezhuli.btnotification.function.device._$$Lambda$FindDeviceActivity$VBZlGoP_Nt10lLmGiDDiKLnsd0c
 *  com.lianhezhuli.btnotification.mtk.CommandUtil
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MessageDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package com.lianhezhuli.btnotification.function.device;

import android.content.Context;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.event.FindWatchEvent;
import com.lianhezhuli.btnotification.function.device._$;
import com.lianhezhuli.btnotification.mtk.CommandUtil;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FindDeviceActivity
extends BaseActivity {
    @BindView(value=2131296491)
    QMUITopBarLayout mTopBar;

    static /* synthetic */ void lambda$findWatchSuccess$1(QMUIDialog qMUIDialog, int n) {
        MainService.getInstance().sendPhoneData(CommandUtil.FIND_WATCH_STOP);
        qMUIDialog.dismiss();
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void findWatchSuccess(FindWatchEvent object) {
        object = new StringBuilder();
        ((StringBuilder)object).append(this.TAG);
        ((StringBuilder)object).append(" findWatchSuccess ===========");
        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        object = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)this).setTitle(this.getString(2131755045))).addAction((CharSequence)this.getString(2131755116), (QMUIDialogAction.ActionListener)_$.Lambda.FindDeviceActivity.VBZlGoP_Nt10lLmGiDDiKLnsd0c.INSTANCE)).create();
        object.setCancelable(false);
        object.show();
    }

    protected void initView() {
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.FindDeviceActivity.Md_DnPDMX3lprrbCXB__afH0LQM(this));
        this.mTopBar.setTitle(2131755094);
        EventBus.getDefault().register((Object)this);
    }

    public /* synthetic */ void lambda$initView$0$FindDeviceActivity(View view) {
        this.finish();
    }

    @OnClick(value={2131296490})
    public void onClick(View view) {
        if (view.getId() != 2131296490) return;
        if (MainService.getInstance() == null) {
            ToastUtils.showLong((Context)this, (int)2131755124);
            return;
        }
        if (!MainService.getInstance().sendPhoneData(CommandUtil.FIND_WATCH)) return;
        ToastUtils.showLong((Context)this, (int)2131755095);
    }

    protected void onDestroy() {
        EventBus.getDefault().unregister((Object)this);
        super.onDestroy();
    }

    protected int setLayoutId() {
        return 2131492893;
    }
}
