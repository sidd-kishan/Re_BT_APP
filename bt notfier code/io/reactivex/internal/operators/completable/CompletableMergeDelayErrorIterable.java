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
 *  io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray$MergeInnerCompletableObserver
 *  io.reactivex.internal.util.AtomicThrowable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorIterable
extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.sources = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Serializable serializable;
        Iterator iterator;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe((Disposable)compositeDisposable);
        try {
            iterator = (Iterator)ObjectHelper.requireNonNull(this.sources.iterator(), (String)"The source iterator returned is null");
            serializable = new AtomicInteger(1);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            completableObserver.onError(throwable);
            return;
        }
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        while (true) {
            CompletableSource completableSource;
            block13: {
                if (compositeDisposable.isDisposed()) {
                    return;
                }
                try {
                    boolean bl = iterator.hasNext();
                    if (!bl) {
                    }
                    break block13;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    atomicThrowable.addThrowable(throwable);
                }
                break;
            }
            if (compositeDisposable.isDisposed()) {
                return;
            }
            try {
                completableSource = (CompletableSource)ObjectHelper.requireNonNull(iterator.next(), (String)"The iterator returned a null CompletableSource");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                atomicThrowable.addThrowable(throwable);
                break;
            }
            if (compositeDisposable.isDisposed()) {
                return;
            }
            ((AtomicInteger)serializable).getAndIncrement();
            completableSource.subscribe((CompletableObserver)new CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, (AtomicInteger)serializable));
        }
        if (((AtomicInteger)serializable).decrementAndGet() != 0) return;
        serializable = atomicThrowable.terminate();
        if (serializable == null) {
            completableObserver.onComplete();
        } else {
            completableObserver.onError((Throwable)serializable);
        }
    }
}
