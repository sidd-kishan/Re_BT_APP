/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.bigkoo.pickerview.listener.OnTimeSelectListener
 *  com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity
 */
package com.lianhezhuli.btnotification.function.userinfo;

import android.view.View;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity;
import java.util.Date;

public final class _$$Lambda$UserInfoActivity$MjRnKxi0omUT3umib_jjYzwmvDw
implements OnTimeSelectListener {
    private final UserInfoActivity f$0;

    public /* synthetic */ _$$Lambda$UserInfoActivity$MjRnKxi0omUT3umib_jjYzwmvDw(UserInfoActivity userInfoActivity) {
        this.f$0 = userInfoActivity;
    }

    public final void onTimeSelect(Date date, View view) {
        this.f$0.lambda$click$6$UserInfoActivity(date, view);
    }
}
