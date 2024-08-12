/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSupport
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;

static final class FlowableTimeoutTimed.TimeoutTask
implements Runnable {
    final long idx;
    final FlowableTimeoutTimed.TimeoutSupport parent;

    FlowableTimeoutTimed.TimeoutTask(long l, FlowableTimeoutTimed.TimeoutSupport timeoutSupport) {
        this.idx = l;
        this.parent = timeoutSupport;
    }

    @Override
    public void run() {
        this.parent.onTimeout(this.idx);
    }
}
