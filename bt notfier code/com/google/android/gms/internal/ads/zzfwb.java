/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfue
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfvx
 *  com.google.android.gms.internal.ads.zzfwa
 *  com.google.android.gms.internal.ads.zzfwd
 *  com.google.android.gms.internal.ads.zzgby
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfue;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfvx;
import com.google.android.gms.internal.ads.zzfwa;
import com.google.android.gms.internal.ads.zzfwd;
import com.google.android.gms.internal.ads.zzgby;
import java.security.GeneralSecurityException;

public final class zzfwb {
    public static final String zza;
    @Deprecated
    public static final zzgby zzb;
    @Deprecated
    public static final zzgby zzc;

    static {
        new zzfwa();
        zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
        zzb = zzgby.zzc();
        zzc = zzgby.zzc();
        try {
            zzfwd zzfwd2 = new zzfwd();
            zzfum.zze((zzfue)zzfwd2);
            if (zzfvx.zza()) {
                return;
            }
            zzfwd2 = new zzfwa();
            zzfum.zzc((zzftu)zzfwd2, (boolean)true);
            return;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new ExceptionInInitializerError(generalSecurityException);
        }
    }
}
