/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftv
 *  com.google.android.gms.internal.ads.zzgbb
 *  com.google.android.gms.internal.ads.zzgbc
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzggm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftv;
import com.google.android.gms.internal.ads.zzgbb;
import com.google.android.gms.internal.ads.zzgbc;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzggm;
import java.security.GeneralSecurityException;

@Deprecated
public final class zzftz {
    @Deprecated
    public static final zzftv zza(byte[] object) throws GeneralSecurityException {
        try {
            zzgbb zzgbb2;
            zzgbc zzgbc2 = zzgbc.zze((byte[])object, (zzgfm)zzgfm.zza());
            object = zzgbc2.zzc().iterator();
            do {
                if (object.hasNext()) continue;
                object = zzftv.zza((zzgbc)zzgbc2);
                return object;
            } while ((zzgbb2 = (zzgbb)object.next()).zzc().zzi() != 2 && zzgbb2.zzc().zzi() != 3 && zzgbb2.zzc().zzi() != 4);
            object = new GeneralSecurityException("keyset contains secret key material");
            throw object;
        }
        catch (zzggm zzggm2) {
            GeneralSecurityException generalSecurityException = new GeneralSecurityException("invalid keyset");
            throw generalSecurityException;
        }
    }
}
