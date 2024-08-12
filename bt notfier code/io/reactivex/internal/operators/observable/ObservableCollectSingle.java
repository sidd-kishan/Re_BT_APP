/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableCollect
 *  io.reactivex.internal.operators.observable.ObservableCollectSingle$CollectObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableCollect;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollectSingle<T, U>
extends Single<U>
implements FuseToObservable<U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;
    final ObservableSource<T> source;

    public ObservableCollectSingle(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.source = observableSource;
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableCollect(this.source, this.initialSupplier, this.collector));
    }

    protected void subscribeActual(SingleObserver<? super U> singleObserver) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull(this.initialSupplier.call(), (String)"The initialSupplier returned a null value");
        }
        catch (Throwable throwable) {
            EmptyDisposable.error((Throwable)throwable, singleObserver);
            return;
        }
        this.source.subscribe((Observer)new CollectObserver(singleObserver, object, this.collector));
    }
}
