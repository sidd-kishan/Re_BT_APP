/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$ApiOptions$NoOptions
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.internal.ConnectionCallbacks
 *  com.google.android.gms.common.api.internal.OnConnectionFailedListener
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.internal.appset.zzd
 */
package com.google.android.gms.internal.appset;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.appset.zzd;

final class zzn
extends Api.AbstractClientBuilder<zzd, Api.ApiOptions.NoOptions> {
    zzn() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object object, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        object = (Api.ApiOptions.NoOptions)object;
        return new zzd(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
