/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbse
 *  com.google.android.gms.internal.ads.zzbsg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbse;
import com.google.android.gms.internal.ads.zzbsg;

public abstract class zzbsf
extends zzadk
implements zzbsg {
    public static zzbsg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
        if (!(iInterface instanceof zzbsg)) return new zzbse(iBinder);
        return (zzbsg)iInterface;
    }
}
