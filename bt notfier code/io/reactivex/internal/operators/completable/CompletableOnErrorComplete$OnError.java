/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.completable.CompletableOnErrorComplete
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;

final class CompletableOnErrorComplete.OnError
implements CompletableObserver {
    private final CompletableObserver downstream;
    final CompletableOnErrorComplete this$0;

    CompletableOnErrorComplete.OnError(CompletableOnErrorComplete completableOnErrorComplete, CompletableObserver completableObserver) {
        this.this$0 = completableOnErrorComplete;
        this.downstream = completableObserver;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        block3: {
            block2: {
                try {
                    boolean bl = this.this$0.predicate.test((Object)throwable);
                    if (!bl) break block2;
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                    return;
                }
                this.downstream.onComplete();
                break block3;
            }
            this.downstream.onError(throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.downstream.onSubscribe(disposable);
    }
}
