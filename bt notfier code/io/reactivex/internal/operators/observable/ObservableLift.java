/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableOperator
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableLift<R, T>
extends AbstractObservableWithUpstream<T, R> {
    final ObservableOperator<? extends R, ? super T> operator;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.operator = observableOperator;
    }

    public void subscribeActual(Observer<? super R> object) {
        try {
            Observer observer = this.operator.apply(object);
            object = new StringBuilder();
            ((StringBuilder)object).append("Operator ");
            ((StringBuilder)object).append(this.operator);
            ((StringBuilder)object).append(" returned a null Observer");
            object = (Observer)ObjectHelper.requireNonNull((Object)observer, (String)((StringBuilder)object).toString());
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(throwable);
            throw nullPointerException;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
        this.source.subscribe((Observer)object);
    }
}
