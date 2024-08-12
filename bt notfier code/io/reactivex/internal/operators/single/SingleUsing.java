/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.single.SingleUsing$UsingSingleObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class SingleUsing<T, U>
extends Single<T> {
    final Consumer<? super U> disposer;
    final boolean eager;
    final Callable<U> resourceSupplier;
    final Function<? super U, ? extends SingleSource<? extends T>> singleFunction;

    public SingleUsing(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean bl) {
        this.resourceSupplier = callable;
        this.singleFunction = function;
        this.disposer = consumer;
        this.eager = bl;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        SingleSource singleSource;
        U u;
        try {
            u = this.resourceSupplier.call();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, singleObserver);
            return;
        }
        try {
            singleSource = (SingleSource)ObjectHelper.requireNonNull((Object)this.singleFunction.apply(u), (String)"The singleFunction returned a null SingleSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            Throwable throwable2 = throwable;
            if (this.eager) {
                try {
                    this.disposer.accept(u);
                    throwable2 = throwable;
                }
                catch (Throwable throwable3) {
                    Exceptions.throwIfFatal((Throwable)throwable3);
                    throwable2 = new CompositeException(new Throwable[]{throwable, throwable3});
                }
            }
            EmptyDisposable.error((Throwable)throwable2, singleObserver);
            if (this.eager) return;
            try {
                this.disposer.accept(u);
            }
            catch (Throwable throwable4) {
                Exceptions.throwIfFatal((Throwable)throwable4);
                RxJavaPlugins.onError((Throwable)throwable4);
            }
            return;
        }
        singleSource.subscribe((SingleObserver)new UsingSingleObserver(singleObserver, u, this.eager, this.disposer));
    }
}
