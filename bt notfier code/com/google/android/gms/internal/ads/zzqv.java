/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzqw
 *  com.google.android.gms.internal.ads.zzqx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzqv
extends zzqx {
    public final long zza;
    public final List<zzqw> zzb;
    public final List<zzqv> zzc;

    public zzqv(int n, long l) {
        super(n);
        this.zza = l;
        this.zzb = new ArrayList<zzqw>();
        this.zzc = new ArrayList<zzqv>();
    }

    public final String toString() {
        String string = zzqv.zzf((int)this.zzd);
        String string2 = Arrays.toString(this.zzb.toArray());
        String string3 = Arrays.toString(this.zzc.toArray());
        int n = String.valueOf(string2).length();
        int n2 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 22 + n + n2);
        stringBuilder.append(string);
        stringBuilder.append(" leaves: ");
        stringBuilder.append(string2);
        stringBuilder.append(" containers: ");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final void zza(zzqw zzqw2) {
        this.zzb.add(zzqw2);
    }

    public final void zzb(zzqv zzqv2) {
        this.zzc.add(zzqv2);
    }

    public final zzqw zzc(int n) {
        int n2 = this.zzb.size();
        int n3 = 0;
        while (n3 < n2) {
            zzqw zzqw2 = this.zzb.get(n3);
            if (zzqw2.zzd == n) {
                return zzqw2;
            }
            ++n3;
        }
        return null;
    }

    public final zzqv zzd(int n) {
        int n2 = this.zzc.size();
        int n3 = 0;
        while (n3 < n2) {
            zzqv zzqv2 = this.zzc.get(n3);
            if (zzqv2.zzd == n) {
                return zzqv2;
            }
            ++n3;
        }
        return null;
    }
}
