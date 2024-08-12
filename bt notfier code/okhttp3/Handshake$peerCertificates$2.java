/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2={"<anonymous>", "", "Ljava/security/cert/Certificate;"}, k=3, mv={1, 5, 1}, xi=48)
static final class Handshake.peerCertificates.2
extends Lambda
implements Function0<List<? extends Certificate>> {
    final Function0<List<Certificate>> $peerCertificatesFn;

    Handshake.peerCertificates.2(Function0<? extends List<? extends Certificate>> function0) {
        this.$peerCertificatesFn = function0;
        super(0);
    }

    public final List<Certificate> invoke() {
        List list;
        try {
            list = (List)this.$peerCertificatesFn.invoke();
        }
        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }
}
