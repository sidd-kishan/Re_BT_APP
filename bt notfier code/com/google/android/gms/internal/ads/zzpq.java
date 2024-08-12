/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzox
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzox;

abstract class zzpq {
    protected final zzox zza;

    protected zzpq(zzox zzox2) {
        this.zza = zzox2;
    }

    protected abstract boolean zza(zzamf var1) throws zzaha;

    protected abstract boolean zzb(zzamf var1, long var2) throws zzaha;

    public final boolean zzf(zzamf zzamf2, long l) throws zzaha {
        if (!this.zza(zzamf2)) return false;
        if (!this.zzb(zzamf2, l)) return false;
        return true;
    }
}
