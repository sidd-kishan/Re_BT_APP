/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzt;

public final class zzcc {
    private long zza;
    private long zzb = Long.MIN_VALUE;
    private final Object zzc = new Object();

    public zzcc(long l) {
        this.zza = l;
    }

    public final boolean zza() {
        Object object = this.zzc;
        synchronized (object) {
            long l = zzt.zzj().elapsedRealtime();
            if (this.zzb + this.zza > l) {
                return false;
            }
            this.zzb = l;
            return true;
        }
    }

    public final void zzb(long l) {
        Object object = this.zzc;
        synchronized (object) {
            this.zza = l;
            return;
        }
    }
}
