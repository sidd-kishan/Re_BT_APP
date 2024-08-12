/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ForwardingSink
 *  okio.Sink
 *  okio.Throttler
 */
package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import okio.Throttler;

@Metadata(d1={"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"okio/Throttler$sink$1", "Lokio/ForwardingSink;", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Throttler.sink.1
extends ForwardingSink {
    final Sink $sink;
    final Throttler this$0;

    Throttler.sink.1(Throttler throttler, Sink sink2) {
        this.this$0 = throttler;
        this.$sink = sink2;
        super(sink2);
    }

    public void write(Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        while (l > 0L) {
            try {
                long l2 = this.this$0.take$okio(l);
                super.write(buffer, l2);
                l -= l2;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }
}
