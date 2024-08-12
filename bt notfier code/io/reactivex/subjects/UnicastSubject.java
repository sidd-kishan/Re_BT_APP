/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.Subject
 *  io.reactivex.subjects.UnicastSubject$UnicastQueueDisposable
 */
package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T>
extends Subject<T> {
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    final AtomicReference<Observer<? super T>> downstream;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final BasicIntQueueDisposable<T> wip;

    UnicastSubject(int n, Runnable runnable) {
        this(n, runnable, true);
    }

    UnicastSubject(int n, Runnable runnable, boolean bl) {
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive((int)n, (String)"capacityHint"));
        this.onTerminate = new AtomicReference<Object>(ObjectHelper.requireNonNull((Object)runnable, (String)"onTerminate"));
        this.delayError = bl;
        this.downstream = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable(this);
    }

    UnicastSubject(int n, boolean bl) {
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive((int)n, (String)"capacityHint"));
        this.onTerminate = new AtomicReference();
        this.delayError = bl;
        this.downstream = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueDisposable(this);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<T>(UnicastSubject.bufferSize(), true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int n) {
        return new UnicastSubject<T>(n, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int n, Runnable runnable) {
        return new UnicastSubject<T>(n, runnable, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int n, Runnable runnable, boolean bl) {
        return new UnicastSubject<T>(n, runnable, bl);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(boolean bl) {
        return new UnicastSubject<T>(UnicastSubject.bufferSize(), bl);
    }

    void doTerminate() {
        Runnable runnable = this.onTerminate.get();
        if (runnable == null) return;
        if (!this.onTerminate.compareAndSet(runnable, null)) return;
        runnable.run();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.downstream.get();
        int n = 1;
        while (true) {
            if (observer != null) {
                if (this.enableOperatorFusion) {
                    this.drainFused(observer);
                    break;
                }
                this.drainNormal(observer);
                break;
            }
            if ((n = this.wip.addAndGet(-n)) == 0) {
                return;
            }
            observer = this.downstream.get();
        }
    }

    void drainFused(Observer<? super T> observer) {
        int n;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean bl = this.delayError;
        int n2 = 1;
        do {
            if (this.disposed) {
                this.downstream.lazySet(null);
                spscLinkedArrayQueue.clear();
                return;
            }
            boolean bl2 = this.done;
            if (bl ^ true && bl2 && this.failedFast((SimpleQueue<T>)spscLinkedArrayQueue, observer)) {
                return;
            }
            observer.onNext(null);
            if (bl2) {
                this.errorOrComplete(observer);
                return;
            }
            n2 = n = this.wip.addAndGet(-n2);
        } while (n != 0);
    }

    void drainNormal(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean bl = this.delayError;
        boolean bl2 = true;
        int n = 1;
        while (true) {
            if (this.disposed) {
                this.downstream.lazySet(null);
                spscLinkedArrayQueue.clear();
                return;
            }
            boolean bl3 = this.done;
            Object object = this.queue.poll();
            int n2 = object == null ? 1 : 0;
            boolean bl4 = bl2;
            if (bl3) {
                bl4 = bl2;
                if (bl ^ true) {
                    bl4 = bl2;
                    if (bl2) {
                        if (this.failedFast((SimpleQueue<T>)spscLinkedArrayQueue, observer)) {
                            return;
                        }
                        bl4 = false;
                    }
                }
                if (n2 != 0) {
                    this.errorOrComplete(observer);
                    return;
                }
            }
            if (n2 != 0) {
                n2 = this.wip.addAndGet(-n);
                bl2 = bl4;
                n = n2;
                if (n2 != 0) continue;
                return;
            }
            observer.onNext(object);
            bl2 = bl4;
        }
    }

    void errorOrComplete(Observer<? super T> observer) {
        this.downstream.lazySet(null);
        Throwable throwable = this.error;
        if (throwable != null) {
            observer.onError(throwable);
        } else {
            observer.onComplete();
        }
    }

    boolean failedFast(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable throwable = this.error;
        if (throwable == null) return false;
        this.downstream.lazySet(null);
        simpleQueue.clear();
        observer.onError(throwable);
        return true;
    }

    public Throwable getThrowable() {
        if (!this.done) return null;
        return this.error;
    }

    public boolean hasComplete() {
        boolean bl = this.done && this.error == null;
        return bl;
    }

    public boolean hasObservers() {
        boolean bl = this.downstream.get() != null;
        return bl;
    }

    public boolean hasThrowable() {
        boolean bl = this.done && this.error != null;
        return bl;
    }

    public void onComplete() {
        if (this.done) return;
        if (this.disposed) return;
        this.done = true;
        this.doTerminate();
        this.drain();
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.disposed) {
            this.error = throwable;
            this.done = true;
            this.doTerminate();
            this.drain();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) return;
        if (this.disposed) return;
        this.queue.offer(t);
        this.drain();
    }

    public void onSubscribe(Disposable disposable) {
        if (!this.done) {
            if (!this.disposed) return;
        }
        disposable.dispose();
    }

    protected void subscribeActual(Observer<? super T> observer) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            observer.onSubscribe(this.wip);
            this.downstream.lazySet(observer);
            if (this.disposed) {
                this.downstream.lazySet(null);
                return;
            }
            this.drain();
        } else {
            EmptyDisposable.error((Throwable)new IllegalStateException("Only a single observer allowed."), observer);
        }
    }
}
