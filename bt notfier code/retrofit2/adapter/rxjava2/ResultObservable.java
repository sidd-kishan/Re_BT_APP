/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  retrofit2.Response
 *  retrofit2.adapter.rxjava2.Result
 *  retrofit2.adapter.rxjava2.ResultObservable$ResultObserver
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.adapter.rxjava2.ResultObservable;

final class ResultObservable<T>
extends Observable<Result<T>> {
    private final Observable<Response<T>> upstream;

    ResultObservable(Observable<Response<T>> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Observer<? super Result<T>> observer) {
        this.upstream.subscribe((Observer)new ResultObserver(observer));
    }
}
