/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Batch
 *  com.google.android.gms.common.api.BatchResult
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Batch;
import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zab
implements PendingResult.StatusListener {
    final Batch zaa;

    zab(Batch batch) {
        this.zaa = batch;
    }

    public final void onComplete(Status status) {
        Object object = Batch.zaa((Batch)this.zaa);
        synchronized (object) {
            if (this.zaa.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                Batch.zab((Batch)this.zaa, (boolean)true);
            } else if (!status.isSuccess()) {
                Batch.zac((Batch)this.zaa, (boolean)true);
            }
            Batch.zad((Batch)this.zaa);
            if (Batch.zae((Batch)this.zaa) != 0) return;
            if (Batch.zaf((Batch)this.zaa)) {
                Batch.zag((Batch)this.zaa);
            } else {
                status = Batch.zah((Batch)this.zaa) ? new Status(13) : Status.RESULT_SUCCESS;
                Batch batch = this.zaa;
                BatchResult batchResult = new BatchResult(status, Batch.zai((Batch)batch));
                batch.setResult((Result)batchResult);
            }
            return;
        }
    }
}
