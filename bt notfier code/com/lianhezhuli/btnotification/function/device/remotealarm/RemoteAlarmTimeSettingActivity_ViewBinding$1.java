/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity
 *  com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity_ViewBinding
 */
package com.lianhezhuli.btnotification.function.device.remotealarm;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity;
import com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity_ViewBinding;

class RemoteAlarmTimeSettingActivity_ViewBinding.1
extends DebouncingOnClickListener {
    final RemoteAlarmTimeSettingActivity_ViewBinding this$0;
    final RemoteAlarmTimeSettingActivity val$target;

    RemoteAlarmTimeSettingActivity_ViewBinding.1(RemoteAlarmTimeSettingActivity_ViewBinding remoteAlarmTimeSettingActivity_ViewBinding, RemoteAlarmTimeSettingActivity remoteAlarmTimeSettingActivity) {
        this.this$0 = remoteAlarmTimeSettingActivity_ViewBinding;
        this.val$target = remoteAlarmTimeSettingActivity;
    }

    public void doClick(View view) {
        this.val$target.click(view);
    }
}
