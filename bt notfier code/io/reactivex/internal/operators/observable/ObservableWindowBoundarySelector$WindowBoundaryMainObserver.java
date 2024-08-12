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
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.observers.QueueDrainObserver
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector$OperatorWindowBoundaryCloseObserver
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector$OperatorWindowBoundaryOpenObserver
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector$WindowOperation
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.UnicastSubject
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
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, B, V>
extends QueueDrainObserver<T, Object, Observable<T>>
implements Disposable {
    final AtomicReference<Disposable> boundary = new AtomicReference();
    final int bufferSize;
    final Function<? super B, ? extends ObservableSource<V>> close;
    final ObservableSource<B> open;
    final CompositeDisposable resources;
    final AtomicBoolean stopWindows;
    Disposable upstream;
    final AtomicLong windows = new AtomicLong();
    final List<UnicastSubject<T>> ws;

    ObservableWindowBoundarySelector.WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int n) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.stopWindows = new AtomicBoolean();
        this.open = observableSource;
        this.close = function;
        this.bufferSize = n;
        this.resources = new CompositeDisposable();
        this.ws = new ArrayList<UnicastSubject<T>>();
        this.windows.lazySet(1L);
    }

    public void accept(Observer<? super Observable<T>> observer, Object object) {
    }

    void close(ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver<T, V> operatorWindowBoundaryCloseObserver) {
        this.resources.delete(operatorWindowBoundaryCloseObserver);
        this.queue.offer((Object)new ObservableWindowBoundarySelector.WindowOperation(operatorWindowBoundaryCloseObserver.w, null));
        if (!this.enter()) return;
        this.drainLoop();
    }

    public void dispose() {
        if (!this.stopWindows.compareAndSet(false, true)) return;
        DisposableHelper.dispose(this.boundary);
        if (this.windows.decrementAndGet() != 0L) return;
        this.upstream.dispose();
    }

    void disposeBoundary() {
        this.resources.dispose();
        DisposableHelper.dispose(this.boundary);
    }

    /*
     * Unable to fully structure code
     */
    void drainLoop() {
        var5_1 = (MpscLinkedQueue)this.queue;
        var6_2 = this.downstream;
        var4_3 = this.ws;
        var1_4 = 1;
        block2: while (true) {
            var3_6 = this.done;
            var8_9 = var5_1.poll();
            var2_5 = var8_9 == null ? 1 : 0;
            if (var3_6 && var2_5 != 0) {
                this.disposeBoundary();
                var5_1 = this.error;
                if (var5_1 != null) {
                    var6_2 = var4_3.iterator();
                    while (var6_2.hasNext()) {
                        ((UnicastSubject)var6_2.next()).onError((Throwable)var5_1);
                    }
                } else {
                    var5_1 = var4_3.iterator();
                    while (var5_1.hasNext()) {
                        ((UnicastSubject)var5_1.next()).onComplete();
                    }
                }
                var4_3.clear();
                return;
            }
            if (var2_5 != 0) {
                var1_4 = var2_5 = this.leave(-var1_4);
                if (var2_5 != 0) continue;
                return;
            }
            if (var8_9 instanceof ObservableWindowBoundarySelector.WindowOperation) {
                var7_7 = (ObservableWindowBoundarySelector.WindowOperation)var8_9;
                if (var7_7.w != null) {
                    if (!var4_3.remove(var7_7.w)) continue;
                    var7_7.w.onComplete();
                    if (this.windows.decrementAndGet() != 0L) continue;
                    this.disposeBoundary();
                    return;
                }
                if (this.stopWindows.get()) continue;
                var8_9 = UnicastSubject.create((int)this.bufferSize);
                var4_3.add((UnicastSubject<T>)var8_9);
                var6_2.onNext(var8_9);
                try {
                    var7_7 = (ObservableSource)ObjectHelper.requireNonNull((Object)this.close.apply(var7_7.open), (String)"The ObservableSource supplied is null");
                }
                catch (Throwable var7_8) {
                    Exceptions.throwIfFatal((Throwable)var7_8);
                    this.stopWindows.set(true);
                    var6_2.onError(var7_8);
                    continue;
                }
                if (!this.resources.add((Disposable)(var8_9 = new ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver(this, (UnicastSubject)var8_9)))) continue;
                this.windows.getAndIncrement();
                var7_7.subscribe((Observer)var8_9);
                continue;
            }
            var7_7 = var4_3.iterator();
            while (true) {
                if (var7_7.hasNext()) ** break;
                continue block2;
                ((UnicastSubject)var7_7.next()).onNext(NotificationLite.getValue((Object)var8_9));
            }
            break;
        }
    }

    void error(Throwable throwable) {
        this.upstream.dispose();
        this.resources.dispose();
        this.onError(throwable);
    }

    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        if (this.windows.decrementAndGet() == 0L) {
            this.resources.dispose();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        if (this.windows.decrementAndGet() == 0L) {
            this.resources.dispose();
        }
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.fastEnter()) {
            Iterator<UnicastSubject<T>> iterator = this.ws.iterator();
            while (iterator.hasNext()) {
                iterator.next().onNext(t);
            }
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(NotificationLite.next(t));
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
        if (this.stopWindows.get()) {
            return;
        }
        disposable = new ObservableWindowBoundarySelector.OperatorWindowBoundaryOpenObserver(this);
        if (!this.boundary.compareAndSet(null, disposable)) return;
        this.open.subscribe((Observer)disposable);
    }

    void open(B b) {
        this.queue.offer((Object)new ObservableWindowBoundarySelector.WindowOperation(null, b));
        if (!this.enter()) return;
        this.drainLoop();
    }
}
