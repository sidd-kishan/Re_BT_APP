/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.ssl.SSLSockets
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.Android10SocketAdapter$Companion
 *  okhttp3.internal.platform.android.SocketAdapter
 *  okhttp3.internal.platform.android.SocketAdapter$DefaultImpls
 */
package okhttp3.internal.platform.android;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0017J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2={"Lokhttp3/internal/platform/android/Android10SocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Android10SocketAdapter
implements SocketAdapter {
    public static final Companion Companion = new Companion(null);

    public void configureTlsExtensions(SSLSocket object, String object2, List<? extends Protocol> stringArray) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(stringArray, (String)"protocols");
        try {
            SSLSockets.setUseSessionTickets((SSLSocket)object, (boolean)true);
            object2 = ((SSLSocket)object).getSSLParameters();
            stringArray = ((Collection)Platform.Companion.alpnProtocolNames(stringArray)).toArray(new String[0]);
            if (stringArray != null) {
                ((SSLParameters)object2).setApplicationProtocols(stringArray);
                ((SSLSocket)object).setSSLParameters((SSLParameters)object2);
                return;
            }
            object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            throw object;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IOException("Android internal error", illegalArgumentException);
        }
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        object = ((SSLSocket)object).getApplicationProtocol();
        boolean bl = object == null ? true : Intrinsics.areEqual((Object)object, (Object)"");
        if (!bl) return object;
        object = null;
        return object;
    }

    public boolean isSupported() {
        return Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        return SSLSockets.isSupportedSocket((SSLSocket)sSLSocket);
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }
}
