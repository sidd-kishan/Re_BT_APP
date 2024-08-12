/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposeConverter
 *  com.uber.autodispose.AutoDisposeParallelFlowable
 *  com.uber.autodispose.CompletableSubscribeProxy
 *  com.uber.autodispose.FlowableSubscribeProxy
 *  com.uber.autodispose.MaybeSubscribeProxy
 *  com.uber.autodispose.ObservableSubscribeProxy
 *  com.uber.autodispose.ParallelFlowableSubscribeProxy
 *  com.uber.autodispose.SingleSubscribeProxy
 *  com.uber.autodispose._$$Lambda$AutoDispose$1$rU0zA7CRfo71tCeTkbtKtfpJJOQ
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.Maybe
 *  io.reactivex.Observable
 *  io.reactivex.Single
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.AutoDisposeParallelFlowable;
import com.uber.autodispose.CompletableSubscribeProxy;
import com.uber.autodispose.FlowableSubscribeProxy;
import com.uber.autodispose.MaybeSubscribeProxy;
import com.uber.autodispose.ObservableSubscribeProxy;
import com.uber.autodispose.ParallelFlowableSubscribeProxy;
import com.uber.autodispose.SingleSubscribeProxy;
import com.uber.autodispose._$;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

class AutoDispose.1
implements AutoDisposeConverter<T> {
    final CompletableSource val$scope;

    AutoDispose.1(CompletableSource completableSource) {
        this.val$scope = completableSource;
    }

    static /* synthetic */ void lambda$apply$0(ParallelFlowable parallelFlowable, CompletableSource completableSource, Subscriber[] subscriberArray) {
        new AutoDisposeParallelFlowable(parallelFlowable, completableSource).subscribe(subscriberArray);
    }

    public CompletableSubscribeProxy apply(Completable completable) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public FlowableSubscribeProxy<T> apply(Flowable<T> flowable) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public MaybeSubscribeProxy<T> apply(Maybe<T> maybe) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ObservableSubscribeProxy<T> apply(Observable<T> observable) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ParallelFlowableSubscribeProxy<T> apply(ParallelFlowable<T> parallelFlowable) {
        return new _$.Lambda.AutoDispose.1.rU0zA7CRfo71tCeTkbtKtfpJJOQ(parallelFlowable, this.val$scope);
    }

    public SingleSubscribeProxy<T> apply(Single<T> single) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }
}
