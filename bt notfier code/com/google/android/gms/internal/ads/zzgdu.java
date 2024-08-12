/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.regex.Pattern;

public final class zzgdu {
    private static final Pattern zza = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"), 2);
    private static final Pattern zzb = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"), 2);

    public static void zza(int n) throws InvalidAlgorithmParameterException {
        if (n == 16) return;
        if (n != 32) throw new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", n * 8));
    }

    public static void zzb(int n, int n2) throws GeneralSecurityException {
        if (n < 0 || n > 0) throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", n, 0));
    }
}
