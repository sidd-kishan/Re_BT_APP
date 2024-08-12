/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyi
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyi;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyj
extends zzgga<zzfyj, zzfyi>
implements zzghj {
    private static final zzfyj zze;
    private int zzb;

    static {
        zzfyj zzfyj2;
        zze = zzfyj2 = new zzfyj();
        zzgga.zzay(zzfyj.class, (zzgga)zzfyj2);
    }

    private zzfyj() {
    }

    public static zzfyi zzc() {
        return (zzfyi)zze.zzas();
    }

    public static zzfyj zzd() {
        return zze;
    }

    static /* synthetic */ zzfyj zze() {
        return zze;
    }

    static /* synthetic */ void zzf(zzfyj zzfyj2, int n) {
        zzfyj2.zzb = 16;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfyj.zzaz((zzghi)zze, (String)"\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", (Object[])new Object[]{"zzb"});
        if (n == 3) return new zzfyj();
        if (n == 4) return new zzfyi(null);
        if (n == 5) return zze;
        return null;
    }
}
