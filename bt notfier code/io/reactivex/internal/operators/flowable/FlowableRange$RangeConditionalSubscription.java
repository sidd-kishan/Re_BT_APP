/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableRange;

static final class FlowableRange.RangeConditionalSubscription
extends FlowableRange.BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    final ConditionalSubscriber<? super Integer> downstream;

    FlowableRange.RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int n, int n2) {
        super(n, n2);
        this.downstream = conditionalSubscriber;
    }

    void fastPath() {
        int n = this.end;
        ConditionalSubscriber<? super Integer> conditionalSubscriber = this.downstream;
        for (int i = this.index; i != n; ++i) {
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
        int n = this.end;
        int n2 = this.index;
        ConditionalSubscriber<? super Integer> conditionalSubscriber = this.downstream;
        do {
            l2 = 0L;
            while (true) {
                long l3;
                if (l2 != l && n2 != n) {
                    if (this.cancelled) {
                        return;
                    }
                    l3 = l2;
                    if (conditionalSubscriber.tryOnNext((Object)n2)) {
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
