/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzcdc
implements RewardItem {
    private final zzccp zza;

    public zzcdc(zzccp zzccp2) {
        this.zza = zzccp2;
    }

    public final int getAmount() {
        zzccp zzccp2 = this.zza;
        if (zzccp2 == null) return 0;
        try {
            int n = zzccp2.zzf();
            return n;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Could not forward getAmount to RewardItem", (Throwable)remoteException);
        }
        return 0;
    }

    public final String getType() {
        Object object = this.zza;
        if (object == null) return null;
        try {
            object = object.zze();
            return object;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Could not forward getType to RewardItem", (Throwable)remoteException);
        }
        return null;
    }
}
