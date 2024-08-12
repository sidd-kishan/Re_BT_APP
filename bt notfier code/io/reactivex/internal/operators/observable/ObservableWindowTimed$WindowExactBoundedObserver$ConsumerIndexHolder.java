/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowExactBoundedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableWindowTimed;

/*
 * Exception performing whole class analysis ignored.
 */
static final class ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder
implements Runnable {
    final long index;
    final ObservableWindowTimed.WindowExactBoundedObserver<?> parent;

    ObservableWindowTimed.WindowExactBoundedObserver.ConsumerIndexHolder(long l, ObservableWindowTimed.WindowExactBoundedObserver<?> windowExactBoundedObserver) {
        this.index = l;
        this.parent = windowExactBoundedObserver;
    }

    @Override
    public void run() {
        ObservableWindowTimed.WindowExactBoundedObserver<?> windowExactBoundedObserver = this.parent;
        if (!ObservableWindowTimed.WindowExactBoundedObserver.access$000(windowExactBoundedObserver)) {
            ObservableWindowTimed.WindowExactBoundedObserver.access$100(windowExactBoundedObserver).offer((Object)this);
        } else {
            windowExactBoundedObserver.terminated = true;
            windowExactBoundedObserver.disposeTimer();
        }
        if (!windowExactBoundedObserver.enter()) return;
        windowExactBoundedObserver.drainLoop();
    }
}
