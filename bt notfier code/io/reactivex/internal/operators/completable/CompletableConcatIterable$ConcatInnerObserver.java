/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

static final class CompletableConcatIterable.ConcatInnerObserver
extends AtomicInteger
implements CompletableObserver {
    private static final long serialVersionUID = -7965400327305809232L;
    final CompletableObserver downstream;
    final SequentialDisposable sd;
    final Iterator<? extends CompletableSource> sources;

    CompletableConcatIterable.ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> iterator) {
        this.downstream = completableObserver;
        this.sources = iterator;
        this.sd = new SequentialDisposable();
    }

    void next() {
        if (this.sd.isDisposed()) {
            return;
        }
        if (this.getAndIncrement() != 0) {
            return;
        }
        Iterator<? extends CompletableSource> iterator = this.sources;
        do {
            CompletableSource completableSource;
            block8: {
                if (this.sd.isDisposed()) {
                    return;
                }
                try {
                    boolean bl = iterator.hasNext();
                    if (bl) break block8;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                    return;
                }
                this.downstream.onComplete();
                return;
            }
            try {
                completableSource = (CompletableSource)ObjectHelper.requireNonNull((Object)iterator.next(), (String)"The CompletableSource returned is null");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.downstream.onError(throwable);
                return;
            }
            completableSource.subscribe((CompletableObserver)this);
        } while (this.decrementAndGet() != 0);
    }

    public void onComplete() {
        this.next();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.sd.replace(disposable);
    }
}
