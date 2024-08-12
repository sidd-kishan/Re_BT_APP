/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.fingerprint.FingerprintManager
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
 *  android.hardware.fingerprint.FingerprintManager$CryptoObject
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 *  androidx.core.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback
 *  androidx.core.hardware.fingerprint.FingerprintManagerCompat$CryptoObject
 *  androidx.core.os.CancellationSignal
 */
package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.core.os.CancellationSignal;

@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context context) {
        if (Build.VERSION.SDK_INT == 23) {
            return (FingerprintManager)context.getSystemService(FingerprintManager.class);
        }
        if (Build.VERSION.SDK_INT <= 23) return null;
        if (!context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) return null;
        return (FingerprintManager)context.getSystemService(FingerprintManager.class);
    }

    static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
        CryptoObject cryptoObject2 = null;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) return cryptoObject2;
        cryptoObject2 = new CryptoObject(cryptoObject.getMac());
        return cryptoObject2;
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        FingerprintManager.CryptoObject cryptoObject2 = null;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) return cryptoObject2;
        cryptoObject2 = new FingerprintManager.CryptoObject(cryptoObject.getMac());
        return cryptoObject2;
    }

    public void authenticate(CryptoObject cryptoObject, int n, CancellationSignal object, AuthenticationCallback authenticationCallback, Handler handler) {
        if (Build.VERSION.SDK_INT < 23) return;
        FingerprintManager fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManager == null) return;
        object = object != null ? (android.os.CancellationSignal)object.getCancellationSignalObject() : null;
        fingerprintManager.authenticate(FingerprintManagerCompat.wrapCryptoObject(cryptoObject), (android.os.CancellationSignal)object, n, FingerprintManagerCompat.wrapCallback(authenticationCallback), handler);
    }

    public boolean hasEnrolledFingerprints() {
        boolean bl;
        int n = Build.VERSION.SDK_INT;
        boolean bl2 = bl = false;
        if (n < 23) return bl2;
        FingerprintManager fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        bl2 = bl;
        if (fingerprintManager == null) return bl2;
        bl2 = bl;
        if (!fingerprintManager.hasEnrolledFingerprints()) return bl2;
        bl2 = true;
        return bl2;
    }

    public boolean isHardwareDetected() {
        boolean bl;
        int n = Build.VERSION.SDK_INT;
        boolean bl2 = bl = false;
        if (n < 23) return bl2;
        FingerprintManager fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext);
        bl2 = bl;
        if (fingerprintManager == null) return bl2;
        bl2 = bl;
        if (!fingerprintManager.isHardwareDetected()) return bl2;
        bl2 = true;
        return bl2;
    }
}
