/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfue
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfur
 *  com.google.android.gms.internal.ads.zzfuu
 *  com.google.android.gms.internal.ads.zzfva
 *  com.google.android.gms.internal.ads.zzfvd
 *  com.google.android.gms.internal.ads.zzfvg
 *  com.google.android.gms.internal.ads.zzfvj
 *  com.google.android.gms.internal.ads.zzfvm
 *  com.google.android.gms.internal.ads.zzfvq
 *  com.google.android.gms.internal.ads.zzfvt
 *  com.google.android.gms.internal.ads.zzfvx
 *  com.google.android.gms.internal.ads.zzfwy
 *  com.google.android.gms.internal.ads.zzgby
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfue;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfur;
import com.google.android.gms.internal.ads.zzfuu;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfvd;
import com.google.android.gms.internal.ads.zzfvg;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfvm;
import com.google.android.gms.internal.ads.zzfvq;
import com.google.android.gms.internal.ads.zzfvt;
import com.google.android.gms.internal.ads.zzfvx;
import com.google.android.gms.internal.ads.zzfwy;
import com.google.android.gms.internal.ads.zzgby;
import java.security.GeneralSecurityException;

public final class zzfuo {
    public static final String zza;
    public static final String zzb;
    @Deprecated
    public static final zzgby zzc;
    @Deprecated
    public static final zzgby zzd;
    @Deprecated
    public static final zzgby zze;

    static {
        zzgby zzgby2;
        new zzfuu();
        zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
        new zzfvd();
        zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
        new zzfvg();
        new zzfva();
        new zzfvm();
        new zzfvq();
        new zzfvj();
        new zzfvt();
        zzc = zzgby2 = zzgby.zzc();
        zzd = zzgby2;
        zze = zzgby2;
        try {
            zzfuo.zza();
            return;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new ExceptionInInitializerError(generalSecurityException);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzfum.zze((zzfue)new zzfur());
        zzfwy.zza();
        zzfum.zzc((zzftu)new zzfuu(), (boolean)true);
        zzfum.zzc((zzftu)new zzfvd(), (boolean)true);
        if (zzfvx.zza()) {
            return;
        }
        zzfum.zzc((zzftu)new zzfva(), (boolean)true);
        zzfvg.zzk((boolean)true);
        zzfum.zzc((zzftu)new zzfvj(), (boolean)true);
        zzfum.zzc((zzftu)new zzfvm(), (boolean)true);
        zzfum.zzc((zzftu)new zzfvq(), (boolean)true);
        zzfum.zzc((zzftu)new zzfvt(), (boolean)true);
    }
}
