/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.HttpUrl
 *  okhttp3.Request
 */
package okhttp3.internal.http;

import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2={"Lokhttp3/internal/http/RequestLine;", "", "()V", "get", "", "request", "Lokhttp3/Request;", "proxyType", "Ljava/net/Proxy$Type;", "includeAuthorityInRequestLine", "", "requestPath", "url", "Lokhttp3/HttpUrl;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RequestLine {
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        boolean bl = !request.isHttps() && type == Proxy.Type.HTTP;
        return bl;
    }

    public final String get(Request object, Proxy.Type type) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"request");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"proxyType");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.method());
        stringBuilder.append(' ');
        if (INSTANCE.includeAuthorityInRequestLine((Request)object, type)) {
            stringBuilder.append(object.url());
        } else {
            stringBuilder.append(INSTANCE.requestPath(object.url()));
        }
        stringBuilder.append(" HTTP/1.1");
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public final String requestPath(HttpUrl object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"url");
        String string = object.encodedPath();
        String string2 = object.encodedQuery();
        object = string;
        if (string2 == null) return object;
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append('?');
        ((StringBuilder)object).append((Object)string2);
        object = ((StringBuilder)object).toString();
        return object;
    }
}
