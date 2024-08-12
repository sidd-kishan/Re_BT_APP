/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.AndroidPlatform
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.AndroidSocketAdapter$Companion
 *  okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
 *  okhttp3.internal.platform.android.SocketAdapter
 *  okhttp3.internal.platform.android.SocketAdapter$DefaultImpls
 */
package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "(Ljava/lang/Class;)V", "getAlpnSelectedProtocol", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "setAlpnProtocols", "setHostname", "setUseSessionTickets", "configureTlsExtensions", "", "sslSocket", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public class AndroidSocketAdapter
implements SocketAdapter {
    public static final Companion Companion;
    private static final DeferredSocketAdapter.Factory playProviderFactory;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    static {
        Companion companion;
        Companion = companion = new Companion(null);
        playProviderFactory = companion.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> genericDeclaration) {
        Intrinsics.checkNotNullParameter(genericDeclaration, (String)"sslSocketClass");
        this.sslSocketClass = genericDeclaration;
        genericDeclaration = genericDeclaration.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(genericDeclaration, (String)"sslSocketClass.getDeclar\u2026:class.javaPrimitiveType)");
        this.setUseSessionTickets = genericDeclaration;
        this.setHostname = this.sslSocketClass.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = this.sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = this.sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getPlayProviderFactory$cp() {
        return playProviderFactory;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string, List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(list, (String)"protocols");
        if (!this.matchesSocket(sSLSocket)) return;
        try {
            this.setUseSessionTickets.invoke(sSLSocket, true);
            if (string != null) {
                this.setHostname.invoke(sSLSocket, string);
            }
            this.setAlpnProtocols.invoke(sSLSocket, new Object[]{Platform.Companion.concatLengthPrefixed(list)});
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError((Object)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError((Object)illegalAccessException);
        }
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        boolean bl = this.matchesSocket((SSLSocket)object);
        Charset charset = null;
        if (!bl) {
            return null;
        }
        try {
            byte[] byArray = (byte[])this.getAlpnSelectedProtocol.invoke(object, new Object[0]);
            object = charset;
            if (byArray == null) return object;
            charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue((Object)charset, (String)"UTF_8");
            object = new String(byArray, charset);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError((Object)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError((Object)illegalAccessException);
        }
        catch (NullPointerException nullPointerException) {
            if (!Intrinsics.areEqual((Object)nullPointerException.getMessage(), (Object)"ssl == null")) throw nullPointerException;
            object = null;
        }
        return object;
    }

    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        return this.sslSocketClass.isInstance(sSLSocket);
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }
}
