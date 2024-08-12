/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzddv
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzddv;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Set;

public final class zzddw
implements zzgla<zzddv> {
    private final zzgln<Set<zzdih<zzddx>>> zza;

    public zzddw(zzgln<Set<zzdih<zzddx>>> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzddv zza() {
        return new zzddv(((zzgll)this.zza).zzc());
    }
}
