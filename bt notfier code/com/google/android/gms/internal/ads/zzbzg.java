/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbzf
 *  com.google.android.gms.internal.ads.zzbzh
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbzf;
import com.google.android.gms.internal.ads.zzbzh;

public abstract class zzbzg
extends zzadk
implements zzbzh {
    public static zzbzh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
        if (!(iInterface instanceof zzbzh)) return new zzbzf(iBinder);
        return (zzbzh)iInterface;
    }
}
