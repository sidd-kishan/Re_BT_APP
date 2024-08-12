/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment_ViewBinding
 */
package com.lianhezhuli.btnotification.function.home.fragment.data;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment;
import com.lianhezhuli.btnotification.function.home.fragment.data.DataSportFragment_ViewBinding;

class DataSportFragment_ViewBinding.1
extends DebouncingOnClickListener {
    final DataSportFragment_ViewBinding this$0;
    final DataSportFragment val$target;

    DataSportFragment_ViewBinding.1(DataSportFragment_ViewBinding dataSportFragment_ViewBinding, DataSportFragment dataSportFragment) {
        this.this$0 = dataSportFragment_ViewBinding;
        this.val$target = dataSportFragment;
    }

    public void doClick(View view) {
        this.val$target.click(view);
    }
}
