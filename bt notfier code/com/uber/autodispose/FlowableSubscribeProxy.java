/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.subscribers.TestSubscriber
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package com.uber.autodispose;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.TestSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public interface FlowableSubscribeProxy<T> {
    public Disposable subscribe();

    public Disposable subscribe(Consumer<? super T> var1);

    public Disposable subscribe(Consumer<? super T> var1, Consumer<? super Throwable> var2);

    public Disposable subscribe(Consumer<? super T> var1, Consumer<? super Throwable> var2, Action var3);

    public Disposable subscribe(Consumer<? super T> var1, Consumer<? super Throwable> var2, Action var3, Consumer<? super Subscription> var4);

    public void subscribe(Subscriber<? super T> var1);

    @CheckReturnValue
    public <E extends Subscriber<? super T>> E subscribeWith(E var1);

    @CheckReturnValue
    public TestSubscriber<T> test();

    @CheckReturnValue
    public TestSubscriber<T> test(long var1);

    @CheckReturnValue
    public TestSubscriber<T> test(long var1, boolean var3);
}
