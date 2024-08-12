/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableRange;
import org.reactivestreams.Subscriber;

static final class FlowableRange.RangeSubscription
extends FlowableRange.BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super Integer> downstream;

    FlowableRange.RangeSubscription(Subscriber<? super Integer> subscriber, int n, int n2) {
        super(n, n2);
        this.downstream = subscriber;
    }

    void fastPath() {
        int n = this.end;
        Subscriber<? super Integer> subscriber = this.downstream;
        for (int i = this.index; i != n; ++i) {
            if (this.cancelled) {
                return;
            }
            subscriber.onNext((Object)i);
        }
        if (this.cancelled) {
            return;
        }
        subscriber.onComplete();
    }

    void slowPath(long l) {
        long l2;
        int n = this.end;
        int n2 = this.index;
        Subscriber<? super Integer> subscriber = this.downstream;
        do {
            l2 = 0L;
            while (true) {
                long l3;
                if (l2 != l && n2 != n) {
                    if (this.cancelled) {
                        return;
                    }
                    subscriber.onNext((Object)n2);
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
