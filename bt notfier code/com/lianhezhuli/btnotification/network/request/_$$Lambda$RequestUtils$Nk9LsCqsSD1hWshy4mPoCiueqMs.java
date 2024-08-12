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

public final class _$$Lambda$RequestUtils$Nk9LsCqsSD1hWshy4mPoCiueqMs
implements Consumer {
    public static final _$$Lambda$RequestUtils$Nk9LsCqsSD1hWshy4mPoCiueqMs INSTANCE = new _$$Lambda$RequestUtils$Nk9LsCqsSD1hWshy4mPoCiueqMs();

    private /* synthetic */ _$$Lambda$RequestUtils$Nk9LsCqsSD1hWshy4mPoCiueqMs() {
    }

    public final void accept(Object object) {
        RequestUtils.lambda$postAdvertClick$4((AdvertReportBean)((AdvertReportBean)object));
    }
}
