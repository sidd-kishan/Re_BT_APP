/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver$BufferOpenObserver
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableBufferBoundary.BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -8466418554264089604L;
    final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
    final ObservableSource<? extends Open> bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super C> downstream;
    final AtomicThrowable errors;
    long index;
    final CompositeDisposable observers;
    final SpscLinkedArrayQueue<C> queue;
    final AtomicReference<Disposable> upstream;

    ObservableBufferBoundary.BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
        this.downstream = observer;
        this.bufferSupplier = callable;
        this.bufferOpen = observableSource;
        this.bufferClose = function;
        this.queue = new SpscLinkedArrayQueue(Observable.bufferSize());
        this.observers = new CompositeDisposable();
        this.upstream = new AtomicReference();
        this.buffers = new LinkedHashMap<Long, C>();
        this.errors = new AtomicThrowable();
    }

    void boundaryError(Disposable disposable, Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        this.observers.delete(disposable);
        this.onError(throwable);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    void close(ObservableBufferBoundary.BufferCloseObserver<T, C> bufferCloseObserver, long l) {
        boolean bl;
        this.observers.delete(bufferCloseObserver);
        if (this.observers.size() == 0) {
            DisposableHelper.dispose(this.upstream);
            bl = true;
        } else {
            bl = false;
        }
        // MONITORENTER : this
        if (this.buffers == null) {
            // MONITOREXIT : this
            return;
        }
        this.queue.offer(this.buffers.remove(l));
        // MONITOREXIT : this
        if (bl) {
            this.done = true;
        }
        this.drain();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void dispose() {
        if (!DisposableHelper.dispose(this.upstream)) return;
        this.cancelled = true;
        this.observers.dispose();
        synchronized (this) {
            this.buffers = null;
        }
        if (this.getAndIncrement() == 0) return;
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super C> observer = this.downstream;
        SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
        int n = 1;
        while (true) {
            if (this.cancelled) {
                spscLinkedArrayQueue.clear();
                return;
            }
            boolean bl = this.done;
            if (bl && this.errors.get() != null) {
                spscLinkedArrayQueue.clear();
                observer.onError(this.errors.terminate());
                return;
            }
            Collection collection = (Collection)spscLinkedArrayQueue.poll();
            int n2 = collection == null ? 1 : 0;
            if (bl && n2 != 0) {
                observer.onComplete();
                return;
            }
            if (n2 != 0) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            observer.onNext((Object)collection);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void onComplete() {
        this.observers.dispose();
        synchronized (this) {
            Object object = this.buffers;
            if (object == null) {
                return;
            }
            object = object.values().iterator();
            while (true) {
                if (!object.hasNext()) {
                    this.buffers = null;
                    // MONITOREXIT @DISABLED, blocks:[0, 2, 4, 5] lbl12 : MonitorExitStatement: MONITOREXIT : this
                    this.done = true;
                    this.drain();
                    return;
                }
                Collection collection = (Collection)object.next();
                this.queue.offer((Object)collection);
            }
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            this.observers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            this.drain();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(T t) {
        synchronized (this) {
            try {
                Object object = this.buffers;
                if (object == null) {
                    return;
                }
                object = object.values().iterator();
                while (object.hasNext()) {
                    ((Collection)object.next()).add(t);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce(this.upstream, (Disposable)disposable)) return;
        disposable = new BufferOpenObserver(this);
        this.observers.add(disposable);
        this.bufferOpen.subscribe((Observer)disposable);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void open(Open object) {
        long l;
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), (String)"The bufferSupplier returned a null Collection");
            object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.bufferClose.apply(object), (String)"The bufferClose returned a null ObservableSource");
            l = this.index;
            this.index = 1L + l;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            DisposableHelper.dispose(this.upstream);
            this.onError(throwable);
            return;
        }
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map == null) {
                return;
            }
            map.put(l, collection);
        }
        collection = new ObservableBufferBoundary.BufferCloseObserver(this, l);
        this.observers.add((Disposable)collection);
        object.subscribe((Observer)collection);
    }

    void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
        this.observers.delete(bufferOpenObserver);
        if (this.observers.size() != 0) return;
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        this.drain();
    }
}
