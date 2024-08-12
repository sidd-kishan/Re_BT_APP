/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzgch
 *  com.google.android.gms.internal.ads.zzgci
 *  com.google.android.gms.internal.ads.zzgds
 *  com.google.android.gms.internal.ads.zzgdu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzgch;
import com.google.android.gms.internal.ads.zzgci;
import com.google.android.gms.internal.ads.zzgds;
import com.google.android.gms.internal.ads.zzgdu;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzgcj
implements zzftg {
    private static final ThreadLocal<Cipher> zza = new zzgch();
    private static final ThreadLocal<Cipher> zzb = new zzgci();
    private final byte[] zzc;
    private final byte[] zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public zzgcj(byte[] object, int n) throws GeneralSecurityException {
        if (!zzfvw.zza((int)1)) throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        if (n != 12) {
            if (n != 16) throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzf = n;
        zzgdu.zza((int)((byte[])object).length);
        this.zze = new SecretKeySpec((byte[])object, "AES");
        object = zza.get();
        object.init(1, this.zze);
        object = zzgcj.zzc(object.doFinal(new byte[16]));
        this.zzc = object;
        this.zzd = zzgcj.zzc(object);
    }

    private static byte[] zzb(byte[] byArray, byte[] byArray2) {
        int n = byArray.length;
        byte[] byArray3 = new byte[n];
        int n2 = 0;
        while (n2 < n) {
            byArray3[n2] = (byte)(byArray[n2] ^ byArray2[n2]);
            ++n2;
        }
        return byArray3;
    }

    private static byte[] zzc(byte[] byArray) {
        byte[] byArray2 = new byte[16];
        int n = 0;
        while (true) {
            if (n >= 15) {
                n = byArray[15];
                byArray2[15] = (byte)(byArray[0] >> 7 & 0x87 ^ n + n);
                return byArray2;
            }
            byte by = byArray[n];
            int n2 = n + 1;
            byArray2[n] = (byte)((by + by ^ (byArray[n2] & 0xFF) >>> 7) & 0xFF);
            n = n2;
        }
    }

    private final byte[] zzd(Cipher cipher, int n, byte[] byArray, int n2, int n3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] byArray2 = new byte[16];
        byArray2[15] = (byte)n;
        if (n3 == 0) {
            return cipher.doFinal(zzgcj.zzb(byArray2, this.zzc));
        }
        byArray2 = cipher.doFinal(byArray2);
        int n4 = 0;
        n = 0;
        while (n3 - n > 16) {
            for (int i = 0; i < 16; ++i) {
                byArray2[i] = (byte)(byArray2[i] ^ byArray[n2 + n + i]);
            }
            byArray2 = cipher.doFinal(byArray2);
            n += 16;
        }
        byte[] byArray3 = Arrays.copyOfRange(byArray, n + n2, n2 + n3);
        if (byArray3.length == 16) {
            byArray = zzgcj.zzb(byArray3, this.zzc);
        } else {
            byArray = Arrays.copyOf(this.zzd, 16);
            for (n = n4; n < (n2 = byArray3.length); ++n) {
                byArray[n] = (byte)(byArray[n] ^ byArray3[n]);
            }
            byArray[n2] = (byte)(byArray[n2] ^ 0x80);
        }
        return cipher.doFinal(zzgcj.zzb(byArray2, byArray));
    }

    public final byte[] zza(byte[] object, byte[] byArray) throws GeneralSecurityException {
        int n = ((byte[])object).length;
        int n2 = this.zzf;
        if (n > Integer.MAX_VALUE - n2 - 16) {
            object = new GeneralSecurityException("plaintext too long");
            throw object;
        }
        byte[] byArray2 = new byte[n2 + n + 16];
        byte[] byArray3 = zzgds.zza((int)n2);
        int n3 = this.zzf;
        n2 = 0;
        System.arraycopy(byArray3, 0, byArray2, 0, n3);
        Cipher cipher = zza.get();
        cipher.init(1, this.zze);
        byArray3 = this.zzd(cipher, 0, byArray3, 0, byArray3.length);
        byArray = this.zzd(cipher, 1, byArray, 0, 0);
        Cipher cipher2 = zzb.get();
        cipher2.init(1, (Key)this.zze, new IvParameterSpec(byArray3));
        cipher2.doFinal((byte[])object, 0, n, byArray2, this.zzf);
        object = this.zzd(cipher, 2, byArray2, this.zzf, n);
        n3 = this.zzf;
        while (n2 < 16) {
            byArray2[n + n3 + n2] = (byte)(byArray[n2] ^ byArray3[n2] ^ object[n2]);
            ++n2;
        }
        return byArray2;
    }
}
