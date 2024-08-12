/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgfl
 *  com.google.android.gms.internal.ads.zzgfu
 *  com.google.android.gms.internal.ads.zzgfy
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfl;
import com.google.android.gms.internal.ads.zzgfu;
import com.google.android.gms.internal.ads.zzgfy;
import com.google.android.gms.internal.ads.zzghi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzgfm {
    static final zzgfm zza = new zzgfm(true);
    private static volatile boolean zzb;
    private static volatile zzgfm zzc;
    private static volatile zzgfm zzd;
    private final Map<zzgfl, zzgfy<?, ?>> zze;

    zzgfm() {
        this.zze = new HashMap();
    }

    zzgfm(boolean bl) {
        this.zze = Collections.emptyMap();
    }

    public static zzgfm zza() {
        zzgfm zzgfm2;
        zzgfm zzgfm3 = zzgfm2 = zzc;
        if (zzgfm2 != null) return zzgfm3;
        synchronized (zzgfm.class) {
            zzgfm3 = zzgfm2 = zzc;
            if (zzgfm2 != null) return zzgfm3;
            zzc = zzgfm3 = zza;
        }
        return zzgfm3;
    }

    public static zzgfm zzb() {
        zzgfm zzgfm2 = zzd;
        if (zzgfm2 != null) {
            return zzgfm2;
        }
        synchronized (zzgfm.class) {
            zzgfm2 = zzd;
            if (zzgfm2 != null) {
                return zzgfm2;
            }
            zzd = zzgfm2 = zzgfu.zzb(zzgfm.class);
            return zzgfm2;
        }
    }

    public final <ContainingType extends zzghi> zzgfy<ContainingType, ?> zzc(ContainingType ContainingType, int n) {
        return this.zze.get(new zzgfl(ContainingType, n));
    }
}
