/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  com.google.android.gms.common.api.Api$BaseClientBuilder
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.internal.ConnectionCallbacks
 *  com.google.android.gms.common.api.internal.OnConnectionFailedListener
 *  com.google.android.gms.common.internal.ClientSettings
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

public static abstract class Api.AbstractClientBuilder<T extends Api.Client, O>
extends Api.BaseClientBuilder<T, O> {
    @Deprecated
    public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.buildClient(context, looper, clientSettings, o, (ConnectionCallbacks)connectionCallbacks, (OnConnectionFailedListener)onConnectionFailedListener);
    }

    public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }
}
