/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.BasicQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

static abstract class FlowableFromIterable.BaseRangeSubscription<T>
extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    volatile boolean cancelled;
    Iterator<? extends T> it;
    boolean once;

    FlowableFromIterable.BaseRangeSubscription(Iterator<? extends T> iterator) {
        this.it = iterator;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.it = null;
    }

    abstract void fastPath();

    public final boolean isEmpty() {
        Iterator<T> iterator = this.it;
        boolean bl = iterator == null || !iterator.hasNext();
        return bl;
    }

    public final T poll() {
        Iterator<T> iterator = this.it;
        if (iterator == null) {
            return null;
        }
        if (!this.once) {
            this.once = true;
            return (T)ObjectHelper.requireNonNull(this.it.next(), (String)"Iterator.next() returned a null value");
        }
        if (iterator.hasNext()) return (T)ObjectHelper.requireNonNull(this.it.next(), (String)"Iterator.next() returned a null value");
        return null;
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
