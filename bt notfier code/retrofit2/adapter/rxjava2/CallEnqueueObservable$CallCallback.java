/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.plugins.RxJavaPlugins
 *  retrofit2.Call
 *  retrofit2.Callback
 *  retrofit2.Response
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

private static final class CallEnqueueObservable.CallCallback<T>
implements Disposable,
Callback<T> {
    private final Call<?> call;
    private volatile boolean disposed;
    private final Observer<? super Response<T>> observer;
    boolean terminated = false;

    CallEnqueueObservable.CallCallback(Call<?> call, Observer<? super Response<T>> observer) {
        this.call = call;
        this.observer = observer;
    }

    public void dispose() {
        this.disposed = true;
        this.call.cancel();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onFailure(Call<T> call, Throwable throwable) {
        if (call.isCanceled()) {
            return;
        }
        try {
            this.observer.onError(throwable);
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
        }
    }

    public void onResponse(Call<T> call, Response<T> response) {
        if (this.disposed) {
            return;
        }
        try {
            this.observer.onNext(response);
            if (this.disposed) return;
            this.terminated = true;
            this.observer.onComplete();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            if (this.terminated) {
                RxJavaPlugins.onError((Throwable)throwable);
            }
            if (this.disposed) return;
            try {
                this.observer.onError(throwable);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            }
        }
    }
}
