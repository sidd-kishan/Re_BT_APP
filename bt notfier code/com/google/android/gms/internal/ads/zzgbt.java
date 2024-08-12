/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgbs
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgbs;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbt
extends zzgga<zzgbt, zzgbs>
implements zzghj {
    private static final zzgbt zzf;
    private String zzb = "";
    private zzgau zze;

    static {
        zzgbt zzgbt2;
        zzf = zzgbt2 = new zzgbt();
        zzgga.zzay(zzgbt.class, (zzgga)zzgbt2);
    }

    private zzgbt() {
    }

    public static zzgbt zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgbt)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgbt zzf() {
        return zzf;
    }

    static /* synthetic */ zzgbt zzg() {
        return zzf;
    }

    public final String zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbt.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0208\u0002\t", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzgbt();
        if (n == 4) return new zzgbs(null);
        if (n == 5) return zzf;
        return null;
    }

    public final boolean zzc() {
        if (this.zze == null) return false;
        return true;
    }

    public final zzgau zzd() {
        zzgau zzgau2;
        zzgau zzgau3 = zzgau2 = this.zze;
        if (zzgau2 != null) return zzgau3;
        zzgau3 = zzgau.zze();
        return zzgau3;
    }
}
