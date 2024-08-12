/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BasePendingResult
 */
package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zae<R extends Result>
extends BasePendingResult<R> {
    private final R zae;

    public zae(R r) {
        super(Looper.getMainLooper());
        this.zae = r;
    }

    protected final R createFailedResult(Status status) {
        if (status.getStatusCode() != this.zae.getStatus().getStatusCode()) throw new UnsupportedOperationException("Creating failed results is not supported");
        return this.zae;
    }
}
