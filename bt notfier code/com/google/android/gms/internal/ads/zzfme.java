/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfle
 *  com.google.android.gms.internal.ads.zzflk
 *  com.google.android.gms.internal.ads.zzfmg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfle;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzfmg;

abstract class zzfme
extends zzfle<String> {
    final CharSequence zzb;
    final zzflk zzc;
    int zzd = 0;
    int zze;

    protected zzfme(zzfmg zzfmg2, CharSequence charSequence) {
        this.zzc = zzfmg.zza((zzfmg)zzfmg2);
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    abstract int zzc(int var1);

    abstract int zzd(int var1);
}
