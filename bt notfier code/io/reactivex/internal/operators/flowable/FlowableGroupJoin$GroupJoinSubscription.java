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
 *  io.reactivex.processors.UnicastProcessor
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
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableGroupJoin.GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R>
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
    final Map<Integer, UnicastProcessor<TRight>> lefts;
    final SpscLinkedArrayQueue<Object> queue;
    final AtomicLong requested;
    final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
    int rightIndex;
    final Map<Integer, TRight> rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    FlowableGroupJoin.GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        this.downstream = subscriber;
        this.requested = new AtomicLong();
        this.disposables = new CompositeDisposable();
        this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
        this.lefts = new LinkedHashMap<Integer, UnicastProcessor<TRight>>();
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
        Object object = this.queue;
        Subscriber<? super R> subscriber = this.downstream;
        int n = 1;
        block6: while (true) {
            Publisher publisher;
            if (this.cancelled) {
                object.clear();
                return;
            }
            if (this.error.get() != null) {
                object.clear();
                this.cancelAll();
                this.errorAll(subscriber);
                return;
            }
            int n2 = this.active.get() == 0 ? 1 : 0;
            Object object2 = (Publisher)object.poll();
            boolean bl = object2 == null;
            if (n2 != 0 && bl) {
                object = this.lefts.values().iterator();
                while (true) {
                    if (!object.hasNext()) {
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        subscriber.onComplete();
                        return;
                    }
                    ((UnicastProcessor)object.next()).onComplete();
                }
            }
            if (bl) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            Iterator<TRight> iterator = object.poll();
            if (object2 == LEFT_VALUE) {
                block21: {
                    object2 = UnicastProcessor.create();
                    n2 = this.leftIndex;
                    this.leftIndex = n2 + 1;
                    this.lefts.put(n2, (UnicastProcessor<TRight>)object2);
                    try {
                        publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.leftEnd.apply((Object)iterator), (String)"The leftEnd returned a null Publisher");
                    }
                    catch (Throwable throwable) {
                        this.fail(throwable, subscriber, (SimpleQueue<?>)object);
                        return;
                    }
                    FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber((FlowableGroupJoin.JoinSupport)this, true, n2);
                    this.disposables.add((Disposable)leftRightEndSubscriber);
                    publisher.subscribe((Subscriber)leftRightEndSubscriber);
                    if (this.error.get() != null) {
                        object.clear();
                        this.cancelAll();
                        this.errorAll(subscriber);
                        return;
                    }
                    try {
                        iterator = ObjectHelper.requireNonNull((Object)this.resultSelector.apply((Object)iterator, object2), (String)"The resultSelector returned a null value");
                        if (this.requested.get() == 0L) break block21;
                    }
                    catch (Throwable throwable) {
                        this.fail(throwable, subscriber, (SimpleQueue<?>)object);
                        return;
                    }
                    subscriber.onNext((Object)iterator);
                    BackpressureHelper.produced((AtomicLong)this.requested, (long)1L);
                    iterator = this.rights.values().iterator();
                    while (true) {
                        if (!iterator.hasNext()) continue block6;
                        object2.onNext(iterator.next());
                    }
                }
                this.fail((Throwable)new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, (SimpleQueue<?>)object);
                return;
            }
            if (object2 == RIGHT_VALUE) {
                n2 = this.rightIndex;
                this.rightIndex = n2 + 1;
                this.rights.put(n2, iterator);
                try {
                    object2 = (Publisher)ObjectHelper.requireNonNull((Object)this.rightEnd.apply((Object)iterator), (String)"The rightEnd returned a null Publisher");
                }
                catch (Throwable throwable) {
                    this.fail(throwable, subscriber, (SimpleQueue<?>)object);
                    return;
                }
                publisher = new FlowableGroupJoin.LeftRightEndSubscriber((FlowableGroupJoin.JoinSupport)this, false, n2);
                this.disposables.add((Disposable)publisher);
                object2.subscribe((Subscriber)publisher);
                if (this.error.get() != null) {
                    object.clear();
                    this.cancelAll();
                    this.errorAll(subscriber);
                    return;
                }
                object2 = this.lefts.values().iterator();
                while (true) {
                    if (!object2.hasNext()) continue block6;
                    ((UnicastProcessor)object2.next()).onNext((Object)iterator);
                }
            }
            if (object2 == LEFT_CLOSE) {
                iterator = (FlowableGroupJoin.LeftRightEndSubscriber)iterator;
                object2 = this.lefts.remove(((FlowableGroupJoin.LeftRightEndSubscriber)iterator).index);
                this.disposables.remove((Disposable)iterator);
                if (object2 == null) continue;
                object2.onComplete();
                continue;
            }
            if (object2 != RIGHT_CLOSE) continue;
            iterator = (FlowableGroupJoin.LeftRightEndSubscriber)iterator;
            this.rights.remove(((FlowableGroupJoin.LeftRightEndSubscriber)iterator).index);
            this.disposables.remove((Disposable)iterator);
        }
    }

    void errorAll(Subscriber<?> subscriber) {
        Throwable throwable = ExceptionHelper.terminate(this.error);
        Iterator<UnicastProcessor<TRight>> iterator = this.lefts.values().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.lefts.clear();
                this.rights.clear();
                subscriber.onError(throwable);
                return;
            }
            iterator.next().onError(throwable);
        }
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
