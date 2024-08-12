/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzfer
 *  com.google.android.gms.internal.ads.zzfet
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgll
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzfer;
import com.google.android.gms.internal.ads.zzfet;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgll;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Set;

public final class zzfev
implements zzgla<zzfer> {
    private final zzgln<Set<zzdih<zzfet>>> zza;

    public zzfev(zzgln<Set<zzdih<zzfet>>> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzfer zza() {
        return new zzfer(((zzgll)this.zza).zzc());
    }
}
