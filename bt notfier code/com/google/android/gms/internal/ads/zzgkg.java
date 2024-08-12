/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeg
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjh
 *  com.google.android.gms.internal.ads.zzgji
 *  com.google.android.gms.internal.ads.zzgjk
 *  com.google.android.gms.internal.ads.zzgjx
 *  com.google.android.gms.internal.ads.zzgjy
 *  com.google.android.gms.internal.ads.zzgkd
 *  com.google.android.gms.internal.ads.zzgkf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeg;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjh;
import com.google.android.gms.internal.ads.zzgji;
import com.google.android.gms.internal.ads.zzgjk;
import com.google.android.gms.internal.ads.zzgjx;
import com.google.android.gms.internal.ads.zzgjy;
import com.google.android.gms.internal.ads.zzgkd;
import com.google.android.gms.internal.ads.zzgkf;
import java.util.List;

public final class zzgkg
extends zzgga<zzgkg, zzgji>
implements zzghj {
    private static final zzgkg zzx;
    private int zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzgjk zzj;
    private zzggj<zzgkd> zzk;
    private String zzl = "";
    private zzgjx zzm;
    private boolean zzn;
    private zzggj<String> zzo;
    private String zzp = "";
    private boolean zzq;
    private boolean zzr;
    private zzgex zzs;
    private zzgkf zzt;
    private zzggj<String> zzu;
    private zzggj<String> zzv;
    private byte zzw = (byte)2;

    static {
        zzgkg zzgkg2;
        zzx = zzgkg2 = new zzgkg();
        zzgga.zzay(zzgkg.class, (zzgga)zzgkg2);
    }

    private zzgkg() {
        this.zzk = zzgkg.zzaE();
        this.zzo = zzgga.zzaE();
        this.zzs = zzgex.zzb;
        this.zzu = zzgga.zzaE();
        this.zzv = zzgga.zzaE();
    }

    public static zzgji zze() {
        return (zzgji)zzx.zzas();
    }

    static /* synthetic */ zzgkg zzf() {
        return zzx;
    }

    static /* synthetic */ void zzg(zzgkg zzgkg2, String string) {
        string.getClass();
        zzgkg2.zzb |= 4;
        zzgkg2.zzg = string;
    }

    static /* synthetic */ void zzh(zzgkg zzgkg2, String string) {
        string.getClass();
        zzgkg2.zzb |= 8;
        zzgkg2.zzh = string;
    }

    static /* synthetic */ void zzi(zzgkg zzgkg2, zzgjk zzgjk2) {
        zzgjk2.getClass();
        zzgkg2.zzj = zzgjk2;
        zzgkg2.zzb |= 0x20;
    }

    static /* synthetic */ void zzj(zzgkg zzgkg2, zzgkd zzgkd2) {
        zzgkd2.getClass();
        zzggj<zzgkd> zzggj2 = zzgkg2.zzk;
        if (!zzggj2.zza()) {
            zzgkg2.zzk = zzgga.zzaF(zzggj2);
        }
        zzgkg2.zzk.add((Object)zzgkd2);
    }

    static /* synthetic */ void zzk(zzgkg zzgkg2, String string) {
        zzgkg2.zzb |= 0x40;
        zzgkg2.zzl = string;
    }

    static /* synthetic */ void zzl(zzgkg zzgkg2) {
        zzgkg2.zzb &= 0xFFFFFFBF;
        zzgkg2.zzl = zzgkg.zzx.zzl;
    }

    static /* synthetic */ void zzm(zzgkg zzgkg2, zzgjx zzgjx2) {
        zzgjx2.getClass();
        zzgkg2.zzm = zzgjx2;
        zzgkg2.zzb |= 0x80;
    }

    static /* synthetic */ void zzn(zzgkg zzgkg2, zzgkf zzgkf2) {
        zzgkf2.getClass();
        zzgkg2.zzt = zzgkf2;
        zzgkg2.zzb |= 0x2000;
    }

    static /* synthetic */ void zzo(zzgkg zzgkg2, Iterable iterable) {
        zzggj<String> zzggj2 = zzgkg2.zzu;
        if (!zzggj2.zza()) {
            zzgkg2.zzu = zzgga.zzaF(zzggj2);
        }
        zzgeg.zzar((Iterable)iterable, zzgkg2.zzu);
    }

    static /* synthetic */ void zzp(zzgkg zzgkg2, Iterable iterable) {
        zzggj<String> zzggj2 = zzgkg2.zzv;
        if (!zzggj2.zza()) {
            zzgkg2.zzv = zzgga.zzaF(zzggj2);
        }
        zzgeg.zzar((Iterable)iterable, zzgkg2.zzv);
    }

    static /* synthetic */ void zzq(zzgkg zzgkg2, int n) {
        zzgkg2.zze = n - 1;
        zzgkg2.zzb |= 1;
    }

    public final String zza() {
        return this.zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return this.zzw;
        byte by = 1;
        if (n == 2) {
            object2 = zzgjy.zza;
            object = zzgjh.zza;
            return zzgkg.zzaz((zzghi)zzx, (String)"\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\u1008\u0002\u0002\u1008\u0003\u0003\u1008\u0004\u0004\u041b\u0005\u1007\b\u0006\u001a\u0007\u1008\t\b\u1007\n\t\u1007\u000b\n\u100c\u0000\u000b\u100c\u0001\f\u1009\u0005\r\u1008\u0006\u000e\u1009\u0007\u000f\u100a\f\u0011\u1009\r\u0014\u001a\u0015\u001a", (Object[])new Object[]{"zzb", "zzg", "zzh", "zzi", "zzk", zzgkd.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zze", object2, "zzf", object, "zzj", "zzl", "zzm", "zzs", "zzt", "zzu", "zzv"});
        }
        if (n == 3) return new zzgkg();
        if (n == 4) return new zzgji(null);
        if (n == 5) return zzx;
        if (object == null) {
            by = 0;
        }
        this.zzw = by;
        return null;
    }

    public final List<zzgkd> zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzl;
    }
}
