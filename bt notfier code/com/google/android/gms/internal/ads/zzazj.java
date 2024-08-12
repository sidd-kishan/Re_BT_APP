/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazh
 *  com.google.android.gms.internal.ads.zzazi
 *  com.google.android.gms.internal.ads.zzggc
 *  com.google.android.gms.internal.ads.zzggd
 *  com.google.android.gms.internal.ads.zzgge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazi;
import com.google.android.gms.internal.ads.zzggc;
import com.google.android.gms.internal.ads.zzggd;
import com.google.android.gms.internal.ads.zzgge;

public final class zzazj
extends Enum<zzazj>
implements zzggc {
    public static final /* enum */ zzazj zza;
    public static final /* enum */ zzazj zzb;
    public static final /* enum */ zzazj zzc;
    public static final /* enum */ zzazj zzd;
    public static final /* enum */ zzazj zze;
    public static final /* enum */ zzazj zzf;
    public static final /* enum */ zzazj zzg;
    public static final /* enum */ zzazj zzh;
    public static final /* enum */ zzazj zzi;
    public static final /* enum */ zzazj zzj;
    public static final /* enum */ zzazj zzk;
    public static final /* enum */ zzazj zzl;
    private static final zzggd<zzazj> zzm;
    private static final zzazj[] zzo;
    private final int zzn;

    static {
        zzazj zzazj2;
        zza = new zzazj(0);
        zzb = new zzazj(1);
        zzc = new zzazj(2);
        zzd = new zzazj(3);
        zze = new zzazj(4);
        zzf = new zzazj(5);
        zzg = new zzazj(6);
        zzh = new zzazj(7);
        zzi = new zzazj(8);
        zzj = new zzazj(9);
        zzk = new zzazj(10);
        zzl = zzazj2 = new zzazj(11);
        zzo = new zzazj[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzazj2};
        zzm = new zzazh();
    }

    private zzazj(int n2) {
        this.zzn = n2;
    }

    public static zzazj[] values() {
        return (zzazj[])zzo.clone();
    }

    public static zzazj zzb(int n) {
        switch (n) {
            default: {
                return null;
            }
            case 11: {
                return zzl;
            }
            case 10: {
                return zzk;
            }
            case 9: {
                return zzj;
            }
            case 8: {
                return zzi;
            }
            case 7: {
                return zzh;
            }
            case 6: {
                return zzg;
            }
            case 5: {
                return zzf;
            }
            case 4: {
                return zze;
            }
            case 3: {
                return zzd;
            }
            case 2: {
                return zzc;
            }
            case 1: {
                return zzb;
            }
            case 0: 
        }
        return zza;
    }

    public static zzgge zzc() {
        return zzazi.zza;
    }

    public final String toString() {
        return Integer.toString(this.zzn);
    }

    public final int zza() {
        return this.zzn;
    }
}
