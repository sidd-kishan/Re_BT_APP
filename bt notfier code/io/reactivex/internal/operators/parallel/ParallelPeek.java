/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.LongConsumer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.parallel.ParallelPeek$ParallelPeekSubscriber
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelPeek<T>
extends ParallelFlowable<T> {
    final Consumer<? super T> onAfterNext;
    final Action onAfterTerminated;
    final Action onCancel;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final LongConsumer onRequest;
    final Consumer<? super Subscription> onSubscribe;
    final ParallelFlowable<T> source;

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.source = parallelFlowable;
        this.onNext = (Consumer)ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        this.onAfterNext = (Consumer)ObjectHelper.requireNonNull(consumer2, (String)"onAfterNext is null");
        this.onError = (Consumer)ObjectHelper.requireNonNull(consumer3, (String)"onError is null");
        this.onComplete = (Action)ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        this.onAfterTerminated = (Action)ObjectHelper.requireNonNull((Object)action2, (String)"onAfterTerminated is null");
        this.onSubscribe = (Consumer)ObjectHelper.requireNonNull(consumer4, (String)"onSubscribe is null");
        this.onRequest = (LongConsumer)ObjectHelper.requireNonNull((Object)longConsumer, (String)"onRequest is null");
        this.onCancel = (Action)ObjectHelper.requireNonNull((Object)action3, (String)"onCancel is null");
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArray) {
        if (!this.validate(subscriberArray)) {
            return;
        }
        int n = subscriberArray.length;
        Subscriber[] subscriberArray2 = new Subscriber[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.source.subscribe(subscriberArray2);
                return;
            }
            subscriberArray2[n2] = new ParallelPeekSubscriber(subscriberArray[n2], this);
            ++n2;
        }
    }
}
