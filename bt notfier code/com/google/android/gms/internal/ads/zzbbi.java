/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazx
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzban
 *  com.google.android.gms.internal.ads.zzbbd
 *  com.google.android.gms.internal.ads.zzbbg
 *  com.google.android.gms.internal.ads.zzbbh
 *  com.google.android.gms.internal.ads.zzbbm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzgge
 *  com.google.android.gms.internal.ads.zzggf
 *  com.google.android.gms.internal.ads.zzggg
 *  com.google.android.gms.internal.ads.zzggh
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazx;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzban;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbbh;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzgge;
import com.google.android.gms.internal.ads.zzggf;
import com.google.android.gms.internal.ads.zzggg;
import com.google.android.gms.internal.ads.zzggh;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import java.util.List;

public final class zzbbi
extends zzgga<zzbbi, zzbbh>
implements zzghj {
    private static final zzggg<Integer, zzazx> zzj;
    private static final zzbbi zzr;
    private int zzb;
    private long zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private zzggf zzi = zzbbi.zzaB();
    private zzbbd zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;

    static {
        zzbbi zzbbi2;
        zzj = new zzbbg();
        zzr = zzbbi2 = new zzbbi();
        zzgga.zzay(zzbbi.class, (zzgga)zzbbi2);
    }

    private zzbbi() {
    }

    static /* synthetic */ void zzA(zzbbi zzbbi2, int n) {
        zzbbi2.zzn = n - 1;
        zzbbi2.zzb |= 0x80;
    }

    static /* synthetic */ void zzB(zzbbi zzbbi2, int n) {
        zzbbi2.zzp = n - 1;
        zzbbi2.zzb |= 0x200;
    }

    public static zzbbi zzi(byte[] byArray) throws zzggm {
        return (zzbbi)zzgga.zzaJ((zzgga)zzr, (byte[])byArray);
    }

    public static zzbbh zzj() {
        return (zzbbh)zzr.zzas();
    }

    static /* synthetic */ zzbbi zzk() {
        return zzr;
    }

    static /* synthetic */ void zzl(zzbbi zzbbi2, long l) {
        zzbbi2.zzb |= 1;
        zzbbi2.zze = l;
    }

    static /* synthetic */ void zzm(zzbbi zzbbi2, long l) {
        zzbbi2.zzb |= 4;
        zzbbi2.zzg = l;
    }

    static /* synthetic */ void zzn(zzbbi zzbbi2, long l) {
        zzbbi2.zzb |= 8;
        zzbbi2.zzh = l;
    }

    static /* synthetic */ void zzo(zzbbi zzbbi2, Iterable iterable) {
        Object object = zzbbi2.zzi;
        if (!object.zza()) {
            zzbbi2.zzi = zzgga.zzaC((zzggf)object);
        }
        object = iterable.iterator();
        while (object.hasNext()) {
            iterable = (zzazx)object.next();
            zzbbi2.zzi.zzh(iterable.zza());
        }
    }

    static /* synthetic */ void zzp(zzbbi zzbbi2, zzbbd zzbbd2) {
        zzbbd2.getClass();
        zzbbi2.zzk = zzbbd2;
        zzbbi2.zzb |= 0x10;
    }

    static /* synthetic */ void zzq(zzbbi zzbbi2, int n) {
        zzbbi2.zzb |= 0x100;
        zzbbi2.zzo = n;
    }

    static /* synthetic */ void zzr(zzbbi zzbbi2, zzbbm zzbbm2) {
        zzbbi2.zzq = zzbbm2.zza();
        zzbbi2.zzb |= 0x400;
    }

    static /* synthetic */ void zzx(zzbbi zzbbi2, int n) {
        zzbbi2.zzf = n - 1;
        zzbbi2.zzb |= 2;
    }

    static /* synthetic */ void zzy(zzbbi zzbbi2, int n) {
        zzbbi2.zzl = n - 1;
        zzbbi2.zzb |= 0x20;
    }

    static /* synthetic */ void zzz(zzbbi zzbbi2, int n) {
        zzbbi2.zzm = n - 1;
        zzbbi2.zzb |= 0x40;
    }

    public final long zza() {
        return this.zze;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbbi();
            if (n == 4) return new zzbbh(null);
            if (n == 5) return zzr;
            return null;
        }
        zzgge zzgge2 = zzbam.zza;
        zzgge zzgge3 = zzazx.zzc();
        zzgge zzgge4 = zzbam.zza;
        object = zzbam.zza;
        zzgge zzgge5 = zzbam.zza;
        object2 = zzbam.zza;
        zzgge zzgge6 = zzbbm.zzc();
        return zzbbi.zzaz((zzghi)zzr, (String)"\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u1002\u0000\u0002\u100c\u0001\u0003\u1002\u0002\u0004\u1002\u0003\u0005\u001e\u0006\u1009\u0004\u0007\u100c\u0005\b\u100c\u0006\t\u100c\u0007\n\u1004\b\u000b\u100c\t\f\u100c\n", (Object[])new Object[]{"zzb", "zze", "zzf", zzgge2, "zzg", "zzh", "zzi", zzgge3, "zzk", "zzl", zzgge4, "zzm", object, "zzn", zzgge5, "zzo", "zzp", object2, "zzq", zzgge6});
    }

    public final long zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final List<zzazx> zze() {
        return new zzggh((List)this.zzi, zzj);
    }

    public final zzbbd zzf() {
        zzbbd zzbbd2;
        zzbbd zzbbd3 = zzbbd2 = this.zzk;
        if (zzbbd2 != null) return zzbbd3;
        zzbbd3 = zzbbd.zze();
        return zzbbd3;
    }

    public final int zzg() {
        return this.zzo;
    }

    public final zzbbm zzh() {
        zzbbm zzbbm2;
        zzbbm zzbbm3 = zzbbm2 = zzbbm.zzb((int)this.zzq);
        if (zzbbm2 != null) return zzbbm3;
        zzbbm3 = zzbbm.zza;
        return zzbbm3;
    }

    public final int zzs() {
        int n;
        int n2 = n = zzban.zza((int)this.zzf);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }

    public final int zzt() {
        int n;
        int n2 = n = zzban.zza((int)this.zzl);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }

    public final int zzu() {
        int n;
        int n2 = n = zzban.zza((int)this.zzm);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }

    public final int zzv() {
        int n;
        int n2 = n = zzban.zza((int)this.zzn);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }

    public final int zzw() {
        int n;
        int n2 = n = zzban.zza((int)this.zzp);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }
}
