/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzny
 *  com.google.android.gms.internal.ads.zzob
 *  com.google.android.gms.internal.ads.zzoh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzny;
import com.google.android.gms.internal.ads.zzob;
import com.google.android.gms.internal.ads.zzoh;
import java.io.IOException;

public final class zzoc {
    public static boolean zza(zzamf zzamf2, zzoh zzoh2, int n, zzob zzob2) {
        int n2 = zzamf2.zzg();
        long l = zzamf2.zzt();
        long l2 = l >>> 16;
        if (l2 != (long)n) {
            return false;
        }
        boolean bl = (l2 & 1L) == 1L;
        int n3 = (int)(l >> 12 & 0xFL);
        int n4 = (int)(l >> 8 & 0xFL);
        n = (int)(0xFL & l >> 4);
        int n5 = (int)(l >> 1 & 7L);
        if (n <= 7) {
            if (n != zzoh2.zzg - 1) return false;
        } else {
            if (n > 10) return false;
            if (zzoh2.zzg != 2) return false;
        }
        if (n5 != 0) {
            if (n5 != zzoh2.zzi) return false;
        }
        if ((l & 1L) == 1L) return false;
        if (!zzoc.zzd(zzamf2, zzoh2, bl, zzob2)) return false;
        n = zzoc.zzc(zzamf2, n3);
        if (n == -1) return false;
        if (n > zzoh2.zzb) return false;
        n5 = zzoh2.zze;
        if (n4 != 0) {
            if (n4 <= 11) {
                if (n4 != zzoh2.zzf) {
                    return false;
                }
            } else if (n4 == 12) {
                if (zzamf2.zzn() * 1000 != n5) return false;
            } else {
                if (n4 > 14) return false;
                n = n3 = zzamf2.zzo();
                if (n4 == 14) {
                    n = n3 * 10;
                }
                if (n != n5) return false;
            }
        }
        n = zzamf2.zzn();
        n3 = zzamf2.zzg();
        if (n != zzamq.zzW((byte[])zzamf2.zzi(), (int)n2, (int)(n3 - 1), (int)0)) return false;
        return true;
    }

    public static long zzb(zznv zznv2, zzoh zzoh2) throws IOException {
        zznv2.zzl();
        zznp zznp2 = (zznp)zznv2;
        boolean bl = false;
        zznp2.zzj(1, false);
        byte[] byArray = new byte[1];
        zznp2.zzh(byArray, 0, 1, false);
        int n = byArray[0] & 1;
        zznp2.zzj(2, false);
        int n2 = 1 != n ? 6 : 7;
        zznp2 = new zzamf(n2);
        zznp2.zzf(zzny.zzb((zznv)zznv2, (byte[])zznp2.zzi(), (int)0, (int)n2));
        zznv2.zzl();
        zznv2 = new zzob();
        if (1 == n) {
            bl = true;
        }
        if (!zzoc.zzd((zzamf)zznp2, zzoh2, bl, (zzob)zznv2)) throw zzaha.zzb(null, null);
        return zznv2.zza;
    }

    public static int zzc(zzamf zzamf2, int n) {
        switch (n) {
            default: {
                return -1;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return 256 << n - 8;
            }
            case 7: {
                return zzamf2.zzo() + 1;
            }
            case 6: {
                return zzamf2.zzn() + 1;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return 576 << n - 2;
            }
            case 1: 
        }
        return 192;
    }

    private static boolean zzd(zzamf zzamf2, zzoh zzoh2, boolean bl, zzob zzob2) {
        long l;
        block3: {
            block2: {
                try {
                    l = zzamf2.zzH();
                    if (!bl) break block2;
                    break block3;
                }
                catch (NumberFormatException numberFormatException) {
                    return false;
                }
            }
            l *= (long)zzoh2.zzb;
        }
        zzob2.zza = l;
        return true;
    }
}
