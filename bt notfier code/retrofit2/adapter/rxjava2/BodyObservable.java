/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  retrofit2.Response
 *  retrofit2.adapter.rxjava2.BodyObservable$BodyObserver
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.BodyObservable;

final class BodyObservable<T>
extends Observable<T> {
    private final Observable<Response<T>> upstream;

    BodyObservable(Observable<Response<T>> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.upstream.subscribe((Observer)new BodyObserver(observer));
    }
}
