/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzatl {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final boolean zzg;
    public final boolean zzh;
    public final int zzi = Integer.MAX_VALUE;
    public final int zzj = Integer.MAX_VALUE;
    public final boolean zzk;

    public zzatl() {
        this.zza = null;
        this.zzb = false;
        this.zzc = true;
        this.zzg = true;
        this.zzh = true;
        this.zzk = true;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzatl)object;
        if (!TextUtils.equals(null, null)) return false;
        if (!TextUtils.equals(null, null)) return false;
        return true;
    }

    public final int hashCode() {
        throw null;
    }
}
