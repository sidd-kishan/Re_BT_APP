/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.single.SingleZipArray$ZipSingleObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class SingleZipArray.ZipCoordinator<T, R>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = -5556924161382950569L;
    final SingleObserver<? super R> downstream;
    final SingleZipArray.ZipSingleObserver<T>[] observers;
    final Object[] values;
    final Function<? super Object[], ? extends R> zipper;

    SingleZipArray.ZipCoordinator(SingleObserver<? super R> zipSingleObserverArray, int n, Function<? super Object[], ? extends R> function) {
        super(n);
        this.downstream = zipSingleObserverArray;
        this.zipper = function;
        zipSingleObserverArray = new SingleZipArray.ZipSingleObserver[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.observers = zipSingleObserverArray;
                this.values = new Object[n];
                return;
            }
            zipSingleObserverArray[n2] = new SingleZipArray.ZipSingleObserver(this, n2);
            ++n2;
        }
    }

    public void dispose() {
        int n = 0;
        if (this.getAndSet(0) <= 0) return;
        SingleZipArray.ZipSingleObserver<T>[] zipSingleObserverArray = this.observers;
        int n2 = zipSingleObserverArray.length;
        while (n < n2) {
            zipSingleObserverArray[n].dispose();
            ++n;
        }
    }

    void disposeExcept(int n) {
        SingleZipArray.ZipSingleObserver<T>[] zipSingleObserverArray = this.observers;
        int n2 = zipSingleObserverArray.length;
        int n3 = 0;
        while (true) {
            int n4 = n;
            if (n3 >= n) {
                while (++n4 < n2) {
                    zipSingleObserverArray[n4].dispose();
                }
                return;
            }
            zipSingleObserverArray[n3].dispose();
            ++n3;
        }
    }

    void innerError(Throwable throwable, int n) {
        if (this.getAndSet(0) > 0) {
            this.disposeExcept(n);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerSuccess(T object, int n) {
        block2: {
            this.values[n] = object;
            if (this.decrementAndGet() != 0) return;
            try {
                object = ObjectHelper.requireNonNull((Object)this.zipper.apply((Object)this.values), (String)"The zipper returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.downstream.onError(throwable);
                break block2;
            }
            this.downstream.onSuccess(object);
        }
    }

    public boolean isDisposed() {
        boolean bl = this.get() <= 0;
        return bl;
    }
}
