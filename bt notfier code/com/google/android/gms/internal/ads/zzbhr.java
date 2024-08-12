/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  com.google.android.gms.internal.ads.zzbhp
 *  com.google.android.gms.internal.ads.zzbhs
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrr
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrr;
import java.util.List;

final class zzbhr
extends zzbrr {
    final zzbhs zza;

    /* synthetic */ zzbhr(zzbhs zzbhs2, zzbhp zzbhp2) {
        this.zza = zzbhs2;
    }

    public final void zzb(List<zzbrl> arrayList) throws RemoteException {
        zzbhs zzbhs2 = this.zza;
        int n = 0;
        zzbhs.zzb((zzbhs)zzbhs2, (boolean)false);
        zzbhs.zzc((zzbhs)this.zza, (boolean)true);
        zzbhs2 = zzbhs.zzq((zzbhs)this.zza, arrayList);
        arrayList = zzbhs.zza((zzbhs)zzbhs.zze());
        int n2 = arrayList.size();
        while (true) {
            if (n >= n2) {
                zzbhs.zza((zzbhs)zzbhs.zze()).clear();
                return;
            }
            ((OnInitializationCompleteListener)arrayList.get(n)).onInitializationComplete((InitializationStatus)zzbhs2);
            ++n;
        }
    }
}
