/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.internal.http1.HeadersReader$Companion
 *  okio.BufferedSource
 */
package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.http1.HeadersReader;
import okio.BufferedSource;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lokhttp3/internal/http1/HeadersReader;", "", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "headerLimit", "", "getSource", "()Lokio/BufferedSource;", "readHeaders", "Lokhttp3/Headers;", "readLine", "", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class HeadersReader {
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final BufferedSource source;

    public HeadersReader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        this.source = bufferedSource;
        this.headerLimit = 262144L;
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        String string;
        boolean bl;
        while (!(bl = ((CharSequence)(string = this.readLine())).length() == 0)) {
            builder.addLenient$okhttp(string);
        }
        return builder.build();
    }

    public final String readLine() {
        String string = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long)string.length();
        return string;
    }
}
