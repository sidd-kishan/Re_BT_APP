/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.CacheControl
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.HttpUrl$Companion
 *  okhttp3.Request
 *  okhttp3.RequestBody
 *  okhttp3.internal.Util
 *  okhttp3.internal.http.HttpMethod
 */
package okhttp3;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0016J\u0014\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010,\u001a\u00020\u0000H\u0016J\b\u0010-\u001a\u00020\u0000H\u0016J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020/H\u0016J\u001a\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013H\u0016J-\u00104\u001a\u00020\u0000\"\u0004\b\u0000\u001052\u000e\u00106\u001a\n\u0012\u0006\b\u0000\u0012\u0002H50\u001a2\b\u00104\u001a\u0004\u0018\u0001H5H\u0016\u00a2\u0006\u0002\u00107J\u0012\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u000208H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\u0004\u0012\u00020\u00010\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00069"}, d2={"Lokhttp3/Request$Builder;", "", "()V", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "body", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "method", "", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "tags", "", "Ljava/lang/Class;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "addHeader", "name", "value", "build", "cacheControl", "Lokhttp3/CacheControl;", "delete", "get", "head", "header", "Lokhttp3/Headers;", "patch", "post", "put", "removeHeader", "tag", "T", "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static class Request.Builder {
    private RequestBody body;
    private Headers.Builder headers;
    private String method;
    private Map<Class<?>, Object> tags;
    private HttpUrl url;

    public Request.Builder() {
        this.tags = new LinkedHashMap();
        this.method = "GET";
        this.headers = new Headers.Builder();
    }

    public Request.Builder(Request request) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        this.tags = new LinkedHashMap();
        this.url = request.url();
        this.method = request.method();
        this.body = request.body();
        Map map = request.getTags$okhttp().isEmpty() ? (Map)new LinkedHashMap() : MapsKt.toMutableMap((Map)request.getTags$okhttp());
        this.tags = map;
        this.headers = request.headers().newBuilder();
    }

    public static /* synthetic */ Request.Builder delete$default(Request.Builder builder, RequestBody requestBody, int n, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        if ((n & 1) == 0) return builder.delete(requestBody);
        requestBody = Util.EMPTY_REQUEST;
        return builder.delete(requestBody);
    }

    public Request.Builder addHeader(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Request.Builder builder = this;
        builder.getHeaders$okhttp().add(string, string2);
        return builder;
    }

    public Request build() {
        HttpUrl httpUrl = this.url;
        if (httpUrl == null) throw (Throwable)new IllegalStateException("url == null".toString());
        return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
    }

    public Request.Builder cacheControl(CacheControl object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"cacheControl");
        object = object.toString();
        boolean bl = ((CharSequence)object).length() == 0;
        object = bl ? this.removeHeader("Cache-Control") : this.header("Cache-Control", (String)object);
        return object;
    }

    public final Request.Builder delete() {
        return Request.Builder.delete$default(this, null, 1, null);
    }

    public Request.Builder delete(RequestBody requestBody) {
        return this.method("DELETE", requestBody);
    }

    public Request.Builder get() {
        return this.method("GET", null);
    }

    public final RequestBody getBody$okhttp() {
        return this.body;
    }

    public final Headers.Builder getHeaders$okhttp() {
        return this.headers;
    }

    public final String getMethod$okhttp() {
        return this.method;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final HttpUrl getUrl$okhttp() {
        return this.url;
    }

    public Request.Builder head() {
        return this.method("HEAD", null);
    }

    public Request.Builder header(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Request.Builder builder = this;
        builder.getHeaders$okhttp().set(string, string2);
        return builder;
    }

    public Request.Builder headers(Headers headers) {
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        Request.Builder builder = this;
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }

    public Request.Builder method(String string, RequestBody object) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"method");
        Request.Builder builder = this;
        boolean bl = ((CharSequence)string).length() > 0;
        if (!bl) throw (Throwable)new IllegalArgumentException("method.isEmpty() == true".toString());
        if (object == null) {
            if (!(true ^ HttpMethod.requiresRequestBody((String)string))) {
                object = new StringBuilder();
                ((StringBuilder)object).append("method ");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(" must have a request body.");
                throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
            }
        } else if (!HttpMethod.permitsRequestBody((String)string)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("method ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" must not have a request body.");
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        builder.setMethod$okhttp(string);
        builder.setBody$okhttp((RequestBody)object);
        return builder;
    }

    public Request.Builder patch(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        return this.method("PATCH", requestBody);
    }

    public Request.Builder post(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        return this.method("POST", requestBody);
    }

    public Request.Builder put(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        return this.method("PUT", requestBody);
    }

    public Request.Builder removeHeader(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Request.Builder builder = this;
        builder.getHeaders$okhttp().removeAll(string);
        return builder;
    }

    public final void setBody$okhttp(RequestBody requestBody) {
        this.body = requestBody;
    }

    public final void setHeaders$okhttp(Headers.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"<set-?>");
        this.headers = builder;
    }

    public final void setMethod$okhttp(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.method = string;
    }

    public final void setTags$okhttp(Map<Class<?>, Object> map) {
        Intrinsics.checkNotNullParameter(map, (String)"<set-?>");
        this.tags = map;
    }

    public final void setUrl$okhttp(HttpUrl httpUrl) {
        this.url = httpUrl;
    }

    public <T> Request.Builder tag(Class<? super T> clazz, T t) {
        Intrinsics.checkNotNullParameter(clazz, (String)"type");
        Request.Builder builder = this;
        if (t == null) {
            builder.getTags$okhttp().remove(clazz);
        } else {
            if (builder.getTags$okhttp().isEmpty()) {
                builder.setTags$okhttp(new LinkedHashMap());
            }
            Map<Class<?>, Object> map = builder.getTags$okhttp();
            t = clazz.cast(t);
            Intrinsics.checkNotNull(t);
            map.put(clazz, t);
        }
        return builder;
    }

    public Request.Builder tag(Object object) {
        return this.tag(Object.class, object);
    }

    public Request.Builder url(String string) {
        String string2;
        Intrinsics.checkNotNullParameter((Object)string, (String)"url");
        if (StringsKt.startsWith((String)string, (String)"ws:", (boolean)true)) {
            string = string.substring(3);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
            string2 = Intrinsics.stringPlus((String)"http:", (Object)string);
        } else {
            string2 = string;
            if (!StringsKt.startsWith((String)string, (String)"wss:", (boolean)true)) return this.url(HttpUrl.Companion.get(string2));
            string = string.substring(4);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
            string2 = Intrinsics.stringPlus((String)"https:", (Object)string);
        }
        return this.url(HttpUrl.Companion.get(string2));
    }

    public Request.Builder url(URL object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"url");
        HttpUrl.Companion companion = HttpUrl.Companion;
        object = ((URL)object).toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"url.toString()");
        return this.url(companion.get((String)object));
    }

    public Request.Builder url(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        Request.Builder builder = this;
        builder.setUrl$okhttp(httpUrl);
        return builder;
    }
}
