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
 *  io.reactivex.internal.operators.observable.ObservableBufferTimed$BufferSkipBoundedObserver$RemoveFromBuffer
 *  io.reactivex.internal.operators.observable.ObservableBufferTimed$BufferSkipBoundedObserver$RemoveFromBufferEmit
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
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

static final class ObservableBufferTimed.BufferSkipBoundedObserver<T, U extends Collection<? super T>>
extends QueueDrainObserver<T, U, U>
implements Runnable,
Disposable {
    final Callable<U> bufferSupplier;
    final List<U> buffers;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker w;

    ObservableBufferTimed.BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long l, long l2, TimeUnit timeUnit, Scheduler.Worker worker) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.w = worker;
        this.buffers = new LinkedList<U>();
    }

    static /* synthetic */ void access$000(ObservableBufferTimed.BufferSkipBoundedObserver bufferSkipBoundedObserver, Object object, boolean bl, Disposable disposable) {
        bufferSkipBoundedObserver.fastPathOrderedEmit(object, bl, disposable);
    }

    static /* synthetic */ void access$100(ObservableBufferTimed.BufferSkipBoundedObserver bufferSkipBoundedObserver, Object object, boolean bl, Disposable disposable) {
        bufferSkipBoundedObserver.fastPathOrderedEmit(object, bl, disposable);
    }

    public void accept(Observer<? super U> observer, U u) {
        observer.onNext(u);
    }

    void clear() {
        synchronized (this) {
            this.buffers.clear();
            return;
        }
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.clear();
        this.upstream.dispose();
        this.w.dispose();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        Object object;
        synchronized (this) {
            object = new ArrayList(this.buffers);
            this.buffers.clear();
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl5 : MonitorExitStatement: MONITOREXIT : this
            object = object.iterator();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (true) {
            if (!object.hasNext()) {
                this.done = true;
                if (!this.enter()) return;
                QueueDrainHelper.drainLoop((SimplePlainQueue)this.queue, (Observer)this.downstream, (boolean)false, (Disposable)this.w, (ObservableQueueDrain)this);
                return;
            }
            Collection collection = (Collection)object.next();
            this.queue.offer((Object)collection);
        }
    }

    public void onError(Throwable throwable) {
        this.done = true;
        this.clear();
        this.downstream.onError(throwable);
        this.w.dispose();
    }

    public void onNext(T t) {
        synchronized (this) {
            try {
                Iterator<U> iterator = this.buffers.iterator();
                while (iterator.hasNext()) {
                    ((Collection)iterator.next()).add(t);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        block2: {
            Collection collection;
            if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
            this.upstream = disposable;
            try {
                collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
                this.buffers.add(collection);
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
            long l = this.timeskip;
            disposable.schedulePeriodically((Runnable)this, l, l, this.unit);
            this.w.schedule((Runnable)new RemoveFromBufferEmit(this, collection), this.timespan, this.unit);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        Collection collection;
        if (this.cancelled) {
            return;
        }
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null buffer");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            this.dispose();
            return;
        }
        synchronized (this) {
            if (this.cancelled) {
                return;
            }
            this.buffers.add(collection);
        }
        this.w.schedule((Runnable)new RemoveFromBuffer(this, collection), this.timespan, this.unit);
    }
}
