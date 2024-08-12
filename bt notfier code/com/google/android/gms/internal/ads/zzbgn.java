/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.MuteThisAdReason
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbgn
implements MuteThisAdReason {
    private final String zza;
    private final zzbgm zzb;

    public zzbgn(zzbgm object) {
        this.zzb = object;
        try {
            object = object.zze();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            object = null;
        }
        this.zza = object;
    }

    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzbgm zza() {
        return this.zzb;
    }
}
