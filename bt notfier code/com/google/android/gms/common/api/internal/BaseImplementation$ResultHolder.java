/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

public static interface BaseImplementation.ResultHolder<R> {
    public void setFailedResult(Status var1);

    public void setResult(R var1);
}
