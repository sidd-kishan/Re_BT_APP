/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableCache$CacheDisposable
 *  io.reactivex.internal.operators.observable.ObservableCache$Node
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableCache;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T>
extends AbstractObservableWithUpstream<T, T>
implements Observer<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicBoolean once;
    volatile long size;
    Node<T> tail;
    int tailOffset;

    public ObservableCache(Observable<T> node, int n) {
        super(node);
        this.capacityHint = n;
        this.once = new AtomicBoolean();
        this.head = node = new Node(n);
        this.tail = node;
        this.observers = new AtomicReference<CacheDisposable[]>(EMPTY);
    }

    void add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArray;
        CacheDisposable<T>[] cacheDisposableArray2;
        do {
            if ((cacheDisposableArray2 = this.observers.get()) == TERMINATED) {
                return;
            }
            int n = cacheDisposableArray2.length;
            cacheDisposableArray = new CacheDisposable[n + 1];
            System.arraycopy(cacheDisposableArray2, 0, cacheDisposableArray, 0, n);
            cacheDisposableArray[n] = cacheDisposable;
        } while (!this.observers.compareAndSet(cacheDisposableArray2, cacheDisposableArray));
    }

    long cachedEventCount() {
        return this.size;
    }

    boolean hasObservers() {
        boolean bl = this.observers.get().length != 0;
        return bl;
    }

    boolean isConnected() {
        return this.once.get();
    }

    public void onComplete() {
        this.done = true;
        CacheDisposable[] cacheDisposableArray = this.observers.getAndSet(TERMINATED);
        int n = cacheDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.replay(cacheDisposableArray[n2]);
            ++n2;
        }
    }

    public void onError(Throwable cacheDisposableArray) {
        this.error = cacheDisposableArray;
        this.done = true;
        cacheDisposableArray = this.observers.getAndSet(TERMINATED);
        int n = cacheDisposableArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.replay(cacheDisposableArray[n2]);
            ++n2;
        }
    }

    public void onNext(T object) {
        int n = this.tailOffset;
        int n2 = this.capacityHint;
        int n3 = 0;
        if (n == n2) {
            Node node = new Node(n);
            node.values[0] = object;
            this.tailOffset = 1;
            this.tail.next = node;
            this.tail = node;
        } else {
            this.tail.values[n] = object;
            this.tailOffset = n + 1;
        }
        ++this.size;
        object = this.observers.get();
        n = ((T)object).length;
        while (n3 < n) {
            this.replay((CacheDisposable<T>)object[n3]);
            ++n3;
        }
    }

    public void onSubscribe(Disposable disposable) {
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

    void replay(CacheDisposable<T> object) {
        if (object.getAndIncrement() != 0) {
            return;
        }
        long l = object.index;
        int n = object.offset;
        Node node = object.node;
        Observer observer = object.downstream;
        int n2 = this.capacityHint;
        int n3 = 1;
        while (true) {
            if (object.disposed) {
                object.node = null;
                return;
            }
            boolean bl = this.done;
            int n4 = this.size == l ? 1 : 0;
            if (bl && n4 != 0) {
                object.node = null;
                object = this.error;
                if (object != null) {
                    observer.onError(object);
                } else {
                    observer.onComplete();
                }
                return;
            }
            if (n4 == 0) {
                n4 = n;
                Node node2 = node;
                if (n == n2) {
                    node2 = node.next;
                    n4 = 0;
                }
                observer.onNext(node2.values[n4]);
                n = n4 + 1;
                ++l;
                node = node2;
                continue;
            }
            object.index = l;
            object.offset = n;
            object.node = node;
            n3 = n4 = object.addAndGet(-n3);
            if (n4 == 0) return;
        }
    }

    protected void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe((Disposable)cacheDisposable);
        this.add(cacheDisposable);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.source.subscribe((Observer)this);
        } else {
            this.replay(cacheDisposable);
        }
    }
}
