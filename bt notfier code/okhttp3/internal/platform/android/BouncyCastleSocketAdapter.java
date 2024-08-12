/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.BouncyCastlePlatform
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.BouncyCastleSocketAdapter$Companion
 *  okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
 *  okhttp3.internal.platform.android.SocketAdapter
 *  okhttp3.internal.platform.android.SocketAdapter$DefaultImpls
 *  org.bouncycastle.jsse.BCSSLParameters
 *  org.bouncycastle.jsse.BCSSLSocket
 */
package okhttp3.internal.platform.android;

import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2={"Lokhttp3/internal/platform/android/BouncyCastleSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class BouncyCastleSocketAdapter
implements SocketAdapter {
    public static final Companion Companion = new Companion(null);
    private static final DeferredSocketAdapter.Factory factory = (DeferredSocketAdapter.Factory)new /* Unavailable Anonymous Inner Class!! */;

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getFactory$cp() {
        return factory;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string, List<? extends Protocol> stringArray) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(stringArray, (String)"protocols");
        if (!this.matchesSocket(sSLSocket)) return;
        string = (BCSSLSocket)sSLSocket;
        sSLSocket = string.getParameters();
        if ((stringArray = ((Collection)Platform.Companion.alpnProtocolNames(stringArray)).toArray(new String[0])) == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        sSLSocket.setApplicationProtocols(stringArray);
        string.setParameters((BCSSLParameters)sSLSocket);
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        object = ((BCSSLSocket)object).getApplicationProtocol();
        boolean bl = object == null ? true : Intrinsics.areEqual((Object)object, (Object)"");
        if (!bl) return object;
        object = null;
        return object;
    }

    public boolean isSupported() {
        return BouncyCastlePlatform.Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }
}
