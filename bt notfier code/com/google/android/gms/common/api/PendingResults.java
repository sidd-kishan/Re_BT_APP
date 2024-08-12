/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.OptionalPendingResult
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.OptionalPendingResultImpl
 *  com.google.android.gms.common.api.internal.StatusPendingResult
 *  com.google.android.gms.common.api.zae
 *  com.google.android.gms.common.api.zaf
 *  com.google.android.gms.common.api.zag
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.zae;
import com.google.android.gms.common.api.zaf;
import com.google.android.gms.common.api.zag;
import com.google.android.gms.common.internal.Preconditions;

public final class PendingResults {
    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R object) {
        Preconditions.checkNotNull(object, (Object)"Result must not be null");
        boolean bl = object.getStatus().getStatusCode() == 16;
        Preconditions.checkArgument((boolean)bl, (Object)"Status code must be CommonStatusCodes.CANCELED");
        object = new zae(object);
        object.cancel();
        return object;
    }

    public static <R extends Result> PendingResult<R> immediateFailedResult(R r, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, (Object)"Result must not be null");
        Preconditions.checkArgument((boolean)(r.getStatus().isSuccess() ^ true), (Object)"Status code must not be SUCCESS");
        googleApiClient = new zaf(googleApiClient, r);
        googleApiClient.setResult(r);
        return googleApiClient;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        Preconditions.checkNotNull(r, (Object)"Result must not be null");
        zag zag2 = new zag(null);
        zag2.setResult(r);
        return new OptionalPendingResultImpl((PendingResult)zag2);
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, (Object)"Result must not be null");
        googleApiClient = new zag(googleApiClient);
        googleApiClient.setResult(r);
        return new OptionalPendingResultImpl((PendingResult)googleApiClient);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        Preconditions.checkNotNull((Object)status, (Object)"Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult((Result)status);
        return statusPendingResult;
    }

    public static PendingResult<Status> immediatePendingResult(Status status, GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull((Object)status, (Object)"Result must not be null");
        googleApiClient = new StatusPendingResult(googleApiClient);
        googleApiClient.setResult((Result)status);
        return googleApiClient;
    }
}
