/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher$TimeoutMainMaybeObserver
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class MaybeTimeoutPublisher<T, U>
extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<? extends T> fallback;
    final Publisher<U> other;

    public MaybeTimeoutPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.other = publisher;
        this.fallback = maybeSource2;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.fallback);
        maybeObserver.onSubscribe((Disposable)timeoutMainMaybeObserver);
        this.other.subscribe((Subscriber)timeoutMainMaybeObserver.other);
        this.source.subscribe((MaybeObserver)timeoutMainMaybeObserver);
    }
}
