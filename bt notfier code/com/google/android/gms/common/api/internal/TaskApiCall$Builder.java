/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.common.api.internal.TaskApiCall
 *  com.google.android.gms.common.api.internal.zacp
 *  com.google.android.gms.common.api.internal.zacq
 *  com.google.android.gms.common.api.internal.zacr
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.BiConsumer
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zacp;
import com.google.android.gms.common.api.internal.zacq;
import com.google.android.gms.common.api.internal.zacr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public static class TaskApiCall.Builder<A extends Api.AnyClient, ResultT> {
    private RemoteCall<A, TaskCompletionSource<ResultT>> zaa;
    private boolean zab = true;
    private Feature[] zac;
    private int zad = 0;

    private TaskApiCall.Builder() {
    }

    /* synthetic */ TaskApiCall.Builder(zacp zacp2) {
    }

    static /* synthetic */ RemoteCall zaa(TaskApiCall.Builder builder) {
        return builder.zaa;
    }

    public TaskApiCall<A, ResultT> build() {
        boolean bl = this.zaa != null;
        Preconditions.checkArgument((boolean)bl, (Object)"execute parameter required");
        return new zacr(this, this.zac, this.zab, this.zad);
    }

    @Deprecated
    public TaskApiCall.Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
        this.zaa = new zacq(biConsumer);
        return this;
    }

    public TaskApiCall.Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
        this.zaa = remoteCall;
        return this;
    }

    public TaskApiCall.Builder<A, ResultT> setAutoResolveMissingFeatures(boolean bl) {
        this.zab = bl;
        return this;
    }

    public TaskApiCall.Builder<A, ResultT> setFeatures(Feature ... featureArray) {
        this.zac = featureArray;
        return this;
    }

    public TaskApiCall.Builder<A, ResultT> setMethodKey(int n) {
        this.zad = n;
        return this;
    }
}
