/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Observable
 *  androidx.camera.core.impl.Observable$Observer
 *  androidx.camera.core.impl._$$Lambda$ConstantObservable$kXgoMj_SEvwvi5lWtNwahKNa7kU
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl._$;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class ConstantObservable<T>
implements Observable<T> {
    private static final ConstantObservable<Object> NULL_OBSERVABLE = new ConstantObservable<Object>(null);
    private static final String TAG = "ConstantObservable";
    private final ListenableFuture<T> mValueFuture;

    private ConstantObservable(T t) {
        this.mValueFuture = Futures.immediateFuture(t);
    }

    public static <U> Observable<U> withValue(U u) {
        if (u != null) return new ConstantObservable<U>(u);
        return NULL_OBSERVABLE;
    }

    public void addObserver(Executor executor, Observable.Observer<? super T> observer) {
        this.mValueFuture.addListener((Runnable)new _$.Lambda.ConstantObservable.kXgoMj_SEvwvi5lWtNwahKNa7kU(this, observer), executor);
    }

    public ListenableFuture<T> fetchData() {
        return this.mValueFuture;
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ void lambda$addObserver$0$ConstantObservable(Observable.Observer observer) {
        block3: {
            void var2_4;
            try {
                observer.onNewData(this.mValueFuture.get());
                break block3;
            }
            catch (InterruptedException interruptedException) {
            }
            catch (ExecutionException executionException) {
                // empty catch block
            }
            observer.onError((Throwable)var2_4);
        }
    }

    public void removeObserver(Observable.Observer<? super T> observer) {
    }
}
