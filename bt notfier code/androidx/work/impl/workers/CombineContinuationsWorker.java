/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Data
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Worker
 *  androidx.work.WorkerParameters
 */
package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CombineContinuationsWorker
extends Worker {
    public CombineContinuationsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        return ListenableWorker.Result.success((Data)this.getInputData());
    }
}
