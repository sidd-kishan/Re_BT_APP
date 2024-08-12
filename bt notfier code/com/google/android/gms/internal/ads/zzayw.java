/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzayx
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzayx;
import com.google.android.gms.internal.ads.zzchl;

final class zzayw
implements BaseGmsClient.BaseOnConnectionFailedListener {
    final zzchl zza;
    final zzayx zzb;

    zzayw(zzayx zzayx2, zzchl zzchl2) {
        this.zzb = zzayx2;
        this.zza = zzchl2;
    }

    public final void onConnectionFailed(ConnectionResult object) {
        object = zzayx.zzd((zzayx)this.zzb);
        synchronized (object) {
            zzchl zzchl2 = this.zza;
            RuntimeException runtimeException = new RuntimeException("Connection failed.");
            zzchl2.zzd((Throwable)runtimeException);
            return;
        }
    }
}
