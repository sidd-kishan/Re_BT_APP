/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;

static final class FlowableDoAfterNext.DoAfterConditionalSubscriber<T>
extends BasicFuseableConditionalSubscriber<T, T> {
    final Consumer<? super T> onAfterNext;

    FlowableDoAfterNext.DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
        super(conditionalSubscriber);
        this.onAfterNext = consumer;
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
        if (this.sourceMode != 0) return;
        try {
            this.onAfterNext.accept(t);
        }
        catch (Throwable throwable) {
            this.fail(throwable);
        }
    }

    public T poll() throws Exception {
        Object object = this.qs.poll();
        if (object == null) return (T)object;
        this.onAfterNext.accept(object);
        return (T)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }

    public boolean tryOnNext(T t) {
        boolean bl = this.downstream.tryOnNext(t);
        try {
            this.onAfterNext.accept(t);
        }
        catch (Throwable throwable) {
            this.fail(throwable);
        }
        return bl;
    }
}
