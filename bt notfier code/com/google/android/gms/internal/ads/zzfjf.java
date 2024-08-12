/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfjc
 *  com.google.android.gms.internal.ads.zzfjd
 *  com.google.android.gms.internal.ads.zzfje
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggf
 *  com.google.android.gms.internal.ads.zzggg
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfjc;
import com.google.android.gms.internal.ads.zzfjd;
import com.google.android.gms.internal.ads.zzfje;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggf;
import com.google.android.gms.internal.ads.zzggg;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfjf
extends zzgga<zzfjf, zzfje>
implements zzghj {
    private static final zzggg<Integer, Object> zzf;
    private static final zzfjf zzj;
    private int zzb;
    private zzggf zze = zzfjf.zzaB();
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzfjf zzfjf2;
        zzf = new zzfjc();
        zzj = zzfjf2 = new zzfjf();
        zzgga.zzay(zzfjf.class, (zzgga)zzfjf2);
    }

    private zzfjf() {
    }

    public static zzfje zza() {
        return (zzfje)zzj.zzas();
    }

    static /* synthetic */ zzfjf zzc() {
        return zzj;
    }

    static /* synthetic */ void zzd(zzfjf zzfjf2, String string) {
        string.getClass();
        zzfjf2.zzb |= 1;
        zzfjf2.zzg = string;
    }

    static /* synthetic */ void zze(zzfjf zzfjf2, int n) {
        zzggf zzggf2 = zzfjf2.zze;
        if (!zzggf2.zza()) {
            zzfjf2.zze = zzgga.zzaC((zzggf)zzggf2);
        }
        zzfjf2.zze.zzh(2);
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzfjf();
            if (n == 4) return new zzfje(null);
            if (n == 5) return zzj;
            return null;
        }
        object = zzfjd.zza;
        return zzfjf.zzaz((zzghi)zzj, (String)"\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\u1008\u0000\u0003\u1008\u0001\u0004\u1008\u0002", (Object[])new Object[]{"zzb", "zze", object, "zzg", "zzh", "zzi"});
    }
}
