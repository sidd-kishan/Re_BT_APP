/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableSequenceEqual
 *  io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableSequenceEqual;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableSequenceEqualSingle<T>
extends Single<Boolean>
implements FuseToObservable<Boolean> {
    final int bufferSize;
    final BiPredicate<? super T, ? super T> comparer;
    final ObservableSource<? extends T> first;
    final ObservableSource<? extends T> second;

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int n) {
        this.first = observableSource;
        this.second = observableSource2;
        this.comparer = biPredicate;
        this.bufferSize = n;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableSequenceEqual(this.first, this.second, this.comparer, this.bufferSize));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.bufferSize, this.first, this.second, this.comparer);
        singleObserver.onSubscribe((Disposable)equalCoordinator);
        equalCoordinator.subscribe();
    }
}
