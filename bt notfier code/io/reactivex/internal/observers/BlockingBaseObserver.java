/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T>
extends CountDownLatch
implements Observer<T>,
Disposable {
    volatile boolean cancelled;
    Throwable error;
    Disposable upstream;
    T value;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T blockingGet() {
        Throwable throwable;
        if (this.getCount() != 0L) {
            try {
                BlockingHelper.verifyNonBlocking();
                this.await();
            }
            catch (InterruptedException interruptedException) {
                this.dispose();
                throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
            }
        }
        if ((throwable = this.error) != null) throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        return this.value;
    }

    public final void dispose() {
        this.cancelled = true;
        Disposable disposable = this.upstream;
        if (disposable == null) return;
        disposable.dispose();
    }

    public final boolean isDisposed() {
        return this.cancelled;
    }

    public final void onComplete() {
        this.countDown();
    }

    public final void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        if (!this.cancelled) return;
        disposable.dispose();
    }
}
