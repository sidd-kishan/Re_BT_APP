/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.observers.QueueDrainObserver
 *  io.reactivex.internal.operators.observable.ObservableBufferExactBoundary$BufferBoundaryObserver
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.util.ObservableQueueDrain
 *  io.reactivex.internal.util.QueueDrainHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

static final class ObservableBufferExactBoundary.BufferExactBoundaryObserver<T, U extends Collection<? super T>, B>
extends QueueDrainObserver<T, U, U>
implements Observer<T>,
Disposable {
    final ObservableSource<B> boundary;
    U buffer;
    final Callable<U> bufferSupplier;
    Disposable other;
    Disposable upstream;

    ObservableBufferExactBoundary.BufferExactBoundaryObserver(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.boundary = observableSource;
    }

    public void accept(Observer<? super U> observer, U u) {
        this.downstream.onNext(u);
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.other.dispose();
        this.upstream.dispose();
        if (!this.enter()) return;
        this.queue.clear();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void next() {
        U u;
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.dispose();
            this.downstream.onError(throwable);
            return;
        }
        synchronized (this) {
            u = this.buffer;
            if (u == null) {
                return;
            }
            this.buffer = collection;
        }
        this.fastPathEmit(u, false, this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        U u;
        synchronized (this) {
            u = this.buffer;
            if (u == null) {
                return;
            }
            this.buffer = null;
        }
        this.queue.offer(u);
        this.done = true;
        if (!this.enter()) return;
        QueueDrainHelper.drainLoop((SimplePlainQueue)this.queue, (Observer)this.downstream, (boolean)false, (Disposable)this, (ObservableQueueDrain)this);
    }

    public void onError(Throwable throwable) {
        this.dispose();
        this.downstream.onError(throwable);
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
                this.cancelled = true;
                disposable.dispose();
                EmptyDisposable.error((Throwable)throwable, (Observer)this.downstream);
                break block2;
            }
            this.other = disposable = new ObservableBufferExactBoundary.BufferBoundaryObserver(this);
            this.downstream.onSubscribe((Disposable)this);
            if (this.cancelled) return;
            this.boundary.subscribe((Observer)disposable);
        }
    }
}
