/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableCombineLatest$CombinerObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableCombineLatest.LatestCoordinator<T, R>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = 8567835998786448817L;
    int active;
    volatile boolean cancelled;
    final Function<? super Object[], ? extends R> combiner;
    int complete;
    final boolean delayError;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    Object[] latest;
    final ObservableCombineLatest.CombinerObserver<T, R>[] observers;
    final SpscLinkedArrayQueue<Object[]> queue;

    ObservableCombineLatest.LatestCoordinator(Observer<? super R> combinerObserverArray, Function<? super Object[], ? extends R> function, int n, int n2, boolean bl) {
        this.downstream = combinerObserverArray;
        this.combiner = function;
        this.delayError = bl;
        this.latest = new Object[n];
        combinerObserverArray = new ObservableCombineLatest.CombinerObserver[n];
        int n3 = 0;
        while (true) {
            if (n3 >= n) {
                this.observers = combinerObserverArray;
                this.queue = new SpscLinkedArrayQueue(n2);
                return;
            }
            combinerObserverArray[n3] = new ObservableCombineLatest.CombinerObserver(this, n3);
            ++n3;
        }
    }

    void cancelSources() {
        ObservableCombineLatest.CombinerObserver<T, R>[] combinerObserverArray = this.observers;
        int n = combinerObserverArray.length;
        int n2 = 0;
        while (n2 < n) {
            combinerObserverArray[n2].dispose();
            ++n2;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void clear(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
        synchronized (this) {
            this.latest = null;
        }
        spscLinkedArrayQueue.clear();
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.cancelSources();
        if (this.getAndIncrement() != 0) return;
        this.clear(this.queue);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Object object = this.queue;
        Observer<? super R> observer = this.downstream;
        boolean bl = this.delayError;
        int n = 1;
        while (true) {
            if (this.cancelled) {
                this.clear((SpscLinkedArrayQueue<?>)object);
                return;
            }
            if (!bl && this.errors.get() != null) {
                this.cancelSources();
                this.clear((SpscLinkedArrayQueue<?>)object);
                observer.onError(this.errors.terminate());
                return;
            }
            boolean bl2 = this.done;
            Object object2 = (Object[])object.poll();
            int n2 = object2 == null ? 1 : 0;
            if (bl2 && n2 != 0) {
                this.clear((SpscLinkedArrayQueue<?>)object);
                object = this.errors.terminate();
                if (object == null) {
                    observer.onComplete();
                } else {
                    observer.onError(object);
                }
                return;
            }
            if (n2 != 0) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            try {
                object2 = ObjectHelper.requireNonNull((Object)this.combiner.apply(object2), (String)"The combiner returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.errors.addThrowable(throwable);
                this.cancelSources();
                this.clear((SpscLinkedArrayQueue<?>)object);
                observer.onError(this.errors.terminate());
                return;
            }
            observer.onNext(object2);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    void innerComplete(int n) {
        block10: {
            block9: {
                int n2;
                // MONITORENTER : this
                Object[] objectArray = this.latest;
                if (objectArray == null) {
                    // MONITOREXIT : this
                    return;
                }
                if ((n = objectArray[n] == null ? 1 : 0) != 0) break block9;
                this.complete = n2 = this.complete + 1;
                if (n2 != objectArray.length) break block10;
            }
            this.done = true;
        }
        // MONITOREXIT : this
        if (n != 0) {
            this.cancelSources();
        }
        this.drain();
    }

    void innerError(int n, Throwable objectArray) {
        block14: {
            block10: {
                int n2;
                block11: {
                    block13: {
                        if (!this.errors.addThrowable((Throwable)objectArray)) break block10;
                        boolean bl = this.delayError;
                        n2 = 1;
                        if (!bl) break block11;
                        synchronized (this) {
                            block12: {
                                objectArray = this.latest;
                                if (objectArray == null) {
                                    return;
                                }
                                n = objectArray[n] == null ? 1 : 0;
                                if (n != 0) break block12;
                                this.complete = n2 = this.complete + 1;
                                if (n2 != objectArray.length) break block13;
                            }
                            this.done = true;
                        }
                    }
                    n2 = n;
                }
                if (n2 != 0) {
                    this.cancelSources();
                }
                this.drain();
                break block14;
            }
            RxJavaPlugins.onError((Throwable)objectArray);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void innerNext(int n, T t) {
        synchronized (this) {
            int n2;
            Object[] objectArray = this.latest;
            if (objectArray == null) {
                return;
            }
            Object object = objectArray[n];
            int n3 = n2 = this.active;
            if (object == null) {
                this.active = n3 = n2 + 1;
            }
            objectArray[n] = t;
            if (n3 == objectArray.length) {
                this.queue.offer(objectArray.clone());
                n = 1;
            } else {
                n = 0;
            }
        }
        if (n == 0) return;
        this.drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(ObservableSource<? extends T>[] observableSourceArray) {
        ObservableCombineLatest.CombinerObserver<T, R>[] combinerObserverArray = this.observers;
        int n = combinerObserverArray.length;
        this.downstream.onSubscribe((Disposable)this);
        int n2 = 0;
        while (n2 < n) {
            if (this.done) return;
            if (this.cancelled) {
                return;
            }
            observableSourceArray[n2].subscribe(combinerObserverArray[n2]);
            ++n2;
        }
    }
}
