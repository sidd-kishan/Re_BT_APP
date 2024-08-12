/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableSwitchMapCompletable.SwitchMapCompletableObserver<T>
implements FlowableSubscriber<T>,
Disposable {
    static final SwitchMapInnerObserver INNER_DISPOSED = new SwitchMapInnerObserver(null);
    final boolean delayErrors;
    volatile boolean done;
    final CompletableObserver downstream;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapInnerObserver> inner;
    final Function<? super T, ? extends CompletableSource> mapper;
    Subscription upstream;

    FlowableSwitchMapCompletable.SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean bl) {
        this.downstream = completableObserver;
        this.mapper = function;
        this.delayErrors = bl;
        this.errors = new AtomicThrowable();
        this.inner = new AtomicReference();
    }

    public void dispose() {
        this.upstream.cancel();
        this.disposeInner();
    }

    void disposeInner() {
        SwitchMapInnerObserver switchMapInnerObserver = this.inner.getAndSet(INNER_DISPOSED);
        if (switchMapInnerObserver == null) return;
        if (switchMapInnerObserver == INNER_DISPOSED) return;
        switchMapInnerObserver.dispose();
    }

    void innerComplete(SwitchMapInnerObserver object) {
        if (!this.inner.compareAndSet((SwitchMapInnerObserver)object, (SwitchMapInnerObserver)null)) return;
        if (!this.done) return;
        object = this.errors.terminate();
        if (object == null) {
            this.downstream.onComplete();
        } else {
            this.downstream.onError((Throwable)object);
        }
    }

    void innerError(SwitchMapInnerObserver object, Throwable throwable) {
        if (this.inner.compareAndSet((SwitchMapInnerObserver)object, (SwitchMapInnerObserver)null) && this.errors.addThrowable(throwable)) {
            if (this.delayErrors) {
                if (!this.done) return;
                object = this.errors.terminate();
                this.downstream.onError((Throwable)object);
            } else {
                this.dispose();
                object = this.errors.terminate();
                if (object == ExceptionHelper.TERMINATED) return;
                this.downstream.onError((Throwable)object);
            }
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public boolean isDisposed() {
        boolean bl = this.inner.get() == INNER_DISPOSED;
        return bl;
    }

    public void onComplete() {
        this.done = true;
        if (this.inner.get() != null) return;
        Throwable throwable = this.errors.terminate();
        if (throwable == null) {
            this.downstream.onComplete();
        } else {
            this.downstream.onError(throwable);
        }
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.delayErrors) {
                this.onComplete();
            } else {
                this.disposeInner();
                throwable = this.errors.terminate();
                if (throwable == ExceptionHelper.TERMINATED) return;
                this.downstream.onError(throwable);
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        SwitchMapInnerObserver switchMapInnerObserver;
        CompletableSource completableSource;
        try {
            completableSource = (CompletableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null CompletableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        object = new SwitchMapInnerObserver(this);
        while ((switchMapInnerObserver = this.inner.get()) != INNER_DISPOSED) {
            if (!this.inner.compareAndSet(switchMapInnerObserver, (SwitchMapInnerObserver)object)) continue;
            if (switchMapInnerObserver != null) {
                switchMapInnerObserver.dispose();
            }
            completableSource.subscribe(object);
            break;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
