/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.fuseable.HasUpstreamObservableSource
 *  io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver
 *  io.reactivex.internal.operators.observable.ObservablePublish$PublishSource
 *  io.reactivex.internal.operators.observable.ObservablePublishClassic
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observables.ConnectableObservable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishClassic;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T>
extends ConnectableObservable<T>
implements HasUpstreamObservableSource<T>,
ObservablePublishClassic<T> {
    final AtomicReference<PublishObserver<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    private ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource) {
        AtomicReference<PublishObserver<T>> atomicReference = new AtomicReference<PublishObserver<T>>();
        return RxJavaPlugins.onAssembly(new ObservablePublish<T>(new PublishSource(atomicReference), observableSource, atomicReference));
    }

    public void connect(Consumer<? super Disposable> consumer) {
        PublishObserver publishObserver;
        PublishObserver publishObserver2;
        do {
            if ((publishObserver2 = this.current.get()) == null) continue;
            publishObserver = publishObserver2;
            if (!publishObserver2.isDisposed()) break;
        } while (!this.current.compareAndSet(publishObserver2, publishObserver = new PublishObserver(this.current)));
        boolean bl = publishObserver.shouldConnect.get();
        boolean bl2 = true;
        if (bl || !publishObserver.shouldConnect.compareAndSet(false, true)) {
            bl2 = false;
        }
        try {
            consumer.accept((Object)publishObserver);
            if (!bl2) return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RuntimeException runtimeException = ExceptionHelper.wrapOrThrow((Throwable)throwable);
            throw runtimeException;
        }
        this.source.subscribe((Observer)publishObserver);
    }

    public ObservableSource<T> publishSource() {
        return this.source;
    }

    public ObservableSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }
}
