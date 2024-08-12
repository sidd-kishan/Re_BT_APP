/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 */
package io.reactivex.internal.schedulers;

import io.reactivex.CompletableObserver;

static class SchedulerWhen.OnCompletedAction
implements Runnable {
    final Runnable action;
    final CompletableObserver actionCompletable;

    SchedulerWhen.OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
        this.action = runnable;
        this.actionCompletable = completableObserver;
    }

    @Override
    public void run() {
        try {
            this.action.run();
            return;
        }
        finally {
            this.actionCompletable.onComplete();
        }
    }
}
