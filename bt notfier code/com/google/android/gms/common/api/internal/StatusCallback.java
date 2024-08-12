/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
 *  com.google.android.gms.common.api.internal.IStatusCallback$Stub
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

public class StatusCallback
extends IStatusCallback.Stub {
    private final BaseImplementation.ResultHolder<Status> mResultHolder;

    public StatusCallback(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.mResultHolder = resultHolder;
    }

    public void onResult(Status status) {
        this.mResultHolder.setResult((Object)status);
    }
}
