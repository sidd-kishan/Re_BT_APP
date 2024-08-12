/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzx;

public final class zzy {
    public static final zzy zza = new zzy(0, 0, 0, 1.0f);
    public static final zzadw<zzy> zzf = zzx.zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final float zze;

    public zzy(int n, int n2, int n3, float f) {
        this.zzb = n;
        this.zzc = n2;
        this.zzd = n3;
        this.zze = f;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzy)) return false;
        object = (zzy)object;
        if (this.zzb != ((zzy)object).zzb) return false;
        if (this.zzc != ((zzy)object).zzc) return false;
        if (this.zzd != ((zzy)object).zzd) return false;
        if (this.zze != ((zzy)object).zze) return false;
        return true;
    }

    public final int hashCode() {
        return (((this.zzb + 217) * 31 + this.zzc) * 31 + this.zzd) * 31 + Float.floatToRawIntBits(this.zze);
    }
}
