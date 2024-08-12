/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;

public static abstract class BaseImplementation.ApiMethodImpl<R extends Result, A extends Api.AnyClient>
extends BasePendingResult<R>
implements BaseImplementation.ResultHolder<R> {
    private final Api<?> mApi;
    private final Api.AnyClientKey<A> mClientKey;

    @Deprecated
    protected BaseImplementation.ApiMethodImpl(Api.AnyClientKey<A> anyClientKey, GoogleApiClient googleApiClient) {
        super((GoogleApiClient)Preconditions.checkNotNull((Object)googleApiClient, (Object)"GoogleApiClient must not be null"));
        this.mClientKey = (Api.AnyClientKey)Preconditions.checkNotNull(anyClientKey);
        this.mApi = null;
    }

    protected BaseImplementation.ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
        super((GoogleApiClient)Preconditions.checkNotNull((Object)googleApiClient, (Object)"GoogleApiClient must not be null"));
        Preconditions.checkNotNull(api, (Object)"Api must not be null");
        this.mClientKey = api.zac();
        this.mApi = api;
    }

    protected BaseImplementation.ApiMethodImpl(BasePendingResult.CallbackHandler<R> callbackHandler) {
        super(callbackHandler);
        this.mClientKey = new Api.AnyClientKey();
        this.mApi = null;
    }

    private void setFailedResult(RemoteException remoteException) {
        this.setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    protected abstract void doExecute(A var1) throws RemoteException;

    public final Api<?> getApi() {
        return this.mApi;
    }

    public final Api.AnyClientKey<A> getClientKey() {
        return this.mClientKey;
    }

    protected void onSetFailedResult(R r) {
    }

    public final void run(A a) throws DeadObjectException {
        try {
            this.doExecute(a);
            return;
        }
        catch (RemoteException remoteException) {
            this.setFailedResult(remoteException);
            return;
        }
        catch (DeadObjectException deadObjectException) {
            this.setFailedResult((RemoteException)((Object)deadObjectException));
            throw deadObjectException;
        }
    }

    public final void setFailedResult(Status status) {
        Preconditions.checkArgument((boolean)(status.isSuccess() ^ true), (Object)"Failed result must not be success");
        status = this.createFailedResult(status);
        this.setResult((Result)status);
        this.onSetFailedResult(status);
    }
}
