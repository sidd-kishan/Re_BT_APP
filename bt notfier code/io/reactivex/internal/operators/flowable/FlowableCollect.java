/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableCollect$CollectSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableCollect;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableCollect<T, U>
extends AbstractFlowableWithUpstream<T, U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;

    public FlowableCollect(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }

    protected void subscribeActual(Subscriber<? super U> subscriber) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull(this.initialSupplier.call(), (String)"The initial value supplied is null");
        }
        catch (Throwable throwable) {
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        this.source.subscribe((FlowableSubscriber)new CollectSubscriber(subscriber, object, this.collector));
    }
}
