/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableConcatMap.ConcatMapDelayErrorObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final DelayErrorInnerObserver<R> observer;
    SimpleQueue<T> queue;
    int sourceMode;
    final boolean tillTheEnd;
    Disposable upstream;

    ObservableConcatMap.ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int n, boolean bl) {
        this.downstream = observer;
        this.mapper = function;
        this.bufferSize = n;
        this.tillTheEnd = bl;
        this.error = new AtomicThrowable();
        this.observer = new DelayErrorInnerObserver(observer, this);
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.observer.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super R> observer = this.downstream;
        SimpleQueue<T> simpleQueue = this.queue;
        Object object = this.error;
        while (true) {
            if (!this.active) {
                boolean bl;
                Object object2;
                block15: {
                    if (this.cancelled) {
                        simpleQueue.clear();
                        return;
                    }
                    if (!this.tillTheEnd && (Throwable)object.get() != null) {
                        simpleQueue.clear();
                        this.cancelled = true;
                        observer.onError(object.terminate());
                        return;
                    }
                    boolean bl2 = this.done;
                    try {
                        object2 = simpleQueue.poll();
                        bl = object2 == null;
                        if (!bl2 || !bl) break block15;
                        this.cancelled = true;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.cancelled = true;
                        this.upstream.dispose();
                        object.addThrowable(throwable);
                        observer.onError(object.terminate());
                        return;
                    }
                    if ((object = object.terminate()) != null) {
                        observer.onError((Throwable)object);
                    } else {
                        observer.onComplete();
                    }
                    return;
                }
                if (!bl) {
                    try {
                        object2 = (ObservableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object2), (String)"The mapper returned a null ObservableSource");
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.cancelled = true;
                        this.upstream.dispose();
                        simpleQueue.clear();
                        object.addThrowable(throwable);
                        observer.onError(object.terminate());
                        return;
                    }
                    if (object2 instanceof Callable) {
                        try {
                            if ((object2 = ((Callable)object2).call()) == null || this.cancelled) continue;
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            object.addThrowable(throwable);
                            continue;
                        }
                        observer.onNext(object2);
                        continue;
                    }
                    this.active = true;
                    object2.subscribe(this.observer);
                }
            }
            if (this.decrementAndGet() == 0) return;
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.sourceMode == 0) {
            this.queue.offer(t);
        }
        this.drain();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        if (disposable instanceof QueueDisposable) {
            int n = (disposable = (QueueDisposable)disposable).requestFusion(3);
            if (n == 1) {
                this.sourceMode = n;
                this.queue = disposable;
                this.done = true;
                this.downstream.onSubscribe((Disposable)this);
                this.drain();
                return;
            }
            if (n == 2) {
                this.sourceMode = n;
                this.queue = disposable;
                this.downstream.onSubscribe((Disposable)this);
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        this.downstream.onSubscribe((Disposable)this);
    }
}
