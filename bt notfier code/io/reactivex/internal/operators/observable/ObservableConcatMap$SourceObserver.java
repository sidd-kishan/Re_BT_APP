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
 *  io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableConcatMap.SourceObserver<T, U>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 8828587559905699186L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean disposed;
    volatile boolean done;
    final Observer<? super U> downstream;
    int fusionMode;
    final InnerObserver<U> inner;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    SimpleQueue<T> queue;
    Disposable upstream;

    ObservableConcatMap.SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int n) {
        this.downstream = observer;
        this.mapper = function;
        this.bufferSize = n;
        this.inner = new InnerObserver(observer, this);
    }

    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        this.upstream.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        do {
            boolean bl;
            Object object;
            block7: {
                if (this.disposed) {
                    this.queue.clear();
                    return;
                }
                if (this.active) continue;
                boolean bl2 = this.done;
                try {
                    object = this.queue.poll();
                    bl = object == null;
                    if (!bl2 || !bl) break block7;
                    this.disposed = true;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.dispose();
                    this.queue.clear();
                    this.downstream.onError(throwable);
                    return;
                }
                this.downstream.onComplete();
                return;
            }
            if (bl) continue;
            try {
                object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null ObservableSource");
                this.active = true;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.dispose();
                this.queue.clear();
                this.downstream.onError(throwable);
                return;
            }
            object.subscribe(this.inner);
        } while (this.decrementAndGet() != 0);
    }

    void innerComplete() {
        this.active = false;
        this.drain();
    }

    public boolean isDisposed() {
        return this.disposed;
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
        this.done = true;
        this.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0) {
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
                this.fusionMode = n;
                this.queue = disposable;
                this.done = true;
                this.downstream.onSubscribe((Disposable)this);
                this.drain();
                return;
            }
            if (n == 2) {
                this.fusionMode = n;
                this.queue = disposable;
                this.downstream.onSubscribe((Disposable)this);
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        this.downstream.onSubscribe((Disposable)this);
    }
}
