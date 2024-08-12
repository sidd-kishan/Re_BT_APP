/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbr
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzvk
 *  com.google.android.gms.internal.ads.zzwg
 *  com.google.android.gms.internal.ads.zzwh
 *  com.google.android.gms.internal.ads.zzxh
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzvk;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwh;
import com.google.android.gms.internal.ads.zzxh;
import java.util.Collections;
import java.util.Map;

final class zzbl
extends zzxh {
    final byte[] zza;
    final Map zzb;
    final zzcgs zzc;

    zzbl(zzbr zzbr2, int n, String string, zzwh zzwh2, zzwg zzwg2, byte[] byArray, Map map, zzcgs zzcgs2) {
        this.zza = byArray;
        this.zzb = map;
        this.zzc = zzcgs2;
        super(n, string, zzwh2, zzwg2);
    }

    public final Map<String, String> zzn() throws zzvk {
        Map<String, String> map;
        Map<String, String> map2 = map = this.zzb;
        if (map != null) return map2;
        map2 = Collections.emptyMap();
        return map2;
    }

    public final byte[] zzo() throws zzvk {
        byte[] byArray;
        byte[] byArray2 = byArray = this.zza;
        if (byArray != null) return byArray2;
        byArray2 = null;
        return byArray2;
    }

    protected final void zzz(String string) {
        this.zzc.zze(string);
        super.zzz(string);
    }
}
