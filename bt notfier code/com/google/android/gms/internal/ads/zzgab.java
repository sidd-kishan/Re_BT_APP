/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgaa
 *  com.google.android.gms.internal.ads.zzgad
 *  com.google.android.gms.internal.ads.zzgaf
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgaa;
import com.google.android.gms.internal.ads.zzgad;
import com.google.android.gms.internal.ads.zzgaf;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgab
extends zzgga<zzgab, zzgaa>
implements zzghj {
    private static final zzgab zzg;
    private int zzb;
    private int zze;
    private zzgex zzf = zzgex.zzb;

    static {
        zzgab zzgab2;
        zzg = zzgab2 = new zzgab();
        zzgga.zzay(zzgab.class, (zzgga)zzgab2);
    }

    private zzgab() {
    }

    public static zzgaa zzc() {
        return (zzgaa)zzg.zzas();
    }

    public static zzgab zzd() {
        return zzg;
    }

    static /* synthetic */ zzgab zze() {
        return zzg;
    }

    static /* synthetic */ void zzf(zzgab zzgab2, zzgex zzgex2) {
        zzgab2.zzf = zzgex2;
    }

    static /* synthetic */ void zzi(zzgab zzgab2, int n) {
        zzgab2.zzb = zzgad.zza((int)4);
    }

    static /* synthetic */ void zzj(zzgab zzgab2, int n) {
        zzgab2.zze = zzgaf.zza((int)5);
    }

    public final zzgex zza() {
        return this.zzf;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgab.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzgab();
        if (n == 4) return new zzgaa(null);
        if (n == 5) return zzg;
        return null;
    }

    public final int zzg() {
        int n = this.zzb;
        int n2 = 5;
        if (n != 0) {
            if (n != 2) {
                if (n != 3) {
                    n2 = n != 4 ? (n != 5 ? 0 : 7) : 6;
                }
            } else {
                n2 = 4;
            }
        } else {
            n2 = 2;
        }
        if (n2 != 0) return n2;
        return 1;
    }

    public final int zzh() {
        int n;
        int n2 = n = zzgaf.zzb((int)this.zze);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }
}
