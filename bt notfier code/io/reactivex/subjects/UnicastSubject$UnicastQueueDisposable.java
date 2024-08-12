/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.subjects;

import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.subjects.UnicastSubject;

final class UnicastSubject.UnicastQueueDisposable
extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = 7926949470189395511L;
    final UnicastSubject this$0;

    UnicastSubject.UnicastQueueDisposable(UnicastSubject unicastSubject) {
        this.this$0 = unicastSubject;
    }

    public void clear() {
        this.this$0.queue.clear();
    }

    public void dispose() {
        if (this.this$0.disposed) return;
        this.this$0.disposed = true;
        this.this$0.doTerminate();
        this.this$0.downstream.lazySet(null);
        if (this.this$0.wip.getAndIncrement() != 0) return;
        this.this$0.downstream.lazySet(null);
        this.this$0.queue.clear();
    }

    public boolean isDisposed() {
        return this.this$0.disposed;
    }

    public boolean isEmpty() {
        return this.this$0.queue.isEmpty();
    }

    public T poll() throws Exception {
        return this.this$0.queue.poll();
    }

    public int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.this$0.enableOperatorFusion = true;
        return 2;
    }
}
