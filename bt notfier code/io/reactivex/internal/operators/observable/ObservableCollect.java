/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableCollect$CollectObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableCollect;
import java.util.concurrent.Callable;

public final class ObservableCollect<T, U>
extends AbstractObservableWithUpstream<T, U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;

    public ObservableCollect(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }

    protected void subscribeActual(Observer<? super U> observer) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull(this.initialSupplier.call(), (String)"The initialSupplier returned a null value");
        }
        catch (Throwable throwable) {
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        this.source.subscribe((Observer)new CollectObserver(observer, object, this.collector));
    }
}
