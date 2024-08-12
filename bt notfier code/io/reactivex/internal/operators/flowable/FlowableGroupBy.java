/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.flowables.GroupedFlowable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy$EvictionAction
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber
 *  io.reactivex.internal.util.EmptyComponent
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.util.EmptyComponent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupBy<T, K, V>
extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> mapFactory;
    final Function<? super T, ? extends V> valueSelector;

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int n, boolean bl, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = n;
        this.delayError = bl;
        this.mapFactory = function3;
    }

    protected void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> groupBySubscriber) {
        Object object;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        try {
            if (this.mapFactory == null) {
                concurrentLinkedQueue = null;
                object = new ConcurrentHashMap();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                object = new EvictionAction(concurrentLinkedQueue);
                object = (Map)this.mapFactory.apply(object);
            }
        }
        catch (Exception exception) {
            Exceptions.throwIfFatal((Throwable)exception);
            groupBySubscriber.onSubscribe((Subscription)EmptyComponent.INSTANCE);
            groupBySubscriber.onError((Throwable)exception);
            return;
        }
        groupBySubscriber = new GroupBySubscriber(groupBySubscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, (Map)object, concurrentLinkedQueue);
        this.source.subscribe((FlowableSubscriber)groupBySubscriber);
    }
}
