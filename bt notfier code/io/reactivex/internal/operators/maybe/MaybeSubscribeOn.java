/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeSubscribeOn$SubscribeOnMaybeObserver
 *  io.reactivex.internal.operators.maybe.MaybeSubscribeOn$SubscribeTask
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;

public final class MaybeSubscribeOn<T>
extends AbstractMaybeWithUpstream<T, T> {
    final Scheduler scheduler;

    public MaybeSubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.scheduler = scheduler;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe((Disposable)subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.scheduler.scheduleDirect((Runnable)new SubscribeTask((MaybeObserver)subscribeOnMaybeObserver, this.source)));
    }
}
