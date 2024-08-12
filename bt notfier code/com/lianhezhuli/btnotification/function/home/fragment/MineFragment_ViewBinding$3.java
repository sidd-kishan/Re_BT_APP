/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.home.fragment.MineFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.MineFragment_ViewBinding
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.home.fragment.MineFragment;
import com.lianhezhuli.btnotification.function.home.fragment.MineFragment_ViewBinding;

class MineFragment_ViewBinding.3
extends DebouncingOnClickListener {
    final MineFragment_ViewBinding this$0;
    final MineFragment val$target;

    MineFragment_ViewBinding.3(MineFragment_ViewBinding mineFragment_ViewBinding, MineFragment mineFragment) {
        this.this$0 = mineFragment_ViewBinding;
        this.val$target = mineFragment;
    }

    public void doClick(View view) {
        this.val$target.click(view);
    }
}
