/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.disposables.ArrayCompositeDisposable
 *  io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableSequenceEqualSingle.EqualCoordinator<T>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = -6178010334400373240L;
    volatile boolean cancelled;
    final BiPredicate<? super T, ? super T> comparer;
    final SingleObserver<? super Boolean> downstream;
    final ObservableSource<? extends T> first;
    final ObservableSequenceEqualSingle.EqualObserver<T>[] observers;
    final ArrayCompositeDisposable resources;
    final ObservableSource<? extends T> second;
    T v1;
    T v2;

    ObservableSequenceEqualSingle.EqualCoordinator(SingleObserver<? super Boolean> equalObserverArray, int n, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.downstream = equalObserverArray;
        this.first = observableSource;
        this.second = observableSource2;
        this.comparer = biPredicate;
        equalObserverArray = new ObservableSequenceEqualSingle.EqualObserver[2];
        this.observers = equalObserverArray;
        equalObserverArray[0] = new ObservableSequenceEqualSingle.EqualObserver(this, 0, n);
        equalObserverArray[1] = new ObservableSequenceEqualSingle.EqualObserver(this, 1, n);
        this.resources = new ArrayCompositeDisposable(2);
    }

    void cancel(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
        this.cancelled = true;
        spscLinkedArrayQueue.clear();
        spscLinkedArrayQueue2.clear();
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.resources.dispose();
        if (this.getAndIncrement() != 0) return;
        ObservableSequenceEqualSingle.EqualObserver<T>[] equalObserverArray = this.observers;
        equalObserverArray[0].queue.clear();
        equalObserverArray[1].queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.observers;
        ObservableSequenceEqualSingle.EqualObserver<T> equalObserver = spscLinkedArrayQueue[0];
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = equalObserver.queue;
        ObservableSequenceEqualSingle.EqualObserver<T> equalObserver2 = spscLinkedArrayQueue[1];
        spscLinkedArrayQueue = equalObserver2.queue;
        int n = 1;
        while (true) {
            Throwable throwable;
            if (this.cancelled) {
                spscLinkedArrayQueue2.clear();
                spscLinkedArrayQueue.clear();
                return;
            }
            boolean bl = equalObserver.done;
            if (bl && (throwable = equalObserver.error) != null) {
                this.cancel(spscLinkedArrayQueue2, spscLinkedArrayQueue);
                this.downstream.onError(throwable);
                return;
            }
            boolean bl2 = equalObserver2.done;
            if (bl2 && (throwable = equalObserver2.error) != null) {
                this.cancel(spscLinkedArrayQueue2, spscLinkedArrayQueue);
                this.downstream.onError(throwable);
                return;
            }
            if (this.v1 == null) {
                this.v1 = spscLinkedArrayQueue2.poll();
            }
            int n2 = this.v1 == null ? 1 : 0;
            if (this.v2 == null) {
                this.v2 = spscLinkedArrayQueue.poll();
            }
            int n3 = this.v2 == null;
            if (bl && bl2 && n2 != 0 && n3) {
                this.downstream.onSuccess((Object)true);
                return;
            }
            if (bl && bl2 && n2 != n3) {
                this.cancel(spscLinkedArrayQueue2, spscLinkedArrayQueue);
                this.downstream.onSuccess((Object)false);
                return;
            }
            if (n2 == 0 && !n3) {
                block12: {
                    try {
                        bl2 = this.comparer.test(this.v1, this.v2);
                        if (bl2) break block12;
                        this.cancel(spscLinkedArrayQueue2, spscLinkedArrayQueue);
                    }
                    catch (Throwable throwable2) {
                        Exceptions.throwIfFatal((Throwable)throwable2);
                        this.cancel(spscLinkedArrayQueue2, spscLinkedArrayQueue);
                        this.downstream.onError(throwable2);
                        return;
                    }
                    this.downstream.onSuccess((Object)false);
                    return;
                }
                this.v1 = null;
                this.v2 = null;
            }
            if (n2 == 0 && !n3) continue;
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    boolean setDisposable(Disposable disposable, int n) {
        return this.resources.setResource(n, disposable);
    }

    void subscribe() {
        ObservableSequenceEqualSingle.EqualObserver<T>[] equalObserverArray = this.observers;
        this.first.subscribe(equalObserverArray[0]);
        this.second.subscribe(equalObserverArray[1]);
    }
}
