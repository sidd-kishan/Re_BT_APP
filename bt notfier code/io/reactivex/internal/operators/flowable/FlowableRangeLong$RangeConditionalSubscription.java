/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;

static final class FlowableRangeLong.RangeConditionalSubscription
extends FlowableRangeLong.BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final ConditionalSubscriber<? super Long> downstream;

    FlowableRangeLong.RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long l, long l2) {
        super(l, l2);
        this.downstream = conditionalSubscriber;
    }

    void fastPath() {
        long l = this.end;
        ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
        for (long i = this.index; i != l; ++i) {
            if (this.cancelled) {
                return;
            }
            conditionalSubscriber.tryOnNext((Object)i);
        }
        if (this.cancelled) {
            return;
        }
        conditionalSubscriber.onComplete();
    }

    void slowPath(long l) {
        long l2;
        long l3 = this.end;
        long l4 = this.index;
        ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
        do {
            l2 = 0L;
            while (true) {
                long l5;
                if (l2 != l && l4 != l3) {
                    if (this.cancelled) {
                        return;
                    }
                    l5 = l2;
                    if (conditionalSubscriber.tryOnNext((Object)l4)) {
                        l5 = l2 + 1L;
                    }
                    ++l4;
                    l2 = l5;
                    continue;
                }
                if (l4 == l3) {
                    if (this.cancelled) return;
                    conditionalSubscriber.onComplete();
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
