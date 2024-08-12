/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zabo
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zabo;

final class zabn
implements Runnable {
    final ConnectionResult zaa;
    final zabo zab;

    zabn(zabo zabo2, ConnectionResult connectionResult) {
        this.zab = zabo2;
        this.zaa = connectionResult;
    }

    @Override
    public final void run() {
        zabl zabl2 = (zabl)GoogleApiManager.zaG((GoogleApiManager)this.zab.zaa).get(zabo.zac((zabo)this.zab));
        if (zabl2 == null) {
            return;
        }
        if (!this.zaa.isSuccess()) {
            zabl2.zac(this.zaa, null);
            return;
        }
        zabo.zad((zabo)this.zab, (boolean)true);
        if (zabo.zae((zabo)this.zab).requiresSignIn()) {
            zabo.zaf((zabo)this.zab);
            return;
        }
        try {
            zabo.zae((zabo)this.zab).getRemoteService(null, zabo.zae((zabo)this.zab).getScopesForConnectionlessNonSignIn());
            return;
        }
        catch (SecurityException securityException) {
            Log.e((String)"GoogleApiManager", (String)"Failed to get service from broker. ", (Throwable)securityException);
            zabo.zae((zabo)this.zab).disconnect("Failed to get service from broker.");
            zabl2.zac(new ConnectionResult(10), null);
            return;
        }
    }
}
