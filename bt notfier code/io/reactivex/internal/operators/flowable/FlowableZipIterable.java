/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableZipIterable$ZipIterableSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

public final class FlowableZipIterable<T, U, V>
extends AbstractFlowableWithUpstream<T, V> {
    final Iterable<U> other;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.other = iterable;
        this.zipper = biFunction;
    }

    public void subscribeActual(Subscriber<? super V> subscriber) {
        Iterator iterator;
        block4: {
            try {
                iterator = (Iterator)ObjectHelper.requireNonNull(this.other.iterator(), (String)"The iterator returned by other is null");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptySubscription.error((Throwable)throwable, subscriber);
                return;
            }
            try {
                boolean bl = iterator.hasNext();
                if (bl) break block4;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptySubscription.error((Throwable)throwable, subscriber);
                return;
            }
            EmptySubscription.complete(subscriber);
            return;
        }
        this.source.subscribe((FlowableSubscriber)new ZipIterableSubscriber(subscriber, iterator, this.zipper));
    }
}
