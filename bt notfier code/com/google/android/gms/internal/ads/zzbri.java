/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.internal.ads.zzbrk
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzbrk;
import com.google.android.gms.internal.ads.zzchl;

final class zzbri
implements BaseGmsClient.BaseConnectionCallbacks {
    final zzchl zza;
    final zzbrk zzb;

    zzbri(zzbrk zzbrk2, zzchl zzchl2) {
        this.zzb = zzbrk2;
        this.zza = zzchl2;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc((Object)zzbrk.zzb((zzbrk)this.zzb).zzp());
            return;
        }
        catch (DeadObjectException deadObjectException) {
            this.zza.zzd((Throwable)deadObjectException);
            return;
        }
    }

    public final void onConnectionSuspended(int n) {
        zzchl zzchl2 = this.zza;
        StringBuilder stringBuilder = new StringBuilder(34);
        stringBuilder.append("onConnectionSuspended: ");
        stringBuilder.append(n);
        zzchl2.zzd((Throwable)new RuntimeException(stringBuilder.toString()));
    }
}
