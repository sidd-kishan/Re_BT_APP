/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.StatusPendingResult
 *  com.google.android.gms.common.api.internal.zaaz
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaaz;

final class zaav
implements GoogleApiClient.OnConnectionFailedListener {
    final StatusPendingResult zaa;

    zaav(zaaz zaaz2, StatusPendingResult statusPendingResult) {
        this.zaa = statusPendingResult;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaa.setResult((Result)new Status(8));
    }
}
