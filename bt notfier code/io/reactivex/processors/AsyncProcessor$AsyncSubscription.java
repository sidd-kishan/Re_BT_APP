/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.AsyncProcessor
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.AsyncProcessor;
import org.reactivestreams.Subscriber;

static final class AsyncProcessor.AsyncSubscription<T>
extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = 5629876084736248016L;
    final AsyncProcessor<T> parent;

    AsyncProcessor.AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
        super(subscriber);
        this.parent = asyncProcessor;
    }

    public void cancel() {
        if (!super.tryCancel()) return;
        this.parent.remove(this);
    }

    void onComplete() {
        if (this.isCancelled()) return;
        this.downstream.onComplete();
    }

    void onError(Throwable throwable) {
        if (this.isCancelled()) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            this.downstream.onError(throwable);
        }
    }
}
