/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;

static final class FlowableMap.MapConditionalSubscriber<T, U>
extends BasicFuseableConditionalSubscriber<T, U> {
    final Function<? super T, ? extends U> mapper;

    FlowableMap.MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
        super(conditionalSubscriber);
        this.mapper = function;
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(null);
            return;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper function returned a null value.");
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return;
        }
        this.downstream.onNext(object);
    }

    public U poll() throws Exception {
        Object object = this.qs.poll();
        object = object != null ? ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper function returned a null value.") : null;
        return (U)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }

    public boolean tryOnNext(T object) {
        if (this.done) {
            return false;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper function returned a null value.");
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return true;
        }
        return this.downstream.tryOnNext(object);
    }
}
