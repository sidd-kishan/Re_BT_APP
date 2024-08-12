/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.BouncyCastlePlatform$Companion
 *  okhttp3.internal.platform.Platform
 *  org.bouncycastle.jsse.BCSSLParameters
 *  org.bouncycastle.jsse.BCSSLSocket
 *  org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
 */
package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.Platform;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r\u00a2\u0006\u0002\b\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lokhttp3/internal/platform/BouncyCastlePlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class BouncyCastlePlatform
extends Platform {
    public static final Companion Companion = var1 = new Companion(null);
    private static final boolean isSupported;
    private final Provider provider = (Provider)new BouncyCastleJsseProvider();

    /*
     * Unable to fully structure code
     */
    static {
        var0_2 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, var1.getClass().getClassLoader());
            var0_2 = true;
lbl7:
            // 2 sources

            while (true) {
                BouncyCastlePlatform.isSupported = var0_2;
                return;
            }
        }
        catch (ClassNotFoundException var1_1) {
            ** continue;
        }
    }

    private BouncyCastlePlatform() {
    }

    public /* synthetic */ BouncyCastlePlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string, List<Protocol> stringArray) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(stringArray, (String)"protocols");
        if (sSLSocket instanceof BCSSLSocket) {
            string = (BCSSLSocket)sSLSocket;
            sSLSocket = string.getParameters();
            if ((stringArray = ((Collection)Platform.Companion.alpnProtocolNames(stringArray)).toArray(new String[0])) == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            sSLSocket.setApplicationProtocols(stringArray);
            string.setParameters((BCSSLParameters)sSLSocket);
        } else {
            super.configureTlsExtensions(sSLSocket, string, stringArray);
        }
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        if (object instanceof BCSSLSocket) {
            boolean bl = (object = ((BCSSLSocket)object).getApplicationProtocol()) == null ? true : Intrinsics.areEqual((Object)object, (Object)"");
            if (!bl) return object;
            object = null;
        } else {
            object = super.getSelectedProtocol((SSLSocket)object);
        }
        return object;
    }

    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.checkNotNullExpressionValue((Object)sSLContext, (String)"getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    public X509TrustManager platformTrustManager() {
        Object object = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }
}
