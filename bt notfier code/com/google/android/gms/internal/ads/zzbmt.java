/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbms
 *  com.google.android.gms.internal.ads.zzbmu
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbms;
import com.google.android.gms.internal.ads.zzbmu;

public abstract class zzbmt
extends zzadk
implements zzbmu {
    public static zzbmu zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (!(iInterface instanceof zzbmu)) return new zzbms(iBinder);
        return (zzbmu)iInterface;
    }
}
