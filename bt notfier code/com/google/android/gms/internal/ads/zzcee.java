/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzceb
 *  com.google.android.gms.internal.ads.zzced
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzced;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzcee
implements zzgla<zzced> {
    private final zzgln<Clock> zza;
    private final zzgln<zzceb> zzb;

    public zzcee(zzgln<Clock> zzgln2, zzgln<zzceb> zzgln3) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
    }

    public final zzced zza() {
        return new zzced((Clock)this.zza.zzb(), (zzceb)this.zzb.zzb());
    }
}
