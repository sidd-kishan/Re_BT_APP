/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftj
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzgcn
 *  com.google.android.gms.internal.ads.zzgco
 *  com.google.android.gms.internal.ads.zzgdb
 *  com.google.android.gms.internal.ads.zzgdn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftj;
import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzgcn;
import com.google.android.gms.internal.ads.zzgco;
import com.google.android.gms.internal.ads.zzgdb;
import com.google.android.gms.internal.ads.zzgdn;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzgcm
implements zzftj {
    private static final Collection<Integer> zza = Arrays.asList(64);
    private static final byte[] zzb = new byte[16];
    private final zzgdn zzc;
    private final byte[] zzd;

    public zzgcm(byte[] object) throws GeneralSecurityException {
        if (!zzfvw.zza((int)1)) throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        Collection<Integer> collection = zza;
        int n = ((byte[])object).length;
        if (collection.contains(n)) {
            int n2 = n >> 1;
            collection = (Collection<Integer>)Arrays.copyOfRange((byte[])object, 0, n2);
            this.zzd = Arrays.copyOfRange((byte[])object, n2, n);
            this.zzc = new zzgdn((byte[])collection);
            return;
        }
        object = new StringBuilder(59);
        ((StringBuilder)object).append("invalid key size: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" bytes; key must have 64 bytes");
        throw new InvalidKeyException(((StringBuilder)object).toString());
    }

    public final byte[] zza(byte[] object, byte[] byArray) throws GeneralSecurityException {
        byte[] byArray2;
        byte[] byArray3;
        int n;
        if (((byte[])object).length > 0x7FFFFFEF) {
            object = new GeneralSecurityException("plaintext too long");
            throw object;
        }
        Cipher cipher = (Cipher)zzgdb.zza.zzb("AES/CTR/NoPadding");
        byte[][] byArrayArray = new byte[][]{byArray, object};
        byArray = this.zzc.zza(zzb, 16);
        for (n = 0; n <= 0; ++n) {
            byArray2 = byArray3 = byArrayArray[n];
            if (byArray3 == null) {
                byArray2 = new byte[]{};
            }
            byArray = zzgco.zzd((byte[])zzgcn.zza((byte[])byArray), (byte[])this.zzc.zza(byArray2, 16));
        }
        byArray2 = byArrayArray[1];
        int n2 = byArray2.length;
        if (n2 >= 16) {
            int n3 = byArray.length;
            if (n2 < n3) throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            byArray3 = Arrays.copyOf(byArray2, n2);
            n = 0;
            while (true) {
                byArray2 = byArray3;
                if (n < byArray.length) {
                    int n4 = n2 - n3 + n;
                    byArray3[n4] = (byte)(byArray3[n4] ^ byArray[n]);
                    ++n;
                    continue;
                }
                break;
            }
        } else {
            byArray2 = zzgco.zzd((byte[])zzgcn.zzb((byte[])byArray2), (byte[])zzgcn.zza((byte[])byArray));
        }
        byArray = this.zzc.zza(byArray2, 16);
        byArray2 = (byte[])byArray.clone();
        byArray2[8] = (byte)(byArray2[8] & 0x7F);
        byArray2[12] = (byte)(byArray2[12] & 0x7F);
        cipher.init(1, (Key)new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(byArray2));
        return zzgco.zza((byte[][])new byte[][]{byArray, cipher.doFinal((byte[])object)});
    }
}
