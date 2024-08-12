/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.BatchResult
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.zab
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.zab;
import java.util.List;

public final class Batch
extends BasePendingResult<BatchResult> {
    private int zae;
    private boolean zaf;
    private boolean zag;
    private final PendingResult<?>[] zah;
    private final Object zai = new Object();

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zab zab2) {
        super(googleApiClient);
        int n;
        this.zae = n = list.size();
        this.zah = new PendingResult[n];
        if (list.isEmpty()) {
            this.setResult((Result)new BatchResult(Status.RESULT_SUCCESS, this.zah));
            return;
        }
        n = 0;
        while (n < list.size()) {
            this.zah[n] = googleApiClient = (PendingResult)list.get(n);
            googleApiClient.addStatusListener((PendingResult.StatusListener)new zab(this));
            ++n;
        }
    }

    static /* synthetic */ Object zaa(Batch batch) {
        return batch.zai;
    }

    static /* synthetic */ boolean zab(Batch batch, boolean bl) {
        batch.zag = true;
        return true;
    }

    static /* synthetic */ boolean zac(Batch batch, boolean bl) {
        batch.zaf = true;
        return true;
    }

    static /* synthetic */ int zad(Batch batch) {
        int n = batch.zae;
        batch.zae = n - 1;
        return n;
    }

    static /* synthetic */ int zae(Batch batch) {
        return batch.zae;
    }

    static /* synthetic */ boolean zaf(Batch batch) {
        return batch.zag;
    }

    static /* synthetic */ void zag(Batch batch) {
        super.cancel();
    }

    static /* synthetic */ boolean zah(Batch batch) {
        return batch.zaf;
    }

    static /* synthetic */ PendingResult[] zai(Batch batch) {
        return batch.zah;
    }

    public void cancel() {
        super.cancel();
        PendingResult<?>[] pendingResultArray = this.zah;
        int n = pendingResultArray.length;
        int n2 = 0;
        while (n2 < n) {
            pendingResultArray[n2].cancel();
            ++n2;
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zah);
    }
}
