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
 *  io.reactivex.internal.observers.InnerQueuedObserver
 *  io.reactivex.internal.observers.InnerQueuedObserverSupport
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.ErrorMode
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
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableConcatMapEager.ConcatMapEagerMainObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable,
InnerQueuedObserverSupport<R> {
    private static final long serialVersionUID = 8080567949447303262L;
    int activeCount;
    volatile boolean cancelled;
    InnerQueuedObserver<R> current;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final ErrorMode errorMode;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final int maxConcurrency;
    final ArrayDeque<InnerQueuedObserver<R>> observers;
    final int prefetch;
    SimpleQueue<T> queue;
    int sourceMode;
    Disposable upstream;

    ObservableConcatMapEager.ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int n, int n2, ErrorMode errorMode) {
        this.downstream = observer;
        this.mapper = function;
        this.maxConcurrency = n;
        this.prefetch = n2;
        this.errorMode = errorMode;
        this.error = new AtomicThrowable();
        this.observers = new ArrayDeque();
    }

    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.dispose();
        this.drainAndDispose();
    }

    void disposeAll() {
        InnerQueuedObserver<R> innerQueuedObserver = this.current;
        if (innerQueuedObserver != null) {
            innerQueuedObserver.dispose();
        }
        while ((innerQueuedObserver = this.observers.poll()) != null) {
            innerQueuedObserver.dispose();
        }
        return;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        var7_1 = this.queue;
        var8_2 = this.observers;
        var6_3 = this.downstream;
        var9_4 = this.errorMode;
        var1_5 = 1;
        while (true) lbl-1000:
        // 5 sources

        {
            for (var2_6 = --this.activeCount; var2_6 != this.maxConcurrency; ++var2_6) {
                if (this.cancelled) {
                    var7_1.clear();
                    this.disposeAll();
                    return;
                }
                if (var9_4 == ErrorMode.IMMEDIATE && (Throwable)this.error.get() != null) {
                    var7_1.clear();
                    this.disposeAll();
                    var6_3.onError(this.error.terminate());
                    return;
                }
                try {
                    var4_8 = var7_1.poll();
                    if (var4_8 == null) break;
                    var4_8 = (InnerQueuedObserver)ObjectHelper.requireNonNull((Object)this.mapper.apply(var4_8), (String)"The mapper returned a null ObservableSource");
                }
                catch (Throwable var4_9) {
                    Exceptions.throwIfFatal((Throwable)var4_9);
                    this.upstream.dispose();
                    var7_1.clear();
                    this.disposeAll();
                    this.error.addThrowable(var4_9);
                    var6_3.onError(this.error.terminate());
                    return;
                }
                var5_11 /* !! */  = new InnerQueuedObserver((InnerQueuedObserverSupport)this, this.prefetch);
                var8_2.offer(var5_11 /* !! */ );
                var4_8.subscribe((Observer)var5_11 /* !! */ );
            }
            this.activeCount = var2_6;
            if (this.cancelled) {
                var7_1.clear();
                this.disposeAll();
                return;
            }
            if (var9_4 == ErrorMode.IMMEDIATE && (Throwable)this.error.get() != null) {
                var7_1.clear();
                this.disposeAll();
                var6_3.onError(this.error.terminate());
                return;
            }
            var4_8 = var5_11 /* !! */  = this.current;
            if (var5_11 /* !! */  == null) {
                if (var9_4 == ErrorMode.BOUNDARY && (Throwable)this.error.get() != null) {
                    var7_1.clear();
                    this.disposeAll();
                    var6_3.onError(this.error.terminate());
                    return;
                }
                var3_7 = this.done;
                var4_8 = var8_2.poll();
                var2_6 = var4_8 == null ? 1 : 0;
                if (var3_7 && var2_6 != 0) {
                    if ((Throwable)this.error.get() != null) {
                        var7_1.clear();
                        this.disposeAll();
                        var6_3.onError(this.error.terminate());
                    } else {
                        var6_3.onComplete();
                    }
                    return;
                }
                if (var2_6 == 0) {
                    this.current = var4_8;
                }
            }
            if (var4_8 != null) {
                var10_12 = var4_8.queue();
                while (true) {
                    if (this.cancelled) {
                        var7_1.clear();
                        this.disposeAll();
                        return;
                    }
                    var3_7 = var4_8.isDone();
                    if (var9_4 == ErrorMode.IMMEDIATE && (Throwable)this.error.get() != null) {
                        var7_1.clear();
                        this.disposeAll();
                        var6_3.onError(this.error.terminate());
                        return;
                    }
                    try {
                        var5_11 /* !! */  = var10_12.poll();
                        var2_6 = var5_11 /* !! */  == null ? 1 : 0;
                        if (var3_7 && var2_6 != 0) {
                            this.current = null;
                            --this.activeCount;
                            ** continue;
                        }
                        if (var2_6 != 0) {
                            break;
                        }
                    }
                    catch (Throwable var4_10) {
                        Exceptions.throwIfFatal((Throwable)var4_10);
                        this.error.addThrowable(var4_10);
                        this.current = null;
                        ** continue;
                    }
                    var6_3.onNext((Object)var5_11 /* !! */ );
                }
            }
            var1_5 = var2_6 = this.addAndGet(-var1_5);
            if (var2_6 == 0) return;
        }
    }

    void drainAndDispose() {
        if (this.getAndIncrement() != 0) return;
        do {
            this.queue.clear();
            this.disposeAll();
        } while (this.decrementAndGet() != 0);
    }

    public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
        innerQueuedObserver.setDone();
        this.drain();
    }

    public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.upstream.dispose();
            }
            innerQueuedObserver.setDone();
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
        innerQueuedObserver.queue().offer(r);
        this.drain();
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
        this.queue = new SpscLinkedArrayQueue(this.prefetch);
        this.downstream.onSubscribe((Disposable)this);
    }
}
