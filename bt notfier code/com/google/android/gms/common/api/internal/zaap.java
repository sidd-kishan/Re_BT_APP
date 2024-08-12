/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.internal.zaah
 *  com.google.android.gms.common.api.internal.zaao
 *  com.google.android.gms.common.api.internal.zaar
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.signin.internal.zae
 *  com.google.android.gms.signin.zae
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zaah;
import com.google.android.gms.common.api.internal.zaao;
import com.google.android.gms.common.api.internal.zaar;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.internal.zae;

final class zaap
implements GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener {
    final zaar zaa;

    /* synthetic */ zaap(zaar zaar2, zaah zaah2) {
        this.zaa = zaar2;
    }

    public final void onConnected(Bundle bundle) {
        bundle = (ClientSettings)Preconditions.checkNotNull((Object)zaar.zar((zaar)this.zaa));
        ((com.google.android.gms.signin.zae)Preconditions.checkNotNull((Object)zaar.zao((zaar)this.zaa))).zaa((zae)new zaao(this.zaa));
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zaar.zak((zaar)this.zaa).lock();
        try {
            if (zaar.zas((zaar)this.zaa, (ConnectionResult)connectionResult)) {
                zaar.zat((zaar)this.zaa);
                zaar.zau((zaar)this.zaa);
            } else {
                zaar.zam((zaar)this.zaa, (ConnectionResult)connectionResult);
            }
            return;
        }
        finally {
            zaar.zak((zaar)this.zaa).unlock();
        }
    }

    public final void onConnectionSuspended(int n) {
    }
}
