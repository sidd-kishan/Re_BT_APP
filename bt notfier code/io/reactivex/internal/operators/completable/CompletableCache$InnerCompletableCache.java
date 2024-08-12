/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableCache
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableCache;
import java.util.concurrent.atomic.AtomicBoolean;

final class CompletableCache.InnerCompletableCache
extends AtomicBoolean
implements Disposable {
    private static final long serialVersionUID = 8943152917179642732L;
    final CompletableObserver downstream;
    final CompletableCache this$0;

    CompletableCache.InnerCompletableCache(CompletableCache completableCache, CompletableObserver completableObserver) {
        this.this$0 = completableCache;
        this.downstream = completableObserver;
    }

    public void dispose() {
        if (!this.compareAndSet(false, true)) return;
        this.this$0.remove(this);
    }

    public boolean isDisposed() {
        return this.get();
    }
}
