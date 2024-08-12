/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzex
 *  com.google.android.gms.internal.ads.zzff
 *  com.google.android.gms.internal.ads.zzhq
 *  com.google.android.gms.internal.ads.zzhw
 *  com.google.android.gms.internal.ads.zzii
 *  com.google.android.gms.internal.ads.zzil
 *  com.google.android.gms.internal.ads.zzku
 *  com.google.android.gms.internal.ads.zzoa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzex;
import com.google.android.gms.internal.ads.zzff;
import com.google.android.gms.internal.ads.zzhq;
import com.google.android.gms.internal.ads.zzhw;
import com.google.android.gms.internal.ads.zzii;
import com.google.android.gms.internal.ads.zzil;
import com.google.android.gms.internal.ads.zzku;
import com.google.android.gms.internal.ads.zzoa;

public final class zzij
implements zzhq {
    private final zzai zza;
    private final zzhw zzb;
    private int zzc;
    private final zzku zzd;
    private final zzex zze;

    public zzij(zzai zzai2, zzoa zzoa2) {
        zzoa2 = new zzii(zzoa2);
        this.zza = zzai2;
        this.zzb = zzoa2;
        this.zze = new zzex();
        this.zzd = new zzku(-1);
        this.zzc = 0x100000;
    }

    public final zzij zza(int n) {
        this.zzc = n;
        return this;
    }

    public final zzil zzb(zzagk zzagk2) {
        if (zzagk2.zzc == null) throw null;
        return new zzil(zzagk2, this.zza, this.zzb, zzff.zza, this.zzd, this.zzc, null, null);
    }
}
