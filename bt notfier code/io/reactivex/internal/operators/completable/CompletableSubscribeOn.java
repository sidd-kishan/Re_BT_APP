/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableSubscribeOn$SubscribeOnObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;

public final class CompletableSubscribeOn
extends Completable {
    final Scheduler scheduler;
    final CompletableSource source;

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.source = completableSource;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.source);
        completableObserver.onSubscribe((Disposable)subscribeOnObserver);
        completableObserver = this.scheduler.scheduleDirect((Runnable)subscribeOnObserver);
        subscribeOnObserver.task.replace((Disposable)completableObserver);
    }
}
