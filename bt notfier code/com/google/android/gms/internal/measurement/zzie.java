/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgp
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzhd
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zziw
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgp;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzhd;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zziw;

public class zzie {
    private static final zzhd zzb = zzhd.zza();
    protected volatile zziw zza;
    private volatile zzgr zzc;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzie)) {
            return false;
        }
        zzie zzie2 = (zzie)object;
        object = this.zza;
        zziw zziw2 = zzie2.zza;
        if (object == null) {
            if (zziw2 == null) return this.zzb().equals((Object)zzie2.zzb());
        }
        if (object != null) {
            if (zziw2 != null) return object.equals(zziw2);
        }
        if (object != null) {
            zzie2.zzc(object.zzbK());
            return object.equals(zzie2.zza);
        }
        this.zzc(zziw2.zzbK());
        return this.zza.equals(zziw2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgp)this.zzc).zza.length;
        }
        if (this.zza == null) return 0;
        return this.zza.zzbw();
    }

    public final zzgr zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgr zzgr2 = this.zzc;
                return zzgr2;
            }
            this.zzc = this.zza == null ? zzgr.zzb : this.zza.zzbo();
            zzgr zzgr3 = this.zzc;
            return zzgr3;
        }
    }

    protected final void zzc(zziw zziw2) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            zziw zziw3 = this.zza;
            if (zziw3 != null) return;
            try {
                this.zza = zziw2;
                this.zzc = zzgr.zzb;
            }
            catch (zzib zzib2) {
                this.zza = zziw2;
                this.zzc = zzgr.zzb;
            }
            return;
        }
    }
}
