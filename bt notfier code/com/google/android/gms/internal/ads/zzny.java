/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

public final class zzny {
    @Pure
    public static void zza(boolean bl, String string) throws zzaha {
        if (!bl) throw zzaha.zzb((String)string, null);
    }

    public static int zzb(zznv zznv2, byte[] byArray, int n, int n2) throws IOException {
        int n3 = 0;
        while (n3 < n2) {
            int n4 = zznv2.zzf(byArray, n + n3, n2 - n3);
            if (n4 == -1) {
                return n3;
            }
            n3 += n4;
        }
        return n3;
    }

    public static boolean zzc(zznv zznv2, byte[] byArray, int n, int n2) throws IOException {
        try {
            ((zznp)zznv2).zza(byArray, n, n2, false);
            return true;
        }
        catch (EOFException eOFException) {
            return false;
        }
    }

    public static boolean zzd(zznv zznv2, int n) throws IOException {
        try {
            ((zznp)zznv2).zzd(n, false);
            return true;
        }
        catch (EOFException eOFException) {
            return false;
        }
    }

    public static boolean zze(zznv zznv2, byte[] byArray, int n, int n2, boolean bl) throws IOException {
        try {
            boolean bl2 = zznv2.zzh(byArray, 0, n2, bl);
            return bl2;
        }
        catch (EOFException eOFException) {
            if (!bl) throw eOFException;
            return false;
        }
    }
}
