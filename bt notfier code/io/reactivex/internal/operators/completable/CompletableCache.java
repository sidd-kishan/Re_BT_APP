/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableCache$InnerCompletableCache
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableCache;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCache
extends Completable
implements CompletableObserver {
    static final InnerCompletableCache[] EMPTY = new InnerCompletableCache[0];
    static final InnerCompletableCache[] TERMINATED = new InnerCompletableCache[0];
    Throwable error;
    final AtomicReference<InnerCompletableCache[]> observers;
    final AtomicBoolean once;
    final CompletableSource source;

    public CompletableCache(CompletableSource completableSource) {
        this.source = completableSource;
        this.observers = new AtomicReference<InnerCompletableCache[]>(EMPTY);
        this.once = new AtomicBoolean();
    }

    boolean add(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArray;
        InnerCompletableCache[] innerCompletableCacheArray2;
        do {
            if ((innerCompletableCacheArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = innerCompletableCacheArray2.length;
            innerCompletableCacheArray = new InnerCompletableCache[n + 1];
            System.arraycopy(innerCompletableCacheArray2, 0, innerCompletableCacheArray, 0, n);
            innerCompletableCacheArray[n] = innerCompletableCache;
        } while (!this.observers.compareAndSet(innerCompletableCacheArray2, innerCompletableCacheArray));
        return true;
    }

    public void onComplete() {
        InnerCompletableCache[] innerCompletableCacheArray = this.observers.getAndSet(TERMINATED);
        int n = innerCompletableCacheArray.length;
        int n2 = 0;
        while (n2 < n) {
            InnerCompletableCache innerCompletableCache = innerCompletableCacheArray[n2];
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
            ++n2;
        }
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        InnerCompletableCache[] innerCompletableCacheArray = this.observers.getAndSet(TERMINATED);
        int n = innerCompletableCacheArray.length;
        int n2 = 0;
        while (n2 < n) {
            InnerCompletableCache innerCompletableCache = innerCompletableCacheArray[n2];
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(throwable);
            }
            ++n2;
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    void remove(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArray;
        InnerCompletableCache[] innerCompletableCacheArray2;
        do {
            int n;
            int n2;
            if ((n2 = (innerCompletableCacheArray2 = this.observers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (innerCompletableCacheArray2[n4] == innerCompletableCache) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                innerCompletableCacheArray = EMPTY;
                continue;
            }
            innerCompletableCacheArray = new InnerCompletableCache[n2 - 1];
            System.arraycopy(innerCompletableCacheArray2, 0, innerCompletableCacheArray, 0, n);
            System.arraycopy(innerCompletableCacheArray2, n + 1, innerCompletableCacheArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(innerCompletableCacheArray2, innerCompletableCacheArray));
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        Object object = new InnerCompletableCache(this, completableObserver);
        completableObserver.onSubscribe((Disposable)object);
        if (this.add((InnerCompletableCache)object)) {
            if (object.isDisposed()) {
                this.remove((InnerCompletableCache)object);
            }
            if (!this.once.compareAndSet(false, true)) return;
            this.source.subscribe((CompletableObserver)this);
        } else {
            object = this.error;
            if (object != null) {
                completableObserver.onError((Throwable)object);
            } else {
                completableObserver.onComplete();
            }
        }
    }
}
