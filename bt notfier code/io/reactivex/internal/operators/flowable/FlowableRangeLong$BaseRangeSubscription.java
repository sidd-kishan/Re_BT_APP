/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscriptions.BasicQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;

static abstract class FlowableRangeLong.BaseRangeSubscription
extends BasicQueueSubscription<Long> {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    final long end;
    long index;

    FlowableRangeLong.BaseRangeSubscription(long l, long l2) {
        this.index = l;
        this.end = l2;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.index = this.end;
    }

    abstract void fastPath();

    public final boolean isEmpty() {
        boolean bl = this.index == this.end;
        return bl;
    }

    public final Long poll() {
        long l = this.index;
        if (l == this.end) {
            return null;
        }
        this.index = 1L + l;
        return l;
    }

    public final void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        if (BackpressureHelper.add((AtomicLong)((Object)this), (long)l) != 0L) return;
        if (l == Long.MAX_VALUE) {
            this.fastPath();
        } else {
            this.slowPath(l);
        }
    }

    public final int requestFusion(int n) {
        return n & 1;
    }

    abstract void slowPath(long var1);
}
