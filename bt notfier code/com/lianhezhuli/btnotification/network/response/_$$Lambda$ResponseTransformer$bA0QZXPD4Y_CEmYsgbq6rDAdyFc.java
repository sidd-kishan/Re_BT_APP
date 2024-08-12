/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.response.ResponseTransformer
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.ObservableTransformer
 */
package com.lianhezhuli.btnotification.network.response;

import com.lianhezhuli.btnotification.network.response.ResponseTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

public final class _$$Lambda$ResponseTransformer$bA0QZXPD4Y_CEmYsgbq6rDAdyFc
implements ObservableTransformer {
    public static final _$$Lambda$ResponseTransformer$bA0QZXPD4Y_CEmYsgbq6rDAdyFc INSTANCE = new _$$Lambda$ResponseTransformer$bA0QZXPD4Y_CEmYsgbq6rDAdyFc();

    private /* synthetic */ _$$Lambda$ResponseTransformer$bA0QZXPD4Y_CEmYsgbq6rDAdyFc() {
    }

    public final ObservableSource apply(Observable observable) {
        return ResponseTransformer.lambda$handleResult$0((Observable)observable);
    }
}
