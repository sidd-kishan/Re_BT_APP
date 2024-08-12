/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzauw
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzauw;

public final class zzauq {
    private static final byte[] zza = new byte[]{0, 0, 0, 1};
    private static final int[] zzb = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zza(byte[] object) {
        int n;
        int n2;
        block5: {
            int n3;
            int n4;
            block4: {
                object = new zzauw(object, ((byte[])object).length);
                n4 = zzauq.zzc((zzauw)object);
                n2 = zzauq.zzd((zzauw)object);
                n3 = object.zza(4);
                if (n4 == 5) break block4;
                n = n3;
                if (n4 != 29) break block5;
            }
            n2 = n4 = zzauq.zzd((zzauw)object);
            n = n3;
            if (zzauq.zzc((zzauw)object) == 22) {
                n = object.zza(4);
                n2 = n4;
            }
        }
        boolean bl = (n = zzc[n]) != -1;
        zzaup.zza((boolean)bl);
        return Pair.create((Object)n2, (Object)n);
    }

    public static byte[] zzb(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2 + 4];
        System.arraycopy(zza, 0, byArray2, 0, 4);
        System.arraycopy(byArray, n, byArray2, 4, n2);
        return byArray2;
    }

    private static int zzc(zzauw zzauw2) {
        int n = zzauw2.zza(5);
        if (n != 31) return n;
        return zzauw2.zza(6) + 32;
    }

    private static int zzd(zzauw zzauw2) {
        int n = zzauw2.zza(4);
        if (n == 15) {
            n = zzauw2.zza(24);
        } else {
            boolean bl = n < 13;
            zzaup.zza((boolean)bl);
            n = zzb[n];
        }
        return n;
    }
}
