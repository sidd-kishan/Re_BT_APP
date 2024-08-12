/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.bean.AppVersionBean
 *  com.lianhezhuli.btnotification.utils.AppUpdateUtils
 *  io.reactivex.functions.Consumer
 */
package com.lianhezhuli.btnotification.utils;

import com.lianhezhuli.btnotification.bean.AppVersionBean;
import com.lianhezhuli.btnotification.utils.AppUpdateUtils;
import io.reactivex.functions.Consumer;

public final class _$$Lambda$AppUpdateUtils$K7_GZwT3tfcWIaz5j7aQOMW5ipE
implements Consumer {
    private final AppUpdateUtils f$0;

    public /* synthetic */ _$$Lambda$AppUpdateUtils$K7_GZwT3tfcWIaz5j7aQOMW5ipE(AppUpdateUtils appUpdateUtils) {
        this.f$0 = appUpdateUtils;
    }

    public final void accept(Object object) {
        this.f$0.lambda$checkNetVersion$0$AppUpdateUtils((AppVersionBean)object);
    }
}
