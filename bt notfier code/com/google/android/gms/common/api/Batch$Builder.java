/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Batch
 *  com.google.android.gms.common.api.BatchResultToken
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Result
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Batch;
import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.ArrayList;
import java.util.List;

public static final class Batch.Builder {
    private List<PendingResult<?>> zaa = new ArrayList();
    private GoogleApiClient zab;

    public Batch.Builder(GoogleApiClient googleApiClient) {
        this.zab = googleApiClient;
    }

    public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
        BatchResultToken batchResultToken = new BatchResultToken(this.zaa.size());
        this.zaa.add(pendingResult);
        return batchResultToken;
    }

    public Batch build() {
        return new Batch(this.zaa, this.zab, null);
    }
}
