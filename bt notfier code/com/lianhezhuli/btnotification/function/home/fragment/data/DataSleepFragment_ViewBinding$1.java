/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment_ViewBinding
 */
package com.lianhezhuli.btnotification.function.home.fragment.data;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSleepFragment_ViewBinding;

class DataSleepFragment_ViewBinding.1
extends DebouncingOnClickListener {
    final DataSleepFragment_ViewBinding this$0;
    final DataSleepFragment val$target;

    DataSleepFragment_ViewBinding.1(DataSleepFragment_ViewBinding dataSleepFragment_ViewBinding, DataSleepFragment dataSleepFragment) {
        this.this$0 = dataSleepFragment_ViewBinding;
        this.val$target = dataSleepFragment;
    }

    public void doClick(View view) {
        this.val$target.click(view);
    }
}
