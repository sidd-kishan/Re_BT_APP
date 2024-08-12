/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.device.FindDeviceActivity
 *  com.lianhezhuli.btnotification.function.device.FindDeviceActivity_ViewBinding
 */
package com.lianhezhuli.btnotification.function.device;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.device.FindDeviceActivity;
import com.lianhezhuli.btnotification.function.device.FindDeviceActivity_ViewBinding;

class FindDeviceActivity_ViewBinding.1
extends DebouncingOnClickListener {
    final FindDeviceActivity_ViewBinding this$0;
    final FindDeviceActivity val$target;

    FindDeviceActivity_ViewBinding.1(FindDeviceActivity_ViewBinding findDeviceActivity_ViewBinding, FindDeviceActivity findDeviceActivity) {
        this.this$0 = findDeviceActivity_ViewBinding;
        this.val$target = findDeviceActivity;
    }

    public void doClick(View view) {
        this.val$target.onClick(view);
    }
}
