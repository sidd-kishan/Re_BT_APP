/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.completable.CompletableMergeIterable$MergeCompletableObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable
extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.sources = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        AtomicInteger atomicInteger;
        Iterator iterator;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe((Disposable)compositeDisposable);
        try {
            iterator = (Iterator)ObjectHelper.requireNonNull(this.sources.iterator(), (String)"The source iterator returned is null");
            atomicInteger = new AtomicInteger(1);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            completableObserver.onError(throwable);
            return;
        }
        completableObserver = new MergeCompletableObserver(completableObserver, compositeDisposable, atomicInteger);
        while (true) {
            CompletableSource completableSource;
            block10: {
                if (compositeDisposable.isDisposed()) {
                    return;
                }
                try {
                    boolean bl = iterator.hasNext();
                    if (bl) break block10;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    compositeDisposable.dispose();
                    completableObserver.onError(throwable);
                    return;
                }
                completableObserver.onComplete();
                return;
            }
            if (compositeDisposable.isDisposed()) {
                return;
            }
            try {
                completableSource = (CompletableSource)ObjectHelper.requireNonNull(iterator.next(), (String)"The iterator returned a null CompletableSource");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                compositeDisposable.dispose();
                completableObserver.onError(throwable);
                return;
            }
            if (compositeDisposable.isDisposed()) {
                return;
            }
            atomicInteger.getAndIncrement();
            completableSource.subscribe(completableObserver);
        }
    }
}
