/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbbo
 *  com.google.android.gms.internal.ads.zzbbr
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbbo;
import com.google.android.gms.internal.ads.zzbbr;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbp
extends zzgga<zzbbp, zzbbo>
implements zzghj {
    private static final zzbbp zzp;
    private int zzb;
    private int zze = 1000;
    private int zzf = 1000;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzbbr zzo;

    static {
        zzbbp zzbbp2;
        zzp = zzbbp2 = new zzbbp();
        zzgga.zzay(zzbbp.class, (zzgga)zzbbp2);
    }

    private zzbbp() {
    }

    static /* synthetic */ zzbbp zza() {
        return zzp;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbbp();
            if (n == 4) return new zzbbo(null);
            if (n == 5) return zzp;
            return null;
        }
        object = zzbam.zza;
        object2 = zzbam.zza;
        return zzbbp.zzaz((zzghi)zzp, (String)"\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u1004\u0002\u0004\u1004\u0003\u0005\u1004\u0004\u0006\u1004\u0005\u0007\u1004\u0006\b\u1004\u0007\t\u1004\b\n\u1004\t\u000b\u1009\n", (Object[])new Object[]{"zzb", "zze", object, "zzf", object2, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
    }
}
