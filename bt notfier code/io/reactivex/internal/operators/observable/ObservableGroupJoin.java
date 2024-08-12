/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$GroupJoinDisposable
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$JoinSupport
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;

public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R>
extends AbstractObservableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    final ObservableSource<? extends TRight> other;
    final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.other = observableSource2;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
    }

    protected void subscribeActual(Observer<? super R> leftRightObserver) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(leftRightObserver, this.leftEnd, this.rightEnd, this.resultSelector);
        leftRightObserver.onSubscribe((Disposable)groupJoinDisposable);
        leftRightObserver = new LeftRightObserver((JoinSupport)groupJoinDisposable, true);
        groupJoinDisposable.disposables.add((Disposable)leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver((JoinSupport)groupJoinDisposable, false);
        groupJoinDisposable.disposables.add((Disposable)leftRightObserver2);
        this.source.subscribe((Observer)leftRightObserver);
        this.other.subscribe((Observer)leftRightObserver2);
    }
}
