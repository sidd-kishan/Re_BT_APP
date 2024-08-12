/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/*
 * Exception performing whole class analysis ignored.
 */
protected class BaseGmsClient.LegacyClientCallbackAdapter
implements BaseGmsClient.ConnectionProgressReportCallbacks {
    final BaseGmsClient zza;

    public BaseGmsClient.LegacyClientCallbackAdapter(BaseGmsClient baseGmsClient) {
        this.zza = baseGmsClient;
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            connectionResult = this.zza;
            connectionResult.getRemoteService(null, connectionResult.getScopes());
            return;
        }
        if (BaseGmsClient.zzn((BaseGmsClient)this.zza) == null) return;
        BaseGmsClient.zzn((BaseGmsClient)this.zza).onConnectionFailed(connectionResult);
    }
}
