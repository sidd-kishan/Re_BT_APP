/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Headers$Builder
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.CacheStrategy
 *  okhttp3.internal.http.DatesKt
 */
package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.DatesKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "nowMillis", "", "request", "Lokhttp3/Request;", "cacheResponse", "Lokhttp3/Response;", "(JLokhttp3/Request;Lokhttp3/Response;)V", "ageSeconds", "", "etag", "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "getRequest$okhttp", "()Lokhttp3/Request;", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "hasConditions", "", "isFreshnessLifetimeHeuristic", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CacheStrategy.Factory {
    private int ageSeconds;
    private final Response cacheResponse;
    private String etag;
    private Date expires;
    private Date lastModified;
    private String lastModifiedString;
    private final long nowMillis;
    private long receivedResponseMillis;
    private final Request request;
    private long sentRequestMillis;
    private Date servedDate;
    private String servedDateString;

    public CacheStrategy.Factory(long l, Request request, Response object) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        this.nowMillis = l;
        this.request = request;
        this.cacheResponse = object;
        this.ageSeconds = -1;
        if (object == null) return;
        this.sentRequestMillis = object.sentRequestAtMillis();
        this.receivedResponseMillis = this.cacheResponse.receivedResponseAtMillis();
        request = this.cacheResponse.headers();
        int n = 0;
        int n2 = request.size();
        if (n2 <= 0) return;
        while (true) {
            int n3 = n + 1;
            String string = request.name(n);
            object = request.value(n);
            if (StringsKt.equals((String)string, (String)"Date", (boolean)true)) {
                this.servedDate = DatesKt.toHttpDateOrNull((String)object);
                this.servedDateString = object;
            } else if (StringsKt.equals((String)string, (String)"Expires", (boolean)true)) {
                this.expires = DatesKt.toHttpDateOrNull((String)object);
            } else if (StringsKt.equals((String)string, (String)"Last-Modified", (boolean)true)) {
                this.lastModified = DatesKt.toHttpDateOrNull((String)object);
                this.lastModifiedString = object;
            } else if (StringsKt.equals((String)string, (String)"ETag", (boolean)true)) {
                this.etag = object;
            } else if (StringsKt.equals((String)string, (String)"Age", (boolean)true)) {
                this.ageSeconds = Util.toNonNegativeInt((String)object, (int)-1);
            }
            if (n3 >= n2) {
                return;
            }
            n = n3;
        }
    }

    private final long cacheResponseAge() {
        Date date = this.servedDate;
        long l = 0L;
        if (date != null) {
            l = Math.max(0L, this.receivedResponseMillis - date.getTime());
        }
        long l2 = l;
        if (this.ageSeconds != -1) {
            l2 = Math.max(l, TimeUnit.SECONDS.toMillis(this.ageSeconds));
        }
        l = this.receivedResponseMillis;
        return l2 + (l - this.sentRequestMillis) + (this.nowMillis - l);
    }

    private final CacheStrategy computeCandidate() {
        long l;
        if (this.cacheResponse == null) {
            return new CacheStrategy(this.request, null);
        }
        if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
            return new CacheStrategy(this.request, null);
        }
        if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
            return new CacheStrategy(this.request, null);
        }
        Object object = this.request.cacheControl();
        if (object.noCache()) return new CacheStrategy(this.request, null);
        if (this.hasConditions(this.request)) {
            return new CacheStrategy(this.request, null);
        }
        Object object2 = this.cacheResponse.cacheControl();
        long l2 = this.cacheResponseAge();
        long l3 = l = this.computeFreshnessLifetime();
        if (object.maxAgeSeconds() != -1) {
            l3 = Math.min(l, TimeUnit.SECONDS.toMillis(object.maxAgeSeconds()));
        }
        int n = object.minFreshSeconds();
        long l4 = 0L;
        long l5 = n != -1 ? TimeUnit.SECONDS.toMillis(object.minFreshSeconds()) : 0L;
        l = l4;
        if (!object2.mustRevalidate()) {
            l = l4;
            if (object.maxStaleSeconds() != -1) {
                l = TimeUnit.SECONDS.toMillis(object.maxStaleSeconds());
            }
        }
        if (!object2.noCache() && (l5 += l2) < l + l3) {
            object = this.cacheResponse.newBuilder();
            if (l5 >= l3) {
                object.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (l2 <= 86400000L) return new CacheStrategy(null, object.build());
            if (!this.isFreshnessLifetimeHeuristic()) return new CacheStrategy(null, object.build());
            object.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            return new CacheStrategy(null, object.build());
        }
        object = this.etag;
        object2 = "If-Modified-Since";
        if (object != null) {
            object2 = "If-None-Match";
        } else if (this.lastModified != null) {
            object = this.lastModifiedString;
        } else {
            if (this.servedDate == null) return new CacheStrategy(this.request, null);
            object = this.servedDateString;
        }
        Headers.Builder builder = this.request.headers().newBuilder();
        Intrinsics.checkNotNull((Object)object);
        builder.addLenient$okhttp((String)object2, (String)object);
        return new CacheStrategy(this.request.newBuilder().headers(builder.build()).build(), this.cacheResponse);
    }

    private final long computeFreshnessLifetime() {
        Object object = this.cacheResponse;
        Intrinsics.checkNotNull((Object)object);
        object = object.cacheControl();
        if (object.maxAgeSeconds() != -1) {
            return TimeUnit.SECONDS.toMillis(object.maxAgeSeconds());
        }
        Date date = this.expires;
        Date date2 = null;
        object = null;
        long l = 0L;
        if (date != null) {
            date2 = this.servedDate;
            if (date2 != null) {
                object = date2.getTime();
            }
            long l2 = object == null ? this.receivedResponseMillis : (Long)object;
            l2 = date.getTime() - l2;
            if (l2 <= 0L) return l;
            l = l2;
            return l;
        }
        long l3 = l;
        if (this.lastModified == null) return l3;
        l3 = l;
        if (this.cacheResponse.request().url().query() != null) return l3;
        object = this.servedDate;
        object = object == null ? date2 : Long.valueOf(((Date)object).getTime());
        l3 = object == null ? this.sentRequestMillis : (Long)object;
        object = this.lastModified;
        Intrinsics.checkNotNull((Object)object);
        long l4 = l3 - ((Date)object).getTime();
        l3 = l;
        if (l4 <= 0L) return l3;
        l3 = l4 / (long)10;
        return l3;
    }

    private final boolean hasConditions(Request request) {
        boolean bl = request.header("If-Modified-Since") != null || request.header("If-None-Match") != null;
        return bl;
    }

    private final boolean isFreshnessLifetimeHeuristic() {
        Response response = this.cacheResponse;
        Intrinsics.checkNotNull((Object)response);
        boolean bl = response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        return bl;
    }

    public final CacheStrategy compute() {
        CacheStrategy cacheStrategy;
        CacheStrategy cacheStrategy2 = cacheStrategy = this.computeCandidate();
        if (cacheStrategy.getNetworkRequest() == null) return cacheStrategy2;
        cacheStrategy2 = cacheStrategy;
        if (!this.request.cacheControl().onlyIfCached()) return cacheStrategy2;
        cacheStrategy2 = new CacheStrategy(null, null);
        return cacheStrategy2;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }
}
