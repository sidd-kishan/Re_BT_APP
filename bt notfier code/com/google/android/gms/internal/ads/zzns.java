/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzn;
import java.util.Arrays;

public final class zzns {
    public static final int zza = 0;
    private static final int[] zzb = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = new int[]{64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static zzafv zza(byte[] object, String string, String string2, zzn zzn2) {
        int n;
        int n2 = 0;
        int n3 = object[0];
        int n4 = -1;
        if (n3 == 127) {
            object = new zzame(object, ((byte[])object).length);
        } else {
            byte[] byArray = Arrays.copyOf(object, ((byte[])object).length);
            n3 = byArray[0];
            if (n3 == -2 || n3 == -1) {
                for (n3 = 0; n3 < byArray.length - 1; n3 += 2) {
                    byte by = byArray[n3];
                    n = n3 + 1;
                    byArray[n3] = byArray[n];
                    byArray[n] = by;
                }
            }
            n3 = byArray.length;
            object = new zzame(byArray, n3);
            if (byArray[0] == 31) {
                zzn2 = new zzame(byArray, n3);
                while (zzn2.zzb() >= 16) {
                    zzn2.zzf(2);
                    object.zzl(zzn2.zzh(14), 14);
                }
            }
            object.zza(byArray, byArray.length);
        }
        object.zzf(60);
        n3 = object.zzh(6);
        n = zzb[n3];
        n3 = object.zzh(4);
        int n5 = zzc[n3];
        n3 = object.zzh(5);
        n3 = n3 >= 29 ? n4 : zzd[n3] * 1000 / 2;
        object.zzf(10);
        if (object.zzh(2) > 0) {
            n2 = 1;
        }
        object = new zzaft();
        object.zzD(string);
        object.zzN("audio/vnd.dts");
        object.zzI(n3);
        object.zzaa(n + n2);
        object.zzab(n5);
        object.zzQ(null);
        object.zzG(string2);
        return object.zzah();
    }
}
