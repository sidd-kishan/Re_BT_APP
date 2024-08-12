/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.schedulers.SchedulerProvider
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.ObservableTransformer
 */
package com.lianhezhuli.btnotification.network.schedulers;

import com.lianhezhuli.btnotification.network.schedulers.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

class SchedulerProvider.1
implements ObservableTransformer<T, T> {
    final SchedulerProvider this$0;

    SchedulerProvider.1(SchedulerProvider schedulerProvider) {
        this.this$0 = schedulerProvider;
    }

    public ObservableSource<T> apply(Observable<T> observable) {
        return observable.subscribeOn(this.this$0.io()).observeOn(this.this$0.ui());
    }
}
