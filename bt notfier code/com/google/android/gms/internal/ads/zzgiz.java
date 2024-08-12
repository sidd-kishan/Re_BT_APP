/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggm;

final class zzgiz {
    static /* synthetic */ boolean zza(byte by) {
        if (by < 0) return false;
        return true;
    }

    static /* synthetic */ boolean zzb(byte by) {
        if (by >= -32) return false;
        return true;
    }

    static /* synthetic */ boolean zzc(byte by) {
        if (by >= -16) return false;
        return true;
    }

    static /* synthetic */ void zzd(byte by, byte by2, char[] cArray, int n) throws zzggm {
        if (by < -62) throw zzggm.zzl();
        if (zzgiz.zzg(by2)) throw zzggm.zzl();
        cArray[n] = (char)((by & 0x1F) << 6 | by2 & 0x3F);
    }

    static /* synthetic */ void zze(byte n, byte by, byte by2, char[] cArray, int n2) throws zzggm {
        if (zzgiz.zzg(by)) throw zzggm.zzl();
        int n3 = n;
        if (n == -32) {
            if (by < -96) throw zzggm.zzl();
            n3 = -32;
        }
        n = n3;
        if (n3 == -19) {
            if (by >= -96) throw zzggm.zzl();
            n = -19;
        }
        if (zzgiz.zzg(by2)) throw zzggm.zzl();
        cArray[n2] = (char)((n & 0xF) << 12 | (by & 0x3F) << 6 | by2 & 0x3F);
    }

    static /* synthetic */ void zzf(byte by, byte by2, byte by3, byte by4, char[] cArray, int n) throws zzggm {
        if (zzgiz.zzg(by2)) throw zzggm.zzl();
        if ((by << 28) + (by2 + 112) >> 30 != 0) throw zzggm.zzl();
        if (zzgiz.zzg(by3)) throw zzggm.zzl();
        if (zzgiz.zzg(by4)) throw zzggm.zzl();
        by = (byte)((by & 7) << 18 | (by2 & 0x3F) << 12 | (by3 & 0x3F) << 6 | by4 & 0x3F);
        cArray[n] = (char)((by >>> 10) + 55232);
        cArray[n + 1] = (char)((by & 0x3FF) + 56320);
    }

    private static boolean zzg(byte by) {
        if (by <= -65) return false;
        return true;
    }
}
