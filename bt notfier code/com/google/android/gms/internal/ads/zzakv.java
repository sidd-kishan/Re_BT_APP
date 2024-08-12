/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamg
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamg;
import com.google.android.gms.internal.ads.zzamq;

public final class zzakv {
    public static final int zza = 0;
    private static final byte[] zzb = new byte[]{0, 0, 0, 1};
    private static final String[] zzc = new String[]{"", "A", "B", "C"};

    public static String zza(int n, int n2, int n3) {
        return String.format("avc1.%02X%02X%02X", n, n2, n3);
    }

    public static String zzb(zzamg object) {
        int n;
        int n2;
        object.zzc(24);
        int n3 = object.zze(2);
        boolean bl = object.zzd();
        int n4 = object.zze(5);
        int n5 = 0;
        for (n2 = 0; n2 < 32; ++n2) {
            n = n5;
            if (object.zzd()) {
                n = n5 | 1 << n2;
            }
            n5 = n;
        }
        n2 = 6;
        int[] nArray = new int[6];
        for (n = 0; n < 6; ++n) {
            nArray[n] = object.zze(8);
        }
        n = object.zze(8);
        object = zzc[n3];
        char c = true != bl ? (char)'L' : 'H';
        object = new StringBuilder(zzamq.zzv((String)"hvc1.%s%d.%X.%c%d", (Object[])new Object[]{object, n4, n5, Character.valueOf(c), n}));
        n5 = n2;
        while (n5 > 0 && nArray[n = n5 - 1] == 0) {
            n5 = n;
        }
        n = 0;
        while (n < n5) {
            ((StringBuilder)object).append(String.format(".%02X", nArray[n]));
            ++n;
        }
        return ((StringBuilder)object).toString();
    }

    public static byte[] zzc(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2 + 4];
        System.arraycopy(zzb, 0, byArray2, 0, 4);
        System.arraycopy(byArray, n, byArray2, 4, n2);
        return byArray2;
    }
}
