/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.text.StringsKt
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okio.BufferedSource
 *  okio.ByteString
 */
package okhttp3;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u00020\u0015*\u00020\u0017J\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001d*\u00020\u0011H\u0002J\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lokhttp3/Cache$Companion;", "", "()V", "ENTRY_BODY", "", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "key", "", "url", "Lokhttp3/HttpUrl;", "readInt", "source", "Lokio/BufferedSource;", "readInt$okhttp", "varyHeaders", "Lokhttp3/Headers;", "requestHeaders", "responseHeaders", "varyMatches", "", "cachedResponse", "Lokhttp3/Response;", "cachedRequest", "newRequest", "Lokhttp3/Request;", "hasVaryAll", "varyFields", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Cache.Companion {
    private Cache.Companion() {
    }

    public /* synthetic */ Cache.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final Set<String> varyFields(Headers object) {
        int n = object.size();
        Object object2 = null;
        Set set = null;
        if (n > 0) {
            int n2 = 0;
            object2 = set;
            while (true) {
                int n3 = n2 + 1;
                if (StringsKt.equals((String)"Vary", (String)object.name(n2), (boolean)true)) {
                    Object object3 = object.value(n2);
                    set = object2;
                    if (object2 == null) {
                        set = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER((StringCompanionObject)StringCompanionObject.INSTANCE));
                    }
                    object3 = StringsKt.split$default((CharSequence)((CharSequence)object3), (char[])new char[]{','}, (boolean)false, (int)0, (int)6, null).iterator();
                    while (true) {
                        object2 = set;
                        if (!object3.hasNext()) break;
                        object2 = (String)object3.next();
                        if (object2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        set.add(((Object)StringsKt.trim((CharSequence)((CharSequence)object2))).toString());
                    }
                }
                if (n3 >= n) break;
                n2 = n3;
            }
        }
        object = object2;
        if (object2 != null) return object;
        object = SetsKt.emptySet();
        return object;
    }

    private final Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> set = this.varyFields(headers2);
        if (set.isEmpty()) {
            return Util.EMPTY_HEADERS;
        }
        headers2 = new Headers.Builder();
        int n = 0;
        int n2 = headers.size();
        if (n2 <= 0) return headers2.build();
        while (true) {
            int n3 = n + 1;
            String string = headers.name(n);
            if (set.contains(string)) {
                headers2.add(string, headers.value(n));
            }
            if (n3 >= n2) {
                return headers2.build();
            }
            n = n3;
        }
    }

    public final boolean hasVaryAll(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"<this>");
        return this.varyFields(response.headers()).contains("*");
    }

    @JvmStatic
    public final String key(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        return ByteString.Companion.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    public final int readInt$okhttp(BufferedSource object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        try {
            boolean bl;
            long l = object.readDecimalLong();
            String string = object.readUtf8LineStrict();
            if (l >= 0L && l <= Integer.MAX_VALUE && !(bl = ((CharSequence)string).length() > 0)) {
                return (int)l;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected an int but was \"");
            stringBuilder.append(l);
            stringBuilder.append(string);
            stringBuilder.append('\"');
            object = new IOException(stringBuilder.toString());
            throw object;
        }
        catch (NumberFormatException numberFormatException) {
            throw new IOException(numberFormatException.getMessage());
        }
    }

    public final Headers varyHeaders(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"<this>");
        Response response2 = response.networkResponse();
        Intrinsics.checkNotNull((Object)response2);
        return this.varyHeaders(response2.request().headers(), response.headers());
    }

    public final boolean varyMatches(Response object, Headers headers, Request request) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"cachedResponse");
        Intrinsics.checkNotNullParameter((Object)headers, (String)"cachedRequest");
        Intrinsics.checkNotNullParameter((Object)request, (String)"newRequest");
        object = this.varyFields(object.headers());
        boolean bl = object instanceof Collection;
        boolean bl2 = true;
        if (bl && ((Collection)object).isEmpty()) {
            bl = bl2;
        } else {
            String string;
            object = object.iterator();
            do {
                bl = bl2;
                if (!object.hasNext()) return bl;
            } while (!(Intrinsics.areEqual((Object)headers.values(string = (String)object.next()), (Object)request.headers(string)) ^ true));
            bl = false;
        }
        return bl;
    }
}
