/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.exception.CustomException
 *  com.lianhezhuli.btnotification.network.response.Response
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.functions.Function
 */
package com.lianhezhuli.btnotification.network.response;

import com.lianhezhuli.btnotification.network.exception.CustomException;
import com.lianhezhuli.btnotification.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

private static class ResponseTransformer.ErrorResumeFunction<T>
implements Function<Throwable, ObservableSource<? extends Response<T>>> {
    private ResponseTransformer.ErrorResumeFunction() {
    }

    public ObservableSource<? extends Response<T>> apply(Throwable throwable) throws Exception {
        return Observable.error((Throwable)CustomException.handleException((Throwable)throwable));
    }
}
