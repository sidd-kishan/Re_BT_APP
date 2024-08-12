/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableConcatMapCompletable.ConcatMapCompletableObserver<T>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    volatile boolean disposed;
    volatile boolean done;
    final CompletableObserver downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    Disposable upstream;

    ObservableConcatMapCompletable.ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int n) {
        this.downstream = completableObserver;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.inner.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        AtomicThrowable atomicThrowable = this.errors;
        ErrorMode errorMode = this.errorMode;
        do {
            boolean bl;
            Throwable throwable;
            block10: {
                if (this.disposed) {
                    this.queue.clear();
                    return;
                }
                if (this.active) continue;
                if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                    this.disposed = true;
                    this.queue.clear();
                    throwable = atomicThrowable.terminate();
                    this.downstream.onError(throwable);
                    return;
                }
                boolean bl2 = this.done;
                throwable = null;
                try {
                    Object object = this.queue.poll();
                    if (object != null) {
                        throwable = (CompletableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null CompletableSource");
                        bl = false;
                    } else {
                        bl = true;
                    }
                    if (!bl2 || !bl) break block10;
                    this.disposed = true;
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    this.disposed = true;
                    this.queue.clear();
                    this.upstream.dispose();
                    atomicThrowable.addThrowable(throwable2);
                    Throwable throwable3 = atomicThrowable.terminate();
                    this.downstream.onError(throwable3);
                    return;
                }
                throwable = atomicThrowable.terminate();
                if (throwable != null) {
                    this.downstream.onError(throwable);
                } else {
                    this.downstream.onComplete();
                }
                return;
            }
            if (bl) continue;
            this.active = true;
            throwable.subscribe((CompletableObserver)this.inner);
        } while (this.decrementAndGet() != 0);
    }

    void innerComplete() {
        this.active = false;
        this.drain();
    }

    void innerError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.upstream.dispose();
                throwable = this.errors.terminate();
                if (throwable != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(throwable);
                }
                if (this.getAndIncrement() != 0) return;
                this.queue.clear();
            } else {
                this.active = false;
                this.drain();
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.inner.dispose();
                throwable = this.errors.terminate();
                if (throwable != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(throwable);
                }
                if (this.getAndIncrement() != 0) return;
                this.queue.clear();
            } else {
                this.done = true;
                this.drain();
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (t != null) {
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
                this.queue = disposable;
                this.done = true;
                this.downstream.onSubscribe((Disposable)this);
                this.drain();
                return;
            }
            if (n == 2) {
                this.queue = disposable;
                this.downstream.onSubscribe((Disposable)this);
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue(this.prefetch);
        this.downstream.onSubscribe((Disposable)this);
    }
}
