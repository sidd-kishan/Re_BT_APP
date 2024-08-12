/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Cache
 *  okhttp3.Call
 *  okhttp3.EventListener
 *  okhttp3.Headers
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.Response$Builder
 *  okhttp3.ResponseBody
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.CacheInterceptor$Companion
 *  okhttp3.internal.cache.CacheRequest
 *  okhttp3.internal.cache.CacheStrategy
 *  okhttp3.internal.cache.CacheStrategy$Factory
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.http.HttpHeaders
 *  okhttp3.internal.http.HttpMethod
 *  okhttp3.internal.http.RealResponseBody
 *  okio.Okio
 *  okio.Source
 */
package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Source;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2={"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class CacheInterceptor
implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Object object = cacheRequest.body();
        ResponseBody responseBody = response.body();
        Intrinsics.checkNotNull((Object)responseBody);
        cacheRequest = new /* Unavailable Anonymous Inner Class!! */;
        object = Response.header$default((Response)response, (String)"Content-Type", null, (int)2, null);
        long l = response.body().contentLength();
        return response.newBuilder().body((ResponseBody)new RealResponseBody((String)object, l, Okio.buffer((Source)((Source)cacheRequest)))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody responseBody;
        ResponseBody responseBody2;
        void var3_11;
        void var3_8;
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        Call call = chain.call();
        Cache cache = this.cache;
        EventListener eventListener = null;
        Response response = cache == null ? null : cache.get$okhttp(chain.request());
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request request = cacheStrategy.getNetworkRequest();
        Response response2 = cacheStrategy.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(cacheStrategy);
        }
        if (call instanceof RealCall) {
            RealCall realCall = (RealCall)call;
        } else {
            Object var3_7 = null;
        }
        if (var3_8 == null) {
            EventListener eventListener2 = eventListener;
        } else {
            EventListener eventListener3 = var3_8.getEventListener$okhttp();
        }
        eventListener = var3_11;
        if (var3_11 == null) {
            eventListener = EventListener.NONE;
        }
        if (response != null && response2 == null && (responseBody2 = response.body()) != null) {
            Util.closeQuietly((Closeable)((Closeable)responseBody2));
        }
        if (request == null && response2 == null) {
            chain = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, (Response)chain);
            return chain;
        }
        if (request == null) {
            Intrinsics.checkNotNull((Object)response2);
            chain = response2.newBuilder().cacheResponse(okhttp3.internal.cache.CacheInterceptor$Companion.access$stripBody((Companion)Companion, (Response)response2)).build();
            eventListener.cacheHit(call, (Response)chain);
            return chain;
        }
        if (response2 != null) {
            eventListener.cacheConditionalHit(call, response2);
        } else if (this.cache != null) {
            eventListener.cacheMiss(call);
        }
        try {
            chain = chain.proceed(request);
        }
        catch (Throwable throwable) {
            if (response == null) throw throwable;
            ResponseBody responseBody3 = response.body();
            if (responseBody3 == null) {
                throw throwable;
            }
            Util.closeQuietly((Closeable)((Closeable)responseBody3));
            throw throwable;
        }
        if (chain == null && response != null && (responseBody = response.body()) != null) {
            Util.closeQuietly((Closeable)((Closeable)responseBody));
        }
        if (response2 != null) {
            boolean bl = false;
            if (chain != null && chain.code() == 304) {
                bl = true;
            }
            if (bl) {
                Response response3 = response2.newBuilder().headers(okhttp3.internal.cache.CacheInterceptor$Companion.access$combine((Companion)Companion, (Headers)response2.headers(), (Headers)chain.headers())).sentRequestAtMillis(chain.sentRequestAtMillis()).receivedResponseAtMillis(chain.receivedResponseAtMillis()).cacheResponse(okhttp3.internal.cache.CacheInterceptor$Companion.access$stripBody((Companion)Companion, (Response)response2)).networkResponse(okhttp3.internal.cache.CacheInterceptor$Companion.access$stripBody((Companion)Companion, (Response)chain)).build();
                chain = chain.body();
                Intrinsics.checkNotNull((Object)chain);
                chain.close();
                chain = this.cache;
                Intrinsics.checkNotNull((Object)chain);
                chain.trackConditionalCacheHit$okhttp();
                this.cache.update$okhttp(response2, response3);
                eventListener.cacheHit(call, response3);
                return response3;
            }
            ResponseBody responseBody4 = response2.body();
            if (responseBody4 != null) {
                Util.closeQuietly((Closeable)((Closeable)responseBody4));
            }
        }
        Intrinsics.checkNotNull((Object)chain);
        chain = chain.newBuilder().cacheResponse(okhttp3.internal.cache.CacheInterceptor$Companion.access$stripBody((Companion)Companion, (Response)response2)).networkResponse(okhttp3.internal.cache.CacheInterceptor$Companion.access$stripBody((Companion)Companion, (Response)chain)).build();
        if (this.cache == null) return chain;
        if (HttpHeaders.promisesBody((Response)chain) && CacheStrategy.Companion.isCacheable((Response)chain, request)) {
            chain = this.cacheWritingResponse(this.cache.put$okhttp((Response)chain), (Response)chain);
            if (response2 == null) return chain;
            eventListener.cacheMiss(call);
            return chain;
        }
        if (!HttpMethod.INSTANCE.invalidatesCache(request.method())) return chain;
        try {}
        catch (IOException iOException) {
            return chain;
        }
        this.cache.remove$okhttp(request);
        return chain;
    }
}
