/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Authenticator
 *  okhttp3.Challenge
 *  okhttp3.Credentials
 *  okhttp3.Dns
 *  okhttp3.HttpUrl
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.Route
 *  okhttp3.internal.authenticator.JavaNetAuthenticator$WhenMappings
 */
package okhttp3.internal.authenticator;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lokhttp3/internal/authenticator/JavaNetAuthenticator;", "Lokhttp3/Authenticator;", "defaultDns", "Lokhttp3/Dns;", "(Lokhttp3/Dns;)V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "connectToInetAddress", "Ljava/net/InetAddress;", "Ljava/net/Proxy;", "url", "Lokhttp3/HttpUrl;", "dns", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class JavaNetAuthenticator
implements Authenticator {
    private final Dns defaultDns;

    public JavaNetAuthenticator() {
        this(null, 1, null);
    }

    public JavaNetAuthenticator(Dns dns) {
        Intrinsics.checkNotNullParameter((Object)dns, (String)"defaultDns");
        this.defaultDns = dns;
    }

    public /* synthetic */ JavaNetAuthenticator(Dns dns, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            dns = Dns.SYSTEM;
        }
        this(dns);
    }

    private final InetAddress connectToInetAddress(Proxy object, HttpUrl httpUrl, Dns dns) throws IOException {
        Proxy.Type type = ((Proxy)object).type();
        int n = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (n == 1) {
            object = (InetAddress)CollectionsKt.first((List)dns.lookup(httpUrl.host()));
        } else {
            if ((object = ((Proxy)object).address()) == null) throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
            object = ((InetSocketAddress)object).getAddress();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"address() as InetSocketAddress).address");
        }
        return object;
    }

    public Request authenticate(Route object, Response object2) throws IOException {
        Challenge challenge;
        Object object3;
        boolean bl;
        Request request;
        block6: {
            Intrinsics.checkNotNullParameter((Object)object2, (String)"response");
            List list = object2.challenges();
            request = object2.request();
            HttpUrl httpUrl = request.url();
            bl = object2.code() == 407;
            object2 = object == null ? null : object.proxy();
            object3 = object2;
            if (object2 == null) {
                object3 = Proxy.NO_PROXY;
            }
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                challenge = (Challenge)iterator.next();
                if (!StringsKt.equals((String)"Basic", (String)challenge.scheme(), (boolean)true)) continue;
                object2 = object == null || (object2 = object.address()) == null ? null : object2.dns();
                list = object2;
                if (object2 == null) {
                    list = this.defaultDns;
                }
                if (bl) {
                    object2 = ((Proxy)object3).address();
                    if (object2 == null) throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress)object2;
                    object2 = inetSocketAddress.getHostName();
                    Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"proxy");
                    object2 = java.net.Authenticator.requestPasswordAuthentication((String)object2, this.connectToInetAddress((Proxy)object3, httpUrl, (Dns)list), inetSocketAddress.getPort(), httpUrl.scheme(), challenge.realm(), challenge.scheme(), httpUrl.url(), Authenticator.RequestorType.PROXY);
                } else {
                    object2 = httpUrl.host();
                    Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"proxy");
                    object2 = java.net.Authenticator.requestPasswordAuthentication((String)object2, this.connectToInetAddress((Proxy)object3, httpUrl, (Dns)list), httpUrl.port(), httpUrl.scheme(), challenge.realm(), challenge.scheme(), httpUrl.url(), Authenticator.RequestorType.SERVER);
                }
                if (object2 == null) {
                    continue;
                }
                break block6;
            }
            return null;
        }
        object = bl ? "Proxy-Authorization" : "Authorization";
        object3 = object2.getUserName();
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"auth.userName");
        object2 = object2.getPassword();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"auth.password");
        object2 = Credentials.basic((String)object3, (String)new String((char[])object2), (Charset)challenge.charset());
        return request.newBuilder().header((String)object, (String)object2).build();
    }
}
