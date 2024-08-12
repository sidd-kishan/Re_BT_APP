/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.internal.zat
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.Preconditions;

public final class zas
implements GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zaa;
    private final boolean zab;
    private zat zac;

    public zas(Api<?> api, boolean bl) {
        this.zaa = api;
        this.zab = bl;
    }

    private final zat zab() {
        Preconditions.checkNotNull((Object)this.zac, (Object)"Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.zac;
    }

    public final void onConnected(Bundle bundle) {
        this.zab().onConnected(bundle);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zab().zaa(connectionResult, this.zaa, this.zab);
    }

    public final void onConnectionSuspended(int n) {
        this.zab().onConnectionSuspended(n);
    }

    public final void zaa(zat zat2) {
        this.zac = zat2;
    }
}
