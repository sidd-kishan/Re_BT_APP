/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableFromArray;
import org.reactivestreams.Subscriber;

static final class FlowableFromArray.ArraySubscription<T>
extends FlowableFromArray.BaseArraySubscription<T> {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super T> downstream;

    FlowableFromArray.ArraySubscription(Subscriber<? super T> subscriber, T[] TArray) {
        super((Object[])TArray);
        this.downstream = subscriber;
    }

    void fastPath() {
        Object object = this.array;
        int n = ((Object[])object).length;
        Subscriber<? super T> subscriber = this.downstream;
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
                subscriber.onError((Throwable)new NullPointerException(((StringBuilder)object).toString()));
                return;
            }
            subscriber.onNext(object2);
        }
        if (this.cancelled) {
            return;
        }
        subscriber.onComplete();
    }

    void slowPath(long l) {
        long l2;
        Object[] objectArray = this.array;
        int n = objectArray.length;
        int n2 = this.index;
        Subscriber<? super T> subscriber = this.downstream;
        do {
            l2 = 0L;
            while (true) {
                long l3;
                if (l2 != l && n2 != n) {
                    if (this.cancelled) {
                        return;
                    }
                    Object object = objectArray[n2];
                    if (object == null) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("The element at index ");
                        ((StringBuilder)object).append(n2);
                        ((StringBuilder)object).append(" is null");
                        subscriber.onError((Throwable)new NullPointerException(((StringBuilder)object).toString()));
                        return;
                    }
                    subscriber.onNext(object);
                    ++l2;
                    ++n2;
                    continue;
                }
                if (n2 == n) {
                    if (this.cancelled) return;
                    subscriber.onComplete();
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
