/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subscribers.DisposableSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;

static final class FlowableDebounce.DebounceSubscriber.DebounceInnerSubscriber<T, U>
extends DisposableSubscriber<U> {
    boolean done;
    final long index;
    final AtomicBoolean once = new AtomicBoolean();
    final FlowableDebounce.DebounceSubscriber<T, U> parent;
    final T value;

    FlowableDebounce.DebounceSubscriber.DebounceInnerSubscriber(FlowableDebounce.DebounceSubscriber<T, U> debounceSubscriber, long l, T t) {
        this.parent = debounceSubscriber;
        this.index = l;
        this.value = t;
    }

    void emit() {
        if (!this.once.compareAndSet(false, true)) return;
        this.parent.emit(this.index, this.value);
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.emit();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.parent.onError(throwable);
    }

    public void onNext(U u) {
        if (this.done) {
            return;
        }
        this.done = true;
        this.cancel();
        this.emit();
    }
}
