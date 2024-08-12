/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okio.FileSystem
 *  okio.Path
 *  okio.internal.ResourceFileSystem
 */
package okio.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.FileSystem;
import okio.Path;
import okio.internal.ResourceFileSystem;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001H\n"}, d2={"<anonymous>", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "Lokio/Path;"}, k=3, mv={1, 5, 1}, xi=48)
static final class ResourceFileSystem.roots.2
extends Lambda
implements Function0<List<? extends Pair<? extends FileSystem, ? extends Path>>> {
    final ClassLoader $classLoader;

    ResourceFileSystem.roots.2(ClassLoader classLoader) {
        this.$classLoader = classLoader;
        super(0);
    }

    public final List<Pair<FileSystem, Path>> invoke() {
        return ResourceFileSystem.access$getCompanion$p().toClasspathRoots(this.$classLoader);
    }
}
