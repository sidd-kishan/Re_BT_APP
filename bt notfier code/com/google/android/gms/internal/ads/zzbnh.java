/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbng
 *  com.google.android.gms.internal.ads.zzbni
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbng;
import com.google.android.gms.internal.ads.zzbni;

public abstract class zzbnh
extends zzadk
implements zzbni {
    public static zzbni zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        if (!(iInterface instanceof zzbni)) return new zzbng(iBinder);
        return (zzbni)iInterface;
    }
}
