/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.OpenJSSEPlatform$Companion
 *  okhttp3.internal.platform.Platform
 *  org.openjsse.javax.net.ssl.SSLParameters
 *  org.openjsse.javax.net.ssl.SSLSocket
 *  org.openjsse.net.ssl.OpenJSSE
 */
package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.OpenJSSEPlatform;
import okhttp3.internal.platform.Platform;
import org.openjsse.javax.net.ssl.SSLSocket;
import org.openjsse.net.ssl.OpenJSSE;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r\u00a2\u0006\u0002\b\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lokhttp3/internal/platform/OpenJSSEPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenJSSEPlatform
extends Platform {
    public static final Companion Companion = var1 = new Companion(null);
    private static final boolean isSupported;
    private final Provider provider = (Provider)new OpenJSSE();

    /*
     * Unable to fully structure code
     */
    static {
        var0_2 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, var1.getClass().getClassLoader());
            var0_2 = true;
lbl7:
            // 2 sources

            while (true) {
                OpenJSSEPlatform.isSupported = var0_2;
                return;
            }
        }
        catch (ClassNotFoundException var1_1) {
            ** continue;
        }
    }

    private OpenJSSEPlatform() {
    }

    public /* synthetic */ OpenJSSEPlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, String object, List<Protocol> sSLParameters) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(sSLParameters, (String)"protocols");
        if (sSLSocket instanceof SSLSocket) {
            object = (sSLSocket = (SSLSocket)sSLSocket).getSSLParameters();
            if (!(object instanceof org.openjsse.javax.net.ssl.SSLParameters)) return;
            String[] stringArray = Platform.Companion.alpnProtocolNames(sSLParameters);
            sSLParameters = (org.openjsse.javax.net.ssl.SSLParameters)object;
            if ((stringArray = ((Collection)stringArray).toArray(new String[0])) == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            sSLParameters.setApplicationProtocols(stringArray);
            sSLSocket.setSSLParameters((SSLParameters)object);
        } else {
            super.configureTlsExtensions(sSLSocket, (String)object, sSLParameters);
        }
    }

    public String getSelectedProtocol(javax.net.ssl.SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        if (object instanceof SSLSocket) {
            boolean bl = (object = ((SSLSocket)object).getApplicationProtocol()) == null ? true : Intrinsics.areEqual((Object)object, (Object)"");
            if (!bl) return object;
            object = null;
        } else {
            object = super.getSelectedProtocol((javax.net.ssl.SSLSocket)object);
        }
        return object;
    }

    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.provider);
        Intrinsics.checkNotNullExpressionValue((Object)sSLContext, (String)"getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    public X509TrustManager platformTrustManager() {
        Object object = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.provider);
        object.init((KeyStore)null);
        object = object.getTrustManagers();
        Intrinsics.checkNotNull((Object)object);
        int n = ((TrustManager[])object).length;
        boolean bl = true;
        if (n != 1 || !(object[0] instanceof X509TrustManager)) {
            bl = false;
        }
        if (bl) {
            if ((object = object[0]) == null) throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager)object;
        }
        object = Arrays.toString(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.toString(this)");
        throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"Unexpected default trust managers: ", (Object)object).toString());
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
    }
}
