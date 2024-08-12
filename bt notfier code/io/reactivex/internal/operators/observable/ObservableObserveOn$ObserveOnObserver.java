/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableObserveOn.ObserveOnObserver<T>
extends BasicIntQueueDisposable<T>
implements Observer<T>,
Runnable {
    private static final long serialVersionUID = 6576896619930983584L;
    final int bufferSize;
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    final Observer<? super T> downstream;
    Throwable error;
    boolean outputFused;
    SimpleQueue<T> queue;
    int sourceMode;
    Disposable upstream;
    final Scheduler.Worker worker;

    ObservableObserveOn.ObserveOnObserver(Observer<? super T> observer, Scheduler.Worker worker, boolean bl, int n) {
        this.downstream = observer;
        this.worker = worker;
        this.delayError = bl;
        this.bufferSize = n;
    }

    boolean checkTerminated(boolean bl, boolean bl2, Observer<? super T> observer) {
        if (this.disposed) {
            this.queue.clear();
            return true;
        }
        if (!bl) return false;
        Throwable throwable = this.error;
        if (this.delayError) {
            if (!bl2) return false;
            this.disposed = true;
            if (throwable != null) {
                observer.onError(throwable);
            } else {
                observer.onComplete();
            }
            this.worker.dispose();
            return true;
        }
        if (throwable != null) {
            this.disposed = true;
            this.queue.clear();
            observer.onError(throwable);
            this.worker.dispose();
            return true;
        }
        if (!bl2) return false;
        this.disposed = true;
        observer.onComplete();
        this.worker.dispose();
        return true;
    }

    public void clear() {
        this.queue.clear();
    }

    public void dispose() {
        if (this.disposed) return;
        this.disposed = true;
        this.upstream.dispose();
        this.worker.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drainFused() {
        int n;
        int n2 = 1;
        do {
            if (this.disposed) {
                return;
            }
            boolean bl = this.done;
            Throwable throwable = this.error;
            if (!this.delayError && bl && throwable != null) {
                this.disposed = true;
                this.downstream.onError(this.error);
                this.worker.dispose();
                return;
            }
            this.downstream.onNext(null);
            if (bl) {
                this.disposed = true;
                throwable = this.error;
                if (throwable != null) {
                    this.downstream.onError(throwable);
                } else {
                    this.downstream.onComplete();
                }
                this.worker.dispose();
                return;
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    void drainNormal() {
        SimpleQueue<T> simpleQueue = this.queue;
        Observer<? super T> observer = this.downstream;
        int n = 1;
        block2: while (!this.checkTerminated(this.done, simpleQueue.isEmpty(), observer)) {
            while (true) {
                Object object;
                block6: {
                    int n2;
                    boolean bl = this.done;
                    try {
                        object = simpleQueue.poll();
                        boolean bl2 = object == null;
                        if (this.checkTerminated(bl, bl2, observer)) {
                            return;
                        }
                        if (!bl2) break block6;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.disposed = true;
                        this.upstream.dispose();
                        simpleQueue.clear();
                        observer.onError(throwable);
                        this.worker.dispose();
                        return;
                    }
                    n = n2 = this.addAndGet(-n);
                    if (n2 != 0) continue block2;
                    return;
                }
                observer.onNext(object);
            }
            break;
        }
        return;
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.schedule();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.schedule();
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 2) {
            this.queue.offer(t);
        }
        this.schedule();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        if (disposable instanceof QueueDisposable) {
            int n = (disposable = (QueueDisposable)disposable).requestFusion(7);
            if (n == 1) {
                this.sourceMode = n;
                this.queue = disposable;
                this.done = true;
                this.downstream.onSubscribe((Disposable)this);
                this.schedule();
                return;
            }
            if (n == 2) {
                this.sourceMode = n;
                this.queue = disposable;
                this.downstream.onSubscribe((Disposable)this);
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue(this.bufferSize);
        this.downstream.onSubscribe((Disposable)this);
    }

    public T poll() throws Exception {
        return (T)this.queue.poll();
    }

    public int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.outputFused = true;
        return 2;
    }

    @Override
    public void run() {
        if (this.outputFused) {
            this.drainFused();
        } else {
            this.drainNormal();
        }
    }

    void schedule() {
        if (this.getAndIncrement() != 0) return;
        this.worker.schedule((Runnable)this);
    }
}
