/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.internal.tls.CertificateChainCleaner$Companion
 */
package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2={"Lokhttp3/internal/tls/CertificateChainCleaner;", "", "()V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);

    public abstract List<Certificate> clean(List<? extends Certificate> var1, String var2) throws SSLPeerUnverifiedException;
}
