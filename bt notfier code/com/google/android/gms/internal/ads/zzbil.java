/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdValue
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.internal.ads.zzbdn
 *  com.google.android.gms.internal.ads.zzbgv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbgv;

public final class zzbil
extends zzbgv {
    private final OnPaidEventListener zza;

    public zzbil(OnPaidEventListener onPaidEventListener) {
        this.zza = onPaidEventListener;
    }

    public final void zze(zzbdn zzbdn2) {
        if (this.zza == null) return;
        zzbdn2 = AdValue.zza((int)zzbdn2.zzb, (String)zzbdn2.zzc, (long)zzbdn2.zzd);
        this.zza.onPaidEvent((AdValue)zzbdn2);
    }
}
