/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.zack
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zack;

public abstract class ResultTransform<R extends Result, S extends Result> {
    public final PendingResult<S> createFailedResult(Status status) {
        return new zack(status);
    }

    public Status onFailure(Status status) {
        return status;
    }

    public abstract PendingResult<S> onSuccess(R var1);
}
