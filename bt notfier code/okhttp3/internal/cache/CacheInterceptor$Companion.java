/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.text.StringsKt
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 */
package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CacheInterceptor.Companion {
    private CacheInterceptor.Companion() {
    }

    public /* synthetic */ CacheInterceptor.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ Headers access$combine(CacheInterceptor.Companion companion, Headers headers, Headers headers2) {
        return companion.combine(headers, headers2);
    }

    public static final /* synthetic */ Response access$stripBody(CacheInterceptor.Companion companion, Response response) {
        return companion.stripBody(response);
    }

    private final Headers combine(Headers object, Headers headers) {
        int n;
        int n2;
        Headers.Builder builder = new Headers.Builder();
        int n3 = object.size();
        int n4 = 0;
        if (n3 > 0) {
            n2 = 0;
            while (true) {
                n = n2 + 1;
                String string = object.name(n2);
                String string2 = object.value(n2);
                if (!(StringsKt.equals((String)"Warning", (String)string, (boolean)true) && StringsKt.startsWith$default((String)string2, (String)"1", (boolean)false, (int)2, null) || !this.isContentSpecificHeader(string) && this.isEndToEnd(string) && headers.get(string) != null)) {
                    builder.addLenient$okhttp(string, string2);
                }
                if (n >= n3) break;
                n2 = n;
            }
        }
        if ((n = headers.size()) <= 0) return builder.build();
        n2 = n4;
        while (true) {
            n4 = n2 + 1;
            object = headers.name(n2);
            if (!this.isContentSpecificHeader((String)object) && this.isEndToEnd((String)object)) {
                builder.addLenient$okhttp((String)object, headers.value(n2));
            }
            if (n4 >= n) {
                return builder.build();
            }
            n2 = n4;
        }
    }

    private final boolean isContentSpecificHeader(String string) {
        boolean bl;
        boolean bl2 = bl = true;
        if (StringsKt.equals((String)"Content-Length", (String)string, (boolean)true)) return bl2;
        bl2 = bl;
        if (StringsKt.equals((String)"Content-Encoding", (String)string, (boolean)true)) return bl2;
        bl2 = StringsKt.equals((String)"Content-Type", (String)string, (boolean)true) ? bl : false;
        return bl2;
    }

    private final boolean isEndToEnd(String string) {
        boolean bl = true;
        if (!StringsKt.equals((String)"Connection", (String)string, (boolean)true) && !StringsKt.equals((String)"Keep-Alive", (String)string, (boolean)true) && !StringsKt.equals((String)"Proxy-Authenticate", (String)string, (boolean)true) && !StringsKt.equals((String)"Proxy-Authorization", (String)string, (boolean)true) && !StringsKt.equals((String)"TE", (String)string, (boolean)true) && !StringsKt.equals((String)"Trailers", (String)string, (boolean)true) && !StringsKt.equals((String)"Transfer-Encoding", (String)string, (boolean)true) && !StringsKt.equals((String)"Upgrade", (String)string, (boolean)true)) return bl;
        bl = false;
        return bl;
    }

    private final Response stripBody(Response response) {
        ResponseBody responseBody = response == null ? null : response.body();
        Response response2 = response;
        if (responseBody == null) return response2;
        response2 = response.newBuilder().body(null).build();
        return response2;
    }
}
