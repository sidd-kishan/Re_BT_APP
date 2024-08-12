/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.LoggingInterceptor
 *  com.lianhezhuli.btnotification.network.converter.GsonConverterFactory
 *  com.lianhezhuli.btnotification.network.request.Request
 *  com.lianhezhuli.btnotification.network.response.Response
 *  com.lianhezhuli.btnotification.network.response.ResponseTransformer
 *  com.lianhezhuli.btnotification.network.schedulers.SchedulerProvider
 *  io.reactivex.Observable
 *  io.reactivex.functions.Consumer
 *  okhttp3.Interceptor
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 *  retrofit2.Retrofit$Builder
 *  retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
 */
package com.lianhezhuli.btnotification.network;

import com.lianhezhuli.btnotification.network.LoggingInterceptor;
import com.lianhezhuli.btnotification.network.converter.GsonConverterFactory;
import com.lianhezhuli.btnotification.network.request.Request;
import com.lianhezhuli.btnotification.network.response.Response;
import com.lianhezhuli.btnotification.network.response.ResponseTransformer;
import com.lianhezhuli.btnotification.network.schedulers.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class NetWorkManager {
    private static NetWorkManager mInstance;
    private static volatile Request request;
    private static Retrofit retrofit;

    public static NetWorkManager getInstance() {
        if (mInstance != null) return mInstance;
        synchronized (NetWorkManager.class) {
            NetWorkManager netWorkManager;
            if (mInstance != null) return mInstance;
            mInstance = netWorkManager = new NetWorkManager();
        }
        return mInstance;
    }

    public static Request getRequest() {
        if (request != null) return request;
        synchronized (Request.class) {
            request = (Request)retrofit.create(Request.class);
        }
        return request;
    }

    public static <T> void toSubscribe(Observable<Response<T>> observable, Consumer<T> consumer, Consumer<? super Throwable> consumer2) {
        observable.compose(ResponseTransformer.handleResult()).compose(SchedulerProvider.getInstance().applySchedulers()).subscribe(consumer, consumer2);
    }

    public void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor((Interceptor)new LoggingInterceptor());
        builder = builder.build();
        retrofit = new Retrofit.Builder().client((OkHttpClient)builder).baseUrl("https://bt.lianhezhuli.com/api/").addCallAdapterFactory((CallAdapter.Factory)RxJava2CallAdapterFactory.create()).addConverterFactory((Converter.Factory)GsonConverterFactory.create()).build();
    }
}
