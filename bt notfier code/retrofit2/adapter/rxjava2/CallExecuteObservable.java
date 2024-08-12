/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.plugins.RxJavaPlugins
 *  retrofit2.Call
 *  retrofit2.Response
 *  retrofit2.adapter.rxjava2.CallExecuteObservable$CallDisposable
 */
package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.CallExecuteObservable;

final class CallExecuteObservable<T>
extends Observable<Response<T>> {
    private final Call<T> originalCall;

    CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    /*
     * WARNING - void declaration
     */
    protected void subscribeActual(Observer<? super Response<T>> observer) {
        block11: {
            void var4_6;
            boolean bl;
            CallDisposable callDisposable;
            block10: {
                Call call = this.originalCall.clone();
                callDisposable = new CallDisposable(call);
                observer.onSubscribe((Disposable)callDisposable);
                if (callDisposable.isDisposed()) {
                    return;
                }
                try {
                    boolean bl2;
                    call = call.execute();
                    if (!callDisposable.isDisposed()) {
                        observer.onNext((Object)call);
                    }
                    if (bl2 = callDisposable.isDisposed()) return;
                }
                catch (Throwable throwable) {
                    bl = false;
                    break block10;
                }
                try {
                    observer.onComplete();
                    break block11;
                }
                catch (Throwable throwable) {
                    bl = true;
                }
            }
            Exceptions.throwIfFatal((Throwable)var4_6);
            if (bl) {
                RxJavaPlugins.onError((Throwable)var4_6);
            } else {
                if (callDisposable.isDisposed()) return;
                try {
                    observer.onError((Throwable)var4_6);
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{var4_6, throwable}));
                }
            }
        }
    }
}
