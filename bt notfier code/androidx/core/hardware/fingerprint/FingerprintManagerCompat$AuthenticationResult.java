/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.hardware.fingerprint.FingerprintManagerCompat$CryptoObject
 */
package androidx.core.hardware.fingerprint;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

public static final class FingerprintManagerCompat.AuthenticationResult {
    private final FingerprintManagerCompat.CryptoObject mCryptoObject;

    public FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.CryptoObject cryptoObject) {
        this.mCryptoObject = cryptoObject;
    }

    public FingerprintManagerCompat.CryptoObject getCryptoObject() {
        return this.mCryptoObject;
    }
}
