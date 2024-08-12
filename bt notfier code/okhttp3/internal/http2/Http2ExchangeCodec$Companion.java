/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Response$Builder
 *  okhttp3.internal.http.RequestLine
 *  okhttp3.internal.http.StatusLine
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Http2ExchangeCodec
 */
package okhttp3.internal.http2;

import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2ExchangeCodec;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lokhttp3/internal/http2/Http2ExchangeCodec$Companion;", "", "()V", "CONNECTION", "", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "http2HeadersList", "Lokhttp3/internal/http2/Header;", "request", "Lokhttp3/Request;", "readHttp2HeadersList", "Lokhttp3/Response$Builder;", "headerBlock", "Lokhttp3/Headers;", "protocol", "Lokhttp3/Protocol;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Http2ExchangeCodec.Companion {
    private Http2ExchangeCodec.Companion() {
    }

    public /* synthetic */ Http2ExchangeCodec.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final List<Header> http2HeadersList(Request object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"request");
        Headers headers = object.headers();
        ArrayList<Header> arrayList = new ArrayList<Header>(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, object.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(object.url())));
        Object object2 = object.header("Host");
        if (object2 != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, (String)object2));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, object.url().scheme()));
        int n = 0;
        int n2 = headers.size();
        if (n2 <= 0) return arrayList;
        while (true) {
            int n3 = n + 1;
            object = headers.name(n);
            object2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"US");
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            object = ((String)object).toLowerCase((Locale)object2);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).toLowerCase(locale)");
            if (!Http2ExchangeCodec.access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp().contains(object) || Intrinsics.areEqual((Object)object, (Object)"te") && Intrinsics.areEqual((Object)headers.value(n), (Object)"trailers")) {
                arrayList.add(new Header((String)object, headers.value(n)));
            }
            if (n3 >= n2) {
                return arrayList;
            }
            n = n3;
        }
    }

    public final Response.Builder readHttp2HeadersList(Headers object, Protocol protocol) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"headerBlock");
        Intrinsics.checkNotNullParameter((Object)protocol, (String)"protocol");
        Headers.Builder builder = new Headers.Builder();
        int n = object.size();
        StatusLine statusLine = null;
        StatusLine statusLine2 = null;
        if (n > 0) {
            int n2 = 0;
            while (true) {
                int n3 = n2 + 1;
                String string = object.name(n2);
                String string2 = object.value(n2);
                if (Intrinsics.areEqual((Object)string, (Object)":status")) {
                    statusLine = StatusLine.Companion.parse(Intrinsics.stringPlus((String)"HTTP/1.1 ", (Object)string2));
                } else {
                    statusLine = statusLine2;
                    if (!Http2ExchangeCodec.access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp().contains(string)) {
                        builder.addLenient$okhttp(string, string2);
                        statusLine = statusLine2;
                    }
                }
                if (n3 >= n) break;
                n2 = n3;
                statusLine2 = statusLine;
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        object = new ProtocolException("Expected ':status' header not present");
        throw object;
    }
}
