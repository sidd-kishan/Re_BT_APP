/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazn
 *  com.google.android.gms.internal.ads.zzazo
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzazo;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazu
extends zzgga<zzazu, zzazo>
implements zzghj {
    private static final zzazu zze;
    private zzggj<zzazn> zzb = zzazu.zzaE();

    static {
        zzazu zzazu2;
        zze = zzazu2 = new zzazu();
        zzgga.zzay(zzazu.class, (zzgga)zzazu2);
    }

    private zzazu() {
    }

    public static zzazo zza() {
        return (zzazo)zze.zzas();
    }

    static /* synthetic */ zzazu zzc() {
        return zze;
    }

    static /* synthetic */ void zzd(zzazu zzazu2, zzazn zzazn2) {
        zzazn2.getClass();
        zzggj<zzazn> zzggj2 = zzazu2.zzb;
        if (!zzggj2.zza()) {
            zzazu2.zzb = zzgga.zzaF(zzggj2);
        }
        zzazu2.zzb.add((Object)zzazn2);
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzazu.zzaz((zzghi)zze, (String)"\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", (Object[])new Object[]{"zzb", zzazn.class});
        if (n == 3) return new zzazu();
        if (n == 4) return new zzazo(null);
        if (n == 5) return zze;
        return null;
    }
}
