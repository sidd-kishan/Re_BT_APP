/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  com.lianhezhuli.btnotification.bean.AppVersionBean
 *  com.lianhezhuli.btnotification.network.NetWorkManager
 *  com.lianhezhuli.btnotification.utils.DialogUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.lianhezhuli.btnotification.utils.Utils
 *  com.lianhezhuli.btnotification.utils._$$Lambda$AppUpdateUtils$K7_GZwT3tfcWIaz5j7aQOMW5ipE
 *  com.lianhezhuli.btnotification.utils._$$Lambda$AppUpdateUtils$TOzrCXc7FghecKkubfutQGGWHQA
 *  com.lianhezhuli.btnotification.utils._$$Lambda$AppUpdateUtils$vt_hQkp4Pf9N0pgPfXhdkKtiWDc
 *  com.lianhezhuli.btnotification.utils._$$Lambda$AppUpdateUtils$wtM_DQoWvuNaYj5Cq1gixYJL_W0
 *  com.orhanobut.logger.Logger
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MessageDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogAction$ActionListener
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 *  io.reactivex.Observable
 *  io.reactivex.functions.Consumer
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.lianhezhuli.btnotification.bean.AppVersionBean;
import com.lianhezhuli.btnotification.network.NetWorkManager;
import com.lianhezhuli.btnotification.utils.DialogUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.lianhezhuli.btnotification.utils.Utils;
import com.lianhezhuli.btnotification.utils._$;
import com.orhanobut.logger.Logger;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class AppUpdateUtils {
    private Context mContext;
    private QMUITipDialog mTipDialog;

    public AppUpdateUtils(Context context) {
        this.mContext = context;
        this.checkNetVersion();
    }

    private void checkIsNewVersion(int n, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("netVersion == ");
        stringBuilder.append(n);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (n > Utils.getVersionCode((Context)this.mContext)) {
            Logger.e((String)"can update ============ ", (Object[])new Object[0]);
            stringBuilder = this.mContext;
            if (stringBuilder == null) {
                return;
            }
            ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)stringBuilder).setTitle(2131755271)).setMessage(2131755253).addAction(2131755050, (QMUIDialogAction.ActionListener)_$.Lambda.AppUpdateUtils.vt_hQkp4Pf9N0pgPfXhdkKtiWDc.INSTANCE)).addAction(2131755116, (QMUIDialogAction.ActionListener)new _$.Lambda.AppUpdateUtils.wtM_DQoWvuNaYj5Cq1gixYJL_W0(this, string))).create().show();
        } else {
            ToastUtils.showShort((Context)this.mContext, (int)2131755254);
        }
    }

    private void checkNetVersion() {
        Context context = this.mContext;
        context = DialogUtils.getTipDialog((Context)context, (int)1, (String)context.getString(2131755248));
        this.mTipDialog = context;
        context.show();
        NetWorkManager.toSubscribe((Observable)NetWorkManager.getRequest().getAppVersion("Android", "2"), (Consumer)new _$.Lambda.AppUpdateUtils.K7_GZwT3tfcWIaz5j7aQOMW5ipE(this), (Consumer)new _$.Lambda.AppUpdateUtils.TOzrCXc7FghecKkubfutQGGWHQA(this));
    }

    static /* synthetic */ void lambda$checkIsNewVersion$2(QMUIDialog qMUIDialog, int n) {
        qMUIDialog.dismiss();
    }

    public /* synthetic */ void lambda$checkIsNewVersion$3$AppUpdateUtils(String string, QMUIDialog object, int n) {
        object.dismiss();
        object = new StringBuilder();
        ((StringBuilder)object).append("can update ============ ");
        ((StringBuilder)object).append(string);
        Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        string = new Intent();
        string.setAction("android.intent.action.VIEW");
        string.setData(Uri.parse((String)"https://play.google.com/store/apps/details?id=com.lianhezhuli.btnotification"));
        string.addFlags(0x10000000);
        this.mContext.startActivity((Intent)string);
    }

    public /* synthetic */ void lambda$checkNetVersion$0$AppUpdateUtils(AppVersionBean appVersionBean) throws Exception {
        this.mTipDialog.dismiss();
        this.checkIsNewVersion(Integer.parseInt(appVersionBean.getVersion()), appVersionBean.getUrl());
    }

    public /* synthetic */ void lambda$checkNetVersion$1$AppUpdateUtils(Throwable throwable) throws Exception {
        this.mTipDialog.dismiss();
        ToastUtils.showShort((Context)this.mContext, (int)2131755104);
    }
}
