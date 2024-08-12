/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

static final class ObservableRange.RangeDisposable
extends BasicIntQueueDisposable<Integer> {
    private static final long serialVersionUID = 396518478098735504L;
    final Observer<? super Integer> downstream;
    final long end;
    boolean fused;
    long index;

    ObservableRange.RangeDisposable(Observer<? super Integer> observer, long l, long l2) {
        this.downstream = observer;
        this.index = l;
        this.end = l2;
    }

    public void clear() {
        this.index = this.end;
        this.lazySet(1);
    }

    public void dispose() {
        this.set(1);
    }

    public boolean isDisposed() {
        boolean bl = this.get() != 0;
        return bl;
    }

    public boolean isEmpty() {
        boolean bl = this.index == this.end;
        return bl;
    }

    public Integer poll() throws Exception {
        long l = this.index;
        if (l != this.end) {
            this.index = 1L + l;
            return (int)l;
        }
        this.lazySet(1);
        return null;
    }

    public int requestFusion(int n) {
        if ((n & 1) == 0) return 0;
        this.fused = true;
        return 1;
    }

    void run() {
        if (this.fused) {
            return;
        }
        Observer<? super Integer> observer = this.downstream;
        long l = this.end;
        for (long i = this.index; i != l && this.get() == 0; ++i) {
            observer.onNext((Object)((int)i));
        }
        if (this.get() != 0) return;
        this.lazySet(1);
        observer.onComplete();
    }
}
