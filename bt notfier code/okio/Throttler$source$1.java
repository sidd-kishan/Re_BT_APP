/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ForwardingSource
 *  okio.Source
 *  okio.Throttler
 */
package okio;

import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import okio.Throttler;

@Metadata(d1={"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2={"okio/Throttler$source$1", "Lokio/ForwardingSource;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Throttler.source.1
extends ForwardingSource {
    final Source $source;
    final Throttler this$0;

    Throttler.source.1(Throttler throttler, Source source2) {
        this.this$0 = throttler;
        this.$source = source2;
        super(source2);
    }

    public long read(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        try {
            l = super.read(buffer, this.this$0.take$okio(l));
            return l;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
