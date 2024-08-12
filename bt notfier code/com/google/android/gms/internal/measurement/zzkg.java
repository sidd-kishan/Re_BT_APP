/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzib
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;

final class zzkg {
    static /* synthetic */ boolean zza(byte by) {
        if (by < 0) return false;
        return true;
    }

    static /* synthetic */ void zzb(byte by, byte by2, char[] cArray, int n) throws zzib {
        if (by < -62) throw zzib.zzf();
        if (zzkg.zze(by2)) throw zzib.zzf();
        cArray[n] = (char)((by & 0x1F) << 6 | by2 & 0x3F);
    }

    static /* synthetic */ void zzc(byte n, byte by, byte by2, char[] cArray, int n2) throws zzib {
        if (zzkg.zze(by)) throw zzib.zzf();
        int n3 = n;
        if (n == -32) {
            if (by < -96) throw zzib.zzf();
            n3 = -32;
        }
        n = n3;
        if (n3 == -19) {
            if (by >= -96) throw zzib.zzf();
            n = -19;
        }
        if (zzkg.zze(by2)) throw zzib.zzf();
        cArray[n2] = (char)((n & 0xF) << 12 | (by & 0x3F) << 6 | by2 & 0x3F);
    }

    static /* synthetic */ void zzd(byte by, byte by2, byte by3, byte by4, char[] cArray, int n) throws zzib {
        if (zzkg.zze(by2)) throw zzib.zzf();
        if ((by << 28) + (by2 + 112) >> 30 != 0) throw zzib.zzf();
        if (zzkg.zze(by3)) throw zzib.zzf();
        if (zzkg.zze(by4)) throw zzib.zzf();
        by = (byte)((by & 7) << 18 | (by2 & 0x3F) << 12 | (by3 & 0x3F) << 6 | by4 & 0x3F);
        cArray[n] = (char)((by >>> 10) + 55232);
        cArray[n + 1] = (char)((by & 0x3FF) + 56320);
    }

    private static boolean zze(byte by) {
        if (by <= -65) return false;
        return true;
    }
}
