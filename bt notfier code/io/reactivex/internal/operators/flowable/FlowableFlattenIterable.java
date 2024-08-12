/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableFlattenIterable$FlattenIterableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableFromIterable
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableFlattenIterable<T, R>
extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int n) {
        super(flowable);
        this.mapper = function;
        this.prefetch = n;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        Object object;
        block5: {
            if (!(this.source instanceof Callable)) {
                this.source.subscribe((FlowableSubscriber)new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch));
                return;
            }
            try {
                object = ((Callable)this.source).call();
                if (object != null) break block5;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptySubscription.error((Throwable)throwable, subscriber);
                return;
            }
            EmptySubscription.complete(subscriber);
            return;
        }
        try {
            object = ((Iterable)this.mapper.apply(object)).iterator();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        FlowableFromIterable.subscribe(subscriber, object);
    }
}
