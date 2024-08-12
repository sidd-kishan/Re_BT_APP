/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdcs
 *  com.google.android.gms.internal.ads.zzdcu
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdcs;
import com.google.android.gms.internal.ads.zzdcu;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Set;

public final class zzdct
implements zzgla<zzdcs> {
    private final zzgln<Set<zzdih<zzdcu>>> zza;

    public zzdct(zzgln<Set<zzdih<zzdcu>>> zzgln2) {
        this.zza = zzgln2;
    }

    public static zzdcs zzc(Set<zzdih<zzdcu>> set) {
        return new zzdcs(set);
    }

    public final zzdcs zza() {
        return new zzdcs(((zzgll)this.zza).zzc());
    }
}
