/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity
 *  com.lianhezhuli.btnotification.function.setting._$$Lambda$MessageSettingActivity$qhzGdBaEqoKkUCS0pOw4_fUEcOc
 *  com.lianhezhuli.btnotification.mtk.data.PreferenceData
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.CheckBox;
import butterknife.BindView;
import butterknife.OnClick;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity;
import com.lianhezhuli.btnotification.function.setting._$;
import com.lianhezhuli.btnotification.mtk.data.PreferenceData;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class MessageSettingActivity
extends BaseActivity {
    @BindView(value=2131296627)
    CheckBox mAlwaysSendCb;
    @BindView(value=2131296630)
    CheckBox mSmsCb;
    @BindView(value=2131296593)
    QMUITopBarLayout mTopBar;

    protected void initView() {
        View view = this.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 23) {
            view.setSystemUiVisibility(9216);
        }
        this.mTopBar.setTitle(2131755252);
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.MessageSettingActivity.qhzGdBaEqoKkUCS0pOw4_fUEcOc(this));
        this.mSmsCb.setChecked(PreferenceData.isSmsServiceEnable());
        this.mAlwaysSendCb.setChecked(PreferenceData.isAlwaysForward());
    }

    public /* synthetic */ void lambda$initView$0$MessageSettingActivity(View view) {
        this.finish();
    }

    @OnClick(value={2131296629, 2131296628, 2131296631})
    public void onClick(View view) {
        switch (view.getId()) {
            default: {
                break;
            }
            case 2131296631: {
                view = this.mSmsCb;
                view.setChecked(view.isChecked() ^ true);
                PreferenceData.setSmsServiceEnable((boolean)this.mSmsCb.isChecked());
                break;
            }
            case 2131296629: {
                this.startActivity(new Intent((Context)this, NotificationAppActivity.class));
                break;
            }
            case 2131296628: {
                view = this.mAlwaysSendCb;
                view.setChecked(view.isChecked() ^ true);
                PreferenceData.setAlwaysForward((boolean)this.mAlwaysSendCb.isChecked());
            }
        }
    }

    protected int setLayoutId() {
        return 2131492895;
    }
}
