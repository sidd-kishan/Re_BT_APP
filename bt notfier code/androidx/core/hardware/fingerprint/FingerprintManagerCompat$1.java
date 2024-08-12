/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationResult
 *  android.hardware.fingerprint.FingerprintManager$CryptoObject
 *  androidx.core.hardware.fingerprint.FingerprintManagerCompat
 *  androidx.core.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback
 *  androidx.core.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult
 */
package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/*
 * Exception performing whole class analysis ignored.
 */
class FingerprintManagerCompat.1
extends FingerprintManager.AuthenticationCallback {
    final FingerprintManagerCompat.AuthenticationCallback val$callback;

    FingerprintManagerCompat.1(FingerprintManagerCompat.AuthenticationCallback authenticationCallback) {
        this.val$callback = authenticationCallback;
    }

    public void onAuthenticationError(int n, CharSequence charSequence) {
        this.val$callback.onAuthenticationError(n, charSequence);
    }

    public void onAuthenticationFailed() {
        this.val$callback.onAuthenticationFailed();
    }

    public void onAuthenticationHelp(int n, CharSequence charSequence) {
        this.val$callback.onAuthenticationHelp(n, charSequence);
    }

    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject((FingerprintManager.CryptoObject)authenticationResult.getCryptoObject())));
    }
}
