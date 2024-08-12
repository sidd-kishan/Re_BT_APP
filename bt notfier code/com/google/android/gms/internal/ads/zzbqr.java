/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbqq
 *  com.google.android.gms.internal.ads.zzbqs
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbqs;

public abstract class zzbqr
extends zzadk
implements zzbqs {
    public static zzbqs zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
        if (!(iInterface instanceof zzbqs)) return new zzbqq(iBinder);
        return (zzbqs)iInterface;
    }
}
