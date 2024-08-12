/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazj
 *  com.google.android.gms.internal.ads.zzazk
 *  com.google.android.gms.internal.ads.zzazz
 *  com.google.android.gms.internal.ads.zzbab
 *  com.google.android.gms.internal.ads.zzbad
 *  com.google.android.gms.internal.ads.zzbaf
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbat
 *  com.google.android.gms.internal.ads.zzbav
 *  com.google.android.gms.internal.ads.zzbbf
 *  com.google.android.gms.internal.ads.zzbbp
 *  com.google.android.gms.internal.ads.zzbcb
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbab;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbav;
import com.google.android.gms.internal.ads.zzbbf;
import com.google.android.gms.internal.ads.zzbbp;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazl
extends zzgga<zzazl, zzazk>
implements zzghj {
    private static final zzazl zzp;
    private int zzb;
    private int zze;
    private int zzf = 1000;
    private zzbab zzg;
    private zzbad zzh;
    private zzggj<zzazz> zzi = zzazl.zzaE();
    private zzbaf zzj;
    private zzbbp zzk;
    private zzbbf zzl;
    private zzbat zzm;
    private zzbav zzn;
    private zzggj<zzbcb> zzo = zzazl.zzaE();

    static {
        zzazl zzazl2;
        zzp = zzazl2 = new zzazl();
        zzgga.zzay(zzazl.class, (zzgga)zzazl2);
    }

    private zzazl() {
    }

    public static zzazl zzc() {
        return zzp;
    }

    static /* synthetic */ zzazl zzd() {
        return zzp;
    }

    static /* synthetic */ void zze(zzazl zzazl2, zzazj zzazj2) {
        zzazl2.zze = zzazj2.zza();
        zzazl2.zzb |= 1;
    }

    static /* synthetic */ void zzf(zzazl zzazl2, zzbad zzbad2) {
        zzbad2.getClass();
        zzazl2.zzh = zzbad2;
        zzazl2.zzb |= 8;
    }

    public final zzbad zza() {
        zzbad zzbad2;
        zzbad zzbad3 = zzbad2 = this.zzh;
        if (zzbad2 != null) return zzbad3;
        zzbad3 = zzbad.zza();
        return zzbad3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzazl();
            if (n == 4) return new zzazk(null);
            if (n == 5) return zzp;
            return null;
        }
        object2 = zzazj.zzc();
        object = zzbam.zza;
        return zzazl.zzaz((zzghi)zzp, (String)"\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007\u100c\u0000\b\u100c\u0001\t\u1009\u0002\n\u1009\u0003\u000b\u001b\f\u1009\u0004\r\u1009\u0005\u000e\u1009\u0006\u000f\u1009\u0007\u0010\u1009\b\u0011\u001b", (Object[])new Object[]{"zzb", "zze", object2, "zzf", object, "zzg", "zzh", "zzi", zzazz.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzbcb.class});
    }
}
