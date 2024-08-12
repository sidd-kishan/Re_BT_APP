/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyv
 *  com.google.android.gms.internal.ads.zzzf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyv;
import com.google.android.gms.internal.ads.zzzf;

public final class zzyw
extends zzgga<zzyw, zzyv>
implements zzghj {
    private static final zzyw zzz;
    private int zzb;
    private long zze = -1L;
    private long zzf = -1L;
    private long zzg = -1L;
    private long zzh = -1L;
    private long zzi = -1L;
    private long zzj = -1L;
    private int zzk = 1000;
    private long zzl = -1L;
    private long zzm = -1L;
    private long zzn = -1L;
    private int zzo = 1000;
    private long zzp = -1L;
    private long zzq = -1L;
    private long zzr = -1L;
    private long zzs = -1L;
    private long zzt;
    private long zzu;
    private long zzv = -1L;
    private long zzw = -1L;
    private long zzx = -1L;
    private long zzy = -1L;

    static {
        zzyw zzyw2;
        zzz = zzyw2 = new zzyw();
        zzgga.zzay(zzyw.class, (zzgga)zzyw2);
    }

    private zzyw() {
    }

    public static zzyv zza() {
        return (zzyv)zzz.zzas();
    }

    static /* synthetic */ zzyw zzc() {
        return zzz;
    }

    static /* synthetic */ void zzd(zzyw zzyw2, long l) {
        zzyw2.zzb |= 1;
        zzyw2.zze = l;
    }

    static /* synthetic */ void zze(zzyw zzyw2, long l) {
        zzyw2.zzb |= 2;
        zzyw2.zzf = l;
    }

    static /* synthetic */ void zzf(zzyw zzyw2, long l) {
        zzyw2.zzb |= 4;
        zzyw2.zzg = l;
    }

    static /* synthetic */ void zzg(zzyw zzyw2, long l) {
        zzyw2.zzb |= 8;
        zzyw2.zzh = l;
    }

    static /* synthetic */ void zzh(zzyw zzyw2) {
        zzyw2.zzb &= 0xFFFFFFF7;
        zzyw2.zzh = -1L;
    }

    static /* synthetic */ void zzi(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x10;
        zzyw2.zzi = l;
    }

    static /* synthetic */ void zzj(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x20;
        zzyw2.zzj = l;
    }

    static /* synthetic */ void zzk(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x80;
        zzyw2.zzl = l;
    }

    static /* synthetic */ void zzl(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x100;
        zzyw2.zzm = l;
    }

    static /* synthetic */ void zzm(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x200;
        zzyw2.zzn = l;
    }

    static /* synthetic */ void zzn(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x800;
        zzyw2.zzp = l;
    }

    static /* synthetic */ void zzo(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x1000;
        zzyw2.zzq = l;
    }

    static /* synthetic */ void zzp(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x2000;
        zzyw2.zzr = l;
    }

    static /* synthetic */ void zzq(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x4000;
        zzyw2.zzs = l;
    }

    static /* synthetic */ void zzr(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x8000;
        zzyw2.zzt = l;
    }

    static /* synthetic */ void zzs(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x10000;
        zzyw2.zzu = l;
    }

    static /* synthetic */ void zzt(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x20000;
        zzyw2.zzv = l;
    }

    static /* synthetic */ void zzu(zzyw zzyw2, long l) {
        zzyw2.zzb |= 0x40000;
        zzyw2.zzw = l;
    }

    static /* synthetic */ void zzv(zzyw zzyw2, int n) {
        zzyw2.zzk = n - 1;
        zzyw2.zzb |= 0x40;
    }

    static /* synthetic */ void zzw(zzyw zzyw2, int n) {
        zzyw2.zzo = n - 1;
        zzyw2.zzb |= 0x400;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzyw();
            if (n == 4) return new zzyv(null);
            if (n == 5) return zzz;
            return null;
        }
        object = zzzf.zza;
        object2 = zzzf.zza;
        return zzyw.zzaz((zzghi)zzz, (String)"\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001\u1002\u0000\u0002\u1002\u0001\u0003\u1002\u0002\u0004\u1002\u0003\u0005\u1002\u0004\u0006\u1002\u0005\u0007\u100c\u0006\b\u1002\u0007\t\u1002\b\n\u1002\t\u000b\u100c\n\f\u1002\u000b\r\u1002\f\u000e\u1002\r\u000f\u1002\u000e\u0010\u1002\u000f\u0011\u1002\u0010\u0012\u1002\u0011\u0013\u1002\u0012\u0014\u1002\u0013\u0015\u1002\u0014", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", object, "zzl", "zzm", "zzn", "zzo", object2, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
    }
}
