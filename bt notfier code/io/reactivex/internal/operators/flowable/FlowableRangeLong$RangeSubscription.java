/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import org.reactivestreams.Subscriber;

static final class FlowableRangeLong.RangeSubscription
extends FlowableRangeLong.BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final Subscriber<? super Long> downstream;

    FlowableRangeLong.RangeSubscription(Subscriber<? super Long> subscriber, long l, long l2) {
        super(l, l2);
        this.downstream = subscriber;
    }

    void fastPath() {
        long l = this.end;
        Subscriber<? super Long> subscriber = this.downstream;
        for (long i = this.index; i != l; ++i) {
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
        long l3 = this.end;
        long l4 = this.index;
        Subscriber<? super Long> subscriber = this.downstream;
        do {
            l2 = 0L;
            while (true) {
                long l5;
                if (l2 != l && l4 != l3) {
                    if (this.cancelled) {
                        return;
                    }
                    subscriber.onNext((Object)l4);
                    ++l2;
                    ++l4;
                    continue;
                }
                if (l4 == l3) {
                    if (this.cancelled) return;
                    subscriber.onComplete();
                    return;
                }
                l = l5 = this.get();
                if (l2 == l5) break;
            }
            this.index = l4;
            l = l2 = this.addAndGet(-l2);
        } while (l2 != 0L);
    }
}
