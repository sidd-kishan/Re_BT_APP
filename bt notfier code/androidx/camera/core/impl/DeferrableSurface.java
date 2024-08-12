/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.Surface
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException
 *  androidx.camera.core.impl._$$Lambda$DeferrableSurface$4AwivYkWbX9ifTwpoNEQg994K4I
 *  androidx.camera.core.impl._$$Lambda$DeferrableSurface$XxjDv83UzOW4COPv7lY3gXa8cFA
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl;

import android.util.Log;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl._$;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DeferrableSurface {
    private static final boolean DEBUG = Logger.isDebugEnabled((String)"DeferrableSurface");
    private static final String TAG = "DeferrableSurface";
    private static final AtomicInteger TOTAL_COUNT;
    private static final AtomicInteger USED_COUNT;
    private boolean mClosed = false;
    private final Object mLock = new Object();
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.DeferrableSurface.4AwivYkWbX9ifTwpoNEQg994K4I(this));
    private int mUseCount = 0;

    static {
        USED_COUNT = new AtomicInteger(0);
        TOTAL_COUNT = new AtomicInteger(0);
    }

    public DeferrableSurface() {
        if (!Logger.isDebugEnabled((String)TAG)) return;
        this.printGlobalDebugCounts("Surface created", TOTAL_COUNT.incrementAndGet(), USED_COUNT.get());
        String string = Log.getStackTraceString((Throwable)new Exception());
        this.mTerminationFuture.addListener((Runnable)new _$.Lambda.DeferrableSurface.XxjDv83UzOW4COPv7lY3gXa8cFA(this, string), CameraXExecutors.directExecutor());
    }

    private void printGlobalDebugCounts(String string, int n, int n2) {
        if (!DEBUG && Logger.isDebugEnabled((String)TAG)) {
            Logger.d((String)TAG, (String)"DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("[total_surfaces=");
        stringBuilder.append(n);
        stringBuilder.append(", used_surfaces=");
        stringBuilder.append(n2);
        stringBuilder.append("](");
        stringBuilder.append(this);
        stringBuilder.append("}");
        Logger.d((String)TAG, (String)stringBuilder.toString());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void close() {
        Object object;
        Object object2 = this.mLock;
        synchronized (object2) {
            if (!this.mClosed) {
                CallbackToFutureAdapter.Completer<Void> completer;
                this.mClosed = true;
                if (this.mUseCount == 0) {
                    completer = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                } else {
                    completer = null;
                }
                object = completer;
                if (Logger.isDebugEnabled((String)TAG)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("surface closed,  useCount=");
                    ((StringBuilder)object).append(this.mUseCount);
                    ((StringBuilder)object).append(" closed=true ");
                    ((StringBuilder)object).append(this);
                    Logger.d((String)TAG, (String)((StringBuilder)object).toString());
                    object = completer;
                }
            } else {
                object = null;
            }
        }
        if (object == null) return;
        object.set(null);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void decrementUseCount() {
        CallbackToFutureAdapter.Completer<Void> completer;
        Object object = this.mLock;
        synchronized (object) {
            int n;
            if (this.mUseCount == 0) {
                IllegalStateException illegalStateException = new IllegalStateException("Decrementing use count occurs more times than incrementing");
                throw illegalStateException;
            }
            this.mUseCount = n = this.mUseCount - 1;
            if (n == 0 && this.mClosed) {
                completer = this.mTerminationCompleter;
                this.mTerminationCompleter = null;
            } else {
                completer = null;
            }
            if (Logger.isDebugEnabled((String)TAG)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("use count-1,  useCount=");
                stringBuilder.append(this.mUseCount);
                stringBuilder.append(" closed=");
                stringBuilder.append(this.mClosed);
                stringBuilder.append(" ");
                stringBuilder.append(this);
                Logger.d((String)TAG, (String)stringBuilder.toString());
                if (this.mUseCount == 0) {
                    this.printGlobalDebugCounts("Surface no longer in use", TOTAL_COUNT.get(), USED_COUNT.decrementAndGet());
                }
            }
        }
        if (completer == null) return;
        completer.set(null);
    }

    public final ListenableFuture<Surface> getSurface() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mClosed) {
                Object object2 = new SurfaceClosedException("DeferrableSurface already closed.", this);
                object2 = Futures.immediateFailedFuture((Throwable)object2);
                return object2;
            }
            ListenableFuture<Surface> listenableFuture = this.provideSurface();
            return listenableFuture;
        }
    }

    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    public int getUseCount() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mUseCount;
            return n;
        }
    }

    public void incrementUseCount() throws SurfaceClosedException {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mUseCount == 0 && this.mClosed) {
                SurfaceClosedException surfaceClosedException = new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                throw surfaceClosedException;
            }
            ++this.mUseCount;
            if (!Logger.isDebugEnabled((String)TAG)) return;
            if (this.mUseCount == 1) {
                this.printGlobalDebugCounts("New surface in use", TOTAL_COUNT.get(), USED_COUNT.incrementAndGet());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("use count+1, useCount=");
            stringBuilder.append(this.mUseCount);
            stringBuilder.append(" ");
            stringBuilder.append(this);
            Logger.d((String)TAG, (String)stringBuilder.toString());
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public /* synthetic */ Object lambda$new$0$DeferrableSurface(CallbackToFutureAdapter.Completer object) throws Exception {
        Object object2 = this.mLock;
        synchronized (object2) {
            this.mTerminationCompleter = object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("DeferrableSurface-termination(");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(")");
        return ((StringBuilder)object).toString();
    }

    public /* synthetic */ void lambda$new$1$DeferrableSurface(String object) {
        try {
            this.mTerminationFuture.get();
            this.printGlobalDebugCounts("Surface terminated", TOTAL_COUNT.decrementAndGet(), USED_COUNT.get());
            return;
        }
        catch (Exception exception) {
            Serializable serializable = new StringBuilder();
            serializable.append("Unexpected surface termination for ");
            serializable.append(this);
            serializable.append("\nStack Trace:\n");
            serializable.append((String)object);
            Logger.e((String)TAG, (String)serializable.toString());
            object = this.mLock;
            synchronized (object) {
                serializable = new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", this, this.mClosed, this.mUseCount), exception);
                throw serializable;
            }
        }
    }

    protected abstract ListenableFuture<Surface> provideSurface();
}
