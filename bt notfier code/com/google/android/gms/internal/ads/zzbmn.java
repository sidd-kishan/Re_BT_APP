/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbmm
 *  com.google.android.gms.internal.ads.zzbmo
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbmm;
import com.google.android.gms.internal.ads.zzbmo;

public abstract class zzbmn
extends zzadk
implements zzbmo {
    public static zzbmo zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (!(iInterface instanceof zzbmo)) return new zzbmm(iBinder);
        return (zzbmo)iInterface;
    }
}
