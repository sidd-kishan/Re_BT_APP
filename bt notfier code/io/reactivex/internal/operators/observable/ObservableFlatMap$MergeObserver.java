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
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.ExceptionHelper
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
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableFlatMap.MergeObserver<T, U>
extends AtomicInteger
implements Disposable,
Observer<T> {
    static final ObservableFlatMap.InnerObserver<?, ?>[] CANCELLED;
    static final ObservableFlatMap.InnerObserver<?, ?>[] EMPTY;
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super U> downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    long lastId;
    int lastIndex;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    final int maxConcurrency;
    final AtomicReference<ObservableFlatMap.InnerObserver<?, ?>[]> observers;
    volatile SimplePlainQueue<U> queue;
    Queue<ObservableSource<? extends U>> sources;
    long uniqueId;
    Disposable upstream;
    int wip;

    static {
        EMPTY = new ObservableFlatMap.InnerObserver[0];
        CANCELLED = new ObservableFlatMap.InnerObserver[0];
    }

    ObservableFlatMap.MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean bl, int n, int n2) {
        this.downstream = observer;
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
        this.bufferSize = n2;
        if (n != Integer.MAX_VALUE) {
            this.sources = new ArrayDeque<ObservableSource<? extends U>>(n);
        }
        this.observers = new AtomicReference<ObservableFlatMap.InnerObserver<?, ?>[]>(EMPTY);
    }

    boolean addInner(ObservableFlatMap.InnerObserver<T, U> innerObserver) {
        ObservableFlatMap.InnerObserver[] innerObserverArray;
        ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArray2;
        do {
            if ((innerObserverArray2 = this.observers.get()) == CANCELLED) {
                innerObserver.dispose();
                return false;
            }
            int n = innerObserverArray2.length;
            innerObserverArray = new ObservableFlatMap.InnerObserver[n + 1];
            System.arraycopy(innerObserverArray2, 0, innerObserverArray, 0, n);
            innerObserverArray[n] = innerObserver;
        } while (!this.observers.compareAndSet(innerObserverArray2, innerObserverArray));
        return true;
    }

    boolean checkTerminate() {
        if (this.cancelled) {
            return true;
        }
        Throwable throwable = (Throwable)this.errors.get();
        if (this.delayErrors) return false;
        if (throwable == null) return false;
        this.disposeAll();
        throwable = this.errors.terminate();
        if (throwable == ExceptionHelper.TERMINATED) return true;
        this.downstream.onError(throwable);
        return true;
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        if (!this.disposeAll()) return;
        Throwable throwable = this.errors.terminate();
        if (throwable == null) return;
        if (throwable == ExceptionHelper.TERMINATED) return;
        RxJavaPlugins.onError((Throwable)throwable);
    }

    boolean disposeAll() {
        this.upstream.dispose();
        ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArray = this.observers.get();
        ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArray2 = CANCELLED;
        int n = 0;
        if (innerObserverArray == innerObserverArray2) return false;
        innerObserverArray = this.observers.getAndSet(innerObserverArray2);
        if (innerObserverArray == CANCELLED) return false;
        int n2 = innerObserverArray.length;
        while (n < n2) {
            innerObserverArray[n].dispose();
            ++n;
        }
        return true;
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void drainLoop() {
        Observer<? super U> observer = this.downstream;
        int n = 1;
        block7: while (true) {
            int n2;
            Object object;
            block39: {
                int n3;
                int n4;
                int n5;
                boolean bl;
                SimplePlainQueue<U> simplePlainQueue;
                block41: {
                    long l;
                    block40: {
                        if (this.checkTerminate()) {
                            return;
                        }
                        simplePlainQueue = this.queue;
                        if (simplePlainQueue != null) {
                            while (true) {
                                if (this.checkTerminate()) {
                                    return;
                                }
                                object = simplePlainQueue.poll();
                                if (object == null) break;
                                observer.onNext(object);
                            }
                        }
                        bl = this.done;
                        simplePlainQueue = this.queue;
                        object = this.observers.get();
                        n5 = ((ObservableFlatMap.InnerObserver<?, ?>[])object).length;
                        n2 = this.maxConcurrency;
                        n4 = 0;
                        if (n2 != Integer.MAX_VALUE) {
                            synchronized (this) {
                                n2 = this.sources.size();
                            }
                        } else {
                            n2 = 0;
                        }
                        if (bl && (simplePlainQueue == null || simplePlainQueue.isEmpty()) && n5 == 0 && n2 == 0) {
                            object = this.errors.terminate();
                            if (object == ExceptionHelper.TERMINATED) return;
                            if (object == null) {
                                observer.onComplete();
                                return;
                            }
                            observer.onError(object);
                            return;
                        }
                        n2 = n4;
                        if (n5 == 0) break block39;
                        l = this.lastId;
                        n4 = this.lastIndex;
                        if (n5 <= n4) break block40;
                        n2 = n4;
                        if (object[n4].id == l) break block41;
                    }
                    n2 = n4;
                    if (n5 <= n4) {
                        n2 = 0;
                    }
                    for (n4 = 0; n4 < n5 && object[n2].id != l; ++n4) {
                        n2 = n3 = n2 + 1;
                        if (n3 != n5) continue;
                        n2 = 0;
                    }
                    this.lastIndex = n2;
                    this.lastId = object[n2].id;
                }
                n4 = 0;
                block10: for (int i = 0; i < n5; ++i) {
                    block38: {
                        int n6;
                        block42: {
                            block43: {
                                SimpleQueue simpleQueue;
                                block37: {
                                    if (this.checkTerminate()) {
                                        return;
                                    }
                                    simplePlainQueue = object[n2];
                                    simpleQueue = simplePlainQueue.queue;
                                    if (simpleQueue != null) {
                                        do {
                                            Object object2;
                                            block36: {
                                                try {
                                                    object2 = simpleQueue.poll();
                                                    if (object2 != null) break block36;
                                                    break block37;
                                                }
                                                catch (Throwable throwable) {
                                                    Exceptions.throwIfFatal((Throwable)throwable);
                                                    simplePlainQueue.dispose();
                                                    this.errors.addThrowable(throwable);
                                                    if (this.checkTerminate()) {
                                                        return;
                                                    }
                                                    this.removeInner((ObservableFlatMap.InnerObserver<T, U>)simplePlainQueue);
                                                    n3 = n4 + 1;
                                                    n6 = n2 + 1;
                                                    n4 = n3;
                                                    n2 = n6;
                                                    if (n6 != n5) continue block10;
                                                    n4 = n3;
                                                    break block38;
                                                }
                                            }
                                            observer.onNext(object2);
                                        } while (!this.checkTerminate());
                                        return;
                                    }
                                }
                                bl = simplePlainQueue.done;
                                simpleQueue = simplePlainQueue.queue;
                                n3 = n4;
                                if (!bl) break block42;
                                if (simpleQueue == null) break block43;
                                n3 = n4;
                                if (!simpleQueue.isEmpty()) break block42;
                            }
                            this.removeInner((ObservableFlatMap.InnerObserver<T, U>)simplePlainQueue);
                            if (this.checkTerminate()) {
                                return;
                            }
                            n3 = n4 + 1;
                        }
                        n6 = n2 + 1;
                        n4 = n3;
                        n2 = n6;
                        if (n6 != n5) continue;
                        n4 = n3;
                    }
                    n2 = 0;
                }
                this.lastIndex = n2;
                this.lastId = object[n2].id;
                n2 = n4;
            }
            if (n2 != 0) {
                if (this.maxConcurrency == Integer.MAX_VALUE) continue;
                while (true) {
                    if (n2 == 0) continue block7;
                    synchronized (this) {
                        object = this.sources.poll();
                        if (object == null) {
                            --this.wip;
                        } else {
                            // MONITOREXIT @DISABLED, blocks:[5, 7, 12, 13, 15] lbl113 : MonitorExitStatement: MONITOREXIT : this
                            this.subscribeInner((ObservableSource<? extends U>)object);
                        }
                    }
                    --n2;
                }
            }
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        block7: {
            if (this.done) {
                return;
            }
            try {
                object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null ObservableSource");
                if (this.maxConcurrency == Integer.MAX_VALUE) break block7;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.dispose();
                this.onError(throwable);
                return;
            }
            synchronized (this) {
                if (this.wip == this.maxConcurrency) {
                    this.sources.offer((ObservableSource<U>)object);
                    return;
                }
                ++this.wip;
            }
        }
        this.subscribeInner((ObservableSource<? extends U>)object);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    void removeInner(ObservableFlatMap.InnerObserver<T, U> innerObserver) {
        ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArray;
        ObservableFlatMap.InnerObserver<?, ?>[] innerObserverArray2;
        do {
            int n;
            int n2;
            if ((n2 = (innerObserverArray2 = this.observers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (innerObserverArray2[n4] == innerObserver) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                innerObserverArray = EMPTY;
                continue;
            }
            innerObserverArray = new ObservableFlatMap.InnerObserver[n2 - 1];
            System.arraycopy(innerObserverArray2, 0, innerObserverArray, 0, n);
            System.arraycopy(innerObserverArray2, n + 1, innerObserverArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(innerObserverArray2, innerObserverArray));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void subscribeInner(ObservableSource<? extends U> observableSource) {
        boolean bl;
        do {
            if (!(observableSource instanceof Callable)) {
                long l = this.uniqueId;
                this.uniqueId = 1L + l;
                ObservableFlatMap.InnerObserver innerObserver = new ObservableFlatMap.InnerObserver(this, l);
                if (!this.addInner(innerObserver)) return;
                observableSource.subscribe((Observer)innerObserver);
                return;
            }
            if (!this.tryEmitScalar((Callable)observableSource)) return;
            if (this.maxConcurrency == Integer.MAX_VALUE) return;
            bl = false;
            synchronized (this) {
                observableSource = this.sources.poll();
                if (observableSource == null) {
                    --this.wip;
                    bl = true;
                }
            }
        } while (!bl);
        this.drain();
    }

    void tryEmit(U u, ObservableFlatMap.InnerObserver<T, U> innerObserver) {
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            this.downstream.onNext(u);
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            SimpleQueue simpleQueue;
            SimpleQueue simpleQueue2 = simpleQueue = innerObserver.queue;
            if (simpleQueue == null) {
                innerObserver.queue = simpleQueue2 = new SpscLinkedArrayQueue(this.bufferSize);
            }
            simpleQueue2.offer(u);
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    boolean tryEmitScalar(Callable<? extends U> object) {
        U u;
        try {
            u = object.call();
            if (u == null) {
                return true;
            }
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.errors.addThrowable(throwable);
            this.drain();
            return true;
        }
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            this.downstream.onNext(u);
            if (this.decrementAndGet() == 0) {
                return true;
            }
        } else {
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            object = simplePlainQueue;
            if (simplePlainQueue == null) {
                object = this.maxConcurrency == Integer.MAX_VALUE ? new SpscLinkedArrayQueue(this.bufferSize) : new SpscArrayQueue(this.maxConcurrency);
                this.queue = object;
            }
            if (!object.offer(u)) {
                this.onError(new IllegalStateException("Scalar queue full?!"));
                return true;
            }
            if (this.getAndIncrement() != 0) {
                return false;
            }
        }
        this.drainLoop();
        return true;
    }
}
