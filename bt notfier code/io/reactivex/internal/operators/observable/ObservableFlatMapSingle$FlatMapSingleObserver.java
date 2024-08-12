/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableFlatMapSingle.FlatMapSingleObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final AtomicReference<SpscLinkedArrayQueue<R>> queue;
    final CompositeDisposable set;
    Disposable upstream;

    ObservableFlatMapSingle.FlatMapSingleObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl) {
        this.downstream = observer;
        this.mapper = function;
        this.delayErrors = bl;
        this.set = new CompositeDisposable();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    void clear() {
        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
        if (spscLinkedArrayQueue == null) return;
        spscLinkedArrayQueue.clear();
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    void drainLoop() {
        Observer<? super R> observer = this.downstream;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.queue;
        int n = 1;
        while (true) {
            Object object;
            if (this.cancelled) {
                this.clear();
                return;
            }
            if (!this.delayErrors && (Throwable)this.errors.get() != null) {
                object = this.errors.terminate();
                this.clear();
                observer.onError(object);
                return;
            }
            int n2 = atomicInteger.get();
            boolean bl = false;
            n2 = n2 == 0 ? 1 : 0;
            object = atomicReference.get();
            if ((object = object != null ? object.poll() : null) == null) {
                bl = true;
            }
            if (n2 != 0 && bl) {
                object = this.errors.terminate();
                if (object != null) {
                    observer.onError(object);
                } else {
                    observer.onComplete();
                }
                return;
            }
            if (bl) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            observer.onNext(object);
        }
    }

    SpscLinkedArrayQueue<R> getOrCreateQueue() {
        SpscLinkedArrayQueue spscLinkedArrayQueue;
        do {
            if ((spscLinkedArrayQueue = this.queue.get()) == null) continue;
            return spscLinkedArrayQueue;
        } while (!this.queue.compareAndSet(null, spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize())));
        return spscLinkedArrayQueue;
    }

    void innerError(InnerObserver innerObserver, Throwable throwable) {
        this.set.delete((Disposable)innerObserver);
        if (this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void innerSuccess(InnerObserver var1_1, R var2_2) {
        this.set.delete((Disposable)var1_1 /* !! */ );
        if (this.get() != 0) ** GOTO lbl-1000
        var3_3 = true;
        if (this.compareAndSet(0, 1)) {
            this.downstream.onNext(var2_2);
            if (this.active.decrementAndGet() != 0) {
                var3_3 = false;
            }
            var1_1 /* !! */  = this.queue.get();
            if (var3_3 && (var1_1 /* !! */  == null || var1_1 /* !! */ .isEmpty())) {
                var1_1 /* !! */  = this.errors.terminate();
                if (var1_1 /* !! */  != null) {
                    this.downstream.onError(var1_1 /* !! */ );
                    return;
                }
                this.downstream.onComplete();
                return;
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = this.getOrCreateQueue();
            synchronized (var1_1 /* !! */ ) {
                var1_1 /* !! */ .offer(var2_2);
            }
            this.active.decrementAndGet();
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.active.decrementAndGet();
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.set.dispose();
            }
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        try {
            object = (SingleSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null SingleSource");
            this.active.getAndIncrement();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        InnerObserver innerObserver = new InnerObserver(this);
        if (this.cancelled) return;
        if (!this.set.add((Disposable)innerObserver)) return;
        object.subscribe((SingleObserver)innerObserver);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
