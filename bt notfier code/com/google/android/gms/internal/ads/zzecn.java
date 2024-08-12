/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzecm
 *  com.google.android.gms.internal.ads.zzfbv
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzecm;
import com.google.android.gms.internal.ads.zzfbv;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzecn
implements zzgla<zzecm> {
    private final zzgln<Context> zza;

    public zzecn(zzgln<Context> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzecm zza() {
        return new zzecm(((zzfbv)this.zza).zza());
    }
}
