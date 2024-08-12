/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.completable.CompletableUsing$UsingObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class CompletableUsing<R>
extends Completable {
    final Function<? super R, ? extends CompletableSource> completableFunction;
    final Consumer<? super R> disposer;
    final boolean eager;
    final Callable<R> resourceSupplier;

    public CompletableUsing(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean bl) {
        this.resourceSupplier = callable;
        this.completableFunction = function;
        this.disposer = consumer;
        this.eager = bl;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        CompletableSource completableSource;
        R r;
        try {
            r = this.resourceSupplier.call();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, (CompletableObserver)completableObserver);
            return;
        }
        try {
            completableSource = (CompletableSource)ObjectHelper.requireNonNull((Object)this.completableFunction.apply(r), (String)"The completableFunction returned a null CompletableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            if (this.eager) {
                try {
                    this.disposer.accept(r);
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    EmptyDisposable.error((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}), (CompletableObserver)completableObserver);
                    return;
                }
            }
            EmptyDisposable.error((Throwable)throwable, (CompletableObserver)completableObserver);
            if (this.eager) return;
            try {
                this.disposer.accept(r);
            }
            catch (Throwable throwable3) {
                Exceptions.throwIfFatal((Throwable)throwable3);
                RxJavaPlugins.onError((Throwable)throwable3);
            }
            return;
        }
        completableSource.subscribe((CompletableObserver)new UsingObserver(completableObserver, r, this.disposer, this.eager));
    }
}
