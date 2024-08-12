/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbka
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbka;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzbjy {
    private final Map<String, zzbjx> zza;
    private final zzbka zzb;

    public zzbjy(zzbka zzbka2) {
        this.zzb = zzbka2;
        this.zza = new HashMap<String, zzbjx>();
    }

    public final void zza(String string, zzbjx zzbjx2) {
        this.zza.put(string, zzbjx2);
    }

    public final void zzb(String string, String string2, long l) {
        zzbka zzbka2 = this.zzb;
        if ((string2 = this.zza.get(string2)) != null) {
            zzbka2.zzb((zzbjx)string2, l, new String[]{string});
        }
        this.zza.put(string, new zzbjx(l, null, null));
    }

    public final zzbka zzc() {
        return this.zzb;
    }
}
