/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzow {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzow(int n, byte[] byArray, int n2, int n3) {
        this.zza = n;
        this.zzb = byArray;
        this.zzc = n2;
        this.zzd = n3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzow)object;
        if (this.zza != ((zzow)object).zza) return false;
        if (this.zzc != ((zzow)object).zzc) return false;
        if (this.zzd != ((zzow)object).zzd) return false;
        if (!Arrays.equals(this.zzb, ((zzow)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        return ((this.zza * 31 + Arrays.hashCode(this.zzb)) * 31 + this.zzc) * 31 + this.zzd;
    }
}
