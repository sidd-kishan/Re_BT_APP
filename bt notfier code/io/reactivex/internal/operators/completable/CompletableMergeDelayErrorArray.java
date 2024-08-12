/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray$MergeInnerCompletableObserver
 *  io.reactivex.internal.util.AtomicThrowable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorArray
extends Completable {
    final CompletableSource[] sources;

    public CompletableMergeDelayErrorArray(CompletableSource[] completableSourceArray) {
        this.sources = completableSourceArray;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        Object object = new AtomicThrowable();
        completableObserver.onSubscribe((Disposable)compositeDisposable);
        for (CompletableSource completableSource : this.sources) {
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                object.addThrowable((Throwable)new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
                continue;
            }
            completableSource.subscribe((CompletableObserver)new MergeInnerCompletableObserver(completableObserver, compositeDisposable, object, atomicInteger));
        }
        if (atomicInteger.decrementAndGet() != 0) return;
        if ((object = object.terminate()) == null) {
            completableObserver.onComplete();
        } else {
            completableObserver.onError((Throwable)object);
        }
    }
}
