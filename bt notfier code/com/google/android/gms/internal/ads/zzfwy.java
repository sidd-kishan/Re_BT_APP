/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfue
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfvx
 *  com.google.android.gms.internal.ads.zzfwu
 *  com.google.android.gms.internal.ads.zzfwx
 *  com.google.android.gms.internal.ads.zzfxb
 *  com.google.android.gms.internal.ads.zzgby
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfue;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfvx;
import com.google.android.gms.internal.ads.zzfwu;
import com.google.android.gms.internal.ads.zzfwx;
import com.google.android.gms.internal.ads.zzfxb;
import com.google.android.gms.internal.ads.zzgby;
import java.security.GeneralSecurityException;

public final class zzfwy {
    @Deprecated
    public static final zzgby zza;
    @Deprecated
    public static final zzgby zzb;
    @Deprecated
    public static final zzgby zzc;

    static {
        zzgby zzgby2;
        new zzfwx();
        zza = zzgby2 = zzgby.zzc();
        zzb = zzgby2;
        zzc = zzgby2;
        try {
            zzfwy.zza();
            return;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new ExceptionInInitializerError(generalSecurityException);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzfum.zze((zzfue)new zzfxb());
        zzfum.zzc((zzftu)new zzfwx(), (boolean)true);
        if (zzfvx.zza()) {
            return;
        }
        zzfum.zzc((zzftu)new zzfwu(), (boolean)true);
    }
}
