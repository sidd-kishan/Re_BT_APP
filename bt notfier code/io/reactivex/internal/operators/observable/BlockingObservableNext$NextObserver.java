/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

static final class BlockingObservableNext.NextObserver<T>
extends DisposableObserver<Notification<T>> {
    private final BlockingQueue<Notification<T>> buf = new ArrayBlockingQueue<Notification<T>>(1);
    final AtomicInteger waiting = new AtomicInteger();

    BlockingObservableNext.NextObserver() {
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(Notification<T> notification) {
        Notification notification2 = notification;
        if (this.waiting.getAndSet(0) != 1) {
            if (notification.isOnNext()) return;
            notification2 = notification;
        }
        while (!this.buf.offer(notification2)) {
            notification = (Notification)this.buf.poll();
            if (notification == null || notification.isOnNext()) continue;
            notification2 = notification;
        }
    }

    void setWaiting() {
        this.waiting.set(1);
    }

    public Notification<T> takeNext() throws InterruptedException {
        this.setWaiting();
        BlockingHelper.verifyNonBlocking();
        return this.buf.take();
    }
}
