/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposingSubscriberImpl
 *  io.reactivex.CompletableSource
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposingSubscriberImpl;
import io.reactivex.CompletableSource;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

final class AutoDisposeParallelFlowable<T>
extends ParallelFlowable<T> {
    private final CompletableSource scope;
    private final ParallelFlowable<T> source;

    AutoDisposeParallelFlowable(ParallelFlowable<T> parallelFlowable, CompletableSource completableSource) {
        this.source = parallelFlowable;
        this.scope = completableSource;
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArray) {
        if (!this.validate(subscriberArray)) {
            return;
        }
        Subscriber[] subscriberArray2 = new Subscriber[subscriberArray.length];
        int n = 0;
        while (true) {
            if (n >= subscriberArray.length) {
                this.source.subscribe(subscriberArray2);
                return;
            }
            subscriberArray2[n] = new AutoDisposingSubscriberImpl(this.scope, subscriberArray[n]);
            ++n;
        }
    }
}
