/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observer
 *  io.reactivex.SingleSource
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeToObservable
 *  io.reactivex.internal.operators.single.SingleToObservable
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    static <T> boolean tryAsCompletable(Object object, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        block4: {
            block3: {
                if (!(object instanceof Callable)) return false;
                Callable callable = (Callable)object;
                object = null;
                try {
                    callable = callable.call();
                    if (callable != null) {
                        object = (CompletableSource)ObjectHelper.requireNonNull((Object)function.apply((Object)callable), (String)"The mapper returned a null CompletableSource");
                    }
                    if (object != null) break block3;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, (CompletableObserver)completableObserver);
                    return true;
                }
                EmptyDisposable.complete((CompletableObserver)completableObserver);
                break block4;
            }
            object.subscribe(completableObserver);
        }
        return true;
    }

    static <T, R> boolean tryAsMaybe(Object object, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        block4: {
            block3: {
                if (!(object instanceof Callable)) return false;
                Callable callable = (Callable)object;
                object = null;
                try {
                    callable = callable.call();
                    if (callable != null) {
                        object = (MaybeSource)ObjectHelper.requireNonNull((Object)function.apply((Object)callable), (String)"The mapper returned a null MaybeSource");
                    }
                    if (object != null) break block3;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, observer);
                    return true;
                }
                EmptyDisposable.complete(observer);
                break block4;
            }
            object.subscribe(MaybeToObservable.create(observer));
        }
        return true;
    }

    static <T, R> boolean tryAsSingle(Object object, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        block4: {
            block3: {
                if (!(object instanceof Callable)) return false;
                Callable callable = (Callable)object;
                object = null;
                try {
                    callable = callable.call();
                    if (callable != null) {
                        object = (SingleSource)ObjectHelper.requireNonNull((Object)function.apply((Object)callable), (String)"The mapper returned a null SingleSource");
                    }
                    if (object != null) break block3;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, observer);
                    return true;
                }
                EmptyDisposable.complete(observer);
                break block4;
            }
            object.subscribe(SingleToObservable.create(observer));
        }
        return true;
    }
}
