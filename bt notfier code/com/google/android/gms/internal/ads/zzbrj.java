/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzbrk
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzbrk;
import com.google.android.gms.internal.ads.zzchl;

final class zzbrj
implements BaseGmsClient.BaseOnConnectionFailedListener {
    final zzchl zza;

    zzbrj(zzbrk zzbrk2, zzchl zzchl2) {
        this.zza = zzchl2;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zza.zzd((Throwable)new RuntimeException("Connection failed."));
    }
}
