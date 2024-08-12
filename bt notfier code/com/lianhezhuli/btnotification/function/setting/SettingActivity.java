/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.OnClick
 *  com.lianhezhuli.btnotification.base.BaseMvpActivity
 *  com.lianhezhuli.btnotification.function.WebViewActivity
 *  com.lianhezhuli.btnotification.function.setting._$$Lambda$SettingActivity$4G04OClrDv_kguc4rNat8DIN7RM
 *  com.lianhezhuli.btnotification.function.setting.mvp.SettingContract$View
 *  com.lianhezhuli.btnotification.function.setting.mvp.setting.SettingPresenter
 *  com.lianhezhuli.btnotification.utils.Utils
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.setting;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lianhezhuli.btnotification.base.BaseMvpActivity;
import com.lianhezhuli.btnotification.function.WebViewActivity;
import com.lianhezhuli.btnotification.function.setting._$;
import com.lianhezhuli.btnotification.function.setting.mvp.SettingContract;
import com.lianhezhuli.btnotification.function.setting.mvp.setting.SettingPresenter;
import com.lianhezhuli.btnotification.utils.Utils;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class SettingActivity
extends BaseMvpActivity<SettingPresenter>
implements SettingContract.View {
    @BindView(value=2131296741)
    QMUITopBarLayout mTopBar;
    @BindView(value=2131296745)
    TextView mVersionNameTv;

    @OnClick(value={2131296743})
    public void click(View view) {
        if (view.getId() != 2131296743) return;
        this.startActivity(WebViewActivity.class);
    }

    public void hideLoading() {
    }

    protected void initView() {
        this.mTopBar.setTitle(2131755088);
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.SettingActivity.4G04OClrDv_kguc4rNat8DIN7RM(this));
        this.mPresenter = new SettingPresenter((SettingContract.View)this);
        this.mVersionNameTv.setText((CharSequence)Utils.getVersion((Context)this));
    }

    public /* synthetic */ void lambda$initView$0$SettingActivity(View view) {
        this.finish();
    }

    public void onError(Throwable throwable) {
    }

    protected int setLayoutId() {
        return 2131492899;
    }

    public void showLoading() {
    }
}
