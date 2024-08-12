/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Cache
 *  okhttp3.CipherSuite
 *  okhttp3.ConnectionSpec
 *  okhttp3.Cookie
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RealConnection
 */
package okhttp3.internal;

import java.util.Comparator;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u001a\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u001a\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013\u001a \u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t\u001a#\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$*\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0$\u00a2\u0006\u0002\u0010&\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006'"}, d2={"connection", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/Response;", "getConnection", "(Lokhttp3/Response;)Lokhttp3/internal/connection/RealConnection;", "addHeaderLenient", "Lokhttp3/Headers$Builder;", "builder", "line", "", "name", "value", "applyConnectionSpec", "", "connectionSpec", "Lokhttp3/ConnectionSpec;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "", "cacheGet", "cache", "Lokhttp3/Cache;", "request", "Lokhttp3/Request;", "cookieToString", "cookie", "Lokhttp3/Cookie;", "forObsoleteRfc2965", "parseCookie", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "effectiveCipherSuites", "", "socketEnabledCipherSuites", "(Lokhttp3/ConnectionSpec;[Ljava/lang/String;)[Ljava/lang/String;", "okhttp"}, k=2, mv={1, 5, 1}, xi=48)
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String string) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)string, (String)"line");
        return builder.addLenient$okhttp(string);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        return builder.addLenient$okhttp(string, string2);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)connectionSpec, (String)"connectionSpec");
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, bl);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)cookie, (String)"cookie");
        return cookie.toString$okhttp(bl);
    }

    public static final String[] effectiveCipherSuites(ConnectionSpec connectionSpec, String[] stringArray) {
        Intrinsics.checkNotNullParameter((Object)connectionSpec, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"socketEnabledCipherSuites");
        String[] stringArray2 = stringArray;
        if (connectionSpec.getCipherSuitesAsString$okhttp() == null) return stringArray2;
        stringArray2 = Util.intersect((String[])stringArray, (String[])connectionSpec.getCipherSuitesAsString$okhttp(), (Comparator)CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        return stringArray2;
    }

    public static final RealConnection getConnection(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"<this>");
        response = response.exchange();
        Intrinsics.checkNotNull((Object)response);
        return response.getConnection$okhttp();
    }

    public static final Cookie parseCookie(long l, HttpUrl httpUrl, String string) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        Intrinsics.checkNotNullParameter((Object)string, (String)"setCookie");
        return Cookie.Companion.parse$okhttp(l, httpUrl, string);
    }
}
