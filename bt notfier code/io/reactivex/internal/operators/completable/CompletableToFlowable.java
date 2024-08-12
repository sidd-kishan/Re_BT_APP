/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.internal.observers.SubscriberCompletableObserver
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

public final class CompletableToFlowable<T>
extends Flowable<T> {
    final CompletableSource source;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    protected void subscribeActual(Subscriber<? super T> subscriberCompletableObserver) {
        subscriberCompletableObserver = new SubscriberCompletableObserver(subscriberCompletableObserver);
        this.source.subscribe((CompletableObserver)subscriberCompletableObserver);
    }
}
