/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzgcf
 *  com.google.android.gms.internal.ads.zzgdl
 *  com.google.android.gms.internal.ads.zzgds
 *  com.google.android.gms.internal.ads.zzgdu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzgcf;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.android.gms.internal.ads.zzgds;
import com.google.android.gms.internal.ads.zzgdu;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzgcg
implements zzgdl {
    private static final ThreadLocal<Cipher> zza = new zzgcf();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzgcg(byte[] byArray, int n) throws GeneralSecurityException {
        int n2;
        if (!zzfvw.zza((int)2)) throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        zzgdu.zza((int)byArray.length);
        this.zzb = new SecretKeySpec(byArray, "AES");
        this.zzd = n2 = zza.get().getBlockSize();
        if (n < 12) throw new GeneralSecurityException("invalid IV size");
        if (n > n2) throw new GeneralSecurityException("invalid IV size");
        this.zzc = n;
    }

    public final byte[] zza(byte[] object) throws GeneralSecurityException {
        int n = ((byte[])object).length;
        int n2 = this.zzc;
        int n3 = Integer.MAX_VALUE - n2;
        if (n <= n3) {
            byte[] byArray = new byte[n2 + n];
            byte[] byArray2 = zzgds.zza((int)n2);
            System.arraycopy(byArray2, 0, byArray, 0, this.zzc);
            n2 = this.zzc;
            Cipher cipher = zza.get();
            Object object2 = new byte[this.zzd];
            System.arraycopy(byArray2, 0, object2, 0, this.zzc);
            object2 = new IvParameterSpec((byte[])object2);
            cipher.init(1, (Key)this.zzb, (AlgorithmParameterSpec)object2);
            if (cipher.doFinal((byte[])object, 0, n, byArray, n2) != n) throw new GeneralSecurityException("stored output's length does not match input's length");
            return byArray;
        }
        object = new StringBuilder(43);
        ((StringBuilder)object).append("plaintext length can not exceed ");
        ((StringBuilder)object).append(n3);
        throw new GeneralSecurityException(((StringBuilder)object).toString());
    }
}
