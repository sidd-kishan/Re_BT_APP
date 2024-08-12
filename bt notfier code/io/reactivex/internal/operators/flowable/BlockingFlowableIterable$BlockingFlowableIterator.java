/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

static final class BlockingFlowableIterable.BlockingFlowableIterator<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T>,
Iterator<T>,
Runnable,
Disposable {
    private static final long serialVersionUID = 6695226475494099826L;
    final long batchSize;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final long limit;
    final Lock lock;
    long produced;
    final SpscArrayQueue<T> queue;

    BlockingFlowableIterable.BlockingFlowableIterator(int n) {
        this.queue = new SpscArrayQueue(n);
        this.batchSize = n;
        this.limit = n - (n >> 2);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    public boolean hasNext() {
        Throwable throwable3222222;
        while (true) {
            boolean bl = this.done;
            boolean bl2 = this.queue.isEmpty();
            if (bl) {
                Throwable throwable2 = this.error;
                if (throwable2 != null) throw ExceptionHelper.wrapOrThrow((Throwable)throwable2);
                if (bl2) {
                    return false;
                }
            }
            if (!bl2) return true;
            BlockingHelper.verifyNonBlocking();
            this.lock.lock();
            while (!this.done && this.queue.isEmpty()) {
                this.condition.await();
            }
            this.lock.unlock();
            continue;
            {
                catch (Throwable throwable3222222) {
                    break;
                }
                catch (InterruptedException interruptedException) {}
                {
                    this.run();
                    throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
                }
            }
        }
        this.lock.unlock();
        throw throwable3222222;
    }

    public boolean isDisposed() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    @Override
    public T next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        Object object = this.queue.poll();
        long l = this.produced + 1L;
        if (l == this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
        return (T)object;
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
        if (!this.queue.offer(t)) {
            SubscriptionHelper.cancel((AtomicReference)this);
            this.onError((Throwable)new MissingBackpressureException("Queue full?!"));
        } else {
            this.signalConsumer();
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)this.batchSize);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public void run() {
        SubscriptionHelper.cancel((AtomicReference)this);
        this.signalConsumer();
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
