/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.ListenableWorker
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.WorkerParameters
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker
extends ListenableWorker {
    SettableFuture<ListenableWorker.Result> mFuture;

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result doWork();

    public final ListenableFuture<ListenableWorker.Result> startWork() {
        this.mFuture = SettableFuture.create();
        this.getBackgroundExecutor().execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        return this.mFuture;
    }
}
