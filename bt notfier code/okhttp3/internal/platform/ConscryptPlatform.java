/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.ConscryptPlatform$Companion
 *  okhttp3.internal.platform.ConscryptPlatform$DisabledHostnameVerifier
 *  okhttp3.internal.platform.Platform
 *  org.conscrypt.Conscrypt
 *  org.conscrypt.ConscryptHostnameVerifier
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
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Platform;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r\u00a2\u0006\u0002\b\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "sslSocketFactory", "Companion", "DisabledHostnameVerifier", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class ConscryptPlatform
extends Platform {
    public static final Companion Companion = var3 = new Companion(null);
    private static final boolean isSupported;
    private final Provider provider;

    /*
     * Unable to fully structure code
     */
    static {
        var1_2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, var3.getClass().getClassLoader());
            var0_3 = var1_2;
            if (Conscrypt.isAvailable()) {
                var2_4 = ConscryptPlatform.Companion.atLeastVersion(2, 1, 0);
                var0_3 = var1_2;
                if (var2_4) {
                    var0_3 = true;
                }
            }
lbl12:
            // 6 sources

            while (true) {
                ConscryptPlatform.isSupported = var0_3;
                return;
            }
        }
        catch (ClassNotFoundException | NoClassDefFoundError var3_1) {
            var0_3 = var1_2;
            ** continue;
        }
    }

    private ConscryptPlatform() {
        Provider provider = Conscrypt.newProvider();
        Intrinsics.checkNotNullExpressionValue((Object)provider, (String)"newProvider()");
        this.provider = provider;
    }

    public /* synthetic */ ConscryptPlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String stringArray, List<Protocol> list) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(list, (String)"protocols");
        if (Conscrypt.isConscrypt((SSLSocket)sSLSocket)) {
            Conscrypt.setUseSessionTickets((SSLSocket)sSLSocket, (boolean)true);
            stringArray = ((Collection)Platform.Companion.alpnProtocolNames(list)).toArray(new String[0]);
            if (stringArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            Conscrypt.setApplicationProtocols((SSLSocket)sSLSocket, (String[])stringArray);
        } else {
            super.configureTlsExtensions(sSLSocket, (String)stringArray, list);
        }
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        object = Conscrypt.isConscrypt((SSLSocket)object) ? Conscrypt.getApplicationProtocol((SSLSocket)object) : super.getSelectedProtocol((SSLSocket)object);
        return object;
    }

    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.checkNotNullExpressionValue((Object)sSLContext, (String)"getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"trustManager");
        SSLContext sSLContext = this.newSSLContext();
        sSLContext.init(null, new TrustManager[]{(TrustManager)object}, null);
        object = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newSSLContext().apply {\n\u2026null)\n    }.socketFactory");
        return object;
    }

    public X509TrustManager platformTrustManager() {
        Object object = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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
            object = (X509TrustManager)object;
            Conscrypt.setHostnameVerifier((TrustManager)((TrustManager)object), (ConscryptHostnameVerifier)((ConscryptHostnameVerifier)DisabledHostnameVerifier.INSTANCE));
            return object;
        }
        object = Arrays.toString(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.toString(this)");
        throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"Unexpected default trust managers: ", (Object)object).toString());
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
        return null;
    }
}
