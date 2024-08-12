/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.MaybeCache$CacheDisposable
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.MaybeCache;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache<T>
extends Maybe<T>
implements MaybeObserver<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    Throwable error;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicReference<MaybeSource<T>> source;
    T value;

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.source = new AtomicReference<MaybeSource<T>>(maybeSource);
        this.observers = new AtomicReference<CacheDisposable[]>(EMPTY);
    }

    boolean add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArray;
        CacheDisposable<T>[] cacheDisposableArray2;
        do {
            if ((cacheDisposableArray2 = this.observers.get()) == TERMINATED) {
                return false;
            }
            int n = cacheDisposableArray2.length;
            cacheDisposableArray = new CacheDisposable[n + 1];
            System.arraycopy(cacheDisposableArray2, 0, cacheDisposableArray, 0, n);
            cacheDisposableArray[n] = cacheDisposable;
        } while (!this.observers.compareAndSet(cacheDisposableArray2, cacheDisposableArray));
        return true;
    }

    public void onComplete() {
        CacheDisposable[] cacheDisposableArray = this.observers.getAndSet(TERMINATED);
        int n = cacheDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            CacheDisposable cacheDisposable = cacheDisposableArray[n2];
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
            ++n2;
        }
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        CacheDisposable[] cacheDisposableArray = this.observers.getAndSet(TERMINATED);
        int n = cacheDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            CacheDisposable cacheDisposable = cacheDisposableArray[n2];
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(throwable);
            }
            ++n2;
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void onSuccess(T t) {
        this.value = t;
        CacheDisposable[] cacheDisposableArray = this.observers.getAndSet(TERMINATED);
        int n = cacheDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            CacheDisposable cacheDisposable = cacheDisposableArray[n2];
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
            ++n2;
        }
    }

    void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArray;
        CacheDisposable<T>[] cacheDisposableArray2;
        do {
            int n;
            int n2;
            if ((n2 = (cacheDisposableArray2 = this.observers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (cacheDisposableArray2[n4] == cacheDisposable) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                cacheDisposableArray = EMPTY;
                continue;
            }
            cacheDisposableArray = new CacheDisposable[n2 - 1];
            System.arraycopy(cacheDisposableArray2, 0, cacheDisposableArray, 0, n);
            System.arraycopy(cacheDisposableArray2, n + 1, cacheDisposableArray, n, n2 - n - 1);
        } while (!this.observers.compareAndSet(cacheDisposableArray2, cacheDisposableArray));
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeSource) {
        Object object = new CacheDisposable(maybeSource, this);
        maybeSource.onSubscribe((Disposable)object);
        if (this.add((CacheDisposable<T>)object)) {
            if (object.isDisposed()) {
                this.remove((CacheDisposable<T>)object);
                return;
            }
            maybeSource = this.source.getAndSet(null);
            if (maybeSource == null) return;
            maybeSource.subscribe((MaybeObserver)this);
            return;
        }
        if (object.isDisposed()) return;
        object = this.error;
        if (object != null) {
            maybeSource.onError((Throwable)object);
        } else {
            object = this.value;
            if (object != null) {
                maybeSource.onSuccess(object);
            } else {
                maybeSource.onComplete();
            }
        }
    }
}
