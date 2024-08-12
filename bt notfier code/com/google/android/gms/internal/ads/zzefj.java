/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzcxe
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzfaw
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzcxe;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzfaw;

final class zzefj
implements zzcxe {
    private final zzeef zza;

    zzefj(zzeef zzeef2) {
        this.zza = zzeef2;
    }

    public final zzbhc zza() {
        zzeef zzeef2 = this.zza;
        try {
            zzeef2 = ((zzbxn)zzeef2.zzb).zzh();
            return zzeef2;
        }
        catch (RemoteException remoteException) {
            throw new zzfaw((Throwable)remoteException);
        }
    }
}
