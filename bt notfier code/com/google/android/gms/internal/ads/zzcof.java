/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzcoe
 *  com.google.android.gms.internal.ads.zzcog
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzcoe;
import com.google.android.gms.internal.ads.zzcog;

public abstract class zzcof
extends zzadk
implements zzcog {
    public static zzcog zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (!(iInterface instanceof zzcog)) return new zzcoe(iBinder);
        return (zzcog)iInterface;
    }
}
