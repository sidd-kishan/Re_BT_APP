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

static final class ObservableRangeLong.RangeDisposable
extends BasicIntQueueDisposable<Long> {
    private static final long serialVersionUID = 396518478098735504L;
    final Observer<? super Long> downstream;
    final long end;
    boolean fused;
    long index;

    ObservableRangeLong.RangeDisposable(Observer<? super Long> observer, long l, long l2) {
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

    public Long poll() throws Exception {
        long l = this.index;
        if (l != this.end) {
            this.index = 1L + l;
            return l;
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
        Observer<? super Long> observer = this.downstream;
        long l = this.end;
        for (long i = this.index; i != l && this.get() == 0; ++i) {
            observer.onNext((Object)i);
        }
        if (this.get() != 0) return;
        this.lazySet(1);
        observer.onComplete();
    }
}
