/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe$ConcatMapMaybeMainObserver$ConcatMapMaybeObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableConcatMapMaybe.ConcatMapMaybeMainObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super R> downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapMaybeObserver<R> inner;
    R item;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final SimplePlainQueue<T> queue;
    volatile int state;
    Disposable upstream;

    ObservableConcatMapMaybe.ConcatMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, int n, ErrorMode errorMode) {
        this.downstream = observer;
        this.mapper = function;
        this.errorMode = errorMode;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapMaybeObserver(this);
        this.queue = new SpscLinkedArrayQueue(n);
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.inner.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
        this.item = null;
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super R> observer = this.downstream;
        ErrorMode errorMode = this.errorMode;
        Object object = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int n = 1;
        while (true) {
            int n2;
            if (this.cancelled) {
                object.clear();
                this.item = null;
            } else {
                Object object2;
                int n3 = this.state;
                if (atomicThrowable.get() != null && (errorMode == ErrorMode.IMMEDIATE || errorMode == ErrorMode.BOUNDARY && n3 == 0)) {
                    object.clear();
                    this.item = null;
                    observer.onError(atomicThrowable.terminate());
                    return;
                }
                n2 = 0;
                if (n3 == 0) {
                    boolean bl = this.done;
                    object2 = object.poll();
                    if (object2 == null) {
                        n2 = 1;
                    }
                    if (bl && n2 != 0) {
                        object = atomicThrowable.terminate();
                        if (object == null) {
                            observer.onComplete();
                        } else {
                            observer.onError(object);
                        }
                        return;
                    }
                    if (n2 == 0) {
                        try {
                            object2 = (MaybeSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object2), (String)"The mapper returned a null MaybeSource");
                            this.state = 1;
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            this.upstream.dispose();
                            object.clear();
                            atomicThrowable.addThrowable(throwable);
                            observer.onError(atomicThrowable.terminate());
                            return;
                        }
                        object2.subscribe(this.inner);
                    }
                } else if (n3 == 2) {
                    object2 = this.item;
                    this.item = null;
                    observer.onNext(object2);
                    this.state = 0;
                    continue;
                }
            }
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
    }

    void innerComplete() {
        this.state = 0;
        this.drain();
    }

    void innerError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode != ErrorMode.END) {
                this.upstream.dispose();
            }
            this.state = 0;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerSuccess(R r) {
        this.item = r;
        this.state = 2;
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
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.dispose();
            }
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        this.queue.offer(t);
        this.drain();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
