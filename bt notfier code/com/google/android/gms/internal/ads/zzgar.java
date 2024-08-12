/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgaq
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgaq;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgar
extends zzgga<zzgar, zzgaq>
implements zzghj {
    private static final zzgar zzg;
    private String zzb = "";
    private zzgex zze = zzgex.zzb;
    private int zzf;

    static {
        zzgar zzgar2;
        zzg = zzgar2 = new zzgar();
        zzgga.zzay(zzgar.class, (zzgga)zzgar2);
    }

    private zzgar() {
    }

    public static zzgaq zzd() {
        return (zzgaq)zzg.zzas();
    }

    public static zzgar zze() {
        return zzg;
    }

    static /* synthetic */ zzgar zzf() {
        return zzg;
    }

    static /* synthetic */ void zzg(zzgar zzgar2, String string) {
        zzgar2.zzb = string;
    }

    static /* synthetic */ void zzh(zzgar zzgar2, zzgex zzgex2) {
        zzgar2.zze = zzgex2;
    }

    static /* synthetic */ void zzj(zzgar zzgar2, int n) {
        zzgar2.zzf = n - 2;
    }

    public final String zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgar.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0208\u0002\n\u0003\f", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzgar();
        if (n == 4) return new zzgaq(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }

    public final int zzi() {
        int n = this.zzf;
        int n2 = 4;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    n2 = n != 3 ? (n != 4 ? 0 : 6) : 5;
                }
            } else {
                n2 = 3;
            }
        } else {
            n2 = 2;
        }
        if (n2 != 0) return n2;
        return 1;
    }
}
