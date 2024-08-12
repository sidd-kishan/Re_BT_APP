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

final class zag<R extends Result>
extends BasePendingResult<R> {
    public zag(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected final R createFailedResult(Status status) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
