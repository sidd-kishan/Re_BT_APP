/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgaf
 *  com.google.android.gms.internal.ads.zzgan
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgaf;
import com.google.android.gms.internal.ads.zzgan;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgao
extends zzgga<zzgao, zzgan>
implements zzghj {
    private static final zzgao zzf;
    private int zzb;
    private int zze;

    static {
        zzgao zzgao2;
        zzf = zzgao2 = new zzgao();
        zzgga.zzay(zzgao.class, (zzgga)zzgao2);
    }

    private zzgao() {
    }

    public static zzgan zzc() {
        return (zzgan)zzf.zzas();
    }

    public static zzgao zzd() {
        return zzf;
    }

    static /* synthetic */ zzgao zze() {
        return zzf;
    }

    static /* synthetic */ void zzf(zzgao zzgao2, int n) {
        zzgao2.zze = n;
    }

    static /* synthetic */ void zzh(zzgao zzgao2, int n) {
        zzgao2.zzb = zzgaf.zza((int)n);
    }

    public final int zza() {
        return this.zze;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgao.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzgao();
        if (n == 4) return new zzgan(null);
        if (n == 5) return zzf;
        return null;
    }

    public final int zzg() {
        int n;
        int n2 = n = zzgaf.zzb((int)this.zzb);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }
}
