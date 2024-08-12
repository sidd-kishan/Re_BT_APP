/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public class zzo {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    protected zzo(zzo zzo2) {
        this.zza = zzo2.zza;
        this.zzb = zzo2.zzb;
        this.zzc = zzo2.zzc;
        this.zzd = zzo2.zzd;
        this.zze = zzo2.zze;
    }

    public zzo(Object object, int n, int n2, long l) {
        this(object, n, n2, l, -1);
    }

    private zzo(Object object, int n, int n2, long l, int n3) {
        this.zza = object;
        this.zzb = n;
        this.zzc = n2;
        this.zzd = l;
        this.zze = n3;
    }

    public zzo(Object object, long l) {
        this(object, -1, -1, -1L, -1);
    }

    public zzo(Object object, long l, int n) {
        this(object, -1, -1, l, n);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzo)) {
            return false;
        }
        object = (zzo)object;
        if (!this.zza.equals(((zzo)object).zza)) return false;
        if (this.zzb != ((zzo)object).zzb) return false;
        if (this.zzc != ((zzo)object).zzc) return false;
        if (this.zzd != ((zzo)object).zzd) return false;
        if (this.zze != ((zzo)object).zze) return false;
        return true;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() + 527) * 31 + this.zzb) * 31 + this.zzc) * 31 + (int)this.zzd) * 31 + this.zze;
    }

    public final zzo zza(Object object) {
        if (!this.zza.equals(object)) return new zzo(object, this.zzb, this.zzc, this.zzd, this.zze);
        return this;
    }

    public final boolean zzb() {
        if (this.zzb == -1) return false;
        return true;
    }
}
