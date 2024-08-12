/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzcfo
 *  com.google.android.gms.internal.ads.zzcfq
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.internal.ads.zzcfq;

public abstract class zzcfp
extends zzadk
implements zzcfq {
    public static zzcfq zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
        if (!(iInterface instanceof zzcfq)) return new zzcfo(iBinder);
        return (zzcfq)iInterface;
    }
}
