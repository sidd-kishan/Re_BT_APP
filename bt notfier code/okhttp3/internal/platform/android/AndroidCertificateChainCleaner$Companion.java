/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.http.X509TrustManagerExtensions
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.android.AndroidCertificateChainCleaner
 */
package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class AndroidCertificateChainCleaner.Companion {
    private AndroidCertificateChainCleaner.Companion() {
    }

    public /* synthetic */ AndroidCertificateChainCleaner.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final AndroidCertificateChainCleaner buildIfSupported(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        AndroidCertificateChainCleaner androidCertificateChainCleaner = null;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions == null) return androidCertificateChainCleaner;
        androidCertificateChainCleaner = new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions);
        return androidCertificateChainCleaner;
    }
}
