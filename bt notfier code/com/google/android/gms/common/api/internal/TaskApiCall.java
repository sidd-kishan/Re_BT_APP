/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.TaskApiCall$Builder
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    protected TaskApiCall(Feature[] featureArray, boolean bl, int n) {
        boolean bl2;
        this.zaa = featureArray;
        boolean bl3 = bl2 = false;
        if (featureArray != null) {
            bl3 = bl2;
            if (bl) {
                bl3 = true;
            }
        }
        this.zab = bl3;
        this.zac = n;
    }

    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder(null);
    }

    protected abstract void doExecute(A var1, TaskCompletionSource<ResultT> var2) throws RemoteException;

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final Feature[] zaa() {
        return this.zaa;
    }

    public final int zab() {
        return this.zac;
    }
}
