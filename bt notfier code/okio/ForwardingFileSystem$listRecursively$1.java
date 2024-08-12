/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  okio.ForwardingFileSystem
 *  okio.Path
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.ForwardingFileSystem;
import okio.Path;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2={"<anonymous>", "Lokio/Path;", "it"}, k=3, mv={1, 5, 1}, xi=48)
static final class ForwardingFileSystem.listRecursively.1
extends Lambda
implements Function1<Path, Path> {
    final ForwardingFileSystem this$0;

    ForwardingFileSystem.listRecursively.1(ForwardingFileSystem forwardingFileSystem) {
        this.this$0 = forwardingFileSystem;
        super(1);
    }

    public final Path invoke(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"it");
        return this.this$0.onPathResult(path, "listRecursively");
    }
}
