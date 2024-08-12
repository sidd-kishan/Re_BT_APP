/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.setting.SettingActivity
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.setting;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.setting.SettingActivity;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class SettingActivity_ViewBinding
implements Unbinder {
    private SettingActivity target;
    private View view7f0901e7;

    public SettingActivity_ViewBinding(SettingActivity settingActivity) {
        this(settingActivity, settingActivity.getWindow().getDecorView());
    }

    public SettingActivity_ViewBinding(SettingActivity settingActivity, View view) {
        this.target = settingActivity;
        settingActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296741, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        settingActivity.mVersionNameTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296745, (String)"field 'mVersionNameTv'", TextView.class);
        this.view7f0901e7 = view = Utils.findRequiredView((View)view, (int)2131296743, (String)"method 'click'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        SettingActivity settingActivity = this.target;
        if (settingActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        settingActivity.mTopBar = null;
        settingActivity.mVersionNameTv = null;
        this.view7f0901e7.setOnClickListener(null);
        this.view7f0901e7 = null;
    }
}
