/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmc
 *  com.google.android.gms.internal.ads.zzfme
 *  com.google.android.gms.internal.ads.zzfmg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmc;
import com.google.android.gms.internal.ads.zzfme;
import com.google.android.gms.internal.ads.zzfmg;

final class zzfmb
extends zzfme {
    final zzfmc zza;

    zzfmb(zzfmc zzfmc2, zzfmg zzfmg2, CharSequence charSequence) {
        this.zza = zzfmc2;
        super(zzfmg2, charSequence);
    }

    public final int zzc(int n) {
        if ((n += 4000) >= this.zzb.length()) return -1;
        return n;
    }

    public final int zzd(int n) {
        return n;
    }
}
