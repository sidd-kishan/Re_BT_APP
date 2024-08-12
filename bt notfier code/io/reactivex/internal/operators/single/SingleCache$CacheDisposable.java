/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.single.SingleCache
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleCache;
import java.util.concurrent.atomic.AtomicBoolean;

static final class SingleCache.CacheDisposable<T>
extends AtomicBoolean
implements Disposable {
    private static final long serialVersionUID = 7514387411091976596L;
    final SingleObserver<? super T> downstream;
    final SingleCache<T> parent;

    SingleCache.CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
        this.downstream = singleObserver;
        this.parent = singleCache;
    }

    public void dispose() {
        if (!this.compareAndSet(false, true)) return;
        this.parent.remove(this);
    }

    public boolean isDisposed() {
        return this.get();
    }
}
