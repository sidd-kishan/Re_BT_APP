/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.ResettableConnectable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection
 *  io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver
 *  io.reactivex.observables.ConnectableObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T>
extends Observable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableObservable<T> source;
    final long timeout;
    final TimeUnit unit;

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.source = connectableObservable;
        this.n = n;
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void cancel(RefConnection refConnection) {
        SequentialDisposable sequentialDisposable;
        synchronized (this) {
            long l;
            if (this.connection == null) return;
            if (this.connection != refConnection) {
                return;
            }
            refConnection.subscriberCount = l = refConnection.subscriberCount - 1L;
            if (l != 0L) return;
            if (!refConnection.connected) {
                return;
            }
            if (this.timeout == 0L) {
                this.timeout(refConnection);
                return;
            }
            sequentialDisposable = new SequentialDisposable();
            refConnection.timer = sequentialDisposable;
        }
        sequentialDisposable.replace(this.scheduler.scheduleDirect((Runnable)refConnection, this.timeout, this.unit));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void subscribeActual(Observer<? super T> observer) {
        boolean bl;
        RefConnection refConnection;
        synchronized (this) {
            long l;
            RefConnection refConnection2;
            refConnection = refConnection2 = this.connection;
            if (refConnection2 == null) {
                this.connection = refConnection = new RefConnection(this);
            }
            if ((l = refConnection.subscriberCount) == 0L && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            refConnection.subscriberCount = ++l;
            boolean bl2 = refConnection.connected;
            bl = true;
            if (!bl2 && l == (long)this.n) {
                refConnection.connected = true;
            } else {
                bl = false;
            }
        }
        this.source.subscribe((Observer)new RefCountObserver(observer, this, refConnection));
        if (!bl) return;
        this.source.connect((Consumer)refConnection);
    }

    void terminated(RefConnection refConnection) {
        synchronized (this) {
            long l;
            if (this.connection != null && this.connection == refConnection) {
                this.connection = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
            }
            refConnection.subscriberCount = l = refConnection.subscriberCount - 1L;
            if (l != 0L) return;
            if (this.source instanceof Disposable) {
                ((Disposable)this.source).dispose();
            } else {
                if (!(this.source instanceof ResettableConnectable)) return;
                ((ResettableConnectable)this.source).resetIf((Disposable)refConnection.get());
            }
            return;
        }
    }

    void timeout(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount != 0L) return;
            if (refConnection != this.connection) return;
            this.connection = null;
            Disposable disposable = (Disposable)refConnection.get();
            DisposableHelper.dispose((AtomicReference)refConnection);
            if (this.source instanceof Disposable) {
                ((Disposable)this.source).dispose();
            } else {
                if (!(this.source instanceof ResettableConnectable)) return;
                if (disposable == null) {
                    refConnection.disconnectedEarly = true;
                } else {
                    ((ResettableConnectable)this.source).resetIf(disposable);
                }
            }
            return;
        }
    }
}
