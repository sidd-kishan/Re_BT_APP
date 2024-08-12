/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnClickListener
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.function.setting._$$Lambda$BluetoothSettingActivity$lQ5V9Zd4aofjy8pjaCtLkeNZpyg
 *  com.lianhezhuli.btnotification.mtk.service.PushAiderHelper
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.function.setting._$;
import com.lianhezhuli.btnotification.mtk.service.PushAiderHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class BluetoothSettingActivity
extends BaseActivity {
    @BindView(value=2131296353)
    QMUITopBarLayout mTopBar;

    protected void initView() {
        View view = this.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 23) {
            view.setSystemUiVisibility(9216);
        }
        this.mTopBar.setTitle(2131755091);
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.BluetoothSettingActivity.lQ5V9Zd4aofjy8pjaCtLkeNZpyg(this));
    }

    public /* synthetic */ void lambda$initView$0$BluetoothSettingActivity(View view) {
        this.finish();
    }

    @OnClick(value={2131296352, 2131296597})
    public void onClick(View view) {
        int n = view.getId();
        if (n == 2131296352) {
            this.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
        } else {
            if (n != 2131296597) return;
            PushAiderHelper.getAiderHelper().goToSettingNotificationAccess((Context)MApplication.getInstance());
        }
    }

    protected int setLayoutId() {
        return 2131492892;
    }
}
