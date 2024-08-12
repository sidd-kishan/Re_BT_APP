/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbdn
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzddn
 *  com.google.android.gms.internal.ads.zzelk
 *  com.google.android.gms.internal.ads.zzexb
 *  com.google.android.gms.internal.ads.zzexc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzelk;
import com.google.android.gms.internal.ads.zzexb;
import com.google.android.gms.internal.ads.zzexc;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzell
implements zzddn {
    private final AtomicReference<zzbgw> zza = new AtomicReference();

    public final void zza(zzbgw zzbgw2) {
        this.zza.set(zzbgw2);
    }

    public final void zzo(zzbdn zzbdn2) {
        zzexc.zza(this.zza, (zzexb)new zzelk(zzbdn2));
    }
}
