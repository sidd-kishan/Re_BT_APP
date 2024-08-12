/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater$BasicInflater
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateRequest
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateThread
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater$OnInflateFinishedListener
 */
package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;

/*
 * Exception performing whole class analysis ignored.
 */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    Handler mHandler;
    private Handler.Callback mHandlerCallback = new /* Unavailable Anonymous Inner Class!! */;
    InflateThread mInflateThread;
    LayoutInflater mInflater;

    public AsyncLayoutInflater(Context context) {
        this.mInflater = new BasicInflater(context);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    public void inflate(int n, ViewGroup viewGroup, OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener == null) throw new NullPointerException("callback argument may not be null!");
        InflateRequest inflateRequest = this.mInflateThread.obtainRequest();
        inflateRequest.inflater = this;
        inflateRequest.resid = n;
        inflateRequest.parent = viewGroup;
        inflateRequest.callback = onInflateFinishedListener;
        this.mInflateThread.enqueue(inflateRequest);
    }
}
