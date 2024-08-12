/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxn
 *  com.google.android.gms.internal.ads.zzfxu
 *  com.google.android.gms.internal.ads.zzgai
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxn;
import com.google.android.gms.internal.ads.zzfxu;
import com.google.android.gms.internal.ads.zzgai;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxo
extends zzgga<zzfxo, zzfxn>
implements zzghj {
    private static final zzfxo zzg;
    private int zzb;
    private zzfxu zze;
    private zzgai zzf;

    static {
        zzfxo zzfxo2;
        zzg = zzfxo2 = new zzfxo();
        zzgga.zzay(zzfxo.class, (zzgga)zzfxo2);
    }

    private zzfxo() {
    }

    public static zzfxo zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfxo)zzgga.zzaI((zzgga)zzg, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfxn zzf() {
        return (zzfxn)zzg.zzas();
    }

    static /* synthetic */ zzfxo zzg() {
        return zzg;
    }

    static /* synthetic */ void zzh(zzfxo zzfxo2, int n) {
        zzfxo2.zzb = n;
    }

    static /* synthetic */ void zzi(zzfxo zzfxo2, zzfxu zzfxu2) {
        zzfxu2.getClass();
        zzfxo2.zze = zzfxu2;
    }

    static /* synthetic */ void zzj(zzfxo zzfxo2, zzgai zzgai2) {
        zzgai2.getClass();
        zzfxo2.zzf = zzgai2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfxo.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzfxo();
        if (n == 4) return new zzfxn(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzfxu zzc() {
        zzfxu zzfxu2;
        zzfxu zzfxu3 = zzfxu2 = this.zze;
        if (zzfxu2 != null) return zzfxu3;
        zzfxu3 = zzfxu.zzg();
        return zzfxu3;
    }

    public final zzgai zzd() {
        zzgai zzgai2;
        zzgai zzgai3 = zzgai2 = this.zzf;
        if (zzgai2 != null) return zzgai3;
        zzgai3 = zzgai.zzg();
        return zzgai3;
    }
}
