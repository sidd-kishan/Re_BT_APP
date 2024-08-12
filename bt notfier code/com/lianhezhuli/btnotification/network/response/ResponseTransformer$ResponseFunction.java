/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.exception.ApiException
 *  com.lianhezhuli.btnotification.network.response.Response
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.functions.Function
 */
package com.lianhezhuli.btnotification.network.response;

import com.lianhezhuli.btnotification.network.exception.ApiException;
import com.lianhezhuli.btnotification.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

private static class ResponseTransformer.ResponseFunction<T>
implements Function<Response<T>, ObservableSource<T>> {
    private ResponseTransformer.ResponseFunction() {
    }

    public ObservableSource<T> apply(Response<T> response) throws Exception {
        String string = response.getCode();
        String string2 = response.getMsg();
        if (!"success".equals(string)) return Observable.error((Throwable)new ApiException(string, string2, ""));
        return Observable.just((Object)response.getData());
    }
}
