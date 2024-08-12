/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgf
 *  com.google.android.gms.internal.measurement.zzgz
 *  com.google.android.gms.internal.measurement.zzhe
 *  com.google.android.gms.internal.measurement.zzho
 *  com.google.android.gms.internal.measurement.zzhr
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzjj
 *  com.google.android.gms.internal.measurement.zzjv
 *  com.google.android.gms.internal.measurement.zzjw
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzjv;
import com.google.android.gms.internal.measurement.zzjw;
import java.io.IOException;

final class zzja<T>
implements zzjh<T> {
    private final zziw zza;
    private final zzjv<?, ?> zzb;
    private final boolean zzc;
    private final zzhe<?> zzd;

    private zzja(zzjv<?, ?> zzjv2, zzhe<?> zzhe2, zziw zziw2) {
        this.zzb = zzjv2;
        this.zzc = zzhe2.zza(zziw2);
        this.zzd = zzhe2;
        this.zza = zziw2;
    }

    static <T> zzja<T> zzf(zzjv<?, ?> zzjv2, zzhe<?> zzhe2, zziw zziw2) {
        return new zzja<T>(zzjv2, zzhe2, zziw2);
    }

    public final T zza() {
        return (T)this.zza.zzbH().zzaD();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t);
        this.zzd.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int n = this.zzb.zzd(t).hashCode();
        if (!this.zzc) {
            return n;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzjj.zzF(this.zzb, t, t2);
        if (!this.zzc) return;
        zzjj.zzE(this.zzd, t, t2);
    }

    public final int zze(T t) {
        zzjv<?, ?> zzjv2 = this.zzb;
        int n = zzjv2.zzg(zzjv2.zzd(t));
        if (!this.zzc) {
            return n;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzh(T object, byte[] object2, int n, int n2, zzgf zzgf2) throws IOException {
        object2 = (zzhr)object;
        if (object2.zzc == zzjw.zza()) {
            object2.zzc = zzjw.zzb();
        }
        object = (zzho)object;
        throw null;
    }

    public final void zzi(T t) {
        this.zzb.zze(t);
        this.zzd.zzc(t);
    }

    public final boolean zzj(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzm(T t, zzgz zzgz2) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
