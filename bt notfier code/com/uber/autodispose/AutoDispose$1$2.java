/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDispose$1
 *  com.uber.autodispose.AutoDisposeFlowable
 *  com.uber.autodispose.FlowableSubscribeProxy
 *  io.reactivex.Flowable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.subscribers.TestSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeFlowable;
import com.uber.autodispose.FlowableSubscribeProxy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.TestSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

class AutoDispose.2
implements FlowableSubscribeProxy<T> {
    final AutoDispose.1 this$0;
    final Flowable val$upstream;

    AutoDispose.2(AutoDispose.1 var1_1, Flowable flowable) {
        this.this$0 = var1_1;
        this.val$upstream = flowable;
    }

    public Disposable subscribe() {
        return new AutoDisposeFlowable((Publisher)this.val$upstream, this.this$0.val$scope).subscribe();
    }

    public Disposable subscribe(Consumer<? super T> consumer) {
        return new AutoDisposeFlowable((Publisher)this.val$upstream, this.this$0.val$scope).subscribe(consumer);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return new AutoDisposeFlowable((Publisher)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return new AutoDisposeFlowable((Publisher)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2, action);
    }

    public Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        return new AutoDisposeFlowable((Publisher)this.val$upstream, this.this$0.val$scope).subscribe(consumer, consumer2, action, consumer3);
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        new AutoDisposeFlowable((Publisher)this.val$upstream, this.this$0.val$scope).subscribe(subscriber);
    }

    public <E extends Subscriber<? super T>> E subscribeWith(E e) {
        return (E)new AutoDisposeFlowable((Publisher)this.val$upstream, this.this$0.val$scope).subscribeWith(e);
    }

    public TestSubscriber<T> test() {
        TestSubscriber testSubscriber = new TestSubscriber();
        this.subscribe((Subscriber)testSubscriber);
        return testSubscriber;
    }

    public TestSubscriber<T> test(long l) {
        TestSubscriber testSubscriber = new TestSubscriber(l);
        this.subscribe((Subscriber)testSubscriber);
        return testSubscriber;
    }

    public TestSubscriber<T> test(long l, boolean bl) {
        TestSubscriber testSubscriber = new TestSubscriber(l);
        if (bl) {
            testSubscriber.cancel();
        }
        this.subscribe((Subscriber)testSubscriber);
        return testSubscriber;
    }
}
