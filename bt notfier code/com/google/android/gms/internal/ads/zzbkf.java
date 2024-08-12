/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbke
 *  com.google.android.gms.internal.ads.zzbkg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbke;
import com.google.android.gms.internal.ads.zzbkg;

public abstract class zzbkf
extends zzadk
implements zzbkg {
    public static zzbkg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        if (!(iInterface instanceof zzbkg)) return new zzbke(iBinder);
        return (zzbkg)iInterface;
    }
}
