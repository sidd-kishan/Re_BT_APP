/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbdl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdl;

public final class zzcob {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcob(int n, int n2, int n3) {
        this.zzc = n;
        this.zzb = n2;
        this.zza = n3;
    }

    public static zzcob zza(zzbdl zzbdl2) {
        if (zzbdl2.zzd) {
            return new zzcob(3, 0, 0);
        }
        if (zzbdl2.zzi) {
            return new zzcob(2, 0, 0);
        }
        if (!zzbdl2.zzh) return zzcob.zzc(zzbdl2.zzf, zzbdl2.zzc);
        return zzcob.zzb();
    }

    public static zzcob zzb() {
        return new zzcob(0, 0, 0);
    }

    public static zzcob zzc(int n, int n2) {
        return new zzcob(1, n, n2);
    }

    public static zzcob zzd() {
        return new zzcob(4, 0, 0);
    }

    public static zzcob zze() {
        return new zzcob(5, 0, 0);
    }

    public final boolean zzf() {
        if (this.zzc != 2) return false;
        return true;
    }

    public final boolean zzg() {
        if (this.zzc != 3) return false;
        return true;
    }

    public final boolean zzh() {
        if (this.zzc != 0) return false;
        return true;
    }

    public final boolean zzi() {
        if (this.zzc != 4) return false;
        return true;
    }

    public final boolean zzj() {
        if (this.zzc != 5) return false;
        return true;
    }
}
