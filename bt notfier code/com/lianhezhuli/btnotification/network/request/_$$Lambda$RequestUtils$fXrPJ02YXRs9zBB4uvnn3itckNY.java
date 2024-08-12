/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.bean.AdvertReportBean
 *  com.lianhezhuli.btnotification.network.request.RequestUtils
 *  io.reactivex.functions.Consumer
 */
package com.lianhezhuli.btnotification.network.request;

import com.lianhezhuli.btnotification.network.bean.AdvertReportBean;
import com.lianhezhuli.btnotification.network.request.RequestUtils;
import io.reactivex.functions.Consumer;

public final class _$$Lambda$RequestUtils$fXrPJ02YXRs9zBB4uvnn3itckNY
implements Consumer {
    public static final _$$Lambda$RequestUtils$fXrPJ02YXRs9zBB4uvnn3itckNY INSTANCE = new _$$Lambda$RequestUtils$fXrPJ02YXRs9zBB4uvnn3itckNY();

    private /* synthetic */ _$$Lambda$RequestUtils$fXrPJ02YXRs9zBB4uvnn3itckNY() {
    }

    public final void accept(Object object) {
        RequestUtils.lambda$postAdvertError$6((AdvertReportBean)((AdvertReportBean)object));
    }
}
