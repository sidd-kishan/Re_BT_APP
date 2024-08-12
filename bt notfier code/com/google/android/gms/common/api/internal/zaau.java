/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.internal.StatusPendingResult
 *  com.google.android.gms.common.api.internal.zaaz
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaaz;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class zaau
implements GoogleApiClient.ConnectionCallbacks {
    final AtomicReference zaa;
    final StatusPendingResult zab;
    final zaaz zac;

    zaau(zaaz zaaz2, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zac = zaaz2;
        this.zaa = atomicReference;
        this.zab = statusPendingResult;
    }

    public final void onConnected(Bundle bundle) {
        zaaz.zaj((zaaz)this.zac, (GoogleApiClient)((GoogleApiClient)Preconditions.checkNotNull((Object)((GoogleApiClient)this.zaa.get()))), (StatusPendingResult)this.zab, (boolean)true);
    }

    public final void onConnectionSuspended(int n) {
    }
}
