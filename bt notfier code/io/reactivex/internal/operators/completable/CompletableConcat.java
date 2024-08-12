/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.internal.operators.completable.CompletableConcat$CompletableConcatSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.internal.operators.completable.CompletableConcat;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class CompletableConcat
extends Completable {
    final int prefetch;
    final Publisher<? extends CompletableSource> sources;

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int n) {
        this.sources = publisher;
        this.prefetch = n;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.sources.subscribe((Subscriber)new CompletableConcatSubscriber(completableObserver, this.prefetch));
    }
}
