/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.setting.MessageSettingActivity
 *  com.lianhezhuli.btnotification.function.setting.MessageSettingActivity_ViewBinding
 */
package com.lianhezhuli.btnotification.function.setting;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.setting.MessageSettingActivity;
import com.lianhezhuli.btnotification.function.setting.MessageSettingActivity_ViewBinding;

class MessageSettingActivity_ViewBinding.1
extends DebouncingOnClickListener {
    final MessageSettingActivity_ViewBinding this$0;
    final MessageSettingActivity val$target;

    MessageSettingActivity_ViewBinding.1(MessageSettingActivity_ViewBinding messageSettingActivity_ViewBinding, MessageSettingActivity messageSettingActivity) {
        this.this$0 = messageSettingActivity_ViewBinding;
        this.val$target = messageSettingActivity;
    }

    public void doClick(View view) {
        this.val$target.onClick(view);
    }
}
