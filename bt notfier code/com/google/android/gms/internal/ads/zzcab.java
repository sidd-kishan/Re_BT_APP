/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzcaa
 *  com.google.android.gms.internal.ads.zzcac
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzcaa;
import com.google.android.gms.internal.ads.zzcac;

public final class zzcab
extends zzadk
implements zzcac {
    public static zzcac zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (!(iInterface instanceof zzcac)) return new zzcaa(iBinder);
        return (zzcac)iInterface;
    }
}
