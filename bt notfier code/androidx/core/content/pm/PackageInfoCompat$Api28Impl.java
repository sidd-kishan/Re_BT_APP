/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.content.pm.SigningInfo
 */
package androidx.core.content.pm;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;

private static class PackageInfoCompat.Api28Impl {
    private PackageInfoCompat.Api28Impl() {
    }

    static Signature[] getApkContentsSigners(SigningInfo signingInfo) {
        return signingInfo.getApkContentsSigners();
    }

    static Signature[] getSigningCertificateHistory(SigningInfo signingInfo) {
        return signingInfo.getSigningCertificateHistory();
    }

    static boolean hasMultipleSigners(SigningInfo signingInfo) {
        return signingInfo.hasMultipleSigners();
    }

    static boolean hasSigningCertificate(PackageManager packageManager, String string, byte[] byArray, int n) {
        return packageManager.hasSigningCertificate(string, byArray, n);
    }
}
