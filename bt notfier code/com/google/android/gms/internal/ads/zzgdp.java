/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzfxc
 *  com.google.android.gms.internal.ads.zzgdo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzfxc;
import com.google.android.gms.internal.ads.zzgdo;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

public final class zzgdp
implements zzfxc {
    private final ThreadLocal<Mac> zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    public zzgdp(String string, Key key) throws GeneralSecurityException {
        block13: {
            int n;
            block14: {
                block9: {
                    block10: {
                        block11: {
                            block12: {
                                block8: {
                                    this.zza = new zzgdo(this);
                                    if (!zzfvw.zza((int)2)) throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
                                    this.zzb = string;
                                    this.zzc = key;
                                    if (key.getEncoded().length < 16) throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
                                    switch (string.hashCode()) {
                                        default: {
                                            break;
                                        }
                                        case 392317873: {
                                            if (!string.equals("HMACSHA512")) break;
                                            n = 4;
                                            break block8;
                                        }
                                        case 392316170: {
                                            if (!string.equals("HMACSHA384")) break;
                                            n = 3;
                                            break block8;
                                        }
                                        case 392315118: {
                                            if (!string.equals("HMACSHA256")) break;
                                            n = 2;
                                            break block8;
                                        }
                                        case 392315023: {
                                            if (!string.equals("HMACSHA224")) break;
                                            n = 1;
                                            break block8;
                                        }
                                        case -1823053428: {
                                            if (!string.equals("HMACSHA1")) break;
                                            n = 0;
                                            break block8;
                                        }
                                    }
                                    n = -1;
                                }
                                if (n == 0) break block9;
                                if (n == 1) break block10;
                                if (n == 2) break block11;
                                if (n == 3) break block12;
                                if (n != 4) {
                                    string = string.length() != 0 ? "unknown Hmac algorithm: ".concat(string) : new String("unknown Hmac algorithm: ");
                                    throw new NoSuchAlgorithmException(string);
                                }
                                this.zzd = 64;
                                break block13;
                            }
                            n = 48;
                            break block14;
                        }
                        n = 32;
                        break block14;
                    }
                    n = 28;
                    break block14;
                }
                n = 20;
            }
            this.zzd = n;
        }
        this.zza.get();
    }

    static /* synthetic */ String zzb(zzgdp zzgdp2) {
        return zzgdp2.zzb;
    }

    static /* synthetic */ Key zzc(zzgdp zzgdp2) {
        return zzgdp2.zzc;
    }

    public final byte[] zza(byte[] byArray, int n) throws GeneralSecurityException {
        if (n > this.zzd) throw new InvalidAlgorithmParameterException("tag size too big");
        this.zza.get().update(byArray);
        return Arrays.copyOf(this.zza.get().doFinal(), n);
    }
}
