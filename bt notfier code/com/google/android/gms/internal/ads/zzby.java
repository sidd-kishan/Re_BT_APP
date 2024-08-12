/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzalj
 *  com.google.android.gms.internal.ads.zzcz
 *  com.google.android.gms.internal.ads.zzda
 *  com.google.android.gms.internal.ads.zzgx
 *  com.google.android.gms.internal.ads.zzhc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzcz;
import com.google.android.gms.internal.ads.zzda;
import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzhc;
import java.io.IOException;

final class zzby
implements zzalj {
    private final zzcz zza;
    private final zzgx zzb;
    private final zzhc zzc;
    private final IOException zzd;
    private final boolean zze;

    zzby(zzcz zzcz2, zzgx zzgx2, zzhc zzhc2, IOException iOException, boolean bl) {
        this.zza = zzcz2;
        this.zzb = zzgx2;
        this.zzc = zzhc2;
        this.zzd = iOException;
        this.zze = bl;
    }

    public final void zza(Object object) {
        zzcz zzcz2 = this.zza;
        zzgx zzgx2 = this.zzb;
        zzhc zzhc2 = this.zzc;
        IOException iOException = this.zzd;
        boolean bl = this.zze;
        ((zzda)object).zzg(zzcz2, zzgx2, zzhc2, iOException, bl);
    }
}
