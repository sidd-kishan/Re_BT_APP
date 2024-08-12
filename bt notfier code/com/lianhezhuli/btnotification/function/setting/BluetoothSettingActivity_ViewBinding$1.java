/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity
 *  com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity_ViewBinding
 */
package com.lianhezhuli.btnotification.function.setting;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity;
import com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity_ViewBinding;

class BluetoothSettingActivity_ViewBinding.1
extends DebouncingOnClickListener {
    final BluetoothSettingActivity_ViewBinding this$0;
    final BluetoothSettingActivity val$target;

    BluetoothSettingActivity_ViewBinding.1(BluetoothSettingActivity_ViewBinding bluetoothSettingActivity_ViewBinding, BluetoothSettingActivity bluetoothSettingActivity) {
        this.this$0 = bluetoothSettingActivity_ViewBinding;
        this.val$target = bluetoothSettingActivity;
    }

    public void doClick(View view) {
        this.val$target.onClick(view);
    }
}
