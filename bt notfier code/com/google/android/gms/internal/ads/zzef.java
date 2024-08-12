/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzde
 *  com.google.android.gms.internal.ads.zzet
 *  com.google.android.gms.internal.ads.zzev
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzde;
import com.google.android.gms.internal.ads.zzet;
import com.google.android.gms.internal.ads.zzev;

public final class zzef {
    private final zzde[] zza;
    private final zzet zzb;
    private final zzev zzc;

    public zzef(zzde ... zzdeArray) {
        zzet zzet2 = new zzet();
        zzev zzev2 = new zzev();
        zzde[] zzdeArray2 = new zzde[2];
        this.zza = zzdeArray2;
        System.arraycopy(zzdeArray, 0, zzdeArray2, 0, 0);
        this.zzb = zzet2;
        this.zzc = zzev2;
        zzdeArray = this.zza;
        zzdeArray[0] = zzet2;
        zzdeArray[1] = zzev2;
    }

    public final zzde[] zza() {
        return this.zza;
    }

    public final zzahf zzb(zzahf zzahf2) {
        this.zzc.zzi(zzahf2.zzb);
        this.zzc.zzj(zzahf2.zzc);
        return zzahf2;
    }

    public final boolean zzc(boolean bl) {
        this.zzb.zzo(bl);
        return bl;
    }

    public final long zzd(long l) {
        return this.zzc.zzk(l);
    }

    public final long zze() {
        return this.zzb.zzp();
    }
}
