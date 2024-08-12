/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.plugins.RxJavaPlugins
 *  retrofit2.Response
 *  retrofit2.adapter.rxjava2.Result
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;

private static class ResultObservable.ResultObserver<R>
implements Observer<Response<R>> {
    private final Observer<? super Result<R>> observer;

    ResultObservable.ResultObserver(Observer<? super Result<R>> observer) {
        this.observer = observer;
    }

    public void onComplete() {
        this.observer.onComplete();
    }

    public void onError(Throwable throwable) {
        try {
            this.observer.onNext((Object)Result.error((Throwable)throwable));
        }
        catch (Throwable throwable2) {
            try {
                this.observer.onError(throwable2);
            }
            catch (Throwable throwable3) {
                Exceptions.throwIfFatal((Throwable)throwable3);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable2, throwable3}));
            }
            return;
        }
        this.observer.onComplete();
    }

    public void onNext(Response<R> response) {
        this.observer.onNext((Object)Result.response(response));
    }

    public void onSubscribe(Disposable disposable) {
        this.observer.onSubscribe(disposable);
    }
}
