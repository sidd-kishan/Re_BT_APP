/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package kotlin.io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k=1, mv={1, 5, 1})
final class PathRelativizer {
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    private static final Path emptyPath = Paths.get("", new String[0]);
    private static final Path parentPath = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }

    public final Path tryRelativeTo(Path object, Path object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"path");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"base");
        Object object3 = object2.normalize();
        object2 = object.normalize();
        object = object3.relativize((Path)object2);
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"bn");
        int n = object3.getNameCount();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"pn");
        int n2 = Math.min(n, object2.getNameCount());
        for (n = 0; n < n2 && !(Intrinsics.areEqual((Object)object3.getName(n), (Object)parentPath) ^ true); ++n) {
            if (Intrinsics.areEqual((Object)object2.getName(n), (Object)parentPath) ^ true) throw (Throwable)new IllegalArgumentException("Unable to compute relative path");
        }
        if (Intrinsics.areEqual((Object)object2, (Object)object3) ^ true && Intrinsics.areEqual((Object)object3, (Object)emptyPath)) {
            object = object2;
        } else {
            object2 = object.toString();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"rn");
            object3 = object.getFileSystem();
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"rn.fileSystem");
            object3 = ((FileSystem)object3).getSeparator();
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"rn.fileSystem.separator");
            if (StringsKt.endsWith$default((String)object2, (String)object3, (boolean)false, (int)2, null)) {
                object3 = object.getFileSystem();
                object = object.getFileSystem();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"rn.fileSystem");
                object = ((FileSystem)object3).getPath(StringsKt.dropLast((String)object2, (int)((FileSystem)object).getSeparator().length()), new String[0]);
            }
        }
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"r");
        return object;
    }
}
