/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableUsing$UsingSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableUsing<T, D>
extends Flowable<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends Publisher<? extends T>> sourceSupplier;

    public FlowableUsing(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean bl) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.disposer = consumer;
        this.eager = bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Publisher publisher;
        D d;
        try {
            d = this.resourceSupplier.call();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.sourceSupplier.apply(d), (String)"The sourceSupplier returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            try {
                this.disposer.accept(d);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                EmptySubscription.error((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}), subscriber);
                return;
            }
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        publisher.subscribe((Subscriber)new UsingSubscriber(subscriber, d, this.disposer, this.eager));
    }
}
