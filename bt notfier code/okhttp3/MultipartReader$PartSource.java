/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.MultipartReader
 *  okio.Buffer
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartReader;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lokhttp3/MultipartReader$PartSource;", "Lokio/Source;", "(Lokhttp3/MultipartReader;)V", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class MultipartReader.PartSource
implements Source {
    final MultipartReader this$0;
    private final Timeout timeout;

    public MultipartReader.PartSource(MultipartReader multipartReader) {
        Intrinsics.checkNotNullParameter((Object)multipartReader, (String)"this$0");
        this.this$0 = multipartReader;
        this.timeout = new Timeout();
    }

    public void close() {
        if (!Intrinsics.areEqual((Object)MultipartReader.access$getCurrentPart$p((MultipartReader)this.this$0), (Object)this)) return;
        MultipartReader.access$setCurrentPart$p((MultipartReader)this.this$0, null);
    }

    public long read(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (!Intrinsics.areEqual((Object)MultipartReader.access$getCurrentPart$p((MultipartReader)this.this$0), (Object)this)) throw (Throwable)new IllegalStateException("closed".toString());
        Timeout timeout = MultipartReader.access$getSource$p((MultipartReader)this.this$0).timeout();
        Timeout timeout2 = this.timeout;
        MultipartReader multipartReader = this.this$0;
        long l2 = timeout.timeoutNanos();
        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (timeout.hasDeadline()) {
            long l3 = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                l = MultipartReader.access$currentPartBytesRemaining((MultipartReader)multipartReader, (long)l);
                l = l == 0L ? -1L : MultipartReader.access$getSource$p((MultipartReader)multipartReader).read(buffer, l);
                return l;
            }
            finally {
                timeout.timeout(l2, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(l3);
                }
            }
        }
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            l = MultipartReader.access$currentPartBytesRemaining((MultipartReader)multipartReader, (long)l);
            l = l == 0L ? -1L : MultipartReader.access$getSource$p((MultipartReader)multipartReader).read(buffer, l);
            return l;
        }
        finally {
            timeout.timeout(l2, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }
}
