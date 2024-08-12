/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.FileSystem
 *  okio.ForwardingFileSystem
 *  okio.Path
 *  okio.Sink
 */
package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Path;
import okio.Sink;

@Metadata(d1={"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"okhttp3/internal/cache/DiskLruCache$fileSystem$1", "Lokio/ForwardingFileSystem;", "sink", "Lokio/Sink;", "file", "Lokio/Path;", "mustCreate", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class DiskLruCache.fileSystem.1
extends ForwardingFileSystem {
    final FileSystem $fileSystem;

    DiskLruCache.fileSystem.1(FileSystem fileSystem2) {
        this.$fileSystem = fileSystem2;
        super(fileSystem2);
    }

    public Sink sink(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        Path path2 = path.parent();
        if (path2 == null) return super.sink(path, bl);
        this.createDirectories(path2);
        return super.sink(path, bl);
    }
}
