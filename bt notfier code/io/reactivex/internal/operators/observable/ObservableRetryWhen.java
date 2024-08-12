/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver
 *  io.reactivex.subjects.PublishSubject
 *  io.reactivex.subjects.Subject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public final class ObservableRetryWhen<T>
extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> handler;

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.handler = function;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        ObservableSource observableSource;
        Subject subject = PublishSubject.create().toSerialized();
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull((Object)this.handler.apply((Object)subject), (String)"The handler returned a null ObservableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        subject = new RepeatWhenObserver(observer, subject, this.source);
        observer.onSubscribe((Disposable)subject);
        observableSource.subscribe((Observer)subject.inner);
        subject.subscribeNext();
    }
}
