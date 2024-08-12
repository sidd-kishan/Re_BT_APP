/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableMergeArray$InnerCompletableObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableMergeArray
extends Completable {
    final CompletableSource[] sources;

    public CompletableMergeArray(CompletableSource[] completableSourceArray) {
        this.sources = completableSourceArray;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), compositeDisposable, this.sources.length + 1);
        completableObserver.onSubscribe((Disposable)compositeDisposable);
        CompletableSource[] completableSourceArray = this.sources;
        int n = completableSourceArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                innerCompletableObserver.onComplete();
                return;
            }
            completableObserver = completableSourceArray[n2];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableObserver == null) {
                compositeDisposable.dispose();
                innerCompletableObserver.onError((Throwable)new NullPointerException("A completable source is null"));
                return;
            }
            completableObserver.subscribe((CompletableObserver)innerCompletableObserver);
            ++n2;
        }
    }
}
