/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;

public interface SuccessContinuation<TResult, TContinuationResult> {
    public Task<TContinuationResult> then(TResult var1) throws Exception;
}
