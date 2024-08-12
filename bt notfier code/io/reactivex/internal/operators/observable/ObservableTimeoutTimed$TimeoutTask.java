/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;

static final class ObservableTimeoutTimed.TimeoutTask
implements Runnable {
    final long idx;
    final ObservableTimeoutTimed.TimeoutSupport parent;

    ObservableTimeoutTimed.TimeoutTask(long l, ObservableTimeoutTimed.TimeoutSupport timeoutSupport) {
        this.idx = l;
        this.parent = timeoutSupport;
    }

    @Override
    public void run() {
        this.parent.onTimeout(this.idx);
    }
}
