/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Response
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.internal.PendingResultUtil$ResultConverter
 *  com.google.android.gms.common.internal.zao
 *  com.google.android.gms.common.internal.zap
 *  com.google.android.gms.common.internal.zaq
 *  com.google.android.gms.common.internal.zar
 *  com.google.android.gms.common.internal.zas
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.zao;
import com.google.android.gms.common.internal.zap;
import com.google.android.gms.common.internal.zaq;
import com.google.android.gms.common.internal.zar;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class PendingResultUtil {
    private static final zas zaa = new zao();

    public static <R extends Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> pendingResult, T t) {
        return PendingResultUtil.toTask(pendingResult, new zaq(t));
    }

    public static <R extends Result, T> Task<T> toTask(PendingResult<R> pendingResult, ResultConverter<R, T> resultConverter) {
        zas zas2 = zaa;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener((PendingResult.StatusListener)new zap(pendingResult, taskCompletionSource, resultConverter, zas2));
        return taskCompletionSource.getTask();
    }

    public static <R extends Result> Task<Void> toVoidTask(PendingResult<R> pendingResult) {
        return PendingResultUtil.toTask(pendingResult, new zar());
    }
}
