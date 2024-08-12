/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzagx
 *  com.google.android.gms.internal.ads.zzagz
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfa
 *  com.google.android.gms.internal.ads.zzfb
 *  com.google.android.gms.internal.ads.zzgx
 *  com.google.android.gms.internal.ads.zzhc
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzho
 *  com.google.android.gms.internal.ads.zzhp
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzagz;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzhc;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzho;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;

final class zzagv
implements zzhp,
zzfb {
    final zzagz zza;
    private final zzagx zzb;
    private zzho zzc;
    private zzfa zzd;

    public zzagv(zzagz zzagz2, zzagx zzagx2) {
        this.zza = zzagz2;
        this.zzc = zzagz.zza((zzagz)zzagz2);
        this.zzd = zzagz.zzb((zzagz)zzagz2);
        this.zzb = zzagx2;
    }

    private final boolean zza(int n, zzhf zzhf2) {
        Object object = null;
        Object object2 = null;
        if (zzhf2 != null) {
            zzagx zzagx2 = this.zzb;
            int n2 = 0;
            while (true) {
                object = object2;
                if (n2 >= zzagx2.zzc.size()) break;
                if (((zzhf)zzagx2.zzc.get((int)n2)).zzd == zzhf2.zzd) {
                    object = zzhf2.zza;
                    object = zzhf2.zzc((Object)Pair.create((Object)zzagx2.zzb, (Object)object));
                    break;
                }
                ++n2;
            }
            if (object == null) return false;
        }
        zzhf2 = this.zzc;
        if (zzhf2.zza != (n += this.zzb.zzd) || !zzamq.zzc((Object)zzhf2.zzb, object)) {
            this.zzc = zzagz.zza((zzagz)this.zza).zza(n, object, 0L);
        }
        zzhf2 = this.zzd;
        if (zzhf2.zza == n) {
            if (zzamq.zzc((Object)zzhf2.zzb, (Object)object)) return true;
        }
        this.zzd = zzagz.zzb((zzagz)this.zza).zza(n, (zzhf)object);
        return true;
    }

    public final void zzC(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zze(zzgx2, zzhc2);
    }

    public final void zzD(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzg(zzgx2, zzhc2);
    }

    public final void zzE(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzi(zzgx2, zzhc2);
    }

    public final void zzF(int n, zzhf zzhf2, zzgx zzgx2, zzhc zzhc2, IOException iOException, boolean bl) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzk(zzgx2, zzhc2, iOException, bl);
    }

    public final void zzG(int n, zzhf zzhf2, zzhc zzhc2) {
        if (!this.zza(n, zzhf2)) return;
        this.zzc.zzm(zzhc2);
    }
}
