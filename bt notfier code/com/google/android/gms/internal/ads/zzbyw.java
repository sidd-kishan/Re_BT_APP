/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbnk
 *  com.google.android.gms.internal.ads.zzbyv
 *  com.google.android.gms.internal.ads.zzbyy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnk;
import com.google.android.gms.internal.ads.zzbyv;
import com.google.android.gms.internal.ads.zzbyy;

final class zzbyw
extends zzbnk {
    final zzbyy zza;

    /* synthetic */ zzbyw(zzbyy zzbyy2, zzbyv zzbyv2) {
        this.zza = zzbyy2;
    }

    public final void zze(zzbnb zzbnb2, String string) {
        if (zzbyy.zzb((zzbyy)this.zza) == null) {
            return;
        }
        zzbyy.zzb((zzbyy)this.zza).onCustomClick(zzbyy.zze((zzbyy)this.zza, (zzbnb)zzbnb2), string);
    }
}
