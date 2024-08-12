/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult
 */
package androidx.core.hardware.fingerprint;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

public static abstract class FingerprintManagerCompat.AuthenticationCallback {
    public void onAuthenticationError(int n, CharSequence charSequence) {
    }

    public void onAuthenticationFailed() {
    }

    public void onAuthenticationHelp(int n, CharSequence charSequence) {
    }

    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
    }
}
