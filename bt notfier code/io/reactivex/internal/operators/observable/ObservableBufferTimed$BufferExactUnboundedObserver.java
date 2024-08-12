/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
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
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableBufferTimed.BufferExactUnboundedObserver<T, U extends Collection<? super T>>
extends QueueDrainObserver<T, U, U>
implements Runnable,
Disposable {
    U buffer;
    final Callable<U> bufferSupplier;
    final Scheduler scheduler;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;

    ObservableBufferTimed.BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long l, TimeUnit timeUnit, Scheduler scheduler) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.timespan = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void accept(Observer<? super U> observer, U u) {
        this.downstream.onNext(u);
    }

    public void dispose() {
        DisposableHelper.dispose(this.timer);
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        boolean bl = this.timer.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void onComplete() {
        // MONITORENTER : this
        U u = this.buffer;
        this.buffer = null;
        // MONITOREXIT : this
        if (u != null) {
            this.queue.offer(u);
            this.done = true;
            if (this.enter()) {
                QueueDrainHelper.drainLoop((SimplePlainQueue)this.queue, (Observer)this.downstream, (boolean)false, null, (ObservableQueueDrain)this);
            }
        }
        DisposableHelper.dispose(this.timer);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onError(Throwable throwable) {
        synchronized (this) {
            this.buffer = null;
        }
        this.downstream.onError(throwable);
        DisposableHelper.dispose(this.timer);
    }

    public void onNext(T t) {
        synchronized (this) {
            U u = this.buffer;
            if (u == null) {
                return;
            }
            u.add(t);
            return;
        }
    }

    public void onSubscribe(Disposable object) {
        block2: {
            if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)object)) return;
            this.upstream = object;
            try {
                object = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
                this.buffer = object;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.dispose();
                EmptyDisposable.error((Throwable)throwable, (Observer)this.downstream);
                break block2;
            }
            this.downstream.onSubscribe((Disposable)this);
            if (this.cancelled) return;
            object = this.scheduler;
            long l = this.timespan;
            if (this.timer.compareAndSet((Disposable)null, (Disposable)(object = object.schedulePeriodicallyDirect((Runnable)this, l, l, this.unit)))) return;
            object.dispose();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    @Override
    public void run() {
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null buffer");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            this.dispose();
            return;
        }
        U u = this.buffer;
        if (u != null) {
            this.buffer = collection;
        }
        // MONITOREXIT : this
        if (u == null) {
            DisposableHelper.dispose(this.timer);
            return;
        }
        this.fastPathEmit(u, false, this);
    }
}
