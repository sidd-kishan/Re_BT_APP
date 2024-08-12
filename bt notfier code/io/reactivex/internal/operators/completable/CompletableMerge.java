/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.internal.operators.completable.CompletableMerge;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class CompletableMerge
extends Completable {
    final boolean delayErrors;
    final int maxConcurrency;
    final Publisher<? extends CompletableSource> source;

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int n, boolean bl) {
        this.source = publisher;
        this.maxConcurrency = n;
        this.delayErrors = bl;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        completableObserver = new CompletableMergeSubscriber(completableObserver, this.maxConcurrency, this.delayErrors);
        this.source.subscribe((Subscriber)completableObserver);
    }
}
