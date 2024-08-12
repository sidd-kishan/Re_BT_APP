/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaqj
 *  com.google.android.gms.internal.ads.zzaqk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzaqk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzaqi
extends zzaqk {
    public final long zza;
    public final List<zzaqj> zzb;
    public final List<zzaqi> zzc;

    public zzaqi(int n, long l) {
        super(n);
        this.zza = l;
        this.zzb = new ArrayList<zzaqj>();
        this.zzc = new ArrayList<zzaqi>();
    }

    public final String toString() {
        String string = zzaqi.zzg((int)this.zzaR);
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

    public final void zza(zzaqj zzaqj2) {
        this.zzb.add(zzaqj2);
    }

    public final void zzb(zzaqi zzaqi2) {
        this.zzc.add(zzaqi2);
    }

    public final zzaqj zzc(int n) {
        int n2 = this.zzb.size();
        int n3 = 0;
        while (n3 < n2) {
            zzaqj zzaqj2 = this.zzb.get(n3);
            if (zzaqj2.zzaR == n) {
                return zzaqj2;
            }
            ++n3;
        }
        return null;
    }

    public final zzaqi zzd(int n) {
        int n2 = this.zzc.size();
        int n3 = 0;
        while (n3 < n2) {
            zzaqi zzaqi2 = this.zzc.get(n3);
            if (zzaqi2.zzaR == n) {
                return zzaqi2;
            }
            ++n3;
        }
        return null;
    }
}
