/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateRequest
 *  androidx.core.util.Pools$SynchronizedPool
 */
package androidx.asynclayoutinflater.view;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

private static class AsyncLayoutInflater.InflateThread
extends Thread {
    private static final AsyncLayoutInflater.InflateThread sInstance;
    private ArrayBlockingQueue<AsyncLayoutInflater.InflateRequest> mQueue = new ArrayBlockingQueue(10);
    private Pools.SynchronizedPool<AsyncLayoutInflater.InflateRequest> mRequestPool = new Pools.SynchronizedPool(10);

    static {
        AsyncLayoutInflater.InflateThread inflateThread;
        sInstance = inflateThread = new AsyncLayoutInflater.InflateThread();
        inflateThread.start();
    }

    private AsyncLayoutInflater.InflateThread() {
    }

    public static AsyncLayoutInflater.InflateThread getInstance() {
        return sInstance;
    }

    public void enqueue(AsyncLayoutInflater.InflateRequest inflateRequest) {
        try {
            this.mQueue.put(inflateRequest);
            return;
        }
        catch (InterruptedException interruptedException) {
            throw new RuntimeException("Failed to enqueue async inflate request", interruptedException);
        }
    }

    public AsyncLayoutInflater.InflateRequest obtainRequest() {
        AsyncLayoutInflater.InflateRequest inflateRequest;
        AsyncLayoutInflater.InflateRequest inflateRequest2 = inflateRequest = (AsyncLayoutInflater.InflateRequest)this.mRequestPool.acquire();
        if (inflateRequest != null) return inflateRequest2;
        inflateRequest2 = new AsyncLayoutInflater.InflateRequest();
        return inflateRequest2;
    }

    public void releaseRequest(AsyncLayoutInflater.InflateRequest inflateRequest) {
        inflateRequest.callback = null;
        inflateRequest.inflater = null;
        inflateRequest.parent = null;
        inflateRequest.resid = 0;
        inflateRequest.view = null;
        this.mRequestPool.release((Object)inflateRequest);
    }

    @Override
    public void run() {
        while (true) {
            this.runInner();
        }
    }

    public void runInner() {
        AsyncLayoutInflater.InflateRequest inflateRequest;
        try {
            inflateRequest = this.mQueue.take();
        }
        catch (InterruptedException interruptedException) {
            Log.w((String)"AsyncLayoutInflater", (Throwable)interruptedException);
            return;
        }
        try {
            inflateRequest.view = inflateRequest.inflater.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)"AsyncLayoutInflater", (String)"Failed to inflate resource in the background! Retrying on the UI thread", (Throwable)runtimeException);
        }
        Message.obtain((Handler)inflateRequest.inflater.mHandler, (int)0, (Object)inflateRequest).sendToTarget();
    }
}
