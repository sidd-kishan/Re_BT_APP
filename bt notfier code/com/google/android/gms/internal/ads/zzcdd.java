/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzccw
 *  com.google.android.gms.internal.ads.zzcgv
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzccw;
import com.google.android.gms.internal.ads.zzcgv;

final class zzcdd
implements zzcgv {
    static final zzcgv zza = new zzcdd();

    private zzcdd() {
    }

    public final Object zza(Object object) {
        IInterface iInterface;
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator")) instanceof zzccw ? (zzccw)iInterface : new zzccw((IBinder)object));
        return object;
    }
}
