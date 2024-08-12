/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.completable.CompletableConcatIterable$ConcatInnerObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import java.util.Iterator;

public final class CompletableConcatIterable
extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.sources = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Iterator iterator;
        try {
            iterator = (Iterator)ObjectHelper.requireNonNull(this.sources.iterator(), (String)"The iterator returned is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, (CompletableObserver)completableObserver);
            return;
        }
        iterator = new ConcatInnerObserver(completableObserver, iterator);
        completableObserver.onSubscribe((Disposable)((ConcatInnerObserver)iterator).sd);
        iterator.next();
    }
}
