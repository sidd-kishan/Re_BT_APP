/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableContainer
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable
extends AtomicReferenceArray<Object>
implements Runnable,
Callable<Object>,
Disposable {
    static final Object ASYNC_DISPOSED;
    static final Object DONE;
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED;
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    static {
        PARENT_DISPOSED = new Object();
        SYNC_DISPOSED = new Object();
        ASYNC_DISPOSED = new Object();
        DONE = new Object();
    }

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.actual = runnable;
        this.lazySet(0, disposableContainer);
    }

    @Override
    public Object call() {
        this.run();
        return null;
    }

    public void dispose() {
        Object object;
        Object e;
        while ((e = this.get(1)) != DONE && e != SYNC_DISPOSED && e != ASYNC_DISPOSED) {
            boolean bl = this.get(2) != Thread.currentThread();
            object = bl ? ASYNC_DISPOSED : SYNC_DISPOSED;
            if (!this.compareAndSet(1, e, object)) continue;
            if (e == null) break;
            ((Future)e).cancel(bl);
            break;
        }
        do {
            if ((e = this.get(0)) == DONE) return;
            object = PARENT_DISPOSED;
            if (e == object) return;
            if (e == null) return;
        } while (!this.compareAndSet(0, e, object));
        ((DisposableContainer)e).delete((Disposable)this);
    }

    public boolean isDisposed() {
        boolean bl = false;
        Object e = this.get(0);
        if (e != PARENT_DISPOSED) {
            if (e != DONE) return bl;
        }
        bl = true;
        return bl;
    }

    @Override
    public void run() {
        this.lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        }
        catch (Throwable throwable) {
            try {
                RxJavaPlugins.onError((Throwable)throwable);
            }
            catch (Throwable throwable2) {
                this.lazySet(2, null);
                Object e = this.get(0);
                if (e != PARENT_DISPOSED && this.compareAndSet(0, e, DONE) && e != null) {
                    ((DisposableContainer)e).delete((Disposable)this);
                }
                while ((e = this.get(1)) != SYNC_DISPOSED) {
                    if (e == ASYNC_DISPOSED) throw throwable2;
                    if (this.compareAndSet(1, e, DONE)) throw throwable2;
                }
                throw throwable2;
            }
        }
        this.lazySet(2, null);
        Object e = this.get(0);
        if (e != PARENT_DISPOSED && this.compareAndSet(0, e, DONE) && e != null) {
            ((DisposableContainer)e).delete((Disposable)this);
        }
        do {
            if ((e = this.get(1)) == SYNC_DISPOSED) return;
            if (e == ASYNC_DISPOSED) return;
        } while (!this.compareAndSet(1, e, DONE));
    }

    public void setFuture(Future<?> future) {
        Object e;
        do {
            if ((e = this.get(1)) == DONE) {
                return;
            }
            if (e == SYNC_DISPOSED) {
                future.cancel(false);
                return;
            }
            if (e != ASYNC_DISPOSED) continue;
            future.cancel(true);
            return;
        } while (!this.compareAndSet(1, e, future));
    }
}
