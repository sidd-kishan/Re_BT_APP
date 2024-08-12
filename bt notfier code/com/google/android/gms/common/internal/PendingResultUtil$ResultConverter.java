/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Result
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Result;

public static interface PendingResultUtil.ResultConverter<R extends Result, T> {
    public T convert(R var1);
}
