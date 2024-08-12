/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin._Assertions
 *  kotlin.io.FileTreeWalk$WalkState
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static abstract class FileTreeWalk.DirectoryState
extends FileTreeWalk.WalkState {
    public FileTreeWalk.DirectoryState(File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"rootDir");
        super(file);
        if (!_Assertions.ENABLED) return;
        boolean bl = file.isDirectory();
        if (!_Assertions.ENABLED) return;
        if (!bl) throw (Throwable)((Object)new AssertionError((Object)"rootDir must be verified to be directory beforehand."));
    }
}
