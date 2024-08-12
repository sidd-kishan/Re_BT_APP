/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.ResettableConnectable
 *  io.reactivex.internal.fuseable.HasUpstreamObservableSource
 *  io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier
 *  io.reactivex.internal.operators.observable.ObservableReplay$MulticastReplay
 *  io.reactivex.internal.operators.observable.ObservableReplay$Replay
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayBufferSupplier
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplaySource
 *  io.reactivex.internal.operators.observable.ObservableReplay$ScheduledReplaySupplier
 *  io.reactivex.internal.operators.observable.ObservableReplay$UnBoundedFactory
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observables.ConnectableObservable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T>
extends ConnectableObservable<T>
implements HasUpstreamObservableSource<T>,
ResettableConnectable {
    static final BufferSupplier DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
    final BufferSupplier<T> bufferFactory;
    final AtomicReference<ReplayObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
        this.bufferFactory = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int n) {
        if (n != Integer.MAX_VALUE) return ObservableReplay.create(observableSource, new ReplayBufferSupplier(n));
        return ObservableReplay.createFrom(observableSource);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long l, TimeUnit timeUnit, Scheduler scheduler) {
        return ObservableReplay.create(observableSource, l, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        return ObservableReplay.create(observableSource, new ScheduledReplaySupplier(n, l, timeUnit, scheduler));
    }

    static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference<ReplayObserver<T>> atomicReference = new AtomicReference<ReplayObserver<T>>();
        return RxJavaPlugins.onAssembly(new ObservableReplay<T>(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        return ObservableReplay.create(observableSource, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <U, R> Observable<R> multicastSelector(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.onAssembly((Observable)new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly((ConnectableObservable)new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    public void connect(Consumer<? super Disposable> consumer) {
        ReplayObserver replayObserver;
        ReplayObserver replayObserver2;
        do {
            if ((replayObserver2 = this.current.get()) == null) continue;
            replayObserver = replayObserver2;
            if (!replayObserver2.isDisposed()) break;
        } while (!this.current.compareAndSet(replayObserver2, replayObserver = new ReplayObserver(this.bufferFactory.call())));
        boolean bl = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            consumer.accept((Object)replayObserver);
            if (!bl) return;
        }
        catch (Throwable throwable) {
            if (bl) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal((Throwable)throwable);
            RuntimeException runtimeException = ExceptionHelper.wrapOrThrow((Throwable)throwable);
            throw runtimeException;
        }
        this.source.subscribe((Observer)replayObserver);
    }

    public void resetIf(Disposable disposable) {
        this.current.compareAndSet((ReplayObserver)disposable, null);
    }

    public ObservableSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }
}
