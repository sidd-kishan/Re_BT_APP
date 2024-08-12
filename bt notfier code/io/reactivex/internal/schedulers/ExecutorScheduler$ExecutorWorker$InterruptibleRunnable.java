/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableContainer
 */
package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.atomic.AtomicInteger;

static final class ExecutorScheduler.ExecutorWorker.InterruptibleRunnable
extends AtomicInteger
implements Runnable,
Disposable {
    static final int FINISHED = 2;
    static final int INTERRUPTED = 4;
    static final int INTERRUPTING = 3;
    static final int READY = 0;
    static final int RUNNING = 1;
    private static final long serialVersionUID = -3603436687413320876L;
    final Runnable run;
    final DisposableContainer tasks;
    volatile Thread thread;

    ExecutorScheduler.ExecutorWorker.InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        this.run = runnable;
        this.tasks = disposableContainer;
    }

    void cleanup() {
        DisposableContainer disposableContainer = this.tasks;
        if (disposableContainer == null) return;
        disposableContainer.delete((Disposable)this);
    }

    public void dispose() {
        int n;
        while ((n = this.get()) < 2) {
            if (n == 0) {
                if (!this.compareAndSet(0, 4)) continue;
                this.cleanup();
                break;
            }
            if (!this.compareAndSet(1, 3)) continue;
            Thread thread = this.thread;
            if (thread != null) {
                thread.interrupt();
                this.thread = null;
            }
            this.set(4);
            this.cleanup();
            break;
        }
    }

    public boolean isDisposed() {
        boolean bl = this.get() >= 2;
        return bl;
    }

    @Override
    public void run() {
        if (this.get() != 0) return;
        this.thread = Thread.currentThread();
        if (this.compareAndSet(0, 1)) {
            try {
                this.run.run();
                this.thread = null;
            }
            catch (Throwable throwable) {
                this.thread = null;
                if (!this.compareAndSet(1, 2)) {
                    while (this.get() == 3) {
                        Thread.yield();
                    }
                    Thread.interrupted();
                } else {
                    this.cleanup();
                }
                throw throwable;
            }
            if (this.compareAndSet(1, 2)) {
                this.cleanup();
            } else {
                while (this.get() == 3) {
                    Thread.yield();
                }
                Thread.interrupted();
            }
        } else {
            this.thread = null;
        }
    }
}
