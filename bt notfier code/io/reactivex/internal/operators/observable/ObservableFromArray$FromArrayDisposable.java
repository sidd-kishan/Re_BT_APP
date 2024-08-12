/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.BasicQueueDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

static final class ObservableFromArray.FromArrayDisposable<T>
extends BasicQueueDisposable<T> {
    final T[] array;
    volatile boolean disposed;
    final Observer<? super T> downstream;
    boolean fusionMode;
    int index;

    ObservableFromArray.FromArrayDisposable(Observer<? super T> observer, T[] TArray) {
        this.downstream = observer;
        this.array = TArray;
    }

    public void clear() {
        this.index = this.array.length;
    }

    public void dispose() {
        this.disposed = true;
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean isEmpty() {
        boolean bl = this.index == this.array.length;
        return bl;
    }

    public T poll() {
        int n = this.index;
        T[] TArray = this.array;
        if (n == TArray.length) return null;
        this.index = n + 1;
        return (T)ObjectHelper.requireNonNull(TArray[n], (String)"The array element is null");
    }

    public int requestFusion(int n) {
        if ((n & 1) == 0) return 0;
        this.fusionMode = true;
        return 1;
    }

    void run() {
        Observer<? super T> observer = this.array;
        int n = ((T[])observer).length;
        for (int i = 0; i < n && !this.isDisposed(); ++i) {
            Object object = observer[i];
            if (object == null) {
                observer = this.downstream;
                object = new StringBuilder();
                ((StringBuilder)object).append("The element at index ");
                ((StringBuilder)object).append(i);
                ((StringBuilder)object).append(" is null");
                observer.onError((Throwable)new NullPointerException(((StringBuilder)object).toString()));
                return;
            }
            this.downstream.onNext(object);
        }
        if (this.isDisposed()) return;
        this.downstream.onComplete();
    }
}
