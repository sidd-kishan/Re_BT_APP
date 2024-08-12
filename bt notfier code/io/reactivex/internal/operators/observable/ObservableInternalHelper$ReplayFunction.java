/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Scheduler
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

static final class ObservableInternalHelper.ReplayFunction<T, R>
implements Function<Observable<T>, ObservableSource<R>> {
    private final Scheduler scheduler;
    private final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

    ObservableInternalHelper.ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        this.selector = function;
        this.scheduler = scheduler;
    }

    public ObservableSource<R> apply(Observable<T> observable) throws Exception {
        return Observable.wrap((ObservableSource)((ObservableSource)ObjectHelper.requireNonNull((Object)this.selector.apply(observable), (String)"The selector returned a null ObservableSource"))).observeOn(this.scheduler);
    }
}
