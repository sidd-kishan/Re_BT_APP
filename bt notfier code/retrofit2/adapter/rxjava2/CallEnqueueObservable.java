/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Response
 *  retrofit2.adapter.rxjava2.CallEnqueueObservable$CallCallback
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.CallEnqueueObservable;

final class CallEnqueueObservable<T>
extends Observable<Response<T>> {
    private final Call<T> originalCall;

    CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    protected void subscribeActual(Observer<? super Response<T>> observer) {
        Call call = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(call, observer);
        observer.onSubscribe((Disposable)callCallback);
        if (callCallback.isDisposed()) return;
        call.enqueue((Callback)callCallback);
    }
}
