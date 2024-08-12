/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.completable.CompletableDoOnEvent
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;

final class CompletableDoOnEvent.DoOnEvent
implements CompletableObserver {
    private final CompletableObserver observer;
    final CompletableDoOnEvent this$0;

    CompletableDoOnEvent.DoOnEvent(CompletableDoOnEvent completableDoOnEvent, CompletableObserver completableObserver) {
        this.this$0 = completableDoOnEvent;
        this.observer = completableObserver;
    }

    public void onComplete() {
        try {
            this.this$0.onEvent.accept(null);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.observer.onError(throwable);
            return;
        }
        this.observer.onComplete();
    }

    public void onError(Throwable throwable) {
        try {
            this.this$0.onEvent.accept((Object)throwable);
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            throwable = new CompositeException(new Throwable[]{throwable, throwable2});
        }
        this.observer.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.observer.onSubscribe(disposable);
    }
}
