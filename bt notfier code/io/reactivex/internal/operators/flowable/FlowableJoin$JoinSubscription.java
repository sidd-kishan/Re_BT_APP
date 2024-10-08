/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$JoinSupport
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableJoin.JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R>
extends AtomicInteger
implements Subscription,
FlowableGroupJoin.JoinSupport {
    static final Integer LEFT_CLOSE;
    static final Integer LEFT_VALUE;
    static final Integer RIGHT_CLOSE;
    static final Integer RIGHT_VALUE;
    private static final long serialVersionUID = -6071216598687999801L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final CompositeDisposable disposables;
    final Subscriber<? super R> downstream;
    final AtomicReference<Throwable> error;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    int leftIndex;
    final Map<Integer, TLeft> lefts;
    final SpscLinkedArrayQueue<Object> queue;
    final AtomicLong requested;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    FlowableJoin.JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        this.downstream = subscriber;
        this.requested = new AtomicLong();
        this.disposables = new CompositeDisposable();
        this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
        this.lefts = new LinkedHashMap<Integer, TLeft>();
        this.rights = new LinkedHashMap<Integer, TRight>();
        this.error = new AtomicReference();
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
        this.active = new AtomicInteger(2);
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.cancelAll();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void cancelAll() {
        this.disposables.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        Subscriber<? super R> subscriber = this.downstream;
        int n = 1;
        while (true) {
            long l;
            long l2;
            Object object;
            if (this.cancelled) {
                spscLinkedArrayQueue.clear();
                return;
            }
            if (this.error.get() != null) {
                spscLinkedArrayQueue.clear();
                this.cancelAll();
                this.errorAll(subscriber);
                return;
            }
            int n2 = this.active.get() == 0 ? 1 : 0;
            Iterator<TLeft> iterator = (Integer)spscLinkedArrayQueue.poll();
            boolean bl = iterator == null;
            if (n2 != 0 && bl) {
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                subscriber.onComplete();
                return;
            }
            if (bl) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            Object object2 = spscLinkedArrayQueue.poll();
            if (iterator == LEFT_VALUE) {
                n2 = this.leftIndex;
                this.leftIndex = n2 + 1;
                this.lefts.put(n2, object2);
                try {
                    object = (Publisher)ObjectHelper.requireNonNull((Object)this.leftEnd.apply(object2), (String)"The leftEnd returned a null Publisher");
                }
                catch (Throwable throwable) {
                    this.fail(throwable, subscriber, (SimpleQueue<?>)spscLinkedArrayQueue);
                    return;
                }
                iterator = new FlowableGroupJoin.LeftRightEndSubscriber((FlowableGroupJoin.JoinSupport)this, true, n2);
                this.disposables.add((Disposable)iterator);
                object.subscribe((Subscriber)iterator);
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    this.cancelAll();
                    this.errorAll(subscriber);
                    return;
                }
                l2 = this.requested.get();
                iterator = this.rights.values().iterator();
                l = 0L;
                while (iterator.hasNext()) {
                    block21: {
                        object = iterator.next();
                        try {
                            object = ObjectHelper.requireNonNull((Object)this.resultSelector.apply(object2, object), (String)"The resultSelector returned a null value");
                            if (l == l2) break block21;
                        }
                        catch (Throwable throwable) {
                            this.fail(throwable, subscriber, (SimpleQueue<?>)spscLinkedArrayQueue);
                            return;
                        }
                        subscriber.onNext(object);
                        ++l;
                        continue;
                    }
                    ExceptionHelper.addThrowable(this.error, (Throwable)new MissingBackpressureException("Could not emit value due to lack of requests"));
                    spscLinkedArrayQueue.clear();
                    this.cancelAll();
                    this.errorAll(subscriber);
                    return;
                }
                if (l == 0L) continue;
                BackpressureHelper.produced((AtomicLong)this.requested, (long)l);
                continue;
            }
            if (iterator == RIGHT_VALUE) {
                n2 = this.rightIndex;
                this.rightIndex = n2 + 1;
                this.rights.put(n2, object2);
                try {
                    object = (Publisher)ObjectHelper.requireNonNull((Object)this.rightEnd.apply(object2), (String)"The rightEnd returned a null Publisher");
                }
                catch (Throwable throwable) {
                    this.fail(throwable, subscriber, (SimpleQueue<?>)spscLinkedArrayQueue);
                    return;
                }
                iterator = new FlowableGroupJoin.LeftRightEndSubscriber((FlowableGroupJoin.JoinSupport)this, false, n2);
                this.disposables.add((Disposable)iterator);
                object.subscribe((Subscriber)iterator);
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    this.cancelAll();
                    this.errorAll(subscriber);
                    return;
                }
                l2 = this.requested.get();
                iterator = this.lefts.values().iterator();
                l = 0L;
                while (iterator.hasNext()) {
                    block22: {
                        object = iterator.next();
                        try {
                            object = ObjectHelper.requireNonNull((Object)this.resultSelector.apply(object, object2), (String)"The resultSelector returned a null value");
                            if (l == l2) break block22;
                        }
                        catch (Throwable throwable) {
                            this.fail(throwable, subscriber, (SimpleQueue<?>)spscLinkedArrayQueue);
                            return;
                        }
                        subscriber.onNext(object);
                        ++l;
                        continue;
                    }
                    ExceptionHelper.addThrowable(this.error, (Throwable)new MissingBackpressureException("Could not emit value due to lack of requests"));
                    spscLinkedArrayQueue.clear();
                    this.cancelAll();
                    this.errorAll(subscriber);
                    return;
                }
                if (l == 0L) continue;
                BackpressureHelper.produced((AtomicLong)this.requested, (long)l);
                continue;
            }
            if (iterator == LEFT_CLOSE) {
                object2 = (FlowableGroupJoin.LeftRightEndSubscriber)object2;
                this.lefts.remove(((FlowableGroupJoin.LeftRightEndSubscriber)object2).index);
                this.disposables.remove((Disposable)object2);
                continue;
            }
            if (iterator != RIGHT_CLOSE) continue;
            object2 = (FlowableGroupJoin.LeftRightEndSubscriber)object2;
            this.rights.remove(((FlowableGroupJoin.LeftRightEndSubscriber)object2).index);
            this.disposables.remove((Disposable)object2);
        }
    }

    void errorAll(Subscriber<?> subscriber) {
        Throwable throwable = ExceptionHelper.terminate(this.error);
        this.lefts.clear();
        this.rights.clear();
        subscriber.onError(throwable);
    }

    void fail(Throwable throwable, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
        Exceptions.throwIfFatal((Throwable)throwable);
        ExceptionHelper.addThrowable(this.error, (Throwable)throwable);
        simpleQueue.clear();
        this.cancelAll();
        this.errorAll(subscriber);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void innerClose(boolean bl, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
        synchronized (this) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Integer n = bl ? LEFT_CLOSE : RIGHT_CLOSE;
            spscLinkedArrayQueue.offer((Object)n, (Object)leftRightEndSubscriber);
        }
        this.drain();
    }

    public void innerCloseError(Throwable throwable) {
        if (ExceptionHelper.addThrowable(this.error, (Throwable)throwable)) {
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
        this.disposables.delete((Disposable)leftRightSubscriber);
        this.active.decrementAndGet();
        this.drain();
    }

    public void innerError(Throwable throwable) {
        if (ExceptionHelper.addThrowable(this.error, (Throwable)throwable)) {
            this.active.decrementAndGet();
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void innerValue(boolean bl, Object object) {
        synchronized (this) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Integer n = bl ? LEFT_VALUE : RIGHT_VALUE;
            spscLinkedArrayQueue.offer((Object)n, object);
        }
        this.drain();
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
    }
}
