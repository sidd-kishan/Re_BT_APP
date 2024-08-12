/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzccd
 *  com.google.android.gms.internal.ads.zzccf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzccd;
import com.google.android.gms.internal.ads.zzccf;

public abstract class zzcce
extends zzadk
implements zzccf {
    public static zzccf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
        if (!(iInterface instanceof zzccf)) return new zzccd(iBinder);
        return (zzccf)iInterface;
    }
}
