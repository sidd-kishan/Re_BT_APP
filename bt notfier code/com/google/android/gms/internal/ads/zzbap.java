/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazl
 *  com.google.android.gms.internal.ads.zzazu
 *  com.google.android.gms.internal.ads.zzbah
 *  com.google.android.gms.internal.ads.zzbak
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbao
 *  com.google.android.gms.internal.ads.zzbbd
 *  com.google.android.gms.internal.ads.zzbbn
 *  com.google.android.gms.internal.ads.zzbbz
 *  com.google.android.gms.internal.ads.zzbcu
 *  com.google.android.gms.internal.ads.zzgeg
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggi
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazl;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbah;
import com.google.android.gms.internal.ads.zzbak;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzbcu;
import com.google.android.gms.internal.ads.zzgeg;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggi;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import java.util.List;

public final class zzbap
extends zzgga<zzbap, zzbao>
implements zzghj {
    private static final zzbap zzr;
    private int zzb;
    private int zze;
    private String zzf = "";
    private int zzg;
    private int zzh = 1000;
    private zzbbz zzi;
    private zzggi zzj = zzbap.zzaD();
    private zzbah zzk;
    private zzbak zzl;
    private zzbbd zzm;
    private zzazl zzn;
    private zzbbn zzo;
    private zzbcu zzp;
    private zzazu zzq;

    static {
        zzbap zzbap2;
        zzr = zzbap2 = new zzbap();
        zzgga.zzay(zzbap.class, (zzgga)zzbap2);
    }

    private zzbap() {
    }

    public static zzbao zze() {
        return (zzbao)zzr.zzas();
    }

    static /* synthetic */ zzbap zzf() {
        return zzr;
    }

    static /* synthetic */ void zzg(zzbap zzbap2, String string) {
        string.getClass();
        zzbap2.zzb |= 2;
        zzbap2.zzf = string;
    }

    static /* synthetic */ void zzh(zzbap zzbap2, Iterable iterable) {
        zzggi zzggi2 = zzbap2.zzj;
        if (!zzggi2.zza()) {
            int n = zzggi2.size();
            n = n == 0 ? 10 : (n += n);
            zzbap2.zzj = zzggi2.zzc(n);
        }
        zzgeg.zzar((Iterable)iterable, (List)zzbap2.zzj);
    }

    static /* synthetic */ void zzi(zzbap zzbap2) {
        zzbap2.zzj = zzbap.zzaD();
    }

    static /* synthetic */ void zzj(zzbap zzbap2, zzbah zzbah2) {
        zzbah2.getClass();
        zzbap2.zzk = zzbah2;
        zzbap2.zzb |= 0x20;
    }

    static /* synthetic */ void zzk(zzbap zzbap2, zzazl zzazl2) {
        zzazl2.getClass();
        zzbap2.zzn = zzazl2;
        zzbap2.zzb |= 0x100;
    }

    static /* synthetic */ void zzl(zzbap zzbap2, zzbbn zzbbn2) {
        zzbbn2.getClass();
        zzbap2.zzo = zzbbn2;
        zzbap2.zzb |= 0x200;
    }

    static /* synthetic */ void zzm(zzbap zzbap2, zzbcu zzbcu2) {
        zzbcu2.getClass();
        zzbap2.zzp = zzbcu2;
        zzbap2.zzb |= 0x400;
    }

    static /* synthetic */ void zzn(zzbap zzbap2, zzazu zzazu2) {
        zzazu2.getClass();
        zzbap2.zzq = zzazu2;
        zzbap2.zzb |= 0x800;
    }

    public final String zza() {
        return this.zzf;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbap();
            if (n == 4) return new zzbao(null);
            if (n == 5) return zzr;
            return null;
        }
        object = zzbam.zza;
        return zzbap.zzaz((zzghi)zzr, (String)"\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\t\u1004\u0000\n\u1008\u0001\u000b\u100b\u0002\f\u100c\u0003\r\u1009\u0004\u000e\u0015\u000f\u1009\u0005\u0010\u1009\u0006\u0011\u1009\u0007\u0012\u1009\b\u0013\u1009\t\u0014\u1009\n\u0015\u1009\u000b", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", object, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
    }

    public final zzbah zzc() {
        zzbah zzbah2;
        zzbah zzbah3 = zzbah2 = this.zzk;
        if (zzbah2 != null) return zzbah3;
        zzbah3 = zzbah.zza();
        return zzbah3;
    }

    public final zzazl zzd() {
        zzazl zzazl2;
        zzazl zzazl3 = zzazl2 = this.zzn;
        if (zzazl2 != null) return zzazl3;
        zzazl3 = zzazl.zzc();
        return zzazl3;
    }
}
