/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggf
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjq
 *  com.google.android.gms.internal.ads.zzgju
 *  com.google.android.gms.internal.ads.zzgka
 *  com.google.android.gms.internal.ads.zzgkc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggf;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjq;
import com.google.android.gms.internal.ads.zzgju;
import com.google.android.gms.internal.ads.zzgka;
import com.google.android.gms.internal.ads.zzgkc;

public final class zzgkd
extends zzgga<zzgkd, zzgkc>
implements zzghj {
    private static final zzgkd zzo;
    private int zzb;
    private int zze;
    private String zzf = "";
    private zzgjq zzg;
    private zzgju zzh;
    private int zzi;
    private zzggf zzj;
    private String zzk = "";
    private int zzl;
    private zzggj<String> zzm;
    private byte zzn = (byte)2;

    static {
        zzgkd zzgkd2;
        zzo = zzgkd2 = new zzgkd();
        zzgga.zzay(zzgkd.class, (zzgga)zzgkd2);
    }

    private zzgkd() {
        this.zzj = zzgkd.zzaB();
        this.zzm = zzgga.zzaE();
    }

    public static zzgkc zzd() {
        return (zzgkc)zzo.zzas();
    }

    static /* synthetic */ zzgkd zze() {
        return zzo;
    }

    static /* synthetic */ void zzf(zzgkd zzgkd2, int n) {
        zzgkd2.zzb |= 1;
        zzgkd2.zze = n;
    }

    static /* synthetic */ void zzg(zzgkd zzgkd2, String string) {
        string.getClass();
        zzgkd2.zzb |= 2;
        zzgkd2.zzf = string;
    }

    static /* synthetic */ void zzh(zzgkd zzgkd2, zzgjq zzgjq2) {
        zzgjq2.getClass();
        zzgkd2.zzg = zzgjq2;
        zzgkd2.zzb |= 4;
    }

    static /* synthetic */ void zzi(zzgkd zzgkd2, String string) {
        string.getClass();
        zzggj<String> zzggj2 = zzgkd2.zzm;
        if (!zzggj2.zza()) {
            zzgkd2.zzm = zzgga.zzaF(zzggj2);
        }
        zzgkd2.zzm.add((Object)string);
    }

    static /* synthetic */ void zzj(zzgkd zzgkd2, int n) {
        zzgkd2.zzl = n - 1;
        zzgkd2.zzb |= 0x40;
    }

    public final String zza() {
        return this.zzf;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return this.zzn;
        byte by = 1;
        if (n == 2) {
            object = zzgka.zza;
            return zzgkd.zzaz((zzghi)zzo, (String)"\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001\u1504\u0000\u0002\u1008\u0001\u0003\u1409\u0002\u0004\u1409\u0003\u0005\u1004\u0004\u0006\u0016\u0007\u1008\u0005\b\u100c\u0006\t\u001a", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", object, "zzm"});
        }
        if (n == 3) return new zzgkd();
        if (n == 4) return new zzgkc(null);
        if (n == 5) return zzo;
        if (object == null) {
            by = 0;
        }
        this.zzn = by;
        return null;
    }

    public final int zzc() {
        return this.zzm.size();
    }
}
