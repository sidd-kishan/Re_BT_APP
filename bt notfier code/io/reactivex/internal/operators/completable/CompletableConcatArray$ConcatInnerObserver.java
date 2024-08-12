/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

static final class CompletableConcatArray.ConcatInnerObserver
extends AtomicInteger
implements CompletableObserver {
    private static final long serialVersionUID = -7965400327305809232L;
    final CompletableObserver downstream;
    int index;
    final SequentialDisposable sd;
    final CompletableSource[] sources;

    CompletableConcatArray.ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArray) {
        this.downstream = completableObserver;
        this.sources = completableSourceArray;
        this.sd = new SequentialDisposable();
    }

    void next() {
        if (this.sd.isDisposed()) {
            return;
        }
        if (this.getAndIncrement() != 0) {
            return;
        }
        CompletableSource[] completableSourceArray = this.sources;
        do {
            if (this.sd.isDisposed()) {
                return;
            }
            int n = this.index;
            this.index = n + 1;
            if (n == completableSourceArray.length) {
                this.downstream.onComplete();
                return;
            }
            completableSourceArray[n].subscribe((CompletableObserver)this);
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
