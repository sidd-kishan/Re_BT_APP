/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableSwitchMapSingle.SwitchMapSingleMainObserver<T, R>
extends AtomicInteger
implements Observer<T>,
Disposable {
    static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver(null);
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapSingleObserver<R>> inner;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    Disposable upstream;

    ObservableSwitchMapSingle.SwitchMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl) {
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
        SwitchMapSingleObserver<Object> switchMapSingleObserver = this.inner.getAndSet(INNER_DISPOSED);
        if (switchMapSingleObserver == null) return;
        if (switchMapSingleObserver == INNER_DISPOSED) return;
        switchMapSingleObserver.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super R> observer = this.downstream;
        AtomicThrowable atomicThrowable = this.errors;
        AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
        int n = 1;
        while (!this.cancelled) {
            if (atomicThrowable.get() != null && !this.delayErrors) {
                observer.onError(atomicThrowable.terminate());
                return;
            }
            boolean bl = this.done;
            Object object = atomicReference.get();
            int n2 = object == null ? 1 : 0;
            if (bl && n2 != 0) {
                object = atomicThrowable.terminate();
                if (object != null) {
                    observer.onError(object);
                } else {
                    observer.onComplete();
                }
                return;
            }
            if (n2 == 0 && object.item != null) {
                atomicReference.compareAndSet((SwitchMapSingleObserver<R>)object, (SwitchMapSingleObserver<R>)null);
                observer.onNext(object.item);
                continue;
            }
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
        return;
    }

    void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable throwable) {
        if (this.inner.compareAndSet(switchMapSingleObserver, null) && this.errors.addThrowable(throwable)) {
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
        SingleSource singleSource = this.inner.get();
        if (singleSource != null) {
            singleSource.dispose();
        }
        try {
            singleSource = (SingleSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null SingleSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.inner.getAndSet(INNER_DISPOSED);
            this.onError(throwable);
            return;
        }
        SwitchMapSingleObserver switchMapSingleObserver = new SwitchMapSingleObserver(this);
        while ((object = this.inner.get()) != INNER_DISPOSED) {
            if (!this.inner.compareAndSet((SwitchMapSingleObserver<R>)object, (SwitchMapSingleObserver<R>)switchMapSingleObserver)) continue;
            singleSource.subscribe((SingleObserver)switchMapSingleObserver);
            break;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
