/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.observers.InnerQueuedObserverSupport
 *  io.reactivex.internal.util.QueueDrainHelper
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final InnerQueuedObserverSupport<T> parent;
    final int prefetch;
    SimpleQueue<T> queue;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int n) {
        this.parent = innerQueuedObserverSupport;
        this.prefetch = n;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public boolean isDone() {
        return this.done;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        if (disposable instanceof QueueDisposable) {
            int n = (disposable = (QueueDisposable)disposable).requestFusion(3);
            if (n == 1) {
                this.fusionMode = n;
                this.queue = disposable;
                this.done = true;
                this.parent.innerComplete(this);
                return;
            }
            if (n == 2) {
                this.fusionMode = n;
                this.queue = disposable;
                return;
            }
        }
        this.queue = QueueDrainHelper.createQueue((int)(-this.prefetch));
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
