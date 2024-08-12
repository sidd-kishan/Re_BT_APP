/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableTimeout$DisposeTask
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableTimeout;

final class CompletableTimeout.DisposeTask.DisposeObserver
implements CompletableObserver {
    final CompletableTimeout.DisposeTask this$1;

    CompletableTimeout.DisposeTask.DisposeObserver(CompletableTimeout.DisposeTask disposeTask) {
        this.this$1 = disposeTask;
    }

    public void onComplete() {
        this.this$1.set.dispose();
        this.this$1.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.this$1.set.dispose();
        this.this$1.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.this$1.set.add(disposable);
    }
}
