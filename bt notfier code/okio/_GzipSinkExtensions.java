/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.GzipSink
 *  okio.Sink
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.GzipSink;
import okio.Sink;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u00a8\u0006\u0003"}, d2={"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"<this>");
        return new GzipSink(sink);
    }
}
