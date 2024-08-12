/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdbo
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdbo;
import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Set;

public final class zzdbq
implements zzgla<zzdbo> {
    private final zzgln<Set<zzdih<zzdbs>>> zza;

    public zzdbq(zzgln<Set<zzdih<zzdbs>>> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzdbo zza() {
        return new zzdbo(((zzgll)this.zza).zzc());
    }
}
