/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okio.Sink
 */
package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okio.Sink;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2={"Lokhttp3/internal/cache/CacheRequest;", "", "abort", "", "body", "Lokio/Sink;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface CacheRequest {
    public void abort();

    public Sink body() throws IOException;
}
