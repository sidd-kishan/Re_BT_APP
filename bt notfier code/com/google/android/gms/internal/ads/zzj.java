/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzi;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

public final class zzj {
    public static final zzadw<zzj> zze = zzi.zza;
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final byte[] zzd;
    private int zzf;

    public zzj(int n, int n2, int n3, byte[] byArray) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = byArray;
    }

    @Pure
    public static int zza(int n) {
        if (n == 1) return 1;
        if (n == 9) return 6;
        if (n == 4) return 2;
        if (n == 5) return 2;
        if (n == 6) return 2;
        if (n == 7) return 2;
        return -1;
    }

    @Pure
    public static int zzb(int n) {
        if (n == 1) return 3;
        if (n == 16) return 6;
        if (n == 18) return 7;
        if (n == 6) return 3;
        if (n == 7) return 3;
        return -1;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzj)object;
        if (this.zza != ((zzj)object).zza) return false;
        if (this.zzb != ((zzj)object).zzb) return false;
        if (this.zzc != ((zzj)object).zzc) return false;
        if (!Arrays.equals(this.zzd, ((zzj)object).zzd)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzf;
        if (n != 0) return n2;
        this.zzf = n2 = (((this.zza + 527) * 31 + this.zzb) * 31 + this.zzc) * 31 + Arrays.hashCode(this.zzd);
        return n2;
    }

    public final String toString() {
        int n = this.zza;
        int n2 = this.zzb;
        int n3 = this.zzc;
        boolean bl = this.zzd != null;
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("ColorInfo(");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(", ");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
