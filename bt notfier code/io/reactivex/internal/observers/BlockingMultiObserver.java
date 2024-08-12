/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.MaybeObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BlockingMultiObserver<T>
extends CountDownLatch
implements SingleObserver<T>,
CompletableObserver,
MaybeObserver<T> {
    volatile boolean cancelled;
    Throwable error;
    Disposable upstream;
    T value;

    public BlockingMultiObserver() {
        super(1);
    }

    public boolean blockingAwait(long l, TimeUnit object) {
        if (this.getCount() != 0L) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!this.await(l, (TimeUnit)((Object)object))) {
                    this.dispose();
                    return false;
                }
            }
            catch (InterruptedException interruptedException) {
                this.dispose();
                throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
            }
        }
        if ((object = this.error) != null) throw ExceptionHelper.wrapOrThrow((Throwable)object);
        return true;
    }

    public T blockingGet() {
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

    public T blockingGet(T object) {
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
        throwable = this.value;
        if (throwable == null) return object;
        object = throwable;
        return object;
    }

    public Throwable blockingGetError() {
        if (this.getCount() == 0L) return this.error;
        try {
            BlockingHelper.verifyNonBlocking();
            this.await();
        }
        catch (InterruptedException interruptedException) {
            this.dispose();
            return interruptedException;
        }
        return this.error;
    }

    public Throwable blockingGetError(long l, TimeUnit timeUnit) {
        if (this.getCount() == 0L) return this.error;
        try {
            BlockingHelper.verifyNonBlocking();
            if (this.await(l, timeUnit)) return this.error;
            this.dispose();
            TimeoutException timeoutException = new TimeoutException(ExceptionHelper.timeoutMessage((long)l, (TimeUnit)timeUnit));
            throw ExceptionHelper.wrapOrThrow((Throwable)timeoutException);
        }
        catch (InterruptedException interruptedException) {
            this.dispose();
            throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
        }
    }

    void dispose() {
        this.cancelled = true;
        Disposable disposable = this.upstream;
        if (disposable == null) return;
        disposable.dispose();
    }

    public void onComplete() {
        this.countDown();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.countDown();
    }

    public void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        if (!this.cancelled) return;
        disposable.dispose();
    }

    public void onSuccess(T t) {
        this.value = t;
        this.countDown();
    }
}
