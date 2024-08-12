/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.ConnectionSpec
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", "", "isFallbackPossible", "nextModeIndex", "", "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        Intrinsics.checkNotNullParameter(list, (String)"connectionSpecs");
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int n = this.nextModeIndex;
        int n2 = this.connectionSpecs.size();
        if (n >= n2) return false;
        while (true) {
            int n3 = n + 1;
            if (this.connectionSpecs.get(n).isCompatible(sSLSocket)) {
                return true;
            }
            if (n3 >= n2) {
                return false;
            }
            n = n3;
        }
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket object) throws IOException {
        StringBuilder stringBuilder;
        block4: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
            int n = this.nextModeIndex;
            int n2 = this.connectionSpecs.size();
            if (n < n2) {
                while (true) {
                    int n3 = n + 1;
                    stringBuilder = this.connectionSpecs.get(n);
                    if (stringBuilder.isCompatible((SSLSocket)object)) {
                        this.nextModeIndex = n3;
                        break block4;
                    }
                    if (n3 >= n2) break;
                    n = n3;
                }
            }
            stringBuilder = null;
        }
        if (stringBuilder != null) {
            this.isFallbackPossible = this.isFallbackPossible((SSLSocket)object);
            stringBuilder.apply$okhttp((SSLSocket)object, this.isFallback);
            return stringBuilder;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find acceptable protocols. isFallback=");
        stringBuilder.append(this.isFallback);
        stringBuilder.append(", modes=");
        stringBuilder.append(this.connectionSpecs);
        stringBuilder.append(", supported protocols=");
        object = object.getEnabledProtocols();
        Intrinsics.checkNotNull((Object)object);
        object = Arrays.toString(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.toString(this)");
        stringBuilder.append((String)object);
        object = new UnknownServiceException(stringBuilder.toString());
        throw object;
    }

    public final boolean connectionFailed(IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"e");
        boolean bl = true;
        this.isFallback = true;
        if (!(!this.isFallbackPossible || iOException instanceof ProtocolException || iOException instanceof InterruptedIOException || iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException || iOException instanceof SSLPeerUnverifiedException)) {
            if (iOException instanceof SSLException) return bl;
        }
        bl = false;
        return bl;
    }
}
