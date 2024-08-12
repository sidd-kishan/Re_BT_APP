/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Cookie
 *  okhttp3.CookieJar
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.MediaType
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  okhttp3.internal.Util
 *  okhttp3.internal.http.HttpHeaders
 *  okhttp3.internal.http.RealResponseBody
 *  okio.GzipSource
 *  okio.Okio
 *  okio.Source
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class BridgeInterceptor
implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter((Object)cookieJar, (String)"cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<Cookie> object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = ((Iterable)object).iterator();
        int n = 0;
        while (true) {
            if (!object.hasNext()) {
                object = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"StringBuilder().apply(builderAction).toString()");
                return object;
            }
            Object object2 = object.next();
            if (n < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            object2 = (Cookie)object2;
            if (n > 0) {
                stringBuilder.append("; ");
            }
            stringBuilder.append(object2.name());
            stringBuilder.append('=');
            stringBuilder.append(object2.value());
            ++n;
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        Object object = request.body();
        if (object != null) {
            long l;
            MediaType mediaType = object.contentType();
            if (mediaType != null) {
                builder.header("Content-Type", mediaType.toString());
            }
            if ((l = object.contentLength()) != -1L) {
                builder.header("Content-Length", String.valueOf(l));
                builder.removeHeader("Transfer-Encoding");
            } else {
                builder.header("Transfer-Encoding", "chunked");
                builder.removeHeader("Content-Length");
            }
        }
        object = request.header("Host");
        boolean bl = false;
        if (object == null) {
            builder.header("Host", Util.toHostHeader$default((HttpUrl)request.url(), (boolean)false, (int)1, null));
        }
        if (request.header("Connection") == null) {
            builder.header("Connection", "Keep-Alive");
        }
        boolean bl2 = bl;
        if (request.header("Accept-Encoding") == null) {
            bl2 = bl;
            if (request.header("Range") == null) {
                builder.header("Accept-Encoding", "gzip");
                bl2 = true;
            }
        }
        if (((Collection)(object = this.cookieJar.loadForRequest(request.url()))).isEmpty() ^ true) {
            builder.header("Cookie", this.cookieHeader((List<Cookie>)object));
        }
        if (request.header("User-Agent") == null) {
            builder.header("User-Agent", "okhttp/5.0.0-alpha.3");
        }
        chain = chain.proceed(builder.build());
        HttpHeaders.receiveHeaders((CookieJar)this.cookieJar, (HttpUrl)request.url(), (Headers)chain.headers());
        request = chain.newBuilder().request(request);
        if (!bl2) return request.build();
        if (!StringsKt.equals((String)"gzip", (String)Response.header$default((Response)chain, (String)"Content-Encoding", null, (int)2, null), (boolean)true)) return request.build();
        if (!HttpHeaders.promisesBody((Response)chain)) return request.build();
        builder = chain.body();
        if (builder == null) return request.build();
        builder = new GzipSource((Source)builder.source());
        request.headers(chain.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
        request.body((ResponseBody)new RealResponseBody(Response.header$default((Response)chain, (String)"Content-Type", null, (int)2, null), -1L, Okio.buffer((Source)((Source)builder))));
        return request.build();
    }
}
