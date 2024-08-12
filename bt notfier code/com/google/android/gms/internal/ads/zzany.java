/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzapk
 *  com.google.android.gms.internal.ads.zzaux
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzaux;
import java.nio.ByteBuffer;

public final class zzany {
    public static final int zza = 0;
    private static final int[] zzb = new int[]{1, 2, 3, 6};
    private static final int[] zzc = new int[]{48000, 44100, 32000};
    private static final int[] zzd = new int[]{2, 1, 2, 3, 3, 4, 4, 5};

    public static zzanm zza(zzaux zzaux2, String string, String string2, zzapk zzapk2) {
        int n;
        int n2 = zzaux2.zzl();
        int n3 = zzc[(n2 & 0xC0) >> 6];
        int n4 = zzaux2.zzl();
        n2 = n = zzd[(n4 & 0x38) >> 3];
        if ((n4 & 4) == 0) return zzanm.zzb((String)string, (String)"audio/ac3", null, (int)-1, (int)-1, (int)n2, (int)n3, null, (zzapk)zzapk2, (int)0, (String)string2);
        n2 = n + 1;
        return zzanm.zzb((String)string, (String)"audio/ac3", null, (int)-1, (int)-1, (int)n2, (int)n3, null, (zzapk)zzapk2, (int)0, (String)string2);
    }

    public static zzanm zzb(zzaux zzaux2, String string, String string2, zzapk zzapk2) {
        int n;
        zzaux2.zzj(2);
        int n2 = zzaux2.zzl();
        int n3 = zzc[(n2 & 0xC0) >> 6];
        int n4 = zzaux2.zzl();
        n2 = n = zzd[(n4 & 0xE) >> 1];
        if ((n4 & 1) == 0) return zzanm.zzb((String)string, (String)"audio/eac3", null, (int)-1, (int)-1, (int)n2, (int)n3, null, (zzapk)zzapk2, (int)0, (String)string2);
        n2 = n + 1;
        return zzanm.zzb((String)string, (String)"audio/eac3", null, (int)-1, (int)-1, (int)n2, (int)n3, null, (zzapk)zzapk2, (int)0, (String)string2);
    }

    public static int zzc(ByteBuffer byteBuffer) {
        byte by = byteBuffer.get(byteBuffer.position() + 4);
        int n = 6;
        if ((by & 0xC0) >> 6 == 3) return n * 256;
        n = zzb[(byteBuffer.get(byteBuffer.position() + 4) & 0x30) >> 4];
        return n * 256;
    }
}
