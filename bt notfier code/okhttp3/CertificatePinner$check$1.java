/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.CertificatePinner
 */
package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.CertificatePinner;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2={"<anonymous>", "", "Ljava/security/cert/X509Certificate;"}, k=3, mv={1, 5, 1}, xi=48)
static final class CertificatePinner.check.1
extends Lambda
implements Function0<List<? extends X509Certificate>> {
    final String $hostname;
    final List<Certificate> $peerCertificates;
    final CertificatePinner this$0;

    CertificatePinner.check.1(CertificatePinner certificatePinner, List<? extends Certificate> list, String string) {
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = string;
        super(0);
    }

    public final List<X509Certificate> invoke() {
        Object object = this.this$0.getCertificateChainCleaner$okhttp();
        object = object == null ? null : object.clean(this.$peerCertificates, this.$hostname);
        Object object2 = object;
        if (object == null) {
            object2 = this.$peerCertificates;
        }
        object2 = (Iterable)object2;
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add((X509Certificate)((Certificate)object2.next()));
        }
        return (List)object;
    }
}
