/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector$OperatorWindowBoundaryCloseSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector$OperatorWindowBoundaryOpenSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector$WindowOperation
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.subscribers.QueueDrainSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.UnicastProcessor
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, B, V>
extends QueueDrainSubscriber<T, Object, Flowable<T>>
implements Subscription {
    final AtomicReference<Disposable> boundary = new AtomicReference();
    final int bufferSize;
    final Function<? super B, ? extends Publisher<V>> close;
    final Publisher<B> open;
    final CompositeDisposable resources;
    final AtomicBoolean stopWindows;
    Subscription upstream;
    final AtomicLong windows = new AtomicLong();
    final List<UnicastProcessor<T>> ws;

    FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int n) {
        super(subscriber, (SimplePlainQueue)new MpscLinkedQueue());
        this.stopWindows = new AtomicBoolean();
        this.open = publisher;
        this.close = function;
        this.bufferSize = n;
        this.resources = new CompositeDisposable();
        this.ws = new ArrayList<UnicastProcessor<T>>();
        this.windows.lazySet(1L);
    }

    public boolean accept(Subscriber<? super Flowable<T>> subscriber, Object object) {
        return false;
    }

    public void cancel() {
        if (!this.stopWindows.compareAndSet(false, true)) return;
        DisposableHelper.dispose(this.boundary);
        if (this.windows.decrementAndGet() != 0L) return;
        this.upstream.cancel();
    }

    void close(FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
        this.resources.delete(operatorWindowBoundaryCloseSubscriber);
        this.queue.offer((Object)new FlowableWindowBoundarySelector.WindowOperation(operatorWindowBoundaryCloseSubscriber.w, null));
        if (!this.enter()) return;
        this.drainLoop();
    }

    void dispose() {
        this.resources.dispose();
        DisposableHelper.dispose(this.boundary);
    }

    /*
     * Unable to fully structure code
     */
    void drainLoop() {
        var7_1 = this.queue;
        var8_2 = this.downstream;
        var6_3 = this.ws;
        var1_4 = 1;
        block2: while (true) {
            var3_6 = this.done;
            var9_8 = var7_1.poll();
            var2_5 = var9_8 == null ? 1 : 0;
            if (var3_6 && var2_5 != 0) {
                this.dispose();
                var7_1 = this.error;
                if (var7_1 != null) {
                    var8_2 = var6_3.iterator();
                    while (var8_2.hasNext()) {
                        ((UnicastProcessor)var8_2.next()).onError((Throwable)var7_1);
                    }
                } else {
                    var7_1 = var6_3.iterator();
                    while (var7_1.hasNext()) {
                        ((UnicastProcessor)var7_1.next()).onComplete();
                    }
                }
                var6_3.clear();
                return;
            }
            if (var2_5 != 0) {
                var1_4 = var2_5 = this.leave(-var1_4);
                if (var2_5 != 0) continue;
                return;
            }
            if (var9_8 instanceof FlowableWindowBoundarySelector.WindowOperation) {
                var10_10 = (FlowableWindowBoundarySelector.WindowOperation)var9_8;
                if (var10_10.w != null) {
                    if (!var6_3.remove(var10_10.w)) continue;
                    var10_10.w.onComplete();
                    if (this.windows.decrementAndGet() != 0L) continue;
                    this.dispose();
                    return;
                }
                if (this.stopWindows.get()) continue;
                var9_8 = UnicastProcessor.create((int)this.bufferSize);
                var4_7 = this.requested();
                if (var4_7 != 0L) {
                    var6_3.add((UnicastProcessor<T>)var9_8);
                    var8_2.onNext(var9_8);
                    if (var4_7 != 0x7FFFFFFFFFFFFFFFL) {
                        this.produced(1L);
                    }
                    try {
                        var10_10 = (Publisher)ObjectHelper.requireNonNull((Object)this.close.apply(var10_10.open), (String)"The publisher supplied is null");
                    }
                    catch (Throwable var9_9) {
                        this.cancel();
                        var8_2.onError(var9_9);
                        continue;
                    }
                    if (!this.resources.add((Disposable)(var9_8 = new FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber(this, (UnicastProcessor)var9_8)))) continue;
                    this.windows.getAndIncrement();
                    var10_10.subscribe((Subscriber)var9_8);
                    continue;
                }
                this.cancel();
                var8_2.onError((Throwable)new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                continue;
            }
            var10_10 = var6_3.iterator();
            while (true) {
                if (var10_10.hasNext()) ** break;
                continue block2;
                ((UnicastProcessor)var10_10.next()).onNext(NotificationLite.getValue((Object)var9_8));
            }
            break;
        }
    }

    void error(Throwable throwable) {
        this.upstream.cancel();
        this.resources.dispose();
        DisposableHelper.dispose(this.boundary);
        this.downstream.onError(throwable);
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        if (this.windows.decrementAndGet() == 0L) {
            this.resources.dispose();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        if (this.windows.decrementAndGet() == 0L) {
            this.resources.dispose();
        }
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fastEnter()) {
            Iterator<UnicastProcessor<T>> iterator = this.ws.iterator();
            while (iterator.hasNext()) {
                iterator.next().onNext(t);
            }
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(NotificationLite.next(t));
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        if (this.stopWindows.get()) {
            return;
        }
        FlowableWindowBoundarySelector.OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new FlowableWindowBoundarySelector.OperatorWindowBoundaryOpenSubscriber(this);
        if (!this.boundary.compareAndSet(null, (Disposable)operatorWindowBoundaryOpenSubscriber)) return;
        subscription.request(Long.MAX_VALUE);
        this.open.subscribe((Subscriber)operatorWindowBoundaryOpenSubscriber);
    }

    void open(B b) {
        this.queue.offer((Object)new FlowableWindowBoundarySelector.WindowOperation(null, b));
        if (!this.enter()) return;
        this.drainLoop();
    }

    public void request(long l) {
        this.requested(l);
    }
}
