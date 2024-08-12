/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;

static final class MaybeSubscribeOn.SubscribeTask<T>
implements Runnable {
    final MaybeObserver<? super T> observer;
    final MaybeSource<T> source;

    MaybeSubscribeOn.SubscribeTask(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
        this.observer = maybeObserver;
        this.source = maybeSource;
    }

    @Override
    public void run() {
        this.source.subscribe(this.observer);
    }
}
