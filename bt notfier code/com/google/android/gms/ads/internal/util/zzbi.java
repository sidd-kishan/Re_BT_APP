/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbf
 *  com.google.android.gms.ads.internal.util.zzbg
 *  com.google.android.gms.ads.internal.util.zzbh
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzbh;
import java.util.ArrayList;
import java.util.List;

public final class zzbi {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze;

    /* synthetic */ zzbi(zzbg zzbg2, zzbh zzbh2) {
        int n = zzbg.zzb((zzbg)zzbg2).size();
        this.zza = zzbg.zza((zzbg)zzbg2).toArray(new String[n]);
        this.zzb = zzbi.zzc(zzbg.zzb((zzbg)zzbg2));
        this.zzc = zzbi.zzc(zzbg.zzc((zzbg)zzbg2));
        this.zzd = new int[n];
        this.zze = 0;
    }

    private static final double[] zzc(List<Double> list) {
        int n = list.size();
        double[] dArray = new double[n];
        int n2 = 0;
        while (n2 < n) {
            dArray[n2] = list.get(n2);
            ++n2;
        }
        return dArray;
    }

    public final void zza(double d) {
        Object[] objectArray;
        ++this.zze;
        int n = 0;
        while (n < (objectArray = this.zzc).length) {
            double d2 = objectArray[n];
            if (d2 <= d && d < this.zzb[n]) {
                objectArray = this.zzd;
                objectArray[n] = objectArray[n] + true;
            }
            if (d < d2) {
                return;
            }
            ++n;
        }
    }

    public final List<zzbf> zzb() {
        Object object;
        ArrayList<zzbf> arrayList = new ArrayList<zzbf>(this.zza.length);
        int n = 0;
        while (n < ((String[])(object = this.zza)).length) {
            object = object[n];
            double d = this.zzc[n];
            double d2 = this.zzb[n];
            int n2 = this.zzd[n];
            double d3 = n2;
            double d4 = this.zze;
            Double.isNaN(d3);
            Double.isNaN(d4);
            arrayList.add(new zzbf((String)object, d, d2, d3 / d4, n2));
            ++n;
        }
        return arrayList;
    }
}
