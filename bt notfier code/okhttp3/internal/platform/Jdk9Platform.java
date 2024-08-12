/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.Jdk9Platform$Companion
 *  okhttp3.internal.platform.Platform
 */
package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.internal.platform.Jdk9Platform;
import okhttp3.internal.platform.Platform;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0011\u0010\t\u001a\r\u0012\t\u0012\u00070\u000b\u00a2\u0006\u0002\b\f0\nH\u0017J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016\u00a8\u0006\u0015"}, d2={"Lokhttp3/internal/platform/Jdk9Platform;", "Lokhttp3/internal/platform/Platform;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public class Jdk9Platform
extends Platform {
    public static final Companion Companion;
    private static final boolean isAvailable;
    private static final Integer majorVersion;

    static {
        boolean bl;
        block5: {
            block4: {
                block3: {
                    Integer n = null;
                    Companion = new Companion(null);
                    String string = System.getProperty("java.specification.version");
                    if (string != null) {
                        n = StringsKt.toIntOrNull((String)string);
                    }
                    majorVersion = n;
                    bl = true;
                    if (n == null) break block3;
                    if (n < 9) break block4;
                    break block5;
                }
                try {
                    SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                }
                catch (NoSuchMethodException noSuchMethodException) {}
            }
            bl = false;
        }
        isAvailable = bl;
    }

    public static final /* synthetic */ Integer access$getMajorVersion$cp() {
        return majorVersion;
    }

    public static final /* synthetic */ boolean access$isAvailable$cp() {
        return isAvailable;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String object, List<Protocol> stringArray) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(stringArray, (String)"protocols");
        object = sSLSocket.getSSLParameters();
        stringArray = ((Collection)Platform.Companion.alpnProtocolNames(stringArray)).toArray(new String[0]);
        if (stringArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        ((SSLParameters)object).setApplicationProtocols(stringArray);
        sSLSocket.setSSLParameters((SSLParameters)object);
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        Object var3_3 = null;
        try {
            object = ((SSLSocket)object).getApplicationProtocol();
            boolean bl = object == null ? true : Intrinsics.areEqual((Object)object, (Object)"");
            if (!bl) return object;
            object = var3_3;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            object = null;
        }
        return object;
    }

    public SSLContext newSSLContext() {
        Object object = majorVersion;
        if (object != null && (Integer)object >= 9) {
            object = SSLContext.getInstance("TLS");
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getInstance(\"TLS\")");
        } else {
            try {
                object = SSLContext.getInstance("TLSv1.3");
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object = SSLContext.getInstance("TLS");
            }
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"try {\n          // Based\u2026Instance(\"TLS\")\n        }");
        }
        return object;
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 8 (>= 252) or JDK 9+");
    }
}
