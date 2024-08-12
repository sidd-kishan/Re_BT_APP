/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowExactBoundedSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableWindowTimed;

/*
 * Exception performing whole class analysis ignored.
 */
static final class FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder
implements Runnable {
    final long index;
    final FlowableWindowTimed.WindowExactBoundedSubscriber<?> parent;

    FlowableWindowTimed.WindowExactBoundedSubscriber.ConsumerIndexHolder(long l, FlowableWindowTimed.WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
        this.index = l;
        this.parent = windowExactBoundedSubscriber;
    }

    @Override
    public void run() {
        FlowableWindowTimed.WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.parent;
        if (!FlowableWindowTimed.WindowExactBoundedSubscriber.access$000(windowExactBoundedSubscriber)) {
            FlowableWindowTimed.WindowExactBoundedSubscriber.access$100(windowExactBoundedSubscriber).offer((Object)this);
        } else {
            windowExactBoundedSubscriber.terminated = true;
            windowExactBoundedSubscriber.dispose();
        }
        if (!windowExactBoundedSubscriber.enter()) return;
        windowExactBoundedSubscriber.drainLoop();
    }
}
