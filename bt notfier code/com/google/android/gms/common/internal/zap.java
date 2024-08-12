/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.internal.ApiExceptionUtil
 *  com.google.android.gms.common.internal.PendingResultUtil$ResultConverter
 *  com.google.android.gms.common.internal.zas
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class zap
implements PendingResult.StatusListener {
    final PendingResult zaa;
    final TaskCompletionSource zab;
    final PendingResultUtil.ResultConverter zac;
    final zas zad;

    zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zas zas2) {
        this.zaa = pendingResult;
        this.zab = taskCompletionSource;
        this.zac = resultConverter;
        this.zad = zas2;
    }

    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            status = this.zaa.await(0L, TimeUnit.MILLISECONDS);
            this.zab.setResult(this.zac.convert((Result)status));
            return;
        }
        this.zab.setException((Exception)ApiExceptionUtil.fromStatus((Status)status));
    }
}
