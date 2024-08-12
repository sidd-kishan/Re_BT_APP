/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class MaybeTakeUntilPublisher<T, U>
extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> other;

    public MaybeTakeUntilPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.other = publisher;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe((Disposable)takeUntilMainMaybeObserver);
        this.other.subscribe((Subscriber)takeUntilMainMaybeObserver.other);
        this.source.subscribe((MaybeObserver)takeUntilMainMaybeObserver);
    }
}
