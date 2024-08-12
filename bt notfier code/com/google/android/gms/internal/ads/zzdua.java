/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaza
 *  com.google.android.gms.internal.ads.zzazk
 *  com.google.android.gms.internal.ads.zzbac
 *  com.google.android.gms.internal.ads.zzbao
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzbac;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzfal;

final class zzdua
implements zzaza {
    private final zzfal zza;

    zzdua(zzfal zzfal2) {
        this.zza = zzfal2;
    }

    public final void zza(zzbao zzbao2) {
        zzfal zzfal2 = this.zza;
        zzazk zzazk2 = (zzazk)zzbao2.zzg().zzau();
        zzbac zzbac2 = (zzbac)zzbao2.zzg().zza().zzau();
        zzbac2.zza(zzfal2.zzb.zzb.zzb);
        zzazk2.zzb(zzbac2);
        zzbao2.zzh(zzazk2);
    }
}
