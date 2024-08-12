/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableDistinct$DistinctSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableDistinct;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableDistinct<T, K>
extends AbstractFlowableWithUpstream<T, T> {
    final Callable<? extends Collection<? super K>> collectionSupplier;
    final Function<? super T, K> keySelector;

    public FlowableDistinct(Flowable<T> flowable, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(flowable);
        this.keySelector = function;
        this.collectionSupplier = callable;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), (String)"The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        this.source.subscribe((FlowableSubscriber)new DistinctSubscriber(subscriber, this.keySelector, collection));
    }
}
