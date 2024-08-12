/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzfxc
 *  com.google.android.gms.internal.ads.zzgcn
 *  com.google.android.gms.internal.ads.zzgco
 *  com.google.android.gms.internal.ads.zzgdb
 *  com.google.android.gms.internal.ads.zzgdu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzfxc;
import com.google.android.gms.internal.ads.zzgcn;
import com.google.android.gms.internal.ads.zzgco;
import com.google.android.gms.internal.ads.zzgdb;
import com.google.android.gms.internal.ads.zzgdu;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class zzgdn
implements zzfxc {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzgdn(byte[] object) throws GeneralSecurityException {
        zzgdu.zza((int)((byte[])object).length);
        this.zza = new SecretKeySpec((byte[])object, "AES");
        object = zzgdn.zzb();
        object.init(1, this.zza);
        object = zzgcn.zza((byte[])object.doFinal(new byte[16]));
        this.zzb = object;
        this.zzc = zzgcn.zza((byte[])object);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (!zzfvw.zza((int)1)) throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        return (Cipher)zzgdb.zza.zzb("AES/ECB/NoPadding");
    }

    public final byte[] zza(byte[] object, int n) throws GeneralSecurityException {
        if (n > 16) {
            object = new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
            throw object;
        }
        Cipher cipher = zzgdn.zzb();
        cipher.init(1, this.zza);
        int n2 = ((byte[])object).length;
        double d = n2;
        Double.isNaN(d);
        int n3 = Math.max(1, (int)Math.ceil(d / 16.0));
        byte[] byArray = n3 * 16 == n2 ? zzgco.zzb((byte[])object, (int)((n3 - 1) * 16), (byte[])this.zzb, (int)0, (int)16) : zzgco.zzd((byte[])zzgcn.zzb((byte[])Arrays.copyOfRange(object, (n3 - 1) * 16, n2)), (byte[])this.zzc);
        byte[] byArray2 = new byte[16];
        n2 = 0;
        while (n2 < n3 - 1) {
            byArray2 = cipher.doFinal(zzgco.zzb((byte[])byArray2, (int)0, (byte[])object, (int)(n2 * 16), (int)16));
            ++n2;
        }
        return Arrays.copyOf(cipher.doFinal(zzgco.zzd((byte[])byArray, (byte[])byArray2)), n);
    }
}
