/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.home.activity.MainActivity
 *  com.lianhezhuli.btnotification.function.home.activity.MainActivity_ViewBinding
 */
package com.lianhezhuli.btnotification.function.home.activity;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.home.activity.MainActivity;
import com.lianhezhuli.btnotification.function.home.activity.MainActivity_ViewBinding;

class MainActivity_ViewBinding.2
extends DebouncingOnClickListener {
    final MainActivity_ViewBinding this$0;
    final MainActivity val$target;

    MainActivity_ViewBinding.2(MainActivity_ViewBinding mainActivity_ViewBinding, MainActivity mainActivity) {
        this.this$0 = mainActivity_ViewBinding;
        this.val$target = mainActivity;
    }

    public void doClick(View view) {
        this.val$target.click(view);
    }
}
