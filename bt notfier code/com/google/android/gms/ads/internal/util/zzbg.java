/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbi
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzbi;
import java.util.ArrayList;
import java.util.List;

public final class zzbg {
    private final List<String> zza = new ArrayList<String>();
    private final List<Double> zzb = new ArrayList<Double>();
    private final List<Double> zzc = new ArrayList<Double>();

    static /* synthetic */ List zza(zzbg zzbg2) {
        return zzbg2.zza;
    }

    static /* synthetic */ List zzb(zzbg zzbg2) {
        return zzbg2.zzb;
    }

    static /* synthetic */ List zzc(zzbg zzbg2) {
        return zzbg2.zzc;
    }

    public final zzbg zzd(String string, double d, double d2) {
        int n;
        for (n = 0; n < this.zza.size(); ++n) {
            double d3 = this.zzc.get(n);
            double d4 = this.zzb.get(n);
            if (d < d3 || d3 == d && d2 < d4) break;
        }
        this.zza.add(n, string);
        this.zzc.add(n, d);
        this.zzb.add(n, d2);
        return this;
    }

    public final zzbi zze() {
        return new zzbi(this, null);
    }
}
