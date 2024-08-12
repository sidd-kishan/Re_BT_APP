/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbaw
 *  com.google.android.gms.internal.ads.zzbay
 *  com.google.android.gms.internal.ads.zzbaz
 *  com.google.android.gms.internal.ads.zzbbb
 *  com.google.android.gms.internal.ads.zzbbc
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbay;
import com.google.android.gms.internal.ads.zzbaz;
import com.google.android.gms.internal.ads.zzbbb;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbd
extends zzgga<zzbbd, zzbaw>
implements zzghj {
    private static final zzbbd zzg;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzbbd zzbbd2;
        zzg = zzbbd2 = new zzbbd();
        zzgga.zzay(zzbbd.class, (zzgga)zzbbd2);
    }

    private zzbbd() {
    }

    public static zzbaw zzd() {
        return (zzbaw)zzg.zzas();
    }

    public static zzbbd zze() {
        return zzg;
    }

    static /* synthetic */ zzbbd zzf() {
        return zzg;
    }

    static /* synthetic */ void zzi(zzbbd zzbbd2, int n) {
        zzbbd2.zze = n - 1;
        zzbbd2.zzb |= 1;
    }

    static /* synthetic */ void zzj(zzbbd zzbbd2, int n) {
        zzbbd2.zzf = n - 1;
        zzbbd2.zzb |= 2;
    }

    public final boolean zza() {
        if ((this.zzb & 1) == 0) return false;
        return true;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbbd();
            if (n == 4) return new zzbaw(null);
            if (n == 5) return zzg;
            return null;
        }
        object = zzbbb.zza;
        object2 = zzbay.zza;
        return zzbbd.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001", (Object[])new Object[]{"zzb", "zze", object, "zzf", object2});
    }

    public final boolean zzc() {
        if ((this.zzb & 2) == 0) return false;
        return true;
    }

    public final int zzg() {
        int n;
        int n2 = n = zzbbc.zza((int)this.zze);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }

    public final int zzh() {
        int n;
        int n2 = n = zzbaz.zza((int)this.zzf);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }
}
