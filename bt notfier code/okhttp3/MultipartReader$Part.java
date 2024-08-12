/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okio.BufferedSource
 */
package okhttp3;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okio.BufferedSource;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b\u00a8\u0006\u000b"}, d2={"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "headers", "Lokhttp3/Headers;", "body", "Lokio/BufferedSource;", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "()Lokio/BufferedSource;", "()Lokhttp3/Headers;", "close", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class MultipartReader.Part
implements Closeable {
    private final BufferedSource body;
    private final Headers headers;

    public MultipartReader.Part(Headers headers, BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"body");
        this.headers = headers;
        this.body = bufferedSource;
    }

    public final BufferedSource body() {
        return this.body;
    }

    @Override
    public void close() {
        this.body.close();
    }

    public final Headers headers() {
        return this.headers;
    }
}
