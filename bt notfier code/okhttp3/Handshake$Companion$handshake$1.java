/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2={"<anonymous>", "", "Ljava/security/cert/Certificate;"}, k=3, mv={1, 5, 1}, xi=48)
static final class Handshake.Companion.handshake.1
extends Lambda
implements Function0<List<? extends Certificate>> {
    final List<Certificate> $peerCertificatesCopy;

    Handshake.Companion.handshake.1(List<? extends Certificate> list) {
        this.$peerCertificatesCopy = list;
        super(0);
    }

    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
