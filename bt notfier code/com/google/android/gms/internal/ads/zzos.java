/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;

public class zzos
implements zzot {
    private final long zza;
    private final zzor zzb;

    public zzos(long l, long l2) {
        this.zza = l;
        zzou zzou2 = l2 == 0L ? zzou.zza : new zzou(0L, l2);
        this.zzb = new zzor(zzou2, zzou2);
    }

    public final boolean zze() {
        return false;
    }

    public final zzor zzf(long l) {
        return this.zzb;
    }

    public final long zzg() {
        return this.zza;
    }
}
