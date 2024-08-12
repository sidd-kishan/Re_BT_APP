/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.tls.BasicCertificateChainCleaner
 *  okhttp3.internal.tls.BasicTrustRootIndex
 *  okhttp3.internal.tls.CertificateChainCleaner
 *  okhttp3.internal.tls.TrustRootIndex
 */
package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001f\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lokhttp3/internal/tls/CertificateChainCleaner$Companion;", "", "()V", "get", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)Lokhttp3/internal/tls/CertificateChainCleaner;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CertificateChainCleaner.Companion {
    private CertificateChainCleaner.Companion() {
    }

    public /* synthetic */ CertificateChainCleaner.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final CertificateChainCleaner get(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        return Platform.Companion.get().buildCertificateChainCleaner(x509TrustManager);
    }

    public final CertificateChainCleaner get(X509Certificate ... x509CertificateArray) {
        Intrinsics.checkNotNullParameter((Object)x509CertificateArray, (String)"caCerts");
        return (CertificateChainCleaner)new BasicCertificateChainCleaner((TrustRootIndex)new BasicTrustRootIndex(Arrays.copyOf(x509CertificateArray, x509CertificateArray.length)));
    }
}
