/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.zacs
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class TaskUtil {
    public static void setResultOrApiException(Status status, TaskCompletionSource<Void> taskCompletionSource) {
        TaskUtil.setResultOrApiException(status, null, taskCompletionSource);
    }

    public static <TResult> void setResultOrApiException(Status status, TResult TResult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(TResult);
            return;
        }
        taskCompletionSource.setException((Exception)new ApiException(status));
    }

    @Deprecated
    public static Task<Void> toVoidTaskThatFailsOnFalse(Task<Boolean> task) {
        return task.continueWith((Continuation)new zacs());
    }

    public static <ResultT> boolean trySetResultOrApiException(Status status, ResultT ResultT, TaskCompletionSource<ResultT> taskCompletionSource) {
        if (!status.isSuccess()) return taskCompletionSource.trySetException((Exception)new ApiException(status));
        return taskCompletionSource.trySetResult(ResultT);
    }
}
