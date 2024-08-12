/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.util.NotificationLite
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    public void dispose() {
        if (!DisposableHelper.dispose((AtomicReference)this)) return;
        this.queue.offer(TERMINATED);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    public void onError(Throwable throwable) {
        this.queue.offer(NotificationLite.error((Throwable)throwable));
    }

    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
