/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.request.FutureTarget
 *  com.bumptech.glide.request.Request
 *  com.bumptech.glide.request.RequestFutureTarget$Waiter
 *  com.bumptech.glide.request.RequestListener
 *  com.bumptech.glide.request.target.SizeReadyCallback
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.request.transition.Transition
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R>
implements FutureTarget<R>,
RequestListener<R>,
Runnable {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private final Handler mainHandler;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    public RequestFutureTarget(Handler handler, int n, int n2) {
        this(handler, n, n2, true, DEFAULT_WAITER);
    }

    RequestFutureTarget(Handler handler, int n, int n2, boolean bl, Waiter waiter) {
        this.mainHandler = handler;
        this.width = n;
        this.height = n2;
        this.assertBackgroundThread = bl;
        this.waiter = waiter;
    }

    private void clearOnMainThread() {
        this.mainHandler.post((Runnable)this);
    }

    private R doGet(Long serializable) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            try {
                if (this.assertBackgroundThread && !this.isDone()) {
                    Util.assertBackgroundThread();
                }
                if (this.isCancelled) {
                    serializable = new CancellationException();
                    throw serializable;
                }
                if (this.loadFailed) {
                    serializable = new ExecutionException((Throwable)this.exception);
                    throw serializable;
                }
                if (this.resultReceived) {
                    serializable = this.resource;
                    return (R)serializable;
                }
                if (serializable == null) {
                    this.waiter.waitForTimeout((Object)this, 0L);
                } else if (serializable > 0L) {
                    long l = System.currentTimeMillis();
                    long l2 = serializable + l;
                    while (!this.isDone() && l < l2) {
                        this.waiter.waitForTimeout((Object)this, l2 - l);
                        l = System.currentTimeMillis();
                    }
                }
                if (Thread.interrupted()) {
                    serializable = new InterruptedException();
                    throw serializable;
                }
                if (this.loadFailed) {
                    serializable = new ExecutionException((Throwable)this.exception);
                    throw serializable;
                }
                if (this.isCancelled) {
                    serializable = new CancellationException();
                    throw serializable;
                }
                if (this.resultReceived) {
                    serializable = this.resource;
                    return (R)serializable;
                }
                serializable = new TimeoutException();
                throw serializable;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean cancel(boolean bl) {
        synchronized (this) {
            boolean bl2 = this.isDone();
            if (bl2) {
                return false;
            }
            this.isCancelled = true;
            this.waiter.notifyAll((Object)this);
            if (!bl) return true;
            this.clearOnMainThread();
            return true;
        }
    }

    public R get() throws InterruptedException, ExecutionException {
        R r;
        try {
            r = this.doGet(null);
        }
        catch (TimeoutException timeoutException) {
            throw new AssertionError((Object)timeoutException);
        }
        return r;
    }

    public R get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.doGet(timeUnit.toMillis(l));
    }

    public Request getRequest() {
        return this.request;
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    public boolean isCancelled() {
        synchronized (this) {
            boolean bl = this.isCancelled;
            return bl;
        }
    }

    public boolean isDone() {
        synchronized (this) {
            boolean bl;
            bl = this.isCancelled || this.resultReceived || (bl = this.loadFailed);
            return bl;
        }
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public void onLoadFailed(Drawable drawable) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public boolean onLoadFailed(GlideException glideException, Object object, Target<R> target, boolean bl) {
        synchronized (this) {
            this.loadFailed = true;
            this.exception = glideException;
            this.waiter.notifyAll((Object)this);
            return false;
        }
    }

    public void onLoadStarted(Drawable drawable) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public void onResourceReady(R r, Transition<? super R> transition) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public boolean onResourceReady(R r, Object object, Target<R> target, DataSource dataSource, boolean bl) {
        synchronized (this) {
            this.resultReceived = true;
            this.resource = r;
            this.waiter.notifyAll((Object)this);
            return false;
        }
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    @Override
    public void run() {
        Request request = this.request;
        if (request == null) return;
        request.clear();
        this.request = null;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
