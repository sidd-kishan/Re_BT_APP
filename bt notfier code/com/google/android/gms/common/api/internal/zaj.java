/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.internal.zak
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zak;

final class zaj
implements GoogleApiClient.OnConnectionFailedListener {
    public final int zaa;
    public final GoogleApiClient zab;
    public final GoogleApiClient.OnConnectionFailedListener zac;
    final zak zad;

    public zaj(zak zak2, int n, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zad = zak2;
        this.zaa = n;
        this.zab = googleApiClient;
        this.zac = onConnectionFailedListener;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        String string = String.valueOf(connectionResult);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 27);
        stringBuilder.append("beginFailureResolution for ");
        stringBuilder.append(string);
        Log.d((String)"AutoManageHelper", (String)stringBuilder.toString());
        this.zad.zaf(connectionResult, this.zaa);
    }
}
