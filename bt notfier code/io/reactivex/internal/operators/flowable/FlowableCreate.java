/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureStrategy
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableEmitter
 *  io.reactivex.FlowableOnSubscribe
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.flowable.FlowableCreate$1
 *  io.reactivex.internal.operators.flowable.FlowableCreate$BufferAsyncEmitter
 *  io.reactivex.internal.operators.flowable.FlowableCreate$DropAsyncEmitter
 *  io.reactivex.internal.operators.flowable.FlowableCreate$ErrorAsyncEmitter
 *  io.reactivex.internal.operators.flowable.FlowableCreate$LatestAsyncEmitter
 *  io.reactivex.internal.operators.flowable.FlowableCreate$MissingEmitter
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T>
extends Flowable<T> {
    final BackpressureStrategy backpressure;
    final FlowableOnSubscribe<T> source;

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.source = flowableOnSubscribe;
        this.backpressure = backpressureStrategy;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        int n = 1.$SwitchMap$io$reactivex$BackpressureStrategy[this.backpressure.ordinal()];
        Object object = n != 1 ? (n != 2 ? (n != 3 ? (n != 4 ? new BufferAsyncEmitter(subscriber, FlowableCreate.bufferSize()) : new LatestAsyncEmitter(subscriber)) : new DropAsyncEmitter(subscriber)) : new ErrorAsyncEmitter(subscriber)) : new MissingEmitter(subscriber);
        subscriber.onSubscribe((Subscription)object);
        try {
            this.source.subscribe((FlowableEmitter)object);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            object.onError(throwable);
        }
    }
}
