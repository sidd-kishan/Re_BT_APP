/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfue
 *  com.google.android.gms.internal.ads.zzfug
 *  com.google.android.gms.internal.ads.zzfum
 *  com.google.android.gms.internal.ads.zzfuo
 *  com.google.android.gms.internal.ads.zzfvx
 *  com.google.android.gms.internal.ads.zzfwg
 *  com.google.android.gms.internal.ads.zzfwi
 *  com.google.android.gms.internal.ads.zzfwl
 *  com.google.android.gms.internal.ads.zzfwo
 *  com.google.android.gms.internal.ads.zzgby
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfue;
import com.google.android.gms.internal.ads.zzfug;
import com.google.android.gms.internal.ads.zzfum;
import com.google.android.gms.internal.ads.zzfuo;
import com.google.android.gms.internal.ads.zzfvx;
import com.google.android.gms.internal.ads.zzfwg;
import com.google.android.gms.internal.ads.zzfwi;
import com.google.android.gms.internal.ads.zzfwl;
import com.google.android.gms.internal.ads.zzfwo;
import com.google.android.gms.internal.ads.zzgby;
import java.security.GeneralSecurityException;

public final class zzfwj {
    @Deprecated
    public static final zzgby zza;
    @Deprecated
    public static final zzgby zzb;
    @Deprecated
    public static final zzgby zzc;

    static {
        new zzfwi();
        new zzfwg();
        zza = zzgby.zzc();
        zzb = zzgby.zzc();
        zzc = zzgby.zzc();
        try {
            zzfwl zzfwl2 = new zzfwl();
            zzfum.zze((zzfue)zzfwl2);
            zzfwl2 = new zzfwo();
            zzfum.zze((zzfue)zzfwl2);
            zzfuo.zza();
            if (zzfvx.zza()) {
                return;
            }
            zzfwg zzfwg2 = new zzfwg();
            zzfwl2 = new zzfwi();
            zzfum.zzd((zzfug)zzfwg2, (zzftu)zzfwl2, (boolean)true);
            return;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new ExceptionInInitializerError(generalSecurityException);
        }
    }
}
