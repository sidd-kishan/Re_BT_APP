/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzagt
 *  com.google.android.gms.internal.ads.zzaiq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzagt;
import com.google.android.gms.internal.ads.zzaiq;

final class zzafd
implements zzagt {
    private final Object zza;
    private zzaiq zzb;

    public zzafd(Object object, zzaiq zzaiq2) {
        this.zza = object;
        this.zzb = zzaiq2;
    }

    static /* synthetic */ zzaiq zza(zzafd zzafd2, zzaiq zzaiq2) {
        zzafd2.zzb = zzaiq2;
        return zzaiq2;
    }

    public final Object zzb() {
        return this.zza;
    }

    public final zzaiq zzc() {
        return this.zzb;
    }
}
