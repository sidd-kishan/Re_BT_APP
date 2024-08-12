/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.BatchResultToken
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.TimeUnit;

public final class BatchResult
implements Result {
    private final Status zaa;
    private final PendingResult<?>[] zab;

    BatchResult(Status status, PendingResult<?>[] pendingResultArray) {
        this.zaa = status;
        this.zab = pendingResultArray;
    }

    public Status getStatus() {
        return this.zaa;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        boolean bl = batchResultToken.mId < this.zab.length;
        Preconditions.checkArgument((boolean)bl, (Object)"The result token does not belong to this batch");
        return (R)this.zab[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
