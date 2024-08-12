/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.ResettableConnectable
 *  io.reactivex.internal.fuseable.HasUpstreamObservableSource
 *  io.reactivex.internal.operators.observable.ObservablePublishAlt$InnerDisposable
 *  io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observables.ConnectableObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishAlt<T>
extends ConnectableObservable<T>
implements HasUpstreamObservableSource<T>,
ResettableConnectable {
    final AtomicReference<PublishConnection<T>> current;
    final ObservableSource<T> source;

    public ObservablePublishAlt(ObservableSource<T> observableSource) {
        this.source = observableSource;
        this.current = new AtomicReference();
    }

    public void connect(Consumer<? super Disposable> consumer) {
        PublishConnection publishConnection;
        PublishConnection publishConnection2;
        do {
            if ((publishConnection2 = this.current.get()) == null) continue;
            publishConnection = publishConnection2;
            if (!publishConnection2.isDisposed()) break;
        } while (!this.current.compareAndSet(publishConnection2, publishConnection = new PublishConnection(this.current)));
        boolean bl = publishConnection.connect.get();
        boolean bl2 = true;
        if (bl || !publishConnection.connect.compareAndSet(false, true)) {
            bl2 = false;
        }
        try {
            consumer.accept((Object)publishConnection);
            if (!bl2) return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RuntimeException runtimeException = ExceptionHelper.wrapOrThrow((Throwable)throwable);
            throw runtimeException;
        }
        this.source.subscribe((Observer)publishConnection);
    }

    public void resetIf(Disposable disposable) {
        this.current.compareAndSet((PublishConnection)disposable, null);
    }

    public ObservableSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        Object object;
        PublishConnection publishConnection;
        do {
            object = publishConnection = this.current.get();
        } while (publishConnection == null && !this.current.compareAndSet((PublishConnection<T>)publishConnection, (PublishConnection<T>)(object = new PublishConnection(this.current))));
        publishConnection = new InnerDisposable(observer, object);
        observer.onSubscribe((Disposable)publishConnection);
        if (object.add((InnerDisposable)publishConnection)) {
            if (!publishConnection.isDisposed()) return;
            object.remove((InnerDisposable)publishConnection);
            return;
        }
        object = object.error;
        if (object != null) {
            observer.onError((Throwable)object);
        } else {
            observer.onComplete();
        }
    }
}
