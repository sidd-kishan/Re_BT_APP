/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableEmitter
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.internal.disposables.CancellableDisposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.flowable.FlowableCreate$SerializedEmitter
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static abstract class FlowableCreate.BaseEmitter<T>
extends AtomicLong
implements FlowableEmitter<T>,
Subscription {
    private static final long serialVersionUID = 7326289992464377023L;
    final Subscriber<? super T> downstream;
    final SequentialDisposable serial;

    FlowableCreate.BaseEmitter(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
        this.serial = new SequentialDisposable();
    }

    public final void cancel() {
        this.serial.dispose();
        this.onUnsubscribed();
    }

    protected void complete() {
        if (this.isCancelled()) {
            return;
        }
        try {
            this.downstream.onComplete();
            return;
        }
        finally {
            this.serial.dispose();
        }
    }

    protected boolean error(Throwable throwable) {
        Throwable throwable2 = throwable;
        if (throwable == null) {
            throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.isCancelled()) {
            return false;
        }
        try {
            this.downstream.onError(throwable2);
            return true;
        }
        finally {
            this.serial.dispose();
        }
    }

    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    public void onComplete() {
        this.complete();
    }

    public final void onError(Throwable throwable) {
        if (this.tryOnError(throwable)) return;
        RxJavaPlugins.onError((Throwable)throwable);
    }

    void onRequested() {
    }

    void onUnsubscribed() {
    }

    public final void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this, (long)l);
        this.onRequested();
    }

    public final long requested() {
        return this.get();
    }

    public final FlowableEmitter<T> serialize() {
        return new FlowableCreate.SerializedEmitter(this);
    }

    public final void setCancellable(Cancellable cancellable) {
        this.setDisposable((Disposable)new CancellableDisposable(cancellable));
    }

    public final void setDisposable(Disposable disposable) {
        this.serial.update(disposable);
    }

    @Override
    public String toString() {
        return String.format("%s{%s}", this.getClass().getSimpleName(), super.toString());
    }

    public boolean tryOnError(Throwable throwable) {
        return this.error(throwable);
    }
}
