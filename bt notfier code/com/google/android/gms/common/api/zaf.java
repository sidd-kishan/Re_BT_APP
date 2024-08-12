/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BasePendingResult
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zaf<R extends Result>
extends BasePendingResult<R> {
    private final R zae;

    public zaf(GoogleApiClient googleApiClient, R r) {
        super(googleApiClient);
        this.zae = r;
    }

    protected final R createFailedResult(Status status) {
        return this.zae;
    }
}
