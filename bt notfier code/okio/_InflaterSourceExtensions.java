/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.InflaterSource
 *  okio.Source
 */
package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.InflaterSource;
import okio.Source;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u0005"}, d2={"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _InflaterSourceExtensions {
    public static final InflaterSource inflate(Source source, Inflater inflater) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)inflater, (String)"inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int n, Object object) {
        if ((n & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)inflater, (String)"inflater");
        return new InflaterSource(source, inflater);
    }
}
