/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcge
 *  com.google.android.gms.internal.ads.zzcgi
 *  com.google.android.gms.internal.ads.zzfbt
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcge;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzfbt;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzfbw
implements zzgla<zzcgi> {
    private final zzfbt zza;
    private final zzgln<zzcge> zzb;

    public zzfbw(zzfbt zzfbt2, zzgln<zzcge> zzgln2) {
        this.zza = zzfbt2;
        this.zzb = zzgln2;
    }

    public final zzcgi zza() {
        return ((zzcge)this.zzb.zzb()).zzs();
    }
}
