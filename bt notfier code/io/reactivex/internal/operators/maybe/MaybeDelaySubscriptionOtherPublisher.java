/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher$OtherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class MaybeDelaySubscriptionOtherPublisher<T, U>
extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> other;

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.other = publisher;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.other.subscribe((Subscriber)new OtherSubscriber(maybeObserver, this.source));
    }
}
