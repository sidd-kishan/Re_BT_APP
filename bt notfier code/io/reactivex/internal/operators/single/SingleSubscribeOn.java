/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.single.SingleSubscribeOn$SubscribeOnObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleSubscribeOn;

public final class SingleSubscribeOn<T>
extends Single<T> {
    final Scheduler scheduler;
    final SingleSource<? extends T> source;

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.source = singleSource;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(SingleObserver<? super T> disposable) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(disposable, this.source);
        disposable.onSubscribe((Disposable)subscribeOnObserver);
        disposable = this.scheduler.scheduleDirect((Runnable)subscribeOnObserver);
        subscribeOnObserver.task.replace(disposable);
    }
}
