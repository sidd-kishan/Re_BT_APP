/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeEqualSingle$EqualObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class MaybeEqualSingle.EqualCoordinator<T>
extends AtomicInteger
implements Disposable {
    final SingleObserver<? super Boolean> downstream;
    final BiPredicate<? super T, ? super T> isEqual;
    final MaybeEqualSingle.EqualObserver<T> observer1;
    final MaybeEqualSingle.EqualObserver<T> observer2;

    MaybeEqualSingle.EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
        super(2);
        this.downstream = singleObserver;
        this.isEqual = biPredicate;
        this.observer1 = new MaybeEqualSingle.EqualObserver(this);
        this.observer2 = new MaybeEqualSingle.EqualObserver(this);
    }

    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    void done() {
        if (this.decrementAndGet() != 0) return;
        Object object = this.observer1.value;
        Object object2 = this.observer2.value;
        if (object != null && object2 != null) {
            boolean bl;
            try {
                bl = this.isEqual.test(object, object2);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.downstream.onError(throwable);
                return;
            }
            this.downstream.onSuccess((Object)bl);
        } else {
            SingleObserver<? super Boolean> singleObserver = this.downstream;
            boolean bl = object == null && object2 == null;
            singleObserver.onSuccess((Object)bl);
        }
    }

    void error(MaybeEqualSingle.EqualObserver<T> equalObserver, Throwable throwable) {
        if (this.getAndSet(0) > 0) {
            MaybeEqualSingle.EqualObserver<T> equalObserver2 = this.observer1;
            if (equalObserver == equalObserver2) {
                this.observer2.dispose();
            } else {
                equalObserver2.dispose();
            }
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.observer1.get()));
    }

    void subscribe(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        maybeSource.subscribe(this.observer1);
        maybeSource2.subscribe(this.observer2);
    }
}
