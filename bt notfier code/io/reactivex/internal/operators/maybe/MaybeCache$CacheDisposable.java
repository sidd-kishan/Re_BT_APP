/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.MaybeCache
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.MaybeCache;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeCache.CacheDisposable<T>
extends AtomicReference<MaybeCache<T>>
implements Disposable {
    private static final long serialVersionUID = -5791853038359966195L;
    final MaybeObserver<? super T> downstream;

    MaybeCache.CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
        super(maybeCache);
        this.downstream = maybeObserver;
    }

    public void dispose() {
        MaybeCache maybeCache = this.getAndSet(null);
        if (maybeCache == null) return;
        maybeCache.remove(this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }
}
