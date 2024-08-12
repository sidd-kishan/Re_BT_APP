/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzecm
 *  com.google.android.gms.internal.ads.zzecn
 *  com.google.android.gms.internal.ads.zzecq
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecm;
import com.google.android.gms.internal.ads.zzecn;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzecr
implements zzgla<zzecq> {
    private final zzgln<zzecm> zza;
    private final zzgln<zzfsn> zzb;

    public zzecr(zzgln<zzecm> zzgln2, zzgln<zzfsn> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzecq zza() {
        return new zzecq(((zzecn)this.zza).zza(), (zzfsn)this.zzb.zzb());
    }
}
