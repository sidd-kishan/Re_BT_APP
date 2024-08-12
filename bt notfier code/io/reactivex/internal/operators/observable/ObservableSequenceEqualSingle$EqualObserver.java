/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;

static final class ObservableSequenceEqualSingle.EqualObserver<T>
implements Observer<T> {
    volatile boolean done;
    Throwable error;
    final int index;
    final ObservableSequenceEqualSingle.EqualCoordinator<T> parent;
    final SpscLinkedArrayQueue<T> queue;

    ObservableSequenceEqualSingle.EqualObserver(ObservableSequenceEqualSingle.EqualCoordinator<T> equalCoordinator, int n, int n2) {
        this.parent = equalCoordinator;
        this.index = n;
        this.queue = new SpscLinkedArrayQueue(n2);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.parent.drain();
    }

    public void onNext(T t) {
        this.queue.offer(t);
        this.parent.drain();
    }

    public void onSubscribe(Disposable disposable) {
        this.parent.setDisposable(disposable, this.index);
    }
}
