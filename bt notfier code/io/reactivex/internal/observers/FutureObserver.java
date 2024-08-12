/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T>
extends CountDownLatch
implements Observer<T>,
Future<T>,
Disposable {
    Throwable error;
    final AtomicReference<Disposable> upstream = new AtomicReference();
    T value;

    public FutureObserver() {
        super(1);
    }

    @Override
    public boolean cancel(boolean bl) {
        Disposable disposable;
        do {
            if ((disposable = this.upstream.get()) == this) return false;
            if (disposable != DisposableHelper.DISPOSED) continue;
            return false;
        } while (!this.upstream.compareAndSet(disposable, (Disposable)DisposableHelper.DISPOSED));
        if (disposable != null) {
            disposable.dispose();
        }
        this.countDown();
        return true;
    }

    public void dispose() {
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        if (this.getCount() != 0L) {
            BlockingHelper.verifyNonBlocking();
            this.await();
        }
        if (this.isCancelled()) throw new CancellationException();
        Throwable throwable = this.error;
        if (throwable != null) throw new ExecutionException(throwable);
        return this.value;
    }

    @Override
    public T get(long l, TimeUnit object) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.getCount() != 0L) {
            BlockingHelper.verifyNonBlocking();
            if (!this.await(l, (TimeUnit)((Object)object))) throw new TimeoutException(ExceptionHelper.timeoutMessage((long)l, (TimeUnit)((Object)object)));
        }
        if (this.isCancelled()) throw new CancellationException();
        object = this.error;
        if (object != null) throw new ExecutionException((Throwable)object);
        return this.value;
    }

    @Override
    public boolean isCancelled() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public boolean isDisposed() {
        return this.isDone();
    }

    @Override
    public boolean isDone() {
        boolean bl = this.getCount() == 0L;
        return bl;
    }

    public void onComplete() {
        Disposable disposable;
        if (this.value == null) {
            this.onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            if ((disposable = this.upstream.get()) == this) return;
            if (disposable == DisposableHelper.DISPOSED) return;
        } while (!this.upstream.compareAndSet(disposable, this));
        this.countDown();
    }

    public void onError(Throwable throwable) {
        Disposable disposable;
        if (this.error != null) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        while ((disposable = this.upstream.get()) != this && disposable != DisposableHelper.DISPOSED) {
            if (!this.upstream.compareAndSet(disposable, this)) continue;
            this.countDown();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(T t) {
        if (this.value != null) {
            this.upstream.get().dispose();
            this.onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }
}
