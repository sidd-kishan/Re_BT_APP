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
 *  retrofit2.adapter.rxjava2.HttpException
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.HttpException;

private static class BodyObservable.BodyObserver<R>
implements Observer<Response<R>> {
    private final Observer<? super R> observer;
    private boolean terminated;

    BodyObservable.BodyObserver(Observer<? super R> observer) {
        this.observer = observer;
    }

    public void onComplete() {
        if (this.terminated) return;
        this.observer.onComplete();
    }

    public void onError(Throwable throwable) {
        if (!this.terminated) {
            this.observer.onError(throwable);
        } else {
            AssertionError assertionError = new AssertionError((Object)"This should never happen! Report as a bug with the full stacktrace.");
            ((Throwable)((Object)assertionError)).initCause(throwable);
            RxJavaPlugins.onError((Throwable)((Object)assertionError));
        }
    }

    public void onNext(Response<R> response) {
        if (response.isSuccessful()) {
            this.observer.onNext(response.body());
        } else {
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError((Throwable)httpException);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{httpException, throwable}));
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.observer.onSubscribe(disposable);
    }
}
