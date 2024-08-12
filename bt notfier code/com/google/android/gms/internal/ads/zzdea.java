/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzddz
 *  com.google.android.gms.internal.ads.zzdeb
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzddz;
import com.google.android.gms.internal.ads.zzdeb;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Set;

public final class zzdea
implements zzgla<zzddz> {
    private final zzgln<Set<zzdih<zzdeb>>> zza;

    public zzdea(zzgln<Set<zzdih<zzdeb>>> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzddz zza() {
        return new zzddz(((zzgll)this.zza).zzc());
    }
}
