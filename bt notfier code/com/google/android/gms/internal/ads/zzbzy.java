/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbzx
 *  com.google.android.gms.internal.ads.zzbzz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzbzz;

public final class zzbzy
extends zzadk
implements zzbzz {
    public static zzbzz zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (!(iInterface instanceof zzbzz)) return new zzbzx(iBinder);
        return (zzbzz)iInterface;
    }
}
