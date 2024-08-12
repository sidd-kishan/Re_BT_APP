/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.CacheRequest
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"okhttp3/internal/cache/CacheInterceptor$cacheWritingResponse$cacheWritingSource$1", "Lokio/Source;", "cacheRequestClosed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CacheInterceptor.cacheWritingResponse.cacheWritingSource.1
implements Source {
    final BufferedSink $cacheBody;
    final CacheRequest $cacheRequest;
    final BufferedSource $source;
    private boolean cacheRequestClosed;

    CacheInterceptor.cacheWritingResponse.cacheWritingSource.1(BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
        this.$source = bufferedSource;
        this.$cacheRequest = cacheRequest;
        this.$cacheBody = bufferedSink;
    }

    public void close() throws IOException {
        if (!this.cacheRequestClosed && !Util.discard((Source)this, (int)100, (TimeUnit)TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            this.$cacheRequest.abort();
        }
        this.$source.close();
    }

    public long read(Buffer buffer, long l) throws IOException {
        block2: {
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
            try {
                l = this.$source.read(buffer, l);
                if (l != -1L) break block2;
                if (this.cacheRequestClosed) return -1L;
                this.cacheRequestClosed = true;
            }
            catch (IOException iOException) {
                if (this.cacheRequestClosed) throw iOException;
                this.cacheRequestClosed = true;
                this.$cacheRequest.abort();
                throw iOException;
            }
            this.$cacheBody.close();
            return -1L;
        }
        buffer.copyTo(this.$cacheBody.getBuffer(), buffer.size() - l, l);
        this.$cacheBody.emitCompleteSegments();
        return l;
    }

    public Timeout timeout() {
        return this.$source.timeout();
    }
}
