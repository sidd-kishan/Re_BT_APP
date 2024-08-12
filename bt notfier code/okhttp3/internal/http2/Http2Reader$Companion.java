/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.http2.Http2Reader
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2Reader;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2={"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", "length", "flags", "padding", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Http2Reader.Companion {
    private Http2Reader.Companion() {
    }

    public /* synthetic */ Http2Reader.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Logger getLogger() {
        return Http2Reader.access$getLogger$cp();
    }

    public final int lengthWithoutPadding(int n, int n2, int n3) throws IOException {
        int n4 = n;
        if ((n2 & 8) != 0) {
            n4 = n - 1;
        }
        if (n3 <= n4) {
            return n4 - n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PROTOCOL_ERROR padding ");
        stringBuilder.append(n3);
        stringBuilder.append(" > remaining length ");
        stringBuilder.append(n4);
        throw new IOException(stringBuilder.toString());
    }
}
