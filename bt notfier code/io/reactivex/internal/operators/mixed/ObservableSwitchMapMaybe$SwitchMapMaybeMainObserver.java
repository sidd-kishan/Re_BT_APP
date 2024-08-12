/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableSwitchMapMaybe.SwitchMapMaybeMainObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable {
    static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver(null);
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapMaybeObserver<R>> inner;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    Disposable upstream;

    ObservableSwitchMapMaybe.SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
        this.downstream = observer;
        this.mapper = function;
        this.delayErrors = bl;
        this.errors = new AtomicThrowable();
        this.inner = new AtomicReference();
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.disposeInner();
    }

    void disposeInner() {
        SwitchMapMaybeObserver<Object> switchMapMaybeObserver = this.inner.getAndSet(INNER_DISPOSED);
        if (switchMapMaybeObserver == null) return;
        if (switchMapMaybeObserver == INNER_DISPOSED) return;
        switchMapMaybeObserver.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super R> observer = this.downstream;
        AtomicThrowable atomicThrowable = this.errors;
        Serializable serializable = this.inner;
        int n = 1;
        while (!this.cancelled) {
            if (atomicThrowable.get() != null && !this.delayErrors) {
                observer.onError(atomicThrowable.terminate());
                return;
            }
            boolean bl = this.done;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver = ((AtomicReference)serializable).get();
            int n2 = switchMapMaybeObserver == null ? 1 : 0;
            if (bl && n2 != 0) {
                serializable = atomicThrowable.terminate();
                if (serializable != null) {
                    observer.onError((Throwable)serializable);
                } else {
                    observer.onComplete();
                }
                return;
            }
            if (n2 == 0 && switchMapMaybeObserver.item != null) {
                ((AtomicReference)serializable).compareAndSet(switchMapMaybeObserver, null);
                observer.onNext(switchMapMaybeObserver.item);
                continue;
            }
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
        return;
    }

    void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
        if (!this.inner.compareAndSet(switchMapMaybeObserver, null)) return;
        this.drain();
    }

    void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable throwable) {
        if (this.inner.compareAndSet(switchMapMaybeObserver, null) && this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.disposeInner();
            }
            this.drain();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
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
            if (!this.delayErrors) {
                this.disposeInner();
            }
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        SwitchMapMaybeObserver<R> switchMapMaybeObserver;
        SwitchMapMaybeObserver switchMapMaybeObserver2 = this.inner.get();
        if (switchMapMaybeObserver2 != null) {
            switchMapMaybeObserver2.dispose();
        }
        try {
            object = (MaybeSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null MaybeSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.inner.getAndSet(INNER_DISPOSED);
            this.onError(throwable);
            return;
        }
        switchMapMaybeObserver2 = new SwitchMapMaybeObserver(this);
        while ((switchMapMaybeObserver = this.inner.get()) != INNER_DISPOSED) {
            if (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver2)) continue;
            object.subscribe((MaybeObserver)switchMapMaybeObserver2);
            break;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
