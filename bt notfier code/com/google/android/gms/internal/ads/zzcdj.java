/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.internal.ads.zzcco
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.internal.ads.zzcco;

public final class zzcdj
extends zzcco {
    private final String zza;
    private final int zzb;

    public zzcdj(RewardItem rewardItem) {
        String string = rewardItem != null ? rewardItem.getType() : "";
        int n = rewardItem != null ? rewardItem.getAmount() : 1;
        this(string, n);
    }

    public zzcdj(String string, int n) {
        this.zza = string;
        this.zzb = n;
    }

    public final String zze() throws RemoteException {
        return this.zza;
    }

    public final int zzf() throws RemoteException {
        return this.zzb;
    }
}
