/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableCache
 *  io.reactivex.internal.operators.observable.ObservableCache$Node
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableCache;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableCache.CacheDisposable<T>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = 6770240836423125754L;
    volatile boolean disposed;
    final Observer<? super T> downstream;
    long index;
    ObservableCache.Node<T> node;
    int offset;
    final ObservableCache<T> parent;

    ObservableCache.CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
        this.downstream = observer;
        this.parent = observableCache;
        this.node = observableCache.head;
    }

    public void dispose() {
        if (this.disposed) return;
        this.disposed = true;
        this.parent.remove(this);
    }

    public boolean isDisposed() {
        return this.disposed;
    }
}
