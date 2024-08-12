/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.observers.QueueDrainObserver
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.util.ObservableQueueDrain
 *  io.reactivex.internal.util.QueueDrainHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

static final class ObservableBufferTimed.BufferExactBoundedObserver<T, U extends Collection<? super T>>
extends QueueDrainObserver<T, U, U>
implements Runnable,
Disposable {
    U buffer;
    final Callable<U> bufferSupplier;
    long consumerIndex;
    final int maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    Disposable timer;
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker w;

    ObservableBufferTimed.BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long l, TimeUnit timeUnit, int n, boolean bl, Scheduler.Worker worker) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.timespan = l;
        this.unit = timeUnit;
        this.maxSize = n;
        this.restartTimerOnMaxSize = bl;
        this.w = worker;
    }

    public void accept(Observer<? super U> observer, U u) {
        observer.onNext(u);
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.dispose();
        this.w.dispose();
        synchronized (this) {
            this.buffer = null;
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        U u;
        this.w.dispose();
        synchronized (this) {
            u = this.buffer;
            this.buffer = null;
        }
        if (u == null) return;
        this.queue.offer(u);
        this.done = true;
        if (!this.enter()) return;
        QueueDrainHelper.drainLoop((SimplePlainQueue)this.queue, (Observer)this.downstream, (boolean)false, (Disposable)this, (ObservableQueueDrain)this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onError(Throwable throwable) {
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(throwable);
        this.w.dispose();
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void onNext(T object) {
        // MONITORENTER : this
        U u = this.buffer;
        if (u == null) {
            // MONITOREXIT : this
            return;
        }
        u.add(object);
        if (u.size() < this.maxSize) {
            // MONITOREXIT : this
            return;
        }
        this.buffer = null;
        ++this.producerIndex;
        // MONITOREXIT : this
        if (this.restartTimerOnMaxSize) {
            this.timer.dispose();
        }
        this.fastPathOrderedEmit(u, false, this);
        try {
            object = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            this.dispose();
            return;
        }
        this.buffer = object;
        ++this.consumerIndex;
        // MONITOREXIT : this
        if (!this.restartTimerOnMaxSize) return;
        object = this.w;
        long l = this.timespan;
        this.timer = object.schedulePeriodically((Runnable)this, l, l, this.unit);
    }

    public void onSubscribe(Disposable disposable) {
        block2: {
            if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
            this.upstream = disposable;
            try {
                Collection collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
                this.buffer = collection;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                disposable.dispose();
                EmptyDisposable.error((Throwable)throwable, (Observer)this.downstream);
                this.w.dispose();
                break block2;
            }
            this.downstream.onSubscribe((Disposable)this);
            disposable = this.w;
            long l = this.timespan;
            this.timer = disposable.schedulePeriodically((Runnable)this, l, l, this.unit);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        U u;
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null buffer");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.dispose();
            this.downstream.onError(throwable);
            return;
        }
        synchronized (this) {
            u = this.buffer;
            if (u == null) return;
            if (this.producerIndex != this.consumerIndex) {
                return;
            }
            this.buffer = collection;
        }
        this.fastPathOrderedEmit(u, false, this);
    }
}
