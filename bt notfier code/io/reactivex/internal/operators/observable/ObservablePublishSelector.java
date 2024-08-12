/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservablePublishSelector$SourceObserver
 *  io.reactivex.internal.operators.observable.ObservablePublishSelector$TargetObserver
 *  io.reactivex.subjects.PublishSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R>
extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.selector = function;
    }

    protected void subscribeActual(Observer<? super R> targetObserver) {
        ObservableSource observableSource;
        PublishSubject publishSubject = PublishSubject.create();
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull((Object)this.selector.apply((Object)publishSubject), (String)"The selector returned a null ObservableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, targetObserver);
            return;
        }
        targetObserver = new TargetObserver(targetObserver);
        observableSource.subscribe((Observer)targetObserver);
        this.source.subscribe((Observer)new SourceObserver(publishSubject, (AtomicReference)targetObserver));
    }
}
