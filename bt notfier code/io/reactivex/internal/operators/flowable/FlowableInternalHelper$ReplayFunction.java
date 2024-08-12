/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import org.reactivestreams.Publisher;

static final class FlowableInternalHelper.ReplayFunction<T, R>
implements Function<Flowable<T>, Publisher<R>> {
    private final Scheduler scheduler;
    private final Function<? super Flowable<T>, ? extends Publisher<R>> selector;

    FlowableInternalHelper.ReplayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        this.selector = function;
        this.scheduler = scheduler;
    }

    public Publisher<R> apply(Flowable<T> flowable) throws Exception {
        return Flowable.fromPublisher((Publisher)((Publisher)ObjectHelper.requireNonNull((Object)this.selector.apply(flowable), (String)"The selector returned a null Publisher"))).observeOn(this.scheduler);
    }
}
