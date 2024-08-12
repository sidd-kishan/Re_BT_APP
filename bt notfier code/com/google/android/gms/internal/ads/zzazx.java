/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazv
 *  com.google.android.gms.internal.ads.zzazw
 *  com.google.android.gms.internal.ads.zzggc
 *  com.google.android.gms.internal.ads.zzggd
 *  com.google.android.gms.internal.ads.zzgge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazv;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzggc;
import com.google.android.gms.internal.ads.zzggd;
import com.google.android.gms.internal.ads.zzgge;

public final class zzazx
extends Enum<zzazx>
implements zzggc {
    public static final /* enum */ zzazx zza;
    public static final /* enum */ zzazx zzb;
    public static final /* enum */ zzazx zzc;
    public static final /* enum */ zzazx zzd;
    public static final /* enum */ zzazx zze;
    public static final /* enum */ zzazx zzf;
    public static final /* enum */ zzazx zzg;
    public static final /* enum */ zzazx zzh;
    public static final /* enum */ zzazx zzi;
    public static final /* enum */ zzazx zzj;
    public static final /* enum */ zzazx zzk;
    private static final zzggd<zzazx> zzl;
    private static final zzazx[] zzn;
    private final int zzm;

    static {
        zzazx zzazx2;
        zza = new zzazx(0);
        zzb = new zzazx(1);
        zzc = new zzazx(2);
        zzd = new zzazx(3);
        zze = new zzazx(4);
        zzf = new zzazx(5);
        zzg = new zzazx(6);
        zzh = new zzazx(7);
        zzi = new zzazx(8);
        zzj = new zzazx(9);
        zzk = zzazx2 = new zzazx(10);
        zzn = new zzazx[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzazx2};
        zzl = new zzazv();
    }

    private zzazx(int n2) {
        this.zzm = n2;
    }

    public static zzazx[] values() {
        return (zzazx[])zzn.clone();
    }

    public static zzazx zzb(int n) {
        switch (n) {
            default: {
                return null;
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
        return zzazw.zza;
    }

    public final String toString() {
        return Integer.toString(this.zzm);
    }

    public final int zza() {
        return this.zzm;
    }
}
