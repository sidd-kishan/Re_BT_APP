/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgf
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzhy
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zziz
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzjw
 *  com.google.android.gms.internal.measurement.zzkk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zziz;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzjw;
import com.google.android.gms.internal.measurement.zzkk;
import java.io.IOException;

final class zzgg {
    static int zza(byte[] byArray, int n, zzgf zzgf2) {
        int n2 = n + 1;
        if ((n = byArray[n]) < 0) return zzgg.zzb(n, byArray, n2, zzgf2);
        zzgf2.zza = n;
        return n2;
    }

    static int zzb(int n, byte[] byArray, int n2, zzgf zzgf2) {
        n &= 0x7F;
        int n3 = n2 + 1;
        if ((n2 = byArray[n2]) >= 0) {
            zzgf2.zza = n | n2 << 7;
            return n3;
        }
        n2 = n | (n2 & 0x7F) << 7;
        n = n3 + 1;
        if ((n3 = byArray[n3]) >= 0) {
            zzgf2.zza = n2 | n3 << 14;
            return n;
        }
        n3 = n2 | (n3 & 0x7F) << 14;
        n2 = n + 1;
        if ((n = byArray[n]) >= 0) {
            zzgf2.zza = n3 | n << 21;
            return n2;
        }
        n3 |= (n & 0x7F) << 21;
        n = n2 + 1;
        byte by = byArray[n2];
        if (by >= 0) {
            zzgf2.zza = n3 | by << 28;
            return n;
        }
        while (true) {
            n2 = n + 1;
            if (byArray[n] >= 0) {
                zzgf2.zza = n3 | (by & 0x7F) << 28;
                return n2;
            }
            n = n2;
        }
    }

    static int zzc(byte[] byArray, int n, zzgf zzgf2) {
        int n2 = n + 1;
        long l = byArray[n];
        if (l >= 0L) {
            zzgf2.zzb = l;
            return n2;
        }
        n = n2 + 1;
        byte by = byArray[n2];
        l = l & 0x7FL | (long)(by & 0x7F) << 7;
        n2 = 7;
        while (true) {
            if (by >= 0) {
                zzgf2.zzb = l;
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

    static int zzf(byte[] byArray, int n, zzgf zzgf2) throws zzib {
        n = zzgg.zza(byArray, n, zzgf2);
        int n2 = zzgf2.zza;
        if (n2 < 0) throw zzib.zzb();
        if (n2 == 0) {
            zzgf2.zzc = "";
            return n;
        }
        zzgf2.zzc = new String(byArray, n, n2, zzhz.zza);
        return n + n2;
    }

    static int zzg(byte[] byArray, int n, zzgf zzgf2) throws zzib {
        n = zzgg.zza(byArray, n, zzgf2);
        int n2 = zzgf2.zza;
        if (n2 < 0) throw zzib.zzb();
        if (n2 == 0) {
            zzgf2.zzc = "";
            return n;
        }
        zzgf2.zzc = zzkk.zze((byte[])byArray, (int)n, (int)n2);
        return n + n2;
    }

    static int zzh(byte[] byArray, int n, zzgf zzgf2) throws zzib {
        n = zzgg.zza(byArray, n, zzgf2);
        int n2 = zzgf2.zza;
        if (n2 < 0) throw zzib.zzb();
        if (n2 > byArray.length - n) throw zzib.zza();
        if (n2 == 0) {
            zzgf2.zzc = zzgr.zzb;
            return n;
        }
        zzgf2.zzc = zzgr.zzj((byte[])byArray, (int)n, (int)n2);
        return n + n2;
    }

    static int zzi(zzjh zzjh2, byte[] byArray, int n, int n2, zzgf zzgf2) throws IOException {
        int n3 = n + 1;
        int n4 = byArray[n];
        int n5 = n3;
        n = n4;
        if (n4 < 0) {
            n5 = zzgg.zzb(n4, byArray, n3, zzgf2);
            n = zzgf2.zza;
        }
        if (n < 0) throw zzib.zza();
        if (n > n2 - n5) throw zzib.zza();
        Object object = zzjh2.zza();
        zzjh2.zzh(object, byArray, n5, n += n5, zzgf2);
        zzjh2.zzi(object);
        zzgf2.zzc = object;
        return n;
    }

    static int zzj(zzjh zzjh2, byte[] byArray, int n, int n2, int n3, zzgf zzgf2) throws IOException {
        zzjh2 = (zziz)zzjh2;
        Object object = zzjh2.zza();
        n = zzjh2.zzg(object, byArray, n, n2, n3, zzgf2);
        zzjh2.zzi(object);
        zzgf2.zzc = object;
        return n;
    }

    static int zzk(int n, byte[] byArray, int n2, int n3, zzhy<?> zzhs2, zzgf zzgf2) {
        zzhs2 = zzhs2;
        n2 = zzgg.zza(byArray, n2, zzgf2);
        zzhs2.zzh(zzgf2.zza);
        while (n2 < n3) {
            int n4 = zzgg.zza(byArray, n2, zzgf2);
            if (n != zzgf2.zza) {
                return n2;
            }
            n2 = zzgg.zza(byArray, n4, zzgf2);
            zzhs2.zzh(zzgf2.zza);
        }
        return n2;
    }

    static int zzl(byte[] object, int n, zzhy<?> zzhs2, zzgf zzgf2) throws IOException {
        zzhs2 = zzhs2;
        n = zzgg.zza(object, n, zzgf2);
        int n2 = zzgf2.zza + n;
        while (n < n2) {
            n = zzgg.zza(object, n, zzgf2);
            zzhs2.zzh(zzgf2.zza);
        }
        if (n == n2) {
            return n;
        }
        object = zzib.zza();
        throw object;
    }

    static int zzm(zzjh<?> zzjh2, int n, byte[] byArray, int n2, int n3, zzhy<?> zzhy2, zzgf zzgf2) throws IOException {
        n2 = zzgg.zzi(zzjh2, byArray, n2, n3, zzgf2);
        zzhy2.add(zzgf2.zzc);
        while (n2 < n3) {
            int n4 = zzgg.zza(byArray, n2, zzgf2);
            if (n != zzgf2.zza) {
                return n2;
            }
            n2 = zzgg.zzi(zzjh2, byArray, n4, n3, zzgf2);
            zzhy2.add(zzgf2.zzc);
        }
        return n2;
    }

    static int zzn(int n, byte[] object, int n2, int n3, zzjw zzjw2, zzgf zzgf2) throws zzib {
        int n4;
        if (n >>> 3 == 0) {
            object = zzib.zzc();
            throw object;
        }
        int n5 = n & 7;
        if (n5 == 0) {
            n2 = zzgg.zzc(object, n2, zzgf2);
            zzjw2.zzh(n, (Object)zzgf2.zzb);
            return n2;
        }
        if (n5 == 1) {
            zzjw2.zzh(n, (Object)zzgg.zze(object, n2));
            return n2 + 8;
        }
        if (n5 != 2) {
            if (n5 != 3) {
                if (n5 != 5) throw zzib.zzc();
                zzjw2.zzh(n, (Object)zzgg.zzd(object, n2));
                return n2 + 4;
            }
        } else {
            n3 = zzgg.zza(object, n2, zzgf2);
            n2 = zzgf2.zza;
            if (n2 < 0) throw zzib.zzb();
            if (n2 > ((byte[])object).length - n3) throw zzib.zza();
            if (n2 == 0) {
                zzjw2.zzh(n, (Object)zzgr.zzb);
            } else {
                zzjw2.zzh(n, (Object)zzgr.zzj((byte[])object, (int)n3, (int)n2));
            }
            return n3 + n2;
        }
        int n6 = n & 0xFFFFFFF8 | 4;
        zzjw zzjw3 = zzjw.zzb();
        n5 = 0;
        while (true) {
            n4 = n2;
            if (n2 >= n3) break;
            n2 = zzgg.zza(object, n2, zzgf2);
            n5 = zzgf2.zza;
            if (n5 == n6) {
                n4 = n2;
                break;
            }
            n2 = zzgg.zzn(n5, object, n2, n3, zzjw3, zzgf2);
        }
        if (n4 > n3) throw zzib.zze();
        if (n5 != n6) throw zzib.zze();
        zzjw2.zzh(n, (Object)zzjw3);
        return n4;
    }
}
