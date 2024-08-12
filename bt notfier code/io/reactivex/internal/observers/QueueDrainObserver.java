/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.observers.QueueDrainSubscriberPad2
 *  io.reactivex.internal.util.ObservableQueueDrain
 *  io.reactivex.internal.util.QueueDrainHelper
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainSubscriberPad2;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

public abstract class QueueDrainObserver<T, U, V>
extends QueueDrainSubscriberPad2
implements Observer<T>,
ObservableQueueDrain<U, V> {
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected final Observer<? super V> downstream;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.downstream = observer;
        this.queue = simplePlainQueue;
    }

    public void accept(Observer<? super V> observer, U u) {
    }

    public final boolean cancelled() {
        return this.cancelled;
    }

    public final boolean done() {
        return this.done;
    }

    public final boolean enter() {
        boolean bl = this.wip.getAndIncrement() == 0;
        return bl;
    }

    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        int n = this.wip.get();
        boolean bl = true;
        if (n == 0 && this.wip.compareAndSet(0, 1)) return bl;
        bl = false;
        return bl;
    }

    protected final void fastPathEmit(U u, boolean bl, Disposable disposable) {
        Observer<? super V> observer = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            this.accept(observer, u);
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!this.enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, (boolean)bl, (Disposable)disposable, (ObservableQueueDrain)this);
    }

    protected final void fastPathOrderedEmit(U u, boolean bl, Disposable disposable) {
        Observer<? super V> observer = this.downstream;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            if (simplePlainQueue.isEmpty()) {
                this.accept(observer, u);
                if (this.leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (!this.enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, (boolean)bl, (Disposable)disposable, (ObservableQueueDrain)this);
    }

    public final int leave(int n) {
        return this.wip.addAndGet(n);
    }
}
