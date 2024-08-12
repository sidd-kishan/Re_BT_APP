/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjj;

public final class zzgjk
extends zzgga<zzgjk, zzgjj>
implements zzghj {
    private static final zzgjk zzf;
    private int zzb;
    private String zze = "";

    static {
        zzgjk zzgjk2;
        zzf = zzgjk2 = new zzgjk();
        zzgga.zzay(zzgjk.class, (zzgga)zzgjk2);
    }

    private zzgjk() {
    }

    public static zzgjj zza() {
        return (zzgjj)zzf.zzas();
    }

    static /* synthetic */ zzgjk zzc() {
        return zzf;
    }

    static /* synthetic */ void zzd(zzgjk zzgjk2, String string) {
        zzgjk2.zzb |= 1;
        zzgjk2.zze = string;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgjk.zzaz((zzghi)zzf, (String)"\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u1008\u0000", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzgjk();
        if (n == 4) return new zzgjj(null);
        if (n == 5) return zzf;
        return null;
    }
}
