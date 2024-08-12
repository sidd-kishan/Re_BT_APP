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
 *  io.reactivex.internal.operators.observable.ObservableZip$ZipObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableZip;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableZip.ZipCoordinator<T, R>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = 2983708048395377667L;
    volatile boolean cancelled;
    final boolean delayError;
    final Observer<? super R> downstream;
    final ObservableZip.ZipObserver<T, R>[] observers;
    final T[] row;
    final Function<? super Object[], ? extends R> zipper;

    ObservableZip.ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int n, boolean bl) {
        this.downstream = observer;
        this.zipper = function;
        this.observers = new ObservableZip.ZipObserver[n];
        this.row = new Object[n];
        this.delayError = bl;
    }

    void cancel() {
        this.clear();
        this.cancelSources();
    }

    void cancelSources() {
        ObservableZip.ZipObserver<T, R>[] zipObserverArray = this.observers;
        int n = zipObserverArray.length;
        int n2 = 0;
        while (n2 < n) {
            zipObserverArray[n2].dispose();
            ++n2;
        }
    }

    boolean checkTerminated(boolean bl, boolean bl2, Observer<? super R> observer, boolean bl3, ObservableZip.ZipObserver<?, ?> object) {
        if (this.cancelled) {
            this.cancel();
            return true;
        }
        if (!bl) return false;
        if (bl3) {
            if (!bl2) return false;
            object = object.error;
            this.cancelled = true;
            this.cancel();
            if (object != null) {
                observer.onError(object);
            } else {
                observer.onComplete();
            }
            return true;
        }
        object = object.error;
        if (object != null) {
            this.cancelled = true;
            this.cancel();
            observer.onError(object);
            return true;
        }
        if (!bl2) return false;
        this.cancelled = true;
        this.cancel();
        observer.onComplete();
        return true;
    }

    void clear() {
        ObservableZip.ZipObserver<T, R>[] zipObserverArray = this.observers;
        int n = zipObserverArray.length;
        int n2 = 0;
        while (n2 < n) {
            zipObserverArray[n2].queue.clear();
            ++n2;
        }
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.cancelSources();
        if (this.getAndIncrement() != 0) return;
        this.clear();
    }

    public void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        ObservableZip.ZipObserver<T, R>[] zipObserverArray = this.observers;
        Observer<? super R> observer = this.downstream;
        Object[] objectArray = this.row;
        boolean bl = this.delayError;
        int n = 1;
        while (true) {
            Object object;
            int n2 = zipObserverArray.length;
            int n3 = 0;
            int n4 = 0;
            for (int i = 0; i < n2; ++n4, ++i) {
                int n5;
                ObservableZip.ZipObserver<T, R> zipObserver = zipObserverArray[i];
                if (objectArray[n4] == null) {
                    boolean bl2 = zipObserver.done;
                    object = zipObserver.queue.poll();
                    boolean bl3 = object == null;
                    if (this.checkTerminated(bl2, bl3, observer, bl, zipObserver)) {
                        return;
                    }
                    if (!bl3) {
                        objectArray[n4] = object;
                        n5 = n3;
                    } else {
                        n5 = n3 + 1;
                    }
                } else {
                    n5 = n3;
                    if (zipObserver.done) {
                        n5 = n3;
                        if (!bl) {
                            object = zipObserver.error;
                            n5 = n3;
                            if (object != null) {
                                this.cancelled = true;
                                this.cancel();
                                observer.onError((Throwable)object);
                                return;
                            }
                        }
                    }
                }
                n3 = n5;
            }
            if (n3 != 0) {
                n = n4 = this.addAndGet(-n);
                if (n4 != 0) continue;
                return;
            }
            try {
                object = ObjectHelper.requireNonNull((Object)this.zipper.apply(objectArray.clone()), (String)"The zipper returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancel();
                observer.onError(throwable);
                return;
            }
            observer.onNext(object);
            Arrays.fill(objectArray, null);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(ObservableSource<? extends T>[] observableSourceArray, int n) {
        ObservableZip.ZipObserver<T, R>[] zipObserverArray = this.observers;
        int n2 = zipObserverArray.length;
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            zipObserverArray[i] = new ObservableZip.ZipObserver(this, n);
        }
        this.lazySet(0);
        this.downstream.onSubscribe((Disposable)this);
        n = n3;
        while (n < n2) {
            if (this.cancelled) {
                return;
            }
            observableSourceArray[n].subscribe(zipObserverArray[n]);
            ++n;
        }
    }
}
