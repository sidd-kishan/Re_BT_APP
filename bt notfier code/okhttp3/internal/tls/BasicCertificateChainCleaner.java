/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.tls.BasicCertificateChainCleaner$Companion
 *  okhttp3.internal.tls.CertificateChainCleaner
 *  okhttp3.internal.tls.TrustRootIndex
 */
package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "verifySignature", "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class BasicCertificateChainCleaner
extends CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        Intrinsics.checkNotNullParameter((Object)trustRootIndex, (String)"trustRootIndex");
        this.trustRootIndex = trustRootIndex;
    }

    /*
     * Enabled force condition propagation
     */
    private final boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        boolean bl = Intrinsics.areEqual((Object)x509Certificate.getIssuerDN(), (Object)x509Certificate2.getSubjectDN());
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException generalSecurityException) {
            return bl2;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List<Certificate> clean(List<? extends Certificate> var1_1, String var2_2) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(var1_1, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"hostname");
        var1_1 = new ArrayDeque<E>((Collection)var1_1);
        var2_2 = new ArrayList<E>();
        var5_3 /* !! */  = var1_1.removeFirst();
        Intrinsics.checkNotNullExpressionValue(var5_3 /* !! */ , (String)"queue.removeFirst()");
        var2_2.add(var5_3 /* !! */ );
        var4_4 = 0;
        var3_5 = false;
        block0: while (true) {
            block5: {
                ++var4_4;
                var5_3 /* !! */  = (X509Certificate)var2_2.get(var2_2.size() - 1);
                var6_6 = this.trustRootIndex.findByIssuerAndSignature(var5_3 /* !! */ );
                if (var6_6 == null) break block5;
                if (var2_2.size() > 1 || !Intrinsics.areEqual(var5_3 /* !! */ , (Object)var6_6)) {
                    var2_2.add(var6_6);
                }
                if (this.verifySignature((X509Certificate)var6_6, (X509Certificate)var6_6)) {
                    return var2_2;
                }
                var3_5 = true;
                ** GOTO lbl33
            }
            var6_6 = var1_1.iterator();
            Intrinsics.checkNotNullExpressionValue((Object)var6_6, (String)"queue.iterator()");
            while (var6_6.hasNext()) {
                var7_7 /* !! */  = var6_6.next();
                if (var7_7 /* !! */  == null) throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                if (!this.verifySignature((X509Certificate)var5_3 /* !! */ , (X509Certificate)(var7_7 /* !! */  = (X509Certificate)var7_7 /* !! */ ))) continue;
                var6_6.remove();
                var2_2.add(var7_7 /* !! */ );
lbl33:
                // 2 sources

                if (var4_4 >= 9) throw new SSLPeerUnverifiedException(Intrinsics.stringPlus((String)"Certificate chain too long: ", (Object)var2_2));
                continue block0;
            }
            break;
        }
        if (var3_5) {
            return var2_2;
        }
        var1_1 = new SSLPeerUnverifiedException(Intrinsics.stringPlus((String)"Failed to find a trusted cert that signed ", var5_3 /* !! */ ));
        throw var1_1;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this || object instanceof BasicCertificateChainCleaner && Intrinsics.areEqual((Object)((BasicCertificateChainCleaner)((Object)object)).trustRootIndex, (Object)this.trustRootIndex)) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
