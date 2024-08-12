/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.zza
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zza;

public final class zzg
extends zza {
    final BaseGmsClient zze;

    public zzg(BaseGmsClient baseGmsClient, int n, Bundle bundle) {
        this.zze = baseGmsClient;
        super(baseGmsClient, n, null);
    }

    protected final boolean zza() {
        this.zze.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
        return true;
    }

    protected final void zzb(ConnectionResult connectionResult) {
        if (this.zze.enableLocalFallback() && BaseGmsClient.zzg((BaseGmsClient)this.zze)) {
            BaseGmsClient.zzc((BaseGmsClient)this.zze, (int)16);
            return;
        }
        this.zze.zzc.onReportServiceBinding(connectionResult);
        this.zze.onConnectionFailed(connectionResult);
    }
}
