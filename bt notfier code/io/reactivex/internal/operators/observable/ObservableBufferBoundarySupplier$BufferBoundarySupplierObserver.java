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
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier$BufferBoundaryObserver
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
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B>
extends QueueDrainObserver<T, U, U>
implements Observer<T>,
Disposable {
    final Callable<? extends ObservableSource<B>> boundarySupplier;
    U buffer;
    final Callable<U> bufferSupplier;
    final AtomicReference<Disposable> other = new AtomicReference();
    Disposable upstream;

    ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.bufferSupplier = callable;
        this.boundarySupplier = callable2;
    }

    public void accept(Observer<? super U> observer, U u) {
        this.downstream.onNext(u);
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.dispose();
        this.disposeOther();
        if (!this.enter()) return;
        this.queue.clear();
    }

    void disposeOther() {
        DisposableHelper.dispose(this.other);
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void next() {
        U u;
        ObservableSource observableSource;
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
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.boundarySupplier.call(), (String)"The boundary ObservableSource supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancelled = true;
            this.upstream.dispose();
            this.downstream.onError(throwable);
            return;
        }
        ObservableBufferBoundarySupplier.BufferBoundaryObserver bufferBoundaryObserver = new ObservableBufferBoundarySupplier.BufferBoundaryObserver(this);
        if (!DisposableHelper.replace(this.other, (Disposable)bufferBoundaryObserver)) return;
        synchronized (this) {
            u = this.buffer;
            if (u == null) {
                return;
            }
            this.buffer = collection;
        }
        observableSource.subscribe((Observer)bufferBoundaryObserver);
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
        block4: {
            Collection collection;
            if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
            this.upstream = disposable;
            Observer observer = this.downstream;
            try {
                collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The buffer supplied is null");
                this.buffer = collection;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancelled = true;
                disposable.dispose();
                EmptyDisposable.error((Throwable)throwable, (Observer)observer);
                break block4;
            }
            try {
                collection = (ObservableSource)ObjectHelper.requireNonNull(this.boundarySupplier.call(), (String)"The boundary ObservableSource supplied is null");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancelled = true;
                disposable.dispose();
                EmptyDisposable.error((Throwable)throwable, (Observer)observer);
                return;
            }
            disposable = new ObservableBufferBoundarySupplier.BufferBoundaryObserver(this);
            this.other.set(disposable);
            observer.onSubscribe((Disposable)this);
            if (this.cancelled) return;
            collection.subscribe((Observer)disposable);
        }
    }
}
