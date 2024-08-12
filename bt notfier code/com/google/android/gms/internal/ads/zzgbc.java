/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgaz
 *  com.google.android.gms.internal.ads.zzgbb
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgaz;
import com.google.android.gms.internal.ads.zzgbb;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import java.util.List;

public final class zzgbc
extends zzgga<zzgbc, zzgaz>
implements zzghj {
    private static final zzgbc zzf;
    private int zzb;
    private zzggj<zzgbb> zze = zzgbc.zzaE();

    static {
        zzgbc zzgbc2;
        zzf = zzgbc2 = new zzgbc();
        zzgga.zzay(zzgbc.class, (zzgga)zzgbc2);
    }

    private zzgbc() {
    }

    public static zzgbc zze(byte[] byArray, zzgfm zzgfm2) throws zzggm {
        return (zzgbc)zzgga.zzaK((zzgga)zzf, (byte[])byArray, (zzgfm)zzgfm2);
    }

    static /* synthetic */ zzgbc zzf() {
        return zzf;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbc.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", (Object[])new Object[]{"zzb", "zze", zzgbb.class});
        if (n == 3) return new zzgbc();
        if (n == 4) return new zzgaz(null);
        if (n == 5) return zzf;
        return null;
    }

    public final List<zzgbb> zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }
}
