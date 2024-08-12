/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.function._$$Lambda$SplashActivity$6cS6e4l_MXcoZQKzIaEduHrwY6Y
 */
package com.lianhezhuli.btnotification.function;

import android.os.Handler;
import android.os.Looper;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.function._$;

public class SplashActivity
extends BaseActivity {
    private final Handler handler = new Handler(Looper.getMainLooper());

    static /* synthetic */ void lambda$onStart$0() {
    }

    protected void initView() {
    }

    protected void onStart() {
        super.onStart();
        this.handler.postDelayed((Runnable)_$.Lambda.SplashActivity.6cS6e4l_MXcoZQKzIaEduHrwY6Y.INSTANCE, 300L);
    }

    protected int setLayoutId() {
        return 2131492902;
    }
}
