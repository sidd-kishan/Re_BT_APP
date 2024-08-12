/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftw;
import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzftx {
    private static final CopyOnWriteArrayList<zzftw> zza = new CopyOnWriteArrayList();

    public static zzftw zza(String object) throws GeneralSecurityException {
        for (zzftw zzftw2 : zza) {
            if (!zzftw2.zza()) continue;
            return zzftw2;
        }
        object = ((String)(object = String.valueOf(object))).length() != 0 ? "No KMS client does support: ".concat((String)object) : new String("No KMS client does support: ");
        object = new GeneralSecurityException((String)object);
        throw object;
    }
}
