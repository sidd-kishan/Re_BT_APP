/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.response.Response
 *  com.lianhezhuli.btnotification.network.response.ResponseTransformer$ErrorResumeFunction
 *  com.lianhezhuli.btnotification.network.response.ResponseTransformer$ResponseFunction
 *  com.lianhezhuli.btnotification.network.response._$$Lambda$ResponseTransformer$bA0QZXPD4Y_CEmYsgbq6rDAdyFc
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.ObservableTransformer
 *  io.reactivex.functions.Function
 */
package com.lianhezhuli.btnotification.network.response;

import com.lianhezhuli.btnotification.network.response.Response;
import com.lianhezhuli.btnotification.network.response.ResponseTransformer;
import com.lianhezhuli.btnotification.network.response._$;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

public class ResponseTransformer {
    public static <T> ObservableTransformer<Response<T>, T> handleResult() {
        return _$.Lambda.ResponseTransformer.bA0QZXPD4Y_CEmYsgbq6rDAdyFc.INSTANCE;
    }

    static /* synthetic */ ObservableSource lambda$handleResult$0(Observable observable) {
        return observable.onErrorResumeNext((Function)new ErrorResumeFunction(null)).flatMap((Function)new ResponseFunction(null));
    }
}
