/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzqx
 *  com.google.android.gms.internal.ads.zzrq
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzqx;
import com.google.android.gms.internal.ads.zzrq;
import java.util.UUID;

public final class zzrr {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static UUID zza(byte[] var0) {
        block3: {
            var3_1 = new zzamf(var0 /* !! */ );
            if (var3_1.zze() < 32) ** GOTO lbl-1000
            var3_1.zzh(0);
            if (var3_1.zzv() != var3_1.zzd() + 4 || var3_1.zzv() != 1886614376) ** GOTO lbl-1000
            var2_2 = zzqx.zze((int)var3_1.zzv());
            if (var2_2 <= 1) break block3;
            var0 /* !! */  = (byte[])new StringBuilder(37);
            var0 /* !! */ .append("Unsupported pssh version: ");
            var0 /* !! */ .append(var2_2);
            Log.w((String)"PsshAtomUtil", (String)var0 /* !! */ .toString());
            ** GOTO lbl-1000
        }
        var4_3 = new UUID(var3_1.zzx(), var3_1.zzx());
        if (var2_2 == 1) {
            var3_1.zzk(var3_1.zzB() * 16);
        }
        if ((var1_4 = var3_1.zzB()) != var3_1.zzd()) lbl-1000:
        // 4 sources

        {
            var0 /* !! */  = null;
        } else {
            var0 /* !! */  = new byte[var1_4];
            var3_1.zzm(var0 /* !! */ , 0, var1_4);
            var0 /* !! */  = (byte[])new zzrq(var4_3, var2_2, var0 /* !! */ );
        }
        if (var0 /* !! */  != null) return zzrq.zza((zzrq)var0 /* !! */ );
        return null;
    }
}
