/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.processors.UnicastProcessor
 */
package io.reactivex.processors;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicLong;

final class UnicastProcessor.UnicastQueueSubscription
extends BasicIntQueueSubscription<T> {
    private static final long serialVersionUID = -4896760517184205454L;
    final UnicastProcessor this$0;

    UnicastProcessor.UnicastQueueSubscription(UnicastProcessor unicastProcessor) {
        this.this$0 = unicastProcessor;
    }

    public void cancel() {
        if (this.this$0.cancelled) {
            return;
        }
        this.this$0.cancelled = true;
        this.this$0.doTerminate();
        if (this.this$0.enableOperatorFusion) return;
        if (this.this$0.wip.getAndIncrement() != 0) return;
        this.this$0.queue.clear();
        this.this$0.downstream.lazySet(null);
    }

    public void clear() {
        this.this$0.queue.clear();
    }

    public boolean isEmpty() {
        return this.this$0.queue.isEmpty();
    }

    public T poll() {
        return this.this$0.queue.poll();
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.this$0.requested, (long)l);
        this.this$0.drain();
    }

    public int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.this$0.enableOperatorFusion = true;
        return 2;
    }
}
