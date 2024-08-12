/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.OkHttpClient
 *  okhttp3.Protocol
 *  okhttp3.internal.Util
 *  okhttp3.internal.platform.Platform$Companion
 *  okhttp3.internal.tls.BasicCertificateChainCleaner
 *  okhttp3.internal.tls.BasicTrustRootIndex
 *  okhttp3.internal.tls.CertificateChainCleaner
 *  okhttp3.internal.tls.TrustRootIndex
 */
package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u0012\u00a2\u0006\u0002\b\u00130\u0011H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u000fJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020+H\u0016\u00a8\u00060"}, d2={"Lokhttp3/internal/platform/Platform;", "", "()V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getPrefix", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "platformTrustManager", "toString", "sslSocketFactory", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public class Platform {
    public static final Companion Companion;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile Platform platform;

    static {
        Companion companion;
        Companion = companion = new Companion(null);
        platform = okhttp3.internal.platform.Platform$Companion.access$findPlatform((Companion)companion);
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static final /* synthetic */ Platform access$getPlatform$cp() {
        return platform;
    }

    public static final /* synthetic */ void access$setPlatform$cp(Platform platform) {
        Platform.platform = platform;
    }

    @JvmStatic
    public static final Platform get() {
        return Companion.get();
    }

    public static /* synthetic */ void log$default(Platform platform, String string, int n, Throwable throwable, int n2, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        if ((n2 & 2) != 0) {
            n = 4;
        }
        if ((n2 & 4) != 0) {
            throwable = null;
        }
        platform.log(string, n, throwable);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        return (CertificateChainCleaner)new BasicCertificateChainCleaner(this.buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509CertificateArray) {
        Intrinsics.checkNotNullParameter((Object)x509CertificateArray, (String)"trustManager");
        x509CertificateArray = x509CertificateArray.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue((Object)x509CertificateArray, (String)"trustManager.acceptedIssuers");
        return (TrustRootIndex)new BasicTrustRootIndex(Arrays.copyOf(x509CertificateArray, x509CertificateArray.length));
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string, List<Protocol> list) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(list, (String)"protocols");
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int n) throws IOException {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        Intrinsics.checkNotNullParameter((Object)inetSocketAddress, (String)"address");
        socket.connect(inetSocketAddress, n);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        return null;
    }

    public Object getStackTraceForCloseable(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"closer");
        object = logger.isLoggable(Level.FINE) ? new Throwable((String)object) : null;
        return object;
    }

    public boolean isCleartextTrafficPermitted(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hostname");
        return true;
    }

    public void log(String string, int n, Throwable throwable) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        Level level = n == 5 ? Level.WARNING : Level.INFO;
        logger.log(level, string, throwable);
    }

    public void logCloseableLeak(String string, Object object) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        String string2 = string;
        if (object == null) {
            string2 = Intrinsics.stringPlus((String)string, (Object)" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        this.log(string2, 5, (Throwable)object);
    }

    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue((Object)sSLContext, (String)"getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"trustManager");
        try {
            SSLContext sSLContext = this.newSSLContext();
            sSLContext.init(null, new TrustManager[]{(TrustManager)object}, null);
            object = sSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newSSLContext().apply {\n\u2026ll)\n      }.socketFactory");
            return object;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new AssertionError(Intrinsics.stringPlus((String)"No System TLS: ", (Object)generalSecurityException), generalSecurityException);
        }
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
            return (X509TrustManager)object;
        }
        object = Arrays.toString(object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.toString(this)");
        throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"Unexpected default trust managers: ", (Object)object).toString());
    }

    public String toString() {
        String string = this.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"javaClass.simpleName");
        return string;
    }

    public X509TrustManager trustManager(SSLSocketFactory object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocketFactory");
        try {
            Class<?> clazz = Class.forName("sun.security.ssl.SSLContextImpl");
            Intrinsics.checkNotNullExpressionValue(clazz, (String)"sslContextClass");
            object = Util.readFieldOrNull((Object)object, clazz, (String)"context");
            if (object == null) {
                return null;
            }
            object = (X509TrustManager)Util.readFieldOrNull((Object)object, X509TrustManager.class, (String)"trustManager");
        }
        catch (RuntimeException runtimeException) {
            if (!Intrinsics.areEqual((Object)runtimeException.getClass().getName(), (Object)"java.lang.reflect.InaccessibleObjectException")) throw runtimeException;
            object = null;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = null;
        }
        return object;
    }
}
