/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdb;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

final class zzgci
extends ThreadLocal<Cipher> {
    zzgci() {
    }

    protected static final Cipher zza() {
        try {
            Cipher cipher = (Cipher)zzgdb.zza.zzb("AES/CTR/NOPADDING");
            return cipher;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new IllegalStateException(generalSecurityException);
        }
    }
}
