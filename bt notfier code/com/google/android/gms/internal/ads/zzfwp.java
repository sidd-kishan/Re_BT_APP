/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfzj
 *  com.google.android.gms.internal.ads.zzfzs
 *  com.google.android.gms.internal.ads.zzgad
 *  com.google.android.gms.internal.ads.zzgaf
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgcz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfzj;
import com.google.android.gms.internal.ads.zzfzs;
import com.google.android.gms.internal.ads.zzgad;
import com.google.android.gms.internal.ads.zzgaf;
import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgcz;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class zzfwp {
    public static void zza(zzfzs zzfzs2) throws GeneralSecurityException {
        zzgcz.zzd((int)zzfwp.zzc(zzfzs2.zza().zzg()));
        zzfwp.zzb(zzfzs2.zza().zzh());
        if (zzfzs2.zzi() == 2) throw new GeneralSecurityException("unknown EC point format");
        zzfum.zzg((zzgau)zzfzs2.zzc().zza());
    }

    public static String zzb(int n) throws NoSuchAlgorithmException {
        int n2 = n - 2;
        if (n2 == 1) return "HmacSha1";
        if (n2 == 2) return "HmacSha384";
        if (n2 == 3) return "HmacSha256";
        if (n2 == 4) return "HmacSha512";
        if (n2 != 5) throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(Integer.toString(zzgaf.zza((int)n))));
        return "HmacSha224";
    }

    public static int zzc(int n) throws GeneralSecurityException {
        int n2 = n - 2;
        if (n2 == 2) return 1;
        if (n2 == 3) return 2;
        if (n2 != 4) throw new GeneralSecurityException("unknown curve type: ".concat(Integer.toString(zzgad.zza((int)n))));
        return 3;
    }

    public static int zzd(int n) throws GeneralSecurityException {
        int n2 = n - 2;
        int n3 = 1;
        if (n2 == 1) return n3;
        n3 = 2;
        if (n2 == 2) return n3;
        if (n2 != 3) throw new GeneralSecurityException("unknown point format: ".concat(Integer.toString(zzfzj.zza((int)n))));
        return 3;
    }
}
