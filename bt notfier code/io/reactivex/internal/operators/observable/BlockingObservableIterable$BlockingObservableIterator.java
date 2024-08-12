/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

static final class BlockingObservableIterable.BlockingObservableIterator<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Iterator<T>,
Disposable {
    private static final long serialVersionUID = 6695226475494099826L;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final Lock lock;
    final SpscLinkedArrayQueue<T> queue;

    BlockingObservableIterable.BlockingObservableIterator(int n) {
        this.queue = new SpscLinkedArrayQueue(n);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    @Override
    public boolean hasNext() {
        block6: while (true) {
            boolean bl = this.done;
            boolean bl2 = this.queue.isEmpty();
            if (bl) {
                Throwable throwable = this.error;
                if (throwable != null) throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
                if (bl2) {
                    return false;
                }
            }
            if (!bl2) return true;
            try {
                BlockingHelper.verifyNonBlocking();
                this.lock.lock();
            }
            catch (InterruptedException interruptedException) {
                DisposableHelper.dispose((AtomicReference)this);
                this.signalConsumer();
                throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
            }
            try {
                while (true) {
                    if (this.done || !this.queue.isEmpty()) continue block6;
                    this.condition.await();
                }
            }
            finally {
                this.lock.unlock();
                continue;
            }
            break;
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    @Override
    public T next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        return (T)this.queue.poll();
    }

    public void onComplete() {
        this.done = true;
        this.signalConsumer();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.signalConsumer();
    }

    public void onNext(T t) {
        this.queue.offer(t);
        this.signalConsumer();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    void signalConsumer() {
        this.lock.lock();
        try {
            this.condition.signalAll();
            return;
        }
        finally {
            this.lock.unlock();
        }
    }
}
