/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdht
 *  com.google.android.gms.internal.ads.zzdhv
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdht;
import com.google.android.gms.internal.ads.zzdhv;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Set;

public final class zzdhu
implements zzgla<zzdht> {
    private final zzgln<Set<zzdih<zzdhv>>> zza;

    public zzdhu(zzgln<Set<zzdih<zzdhv>>> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzdht zza() {
        return new zzdht(((zzgll)this.zza).zzc());
    }
}
