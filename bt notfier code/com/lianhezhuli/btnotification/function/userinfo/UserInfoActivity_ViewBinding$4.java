/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.internal.DebouncingOnClickListener
 *  com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity
 *  com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity_ViewBinding
 */
package com.lianhezhuli.btnotification.function.userinfo;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity;
import com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity_ViewBinding;

class UserInfoActivity_ViewBinding.4
extends DebouncingOnClickListener {
    final UserInfoActivity_ViewBinding this$0;
    final UserInfoActivity val$target;

    UserInfoActivity_ViewBinding.4(UserInfoActivity_ViewBinding userInfoActivity_ViewBinding, UserInfoActivity userInfoActivity) {
        this.this$0 = userInfoActivity_ViewBinding;
        this.val$target = userInfoActivity;
    }

    public void doClick(View view) {
        this.val$target.click(view);
    }
}
