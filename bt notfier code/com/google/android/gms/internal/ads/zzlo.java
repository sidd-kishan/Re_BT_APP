/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzlk
 *  com.google.android.gms.internal.ads.zzll
 *  com.google.android.gms.internal.ads.zzln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzlk;
import com.google.android.gms.internal.ads.zzll;
import com.google.android.gms.internal.ads.zzln;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class zzlo {
    private static final Comparator<zzln> zza = zzlk.zza;
    private static final Comparator<zzln> zzb = zzll.zza;
    private final ArrayList<zzln> zzc;
    private final zzln[] zzd = new zzln[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzlo(int n) {
        this.zzc = new ArrayList();
    }

    public final void zza() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }

    public final void zzb(int n, float f) {
        zzln[] zzlnArray;
        int n2;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        if ((n2 = this.zzh) > 0) {
            zzlnArray = this.zzd;
            this.zzh = --n2;
            zzlnArray = zzlnArray[n2];
        } else {
            zzlnArray = new zzln(null);
        }
        n2 = this.zzf;
        this.zzf = n2 + 1;
        zzlnArray.zza = n2;
        zzlnArray.zzb = n;
        zzlnArray.zzc = f;
        this.zzc.add((zzln)zzlnArray);
        this.zzg += n;
        while ((n = this.zzg) > 2000) {
            zzln zzln2 = this.zzc.get(0);
            n2 = zzln2.zzb;
            if (n2 <= (n -= 2000)) {
                this.zzg -= n2;
                this.zzc.remove(0);
                n = this.zzh;
                if (n >= 5) continue;
                zzlnArray = this.zzd;
                this.zzh = n + 1;
                zzlnArray[n] = zzln2;
                continue;
            }
            zzln2.zzb = n2 - n;
            this.zzg -= n;
        }
    }

    public final float zzc(float f) {
        Object object;
        int n = this.zze;
        int n2 = 0;
        if (n != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        f = this.zzg;
        n = 0;
        while (n2 < this.zzc.size()) {
            object = this.zzc.get(n2);
            if ((float)(n += ((zzln)object).zzb) >= f * 0.5f) {
                return ((zzln)object).zzc;
            }
            ++n2;
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        object = this.zzc;
        return ((zzln)((ArrayList)object).get((int)(((ArrayList)object).size() - 1))).zzc;
    }
}
