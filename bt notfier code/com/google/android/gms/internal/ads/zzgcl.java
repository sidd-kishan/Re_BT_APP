/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzgck
 *  com.google.android.gms.internal.ads.zzgds
 *  com.google.android.gms.internal.ads.zzgdt
 *  com.google.android.gms.internal.ads.zzgdu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzgck;
import com.google.android.gms.internal.ads.zzgds;
import com.google.android.gms.internal.ads.zzgdt;
import com.google.android.gms.internal.ads.zzgdu;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzgcl
implements zzftg {
    private static final ThreadLocal<Cipher> zza = new zzgck();
    private final SecretKey zzb;

    public zzgcl(byte[] byArray) throws GeneralSecurityException {
        if (!zzfvw.zza((int)2)) throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        zzgdu.zza((int)byArray.length);
        this.zzb = new SecretKeySpec(byArray, "AES");
    }

    public final byte[] zza(byte[] byArray, byte[] object) throws GeneralSecurityException {
        int n = byArray.length;
        if (n > 2147483619) throw new GeneralSecurityException("plaintext too long");
        byte[] byArray2 = new byte[n + 28];
        object = zzgds.zza((int)12);
        System.arraycopy(object, 0, byArray2, 0, 12);
        int n2 = ((byte[])object).length;
        object = zzgdt.zza() && zzgdt.zzb() <= 19 ? (Object)new IvParameterSpec((byte[])object, 0, n2) : (Object)new GCMParameterSpec(128, (byte[])object, 0, n2);
        zza.get().init(1, (Key)this.zzb, (AlgorithmParameterSpec)object);
        n2 = zza.get().doFinal(byArray, 0, n, byArray2, 12);
        if (n2 != n + 16) throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, n2 - n));
        return byArray2;
    }
}
