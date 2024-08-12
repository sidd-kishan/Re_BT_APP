/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeZipArray$ZipMaybeObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class MaybeZipArray.ZipCoordinator<T, R>
extends AtomicInteger
implements Disposable {
    private static final long serialVersionUID = -5556924161382950569L;
    final MaybeObserver<? super R> downstream;
    final MaybeZipArray.ZipMaybeObserver<T>[] observers;
    final Object[] values;
    final Function<? super Object[], ? extends R> zipper;

    MaybeZipArray.ZipCoordinator(MaybeObserver<? super R> zipMaybeObserverArray, int n, Function<? super Object[], ? extends R> function) {
        super(n);
        this.downstream = zipMaybeObserverArray;
        this.zipper = function;
        zipMaybeObserverArray = new MaybeZipArray.ZipMaybeObserver[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.observers = zipMaybeObserverArray;
                this.values = new Object[n];
                return;
            }
            zipMaybeObserverArray[n2] = new MaybeZipArray.ZipMaybeObserver(this, n2);
            ++n2;
        }
    }

    public void dispose() {
        int n = 0;
        if (this.getAndSet(0) <= 0) return;
        MaybeZipArray.ZipMaybeObserver<T>[] zipMaybeObserverArray = this.observers;
        int n2 = zipMaybeObserverArray.length;
        while (n < n2) {
            zipMaybeObserverArray[n].dispose();
            ++n;
        }
    }

    void disposeExcept(int n) {
        MaybeZipArray.ZipMaybeObserver<T>[] zipMaybeObserverArray = this.observers;
        int n2 = zipMaybeObserverArray.length;
        int n3 = 0;
        while (true) {
            int n4 = n;
            if (n3 >= n) {
                while (++n4 < n2) {
                    zipMaybeObserverArray[n4].dispose();
                }
                return;
            }
            zipMaybeObserverArray[n3].dispose();
            ++n3;
        }
    }

    void innerComplete(int n) {
        if (this.getAndSet(0) <= 0) return;
        this.disposeExcept(n);
        this.downstream.onComplete();
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
