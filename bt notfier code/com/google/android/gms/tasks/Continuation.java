/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;

public interface Continuation<TResult, TContinuationResult> {
    public TContinuationResult then(Task<TResult> var1) throws Exception;
}
