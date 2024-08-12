/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.Jdk8WithJettyBootPlatform$AlpnProvider
 *  okhttp3.internal.platform.Jdk8WithJettyBootPlatform$Companion
 *  okhttp3.internal.platform.Platform
 */
package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Jdk8WithJettyBootPlatform;
import okhttp3.internal.platform.Platform;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "AlpnProvider", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Jdk8WithJettyBootPlatform
extends Platform {
    public static final Companion Companion = new Companion(null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> clazz, Class<?> clazz2) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"putMethod");
        Intrinsics.checkNotNullParameter((Object)method2, (String)"getMethod");
        Intrinsics.checkNotNullParameter((Object)method3, (String)"removeMethod");
        Intrinsics.checkNotNullParameter(clazz, (String)"clientProviderClass");
        Intrinsics.checkNotNullParameter(clazz2, (String)"serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = clazz;
        this.serverProviderClass = clazz2;
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        try {
            this.removeMethod.invoke(null, sSLSocket);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError("failed to remove ALPN", invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("failed to remove ALPN", illegalAccessException);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String object, List<? extends Protocol> object2) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(object2, (String)"protocols");
        Object object3 = Platform.Companion.alpnProtocolNames(object2);
        try {
            ClassLoader classLoader = Platform.class.getClassLoader();
            object = this.clientProviderClass;
            object2 = this.serverProviderClass;
            AlpnProvider alpnProvider = new AlpnProvider((List)object3);
            object3 = (InvocationHandler)alpnProvider;
            object = Proxy.newProxyInstance(classLoader, new Class[]{object, object2}, (InvocationHandler)object3);
            this.putMethod.invoke(null, sSLSocket, object);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("failed to set ALPN", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError("failed to set ALPN", invocationTargetException);
        }
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        try {
            Method method = this.getMethod;
            Object var2_5 = null;
            object = Proxy.getInvocationHandler(method.invoke(null, object));
            if (object == null) {
                object = new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
                throw object;
            }
            if (!(object = (AlpnProvider)object).getUnsupported() && object.getSelected() == null) {
                Platform.log$default((Platform)this, (String)"ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (int)0, null, (int)6, null);
                return null;
            }
            object = object.getUnsupported() ? var2_5 : object.getSelected();
            return object;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError("failed to get ALPN selected protocol", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new AssertionError("failed to get ALPN selected protocol", invocationTargetException);
        }
    }
}
