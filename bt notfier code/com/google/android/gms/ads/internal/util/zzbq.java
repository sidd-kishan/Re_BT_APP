/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbp
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwg
 *  com.google.android.gms.internal.ads.zzwi
 *  com.google.android.gms.internal.ads.zzwz
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzbp;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzwz;
import java.util.Map;

public final class zzbq
extends zzwc<zzvy> {
    private final zzchl<zzvy> zza;
    private final zzcgs zzb;

    public zzbq(String string, Map<String, String> zzcgs2, zzchl<zzvy> zzchl2) {
        super(0, string, (zzwg)new zzbp(zzchl2));
        this.zza = zzchl2;
        this.zzb = zzcgs2 = new zzcgs(null);
        zzcgs2.zzb(string, "GET", null, null);
    }

    protected final zzwi<zzvy> zzs(zzvy zzvy2) {
        return zzwi.zza((Object)zzvy2, (zzvl)zzwz.zza((zzvy)zzvy2));
    }
}
