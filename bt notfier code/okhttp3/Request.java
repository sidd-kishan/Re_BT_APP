/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CacheControl
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 */
package okhttp3;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\u00a2\u0006\u0002\b\u001bJ\r\u0010\u000f\u001a\u00020\u0010H\u0007\u00a2\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b\u001fJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\b!J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010\u0001J#\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u0002H%0\f\u00a2\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0005H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b)R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u00078\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017R$\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001a\u00a8\u0006+"}, d2={"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "method", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "tags", "", "Ljava/lang/Class;", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "()Ljava/lang/String;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", "name", "-deprecated_headers", "", "-deprecated_method", "newBuilder", "Lokhttp3/Request$Builder;", "tag", "T", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    public Request(HttpUrl httpUrl, String string, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        Intrinsics.checkNotNullParameter((Object)string, (String)"method");
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        Intrinsics.checkNotNullParameter(map, (String)"tags");
        this.url = httpUrl;
        this.method = string;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="body", imports={}))
    public final RequestBody _deprecated_body() {
        return this.body;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cacheControl", imports={}))
    public final CacheControl _deprecated_cacheControl() {
        return this.cacheControl();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="headers", imports={}))
    public final Headers _deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="method", imports={}))
    public final String _deprecated_method() {
        return this.method;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="url", imports={}))
    public final HttpUrl _deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl;
        CacheControl cacheControl2 = cacheControl = this.lazyCacheControl;
        if (cacheControl != null) return cacheControl2;
        this.lazyCacheControl = cacheControl2 = CacheControl.Companion.parse(this.headers);
        return cacheControl2;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return this.headers.get(string);
    }

    public final List<String> headers(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return this.headers.values(string);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return this.tag(Object.class);
    }

    public final <T> T tag(Class<? extends T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"type");
        return clazz.cast(this.tags.get(clazz));
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Request{method=");
        ((StringBuilder)charSequence).append(this.method());
        ((StringBuilder)charSequence).append(", url=");
        ((StringBuilder)charSequence).append(this.url());
        if (this.headers().size() != 0) {
            ((StringBuilder)charSequence).append(", headers=[");
            Object object = (Iterable)this.headers();
            int n = 0;
            object = object.iterator();
            while (object.hasNext()) {
                Object object2 = object.next();
                if (n < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object object3 = (Pair)object2;
                object2 = (String)object3.component1();
                object3 = (String)object3.component2();
                if (n > 0) {
                    ((StringBuilder)charSequence).append(", ");
                }
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(':');
                ((StringBuilder)charSequence).append((String)object3);
                ++n;
            }
            ((StringBuilder)charSequence).append(']');
        }
        if (this.getTags$okhttp().isEmpty() ^ true) {
            ((StringBuilder)charSequence).append(", tags=");
            ((StringBuilder)charSequence).append(this.getTags$okhttp());
        }
        ((StringBuilder)charSequence).append('}');
        charSequence = ((StringBuilder)charSequence).toString();
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }

    public final HttpUrl url() {
        return this.url;
    }
}
