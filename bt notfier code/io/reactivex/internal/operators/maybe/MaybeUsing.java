/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeUsing$UsingObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeUsing<T, D>
extends Maybe<T> {
    final boolean eager;
    final Consumer<? super D> resourceDisposer;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends MaybeSource<? extends T>> sourceSupplier;

    public MaybeUsing(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean bl) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.resourceDisposer = consumer;
        this.eager = bl;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeSource maybeSource;
        D d;
        try {
            d = this.resourceSupplier.call();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, maybeObserver);
            return;
        }
        try {
            maybeSource = (MaybeSource)ObjectHelper.requireNonNull((Object)this.sourceSupplier.apply(d), (String)"The sourceSupplier returned a null MaybeSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            if (this.eager) {
                try {
                    this.resourceDisposer.accept(d);
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    EmptyDisposable.error((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}), maybeObserver);
                    return;
                }
            }
            EmptyDisposable.error((Throwable)throwable, maybeObserver);
            if (this.eager) return;
            try {
                this.resourceDisposer.accept(d);
            }
            catch (Throwable throwable3) {
                Exceptions.throwIfFatal((Throwable)throwable3);
                RxJavaPlugins.onError((Throwable)throwable3);
            }
            return;
        }
        maybeSource.subscribe((MaybeObserver)new UsingObserver(maybeObserver, d, this.resourceDisposer, this.eager));
    }
}
