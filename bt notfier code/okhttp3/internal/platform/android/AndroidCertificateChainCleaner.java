/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.http.X509TrustManagerExtensions
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.android.AndroidCertificateChainCleaner$Companion
 *  okhttp3.internal.tls.CertificateChainCleaner
 */
package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerExtensions", "Landroid/net/http/X509TrustManagerExtensions;", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class AndroidCertificateChainCleaner
extends CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);
    private final X509TrustManager trustManager;
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    public AndroidCertificateChainCleaner(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        Intrinsics.checkNotNullParameter((Object)x509TrustManagerExtensions, (String)"x509TrustManagerExtensions");
        this.trustManager = x509TrustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions;
    }

    public List<Certificate> clean(List<? extends Certificate> object, String object2) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(object, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"hostname");
        object = ((Collection)object).toArray(new X509Certificate[0]);
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        try {
            object = this.x509TrustManagerExtensions.checkServerTrusted(object, "RSA", (String)object2);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"x509TrustManagerExtensio\u2026ficates, \"RSA\", hostname)");
            return object;
        }
        catch (CertificateException certificateException) {
            object2 = new SSLPeerUnverifiedException(certificateException.getMessage());
            ((Throwable)object2).initCause(certificateException);
            throw (Throwable)object2;
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof AndroidCertificateChainCleaner && ((AndroidCertificateChainCleaner)((Object)object)).trustManager == this.trustManager;
        return bl;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }
}
