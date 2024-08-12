/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzxv
 *  com.google.android.gms.internal.ads.zzxx
 *  com.google.android.gms.internal.ads.zzxy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzxv;
import com.google.android.gms.internal.ads.zzxx;
import com.google.android.gms.internal.ads.zzxy;

public final class zzxz
extends zzgga<zzxz, zzxv>
implements zzghj {
    private static final zzxz zzr;
    private int zzb;
    private String zze = "";
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private long zzj;
    private long zzk;
    private String zzl = "";
    private long zzm;
    private String zzn = "";
    private String zzo = "";
    private zzggj<zzxx> zzp = zzxz.zzaE();
    private int zzq;

    static {
        zzxz zzxz2;
        zzr = zzxz2 = new zzxz();
        zzgga.zzay(zzxz.class, (zzgga)zzxz2);
    }

    private zzxz() {
    }

    public static zzxv zza() {
        return (zzxv)zzr.zzas();
    }

    static /* synthetic */ zzxz zzc() {
        return zzr;
    }

    static /* synthetic */ void zzd(zzxz zzxz2, String string) {
        string.getClass();
        zzxz2.zzb |= 1;
        zzxz2.zze = string;
    }

    static /* synthetic */ void zze(zzxz zzxz2, long l) {
        zzxz2.zzb |= 2;
        zzxz2.zzf = l;
    }

    static /* synthetic */ void zzf(zzxz zzxz2, String string) {
        string.getClass();
        zzxz2.zzb |= 4;
        zzxz2.zzg = string;
    }

    static /* synthetic */ void zzg(zzxz zzxz2, String string) {
        string.getClass();
        zzxz2.zzb |= 8;
        zzxz2.zzh = string;
    }

    static /* synthetic */ void zzh(zzxz zzxz2, String string) {
        zzxz2.zzb |= 0x10;
        zzxz2.zzi = string;
    }

    static /* synthetic */ void zzi(zzxz zzxz2, String string) {
        zzxz2.zzb |= 0x400;
        zzxz2.zzo = string;
    }

    static /* synthetic */ void zzj(zzxz zzxz2, int n) {
        zzxz2.zzq = n - 1;
        zzxz2.zzb |= 0x800;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzxz();
            if (n == 4) return new zzxv(null);
            if (n == 5) return zzr;
            return null;
        }
        object = zzxy.zza;
        return zzxz.zzaz((zzghi)zzr, (String)"\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u1002\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u1002\u0005\u0007\u1002\u0006\b\u1008\u0007\t\u1002\b\n\u1008\t\u000b\u1008\n\f\u001b\r\u100c\u000b", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzxx.class, "zzq", object});
    }
}
