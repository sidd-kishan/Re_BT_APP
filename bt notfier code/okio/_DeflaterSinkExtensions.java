/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.DeflaterSink
 *  okio.Sink
 */
package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.DeflaterSink;
import okio.Sink;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u0005"}, d2={"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)deflater, (String)"deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int n, Object object) {
        if ((n & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.checkNotNullParameter((Object)sink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)deflater, (String)"deflater");
        return new DeflaterSink(sink, deflater);
    }
}