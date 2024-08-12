/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.Jdk8WithJettyBootPlatform
 *  okhttp3.internal.platform.Platform
 */
package okhttp3.internal.platform;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Jdk8WithJettyBootPlatform;
import okhttp3.internal.platform.Platform;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0005"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Jdk8WithJettyBootPlatform.Companion {
    private Jdk8WithJettyBootPlatform.Companion() {
    }

    public /* synthetic */ Jdk8WithJettyBootPlatform.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Platform buildIfSupported() {
        Object object = System.getProperty("java.specification.version", "unknown");
        try {
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"jvmVersion");
            int n = Integer.parseInt((String)object);
            if (n >= 9) {
                return null;
            }
        }
        catch (NumberFormatException numberFormatException) {}
        try {
            GenericDeclaration genericDeclaration = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            GenericDeclaration genericDeclaration2 = Class.forName(Intrinsics.stringPlus((String)"org.eclipse.jetty.alpn.ALPN", (Object)"$Provider"), true, null);
            object = Class.forName(Intrinsics.stringPlus((String)"org.eclipse.jetty.alpn.ALPN", (Object)"$ClientProvider"), true, null);
            Class<?> clazz = Class.forName(Intrinsics.stringPlus((String)"org.eclipse.jetty.alpn.ALPN", (Object)"$ServerProvider"), true, null);
            genericDeclaration2 = genericDeclaration.getMethod("put", new Class[]{SSLSocket.class, genericDeclaration2});
            Method method = genericDeclaration.getMethod("get", SSLSocket.class);
            genericDeclaration = genericDeclaration.getMethod("remove", SSLSocket.class);
            Intrinsics.checkNotNullExpressionValue(genericDeclaration2, (String)"putMethod");
            Intrinsics.checkNotNullExpressionValue((Object)method, (String)"getMethod");
            Intrinsics.checkNotNullExpressionValue(genericDeclaration, (String)"removeMethod");
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"clientProviderClass");
            Intrinsics.checkNotNullExpressionValue(clazz, (String)"serverProviderClass");
            Jdk8WithJettyBootPlatform jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(genericDeclaration2, method, genericDeclaration, (Class)object, clazz);
            object = (Platform)jdk8WithJettyBootPlatform;
            return object;
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            return null;
        }
    }
}
