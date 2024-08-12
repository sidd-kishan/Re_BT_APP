/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.conscrypt.ConscryptHostnameVerifier
 */
package okhttp3.internal.platform;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import org.conscrypt.ConscryptHostnameVerifier;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a8\u0006\r"}, d2={"Lokhttp3/internal/platform/ConscryptPlatform$DisabledHostnameVerifier;", "Lorg/conscrypt/ConscryptHostnameVerifier;", "()V", "verify", "", "certs", "", "Ljava/security/cert/X509Certificate;", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ConscryptPlatform.DisabledHostnameVerifier
implements ConscryptHostnameVerifier {
    public static final ConscryptPlatform.DisabledHostnameVerifier INSTANCE = new ConscryptPlatform.DisabledHostnameVerifier();

    private ConscryptPlatform.DisabledHostnameVerifier() {
    }

    public final boolean verify(String string, SSLSession sSLSession) {
        return true;
    }

    public boolean verify(X509Certificate[] x509CertificateArray, String string, SSLSession sSLSession) {
        return true;
    }
}
