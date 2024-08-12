/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

static final class BlockingObservableLatest.BlockingObservableLatestIterator<T>
extends DisposableObserver<Notification<T>>
implements Iterator<T> {
    Notification<T> iteratorNotification;
    final Semaphore notify = new Semaphore(0);
    final AtomicReference<Notification<T>> value = new AtomicReference();

    BlockingObservableLatest.BlockingObservableLatestIterator() {
    }

    @Override
    public boolean hasNext() {
        Notification notification = this.iteratorNotification;
        if (notification != null) {
            if (notification.isOnError()) throw ExceptionHelper.wrapOrThrow((Throwable)this.iteratorNotification.getError());
        }
        if (this.iteratorNotification != null) return this.iteratorNotification.isOnNext();
        try {
            BlockingHelper.verifyNonBlocking();
            this.notify.acquire();
        }
        catch (InterruptedException interruptedException) {
            this.dispose();
            this.iteratorNotification = Notification.createOnError((Throwable)interruptedException);
            throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
        }
        this.iteratorNotification = notification = (Notification)this.value.getAndSet(null);
        if (notification.isOnError()) throw ExceptionHelper.wrapOrThrow((Throwable)notification.getError());
        return this.iteratorNotification.isOnNext();
    }

    @Override
    public T next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        Object object = this.iteratorNotification.getValue();
        this.iteratorNotification = null;
        return (T)object;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(Notification<T> notification) {
        boolean bl = this.value.getAndSet(notification) == null;
        if (!bl) return;
        this.notify.release();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Read-only iterator.");
    }
}
