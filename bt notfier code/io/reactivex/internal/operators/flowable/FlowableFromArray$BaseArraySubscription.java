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
import java.util.concurrent.atomic.AtomicLong;

static abstract class FlowableFromArray.BaseArraySubscription<T>
extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    final T[] array;
    volatile boolean cancelled;
    int index;

    FlowableFromArray.BaseArraySubscription(T[] TArray) {
        this.array = TArray;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.index = this.array.length;
    }

    abstract void fastPath();

    public final boolean isEmpty() {
        boolean bl = this.index == this.array.length;
        return bl;
    }

    public final T poll() {
        int n = this.index;
        T[] TArray = this.array;
        if (n == TArray.length) {
            return null;
        }
        this.index = n + 1;
        return (T)ObjectHelper.requireNonNull(TArray[n], (String)"array element is null");
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
