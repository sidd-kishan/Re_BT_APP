/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableFromArray;

static final class FlowableFromArray.ArrayConditionalSubscription<T>
extends FlowableFromArray.BaseArraySubscription<T> {
    private static final long serialVersionUID = 2587302975077663557L;
    final ConditionalSubscriber<? super T> downstream;

    FlowableFromArray.ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] TArray) {
        super((Object[])TArray);
        this.downstream = conditionalSubscriber;
    }

    void fastPath() {
        Object object = this.array;
        int n = ((Object[])object).length;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
        for (int i = this.index; i != n; ++i) {
            if (this.cancelled) {
                return;
            }
            Object object2 = object[i];
            if (object2 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("The element at index ");
                ((StringBuilder)object).append(i);
                ((StringBuilder)object).append(" is null");
                conditionalSubscriber.onError((Throwable)new NullPointerException(((StringBuilder)object).toString()));
                return;
            }
            conditionalSubscriber.tryOnNext(object2);
        }
        if (this.cancelled) {
            return;
        }
        conditionalSubscriber.onComplete();
    }

    void slowPath(long l) {
        long l2;
        Object object = this.array;
        int n = ((Object[])object).length;
        int n2 = this.index;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
        do {
            l2 = 0L;
            while (true) {
                long l3;
                if (l2 != l && n2 != n) {
                    if (this.cancelled) {
                        return;
                    }
                    Object object2 = object[n2];
                    if (object2 == null) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("The element at index ");
                        ((StringBuilder)object).append(n2);
                        ((StringBuilder)object).append(" is null");
                        conditionalSubscriber.onError((Throwable)new NullPointerException(((StringBuilder)object).toString()));
                        return;
                    }
                    l3 = l2;
                    if (conditionalSubscriber.tryOnNext(object2)) {
                        l3 = l2 + 1L;
                    }
                    ++n2;
                    l2 = l3;
                    continue;
                }
                if (n2 == n) {
                    if (this.cancelled) return;
                    conditionalSubscriber.onComplete();
                    return;
                }
                l = l3 = this.get();
                if (l2 == l3) break;
            }
            this.index = n2;
            l = l2 = this.addAndGet(-l2);
        } while (l2 != 0L);
    }
}
