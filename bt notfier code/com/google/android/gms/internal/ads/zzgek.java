/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgej
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghl
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgip
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgej;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghl;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgip;
import com.google.android.gms.internal.ads.zzgjd;
import java.io.IOException;

final class zzgek {
    static int zza(byte[] byArray, int n, zzgej zzgej2) {
        int n2 = n + 1;
        if ((n = byArray[n]) < 0) return zzgek.zzb(n, byArray, n2, zzgej2);
        zzgej2.zza = n;
        return n2;
    }

    static int zzb(int n, byte[] byArray, int n2, zzgej zzgej2) {
        n &= 0x7F;
        int n3 = n2 + 1;
        if ((n2 = byArray[n2]) >= 0) {
            zzgej2.zza = n | n2 << 7;
            return n3;
        }
        n2 = n | (n2 & 0x7F) << 7;
        n = n3 + 1;
        if ((n3 = byArray[n3]) >= 0) {
            zzgej2.zza = n2 | n3 << 14;
            return n;
        }
        n3 = n2 | (n3 & 0x7F) << 14;
        n2 = n + 1;
        if ((n = byArray[n]) >= 0) {
            zzgej2.zza = n3 | n << 21;
            return n2;
        }
        n3 |= (n & 0x7F) << 21;
        n = n2 + 1;
        byte by = byArray[n2];
        if (by >= 0) {
            zzgej2.zza = n3 | by << 28;
            return n;
        }
        while (true) {
            n2 = n + 1;
            if (byArray[n] >= 0) {
                zzgej2.zza = n3 | (by & 0x7F) << 28;
                return n2;
            }
            n = n2;
        }
    }

    static int zzc(byte[] byArray, int n, zzgej zzgej2) {
        int n2 = n + 1;
        long l = byArray[n];
        if (l >= 0L) {
            zzgej2.zzb = l;
            return n2;
        }
        n = n2 + 1;
        byte by = byArray[n2];
        l = l & 0x7FL | (long)(by & 0x7F) << 7;
        n2 = 7;
        while (true) {
            if (by >= 0) {
                zzgej2.zzb = l;
                return n;
            }
            by = byArray[n];
            l |= (long)(by & 0x7F) << (n2 += 7);
            ++n;
        }
    }

    static int zzd(byte[] byArray, int n) {
        byte by = byArray[n];
        byte by2 = byArray[n + 1];
        byte by3 = byArray[n + 2];
        return (byArray[n + 3] & 0xFF) << 24 | (by & 0xFF | (by2 & 0xFF) << 8 | (by3 & 0xFF) << 16);
    }

    static long zze(byte[] byArray, int n) {
        long l = byArray[n];
        long l2 = byArray[n + 1];
        long l3 = byArray[n + 2];
        long l4 = byArray[n + 3];
        long l5 = byArray[n + 4];
        long l6 = byArray[n + 5];
        long l7 = byArray[n + 6];
        return ((long)byArray[n + 7] & 0xFFL) << 56 | (l & 0xFFL | (l2 & 0xFFL) << 8 | (l3 & 0xFFL) << 16 | (l4 & 0xFFL) << 24 | (l5 & 0xFFL) << 32 | (l6 & 0xFFL) << 40 | (l7 & 0xFFL) << 48);
    }

    static int zzf(byte[] byArray, int n, zzgej zzgej2) throws zzggm {
        int n2 = zzgek.zza(byArray, n, zzgej2);
        n = zzgej2.zza;
        if (n < 0) throw zzggm.zze();
        if (n == 0) {
            zzgej2.zzc = "";
            return n2;
        }
        zzgej2.zzc = new String(byArray, n2, n, zzggk.zza);
        return n2 + n;
    }

    static int zzg(byte[] byArray, int n, zzgej zzgej2) throws zzggm {
        int n2 = zzgek.zza(byArray, n, zzgej2);
        n = zzgej2.zza;
        if (n < 0) throw zzggm.zze();
        if (n == 0) {
            zzgej2.zzc = "";
            return n2;
        }
        zzgej2.zzc = zzgjd.zzj((byte[])byArray, (int)n2, (int)n);
        return n2 + n;
    }

    static int zzh(byte[] byArray, int n, zzgej zzgej2) throws zzggm {
        n = zzgek.zza(byArray, n, zzgej2);
        int n2 = zzgej2.zza;
        if (n2 < 0) throw zzggm.zze();
        if (n2 > byArray.length - n) throw zzggm.zzd();
        if (n2 == 0) {
            zzgej2.zzc = zzgex.zzb;
            return n;
        }
        zzgej2.zzc = zzgex.zzs((byte[])byArray, (int)n, (int)n2);
        return n + n2;
    }

    static int zzi(zzghz zzghz2, byte[] byArray, int n, int n2, zzgej zzgej2) throws IOException {
        int n3 = n + 1;
        int n4 = byArray[n];
        n = n3;
        int n5 = n4;
        if (n4 < 0) {
            n = zzgek.zzb(n4, byArray, n3, zzgej2);
            n5 = zzgej2.zza;
        }
        if (n5 < 0) throw zzggm.zzd();
        if (n5 > n2 - n) throw zzggm.zzd();
        Object object = zzghz2.zza();
        n2 = n5 + n;
        zzghz2.zzi(object, byArray, n, n2, zzgej2);
        zzghz2.zzj(object);
        zzgej2.zzc = object;
        return n2;
    }

    static int zzj(zzghz object, byte[] byArray, int n, int n2, int n3, zzgej zzgej2) throws IOException {
        zzghl zzghl2 = (zzghl)object;
        object = zzghl2.zza();
        n = zzghl2.zzh(object, byArray, n, n2, n3, zzgej2);
        zzghl2.zzj(object);
        zzgej2.zzc = object;
        return n;
    }

    static int zzk(int n, byte[] byArray, int n2, int n3, zzggj<?> zzggb2, zzgej zzgej2) {
        zzggb2 = zzggb2;
        n2 = zzgek.zza(byArray, n2, zzgej2);
        zzggb2.zzh(zzgej2.zza);
        while (n2 < n3) {
            int n4 = zzgek.zza(byArray, n2, zzgej2);
            if (n != zzgej2.zza) {
                return n2;
            }
            n2 = zzgek.zza(byArray, n4, zzgej2);
            zzggb2.zzh(zzgej2.zza);
        }
        return n2;
    }

    static int zzl(byte[] object, int n, zzggj<?> zzggb2, zzgej zzgej2) throws IOException {
        zzggb2 = zzggb2;
        n = zzgek.zza(object, n, zzgej2);
        int n2 = zzgej2.zza + n;
        while (n < n2) {
            n = zzgek.zza(object, n, zzgej2);
            zzggb2.zzh(zzgej2.zza);
        }
        if (n == n2) {
            return n;
        }
        object = zzggm.zzd();
        throw object;
    }

    static int zzm(zzghz<?> zzghz2, int n, byte[] byArray, int n2, int n3, zzggj<?> zzggj2, zzgej zzgej2) throws IOException {
        n2 = zzgek.zzi(zzghz2, byArray, n2, n3, zzgej2);
        zzggj2.add(zzgej2.zzc);
        while (n2 < n3) {
            int n4 = zzgek.zza(byArray, n2, zzgej2);
            if (n != zzgej2.zza) {
                return n2;
            }
            n2 = zzgek.zzi(zzghz2, byArray, n4, n3, zzgej2);
            zzggj2.add(zzgej2.zzc);
        }
        return n2;
    }

    static int zzn(int n, byte[] object, int n2, int n3, zzgip zzgip2, zzgej zzgej2) throws zzggm {
        int n4;
        if (n >>> 3 == 0) {
            object = zzggm.zzg();
            throw object;
        }
        int n5 = n & 7;
        if (n5 == 0) {
            n2 = zzgek.zzc(object, n2, zzgej2);
            zzgip2.zzh(n, (Object)zzgej2.zzb);
            return n2;
        }
        if (n5 == 1) {
            zzgip2.zzh(n, (Object)zzgek.zze(object, n2));
            return n2 + 8;
        }
        if (n5 != 2) {
            if (n5 != 3) {
                if (n5 != 5) throw zzggm.zzg();
                zzgip2.zzh(n, (Object)zzgek.zzd(object, n2));
                return n2 + 4;
            }
        } else {
            n2 = zzgek.zza(object, n2, zzgej2);
            n3 = zzgej2.zza;
            if (n3 < 0) throw zzggm.zze();
            if (n3 > ((byte[])object).length - n2) throw zzggm.zzd();
            if (n3 == 0) {
                zzgip2.zzh(n, (Object)zzgex.zzb);
            } else {
                zzgip2.zzh(n, (Object)zzgex.zzs((byte[])object, (int)n2, (int)n3));
            }
            return n2 + n3;
        }
        int n6 = n & 0xFFFFFFF8 | 4;
        zzgip zzgip3 = zzgip.zzb();
        n5 = 0;
        while (true) {
            n4 = n2;
            if (n2 >= n3) break;
            n4 = zzgek.zza(object, n2, zzgej2);
            n2 = zzgej2.zza;
            if (n2 == n6) {
                n5 = n2;
                break;
            }
            n4 = zzgek.zzn(n2, object, n4, n3, zzgip3, zzgej2);
            n5 = n2;
            n2 = n4;
        }
        if (n4 > n3) throw zzggm.zzk();
        if (n5 != n6) throw zzggm.zzk();
        zzgip2.zzh(n, (Object)zzgip3);
        return n4;
    }
}
