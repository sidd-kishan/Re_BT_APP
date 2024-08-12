/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.setting.SettingActivity
 *  com.lianhezhuli.btnotification.function.setting.SettingActivity_ViewBinding
 */
package com.lianhezhuli.btnotification.function.setting;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.setting.SettingActivity;
import com.lianhezhuli.btnotification.function.setting.SettingActivity_ViewBinding;

class SettingActivity_ViewBinding.1
extends DebouncingOnClickListener {
    final SettingActivity_ViewBinding this$0;
    final SettingActivity val$target;

    SettingActivity_ViewBinding.1(SettingActivity_ViewBinding settingActivity_ViewBinding, SettingActivity settingActivity) {
        this.this$0 = settingActivity_ViewBinding;
        this.val$target = settingActivity;
    }

    public void doClick(View view) {
        this.val$target.click(view);
    }
}
