/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableSwitchMap.SwitchMapInnerObserver<T, R>
extends AtomicReference<Disposable>
implements Observer<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    final long index;
    final ObservableSwitchMap.SwitchMapObserver<T, R> parent;
    volatile SimpleQueue<R> queue;

    ObservableSwitchMap.SwitchMapInnerObserver(ObservableSwitchMap.SwitchMapObserver<T, R> switchMapObserver, long l, int n) {
        this.parent = switchMapObserver;
        this.index = l;
        this.bufferSize = n;
    }

    public void cancel() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        if (this.index != this.parent.unique) return;
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onNext(R r) {
        if (this.index != this.parent.unique) return;
        if (r != null) {
            this.queue.offer(r);
        }
        this.parent.drain();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        if (disposable instanceof QueueDisposable) {
            int n = (disposable = (QueueDisposable)disposable).requestFusion(7);
            if (n == 1) {
                this.queue = disposable;
                this.done = true;
                this.parent.drain();
                return;
            }
            if (n == 2) {
                this.queue = disposable;
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue(this.bufferSize);
    }
}
